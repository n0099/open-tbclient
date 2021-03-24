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
    public String f21167e;

    /* renamed from: f  reason: collision with root package name */
    public String f21168f;

    /* renamed from: g  reason: collision with root package name */
    public c f21169g;

    /* renamed from: h  reason: collision with root package name */
    public b f21170h;
    public String i;

    /* loaded from: classes5.dex */
    public interface b {
        void a(SignData signData);

        void onError(String str, String str2);
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Object, Integer, SignData> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f21171a;

        public c() {
            this.f21171a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public SignData doInBackground(Object... objArr) {
            SignData signData;
            Exception e2;
            SignData signData2 = null;
            try {
                this.f21171a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.SIGN_ADDRESS);
                this.f21171a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, SignSingleModel.this.f21167e);
                this.f21171a.addPostData("fid", SignSingleModel.this.f21168f);
                this.f21171a.addPostData("authsid", SignSingleModel.this.i);
                this.f21171a.getNetContext().getRequest().mIsNeedTbs = true;
                this.f21171a.setNeedSig(true);
                String postNetData = this.f21171a.postNetData();
                if (this.f21171a.isNetSuccess() && this.f21171a.getNetContext().getResponse().isRequestSuccess()) {
                    signData = new SignData();
                    try {
                        signData.parserJson(postNetData);
                        signData.forumId = SignSingleModel.this.f21168f;
                        signData.forumName = SignSingleModel.this.f21167e;
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
            SignSingleModel.this.f21169g = null;
            if (signData != null || this.f21171a == null) {
                SignSingleModel.this.f21170h.a(signData);
                return;
            }
            SignSingleModel.this.mErrorCode = this.f21171a.getServerErrorCode();
            SignSingleModel.this.mErrorString = this.f21171a.getErrorString();
            SignSingleModel.this.f21170h.onError(SignSingleModel.this.f21168f, SignSingleModel.this.mErrorString);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f21171a != null) {
                this.f21171a.cancelNetConnect();
            }
            SignSingleModel.this.f21169g = null;
            super.cancel(true);
            SignSingleModel.this.f21170h.onError(SignSingleModel.this.f21168f, null);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }
    }

    public SignSingleModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.f21167e = null;
        this.f21168f = null;
        this.f21169g = null;
    }

    public void A() {
        c cVar = this.f21169g;
        if (cVar != null) {
            cVar.cancel();
            this.f21169g = null;
        }
    }

    public void B(b bVar) {
        this.f21170h = bVar;
    }

    public void C(String str, String str2) {
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0 || this.f21169g != null) {
            return;
        }
        this.f21167e = str;
        this.f21168f = str2;
        c cVar = new c();
        this.f21169g = cVar;
        cVar.setPriority(2);
        this.f21169g.execute(new Object[0]);
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
