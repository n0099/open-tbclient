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
    public String f20669e;

    /* renamed from: f  reason: collision with root package name */
    public String f20670f;

    /* renamed from: g  reason: collision with root package name */
    public c f20671g;

    /* renamed from: h  reason: collision with root package name */
    public b f20672h;

    /* renamed from: i  reason: collision with root package name */
    public String f20673i;

    /* loaded from: classes5.dex */
    public interface b {
        void a(SignData signData);

        void onError(String str, String str2);
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Object, Integer, SignData> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f20674a;

        public c() {
            this.f20674a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public SignData doInBackground(Object... objArr) {
            SignData signData;
            Exception e2;
            SignData signData2 = null;
            try {
                this.f20674a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.SIGN_ADDRESS);
                this.f20674a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, SignSingleModel.this.f20669e);
                this.f20674a.addPostData("fid", SignSingleModel.this.f20670f);
                this.f20674a.addPostData("authsid", SignSingleModel.this.f20673i);
                this.f20674a.getNetContext().getRequest().mIsNeedTbs = true;
                this.f20674a.setNeedSig(true);
                String postNetData = this.f20674a.postNetData();
                if (this.f20674a.isNetSuccess() && this.f20674a.getNetContext().getResponse().isRequestSuccess()) {
                    signData = new SignData();
                    try {
                        signData.parserJson(postNetData);
                        signData.forumId = SignSingleModel.this.f20670f;
                        signData.forumName = SignSingleModel.this.f20669e;
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
            SignSingleModel.this.f20671g = null;
            if (signData != null || this.f20674a == null) {
                SignSingleModel.this.f20672h.a(signData);
                return;
            }
            SignSingleModel.this.mErrorCode = this.f20674a.getServerErrorCode();
            SignSingleModel.this.mErrorString = this.f20674a.getErrorString();
            SignSingleModel.this.f20672h.onError(SignSingleModel.this.f20670f, SignSingleModel.this.mErrorString);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f20674a != null) {
                this.f20674a.cancelNetConnect();
            }
            SignSingleModel.this.f20671g = null;
            super.cancel(true);
            SignSingleModel.this.f20672h.onError(SignSingleModel.this.f20670f, null);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }
    }

    public SignSingleModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.f20669e = null;
        this.f20670f = null;
        this.f20671g = null;
    }

    public void A() {
        c cVar = this.f20671g;
        if (cVar != null) {
            cVar.cancel();
            this.f20671g = null;
        }
    }

    public void B(b bVar) {
        this.f20672h = bVar;
    }

    public void C(String str, String str2) {
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0 || this.f20671g != null) {
            return;
        }
        this.f20669e = str;
        this.f20670f = str2;
        c cVar = new c();
        this.f20671g = cVar;
        cVar.setPriority(2);
        this.f20671g.execute(new Object[0]);
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
