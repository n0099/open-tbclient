package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
/* loaded from: classes5.dex */
public class SignSingleModel extends BdBaseModel<SignAllForumActivity> {

    /* renamed from: e  reason: collision with root package name */
    public String f21425e;

    /* renamed from: f  reason: collision with root package name */
    public String f21426f;

    /* renamed from: g  reason: collision with root package name */
    public c f21427g;

    /* renamed from: h  reason: collision with root package name */
    public b f21428h;

    /* renamed from: i  reason: collision with root package name */
    public String f21429i;

    /* loaded from: classes5.dex */
    public interface b {
        void a(SignData signData);

        void onError(String str, String str2);
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Object, Integer, SignData> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f21430a;

        public c() {
            this.f21430a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public SignData doInBackground(Object... objArr) {
            SignData signData;
            Exception e2;
            SignData signData2 = null;
            try {
                this.f21430a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.SIGN_ADDRESS);
                this.f21430a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, SignSingleModel.this.f21425e);
                this.f21430a.addPostData("fid", SignSingleModel.this.f21426f);
                this.f21430a.addPostData("authsid", SignSingleModel.this.f21429i);
                this.f21430a.getNetContext().getRequest().mIsNeedTbs = true;
                this.f21430a.setNeedSig(true);
                String postNetData = this.f21430a.postNetData();
                if (this.f21430a.isNetSuccess() && this.f21430a.getNetContext().getResponse().isRequestSuccess()) {
                    signData = new SignData();
                    try {
                        signData.parserJson(postNetData);
                        signData.forumId = SignSingleModel.this.f21426f;
                        signData.forumName = SignSingleModel.this.f21425e;
                        signData2 = signData;
                    } catch (Exception e3) {
                        e2 = e3;
                        BdLog.e(e2.getMessage());
                        return signData;
                    }
                }
                AuthTokenData.parse(postNetData);
                return signData2;
            } catch (Exception e4) {
                signData = signData2;
                e2 = e4;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(SignData signData) {
            SignSingleModel.this.f21427g = null;
            if (signData != null || this.f21430a == null) {
                SignSingleModel.this.f21428h.a(signData);
                return;
            }
            SignSingleModel.this.mErrorCode = this.f21430a.getServerErrorCode();
            SignSingleModel.this.mErrorString = this.f21430a.getErrorString();
            SignSingleModel.this.f21428h.onError(SignSingleModel.this.f21426f, SignSingleModel.this.mErrorString);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f21430a != null) {
                this.f21430a.cancelNetConnect();
            }
            SignSingleModel.this.f21427g = null;
            super.cancel(true);
            SignSingleModel.this.f21428h.onError(SignSingleModel.this.f21426f, null);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }
    }

    public SignSingleModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.f21425e = null;
        this.f21426f = null;
        this.f21427g = null;
    }

    public void A() {
        c cVar = this.f21427g;
        if (cVar != null) {
            cVar.cancel();
            this.f21427g = null;
        }
    }

    public void B(b bVar) {
        this.f21428h = bVar;
    }

    public void C(String str, String str2) {
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0 || this.f21427g != null) {
            return;
        }
        this.f21425e = str;
        this.f21426f = str2;
        c cVar = new c();
        this.f21427g = cVar;
        cVar.setPriority(2);
        this.f21427g.execute(new Object[0]);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
