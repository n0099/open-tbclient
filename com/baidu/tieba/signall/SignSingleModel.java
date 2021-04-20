package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
/* loaded from: classes4.dex */
public class SignSingleModel extends BdBaseModel<SignAllForumActivity> {

    /* renamed from: e  reason: collision with root package name */
    public String f20853e;

    /* renamed from: f  reason: collision with root package name */
    public String f20854f;

    /* renamed from: g  reason: collision with root package name */
    public c f20855g;

    /* renamed from: h  reason: collision with root package name */
    public b f20856h;
    public String i;

    /* loaded from: classes4.dex */
    public interface b {
        void a(SignData signData);

        void onError(String str, String str2);
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<Object, Integer, SignData> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f20857a;

        public c() {
            this.f20857a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public SignData doInBackground(Object... objArr) {
            SignData signData;
            Exception e2;
            SignData signData2 = null;
            try {
                this.f20857a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.SIGN_ADDRESS);
                this.f20857a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, SignSingleModel.this.f20853e);
                this.f20857a.addPostData("fid", SignSingleModel.this.f20854f);
                this.f20857a.addPostData("authsid", SignSingleModel.this.i);
                this.f20857a.getNetContext().getRequest().mIsNeedTbs = true;
                this.f20857a.setNeedSig(true);
                String postNetData = this.f20857a.postNetData();
                if (this.f20857a.isNetSuccess() && this.f20857a.getNetContext().getResponse().isRequestSuccess()) {
                    signData = new SignData();
                    try {
                        signData.parserJson(postNetData);
                        signData.forumId = SignSingleModel.this.f20854f;
                        signData.forumName = SignSingleModel.this.f20853e;
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
            SignSingleModel.this.f20855g = null;
            if (signData != null || this.f20857a == null) {
                SignSingleModel.this.f20856h.a(signData);
                return;
            }
            SignSingleModel.this.mErrorCode = this.f20857a.getServerErrorCode();
            SignSingleModel.this.mErrorString = this.f20857a.getErrorString();
            SignSingleModel.this.f20856h.onError(SignSingleModel.this.f20854f, SignSingleModel.this.mErrorString);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f20857a != null) {
                this.f20857a.cancelNetConnect();
            }
            SignSingleModel.this.f20855g = null;
            super.cancel(true);
            SignSingleModel.this.f20856h.onError(SignSingleModel.this.f20854f, null);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }
    }

    public SignSingleModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.f20853e = null;
        this.f20854f = null;
        this.f20855g = null;
    }

    public void A() {
        c cVar = this.f20855g;
        if (cVar != null) {
            cVar.cancel();
            this.f20855g = null;
        }
    }

    public void B(b bVar) {
        this.f20856h = bVar;
    }

    public void C(String str, String str2) {
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0 || this.f20855g != null) {
            return;
        }
        this.f20853e = str;
        this.f20854f = str2;
        c cVar = new c();
        this.f20855g = cVar;
        cVar.setPriority(2);
        this.f20855g.execute(new Object[0]);
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
