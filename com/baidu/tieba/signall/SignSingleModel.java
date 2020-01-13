package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
/* loaded from: classes9.dex */
public class SignSingleModel extends BdBaseModel<SignAllForumActivity> {
    private b jYL;
    private a jYM;
    private String mAuthSid;
    private String mForumId;
    private String mForumName;

    /* loaded from: classes9.dex */
    public interface a {
        void c(SignData signData);

        void en(String str, String str2);
    }

    public SignSingleModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.jYL = null;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void cHH() {
        if (this.jYL != null) {
            this.jYL.cancel();
            this.jYL = null;
        }
    }

    public void eo(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.jYL == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.jYL = new b();
            this.jYL.setPriority(2);
            this.jYL.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Object, Integer, SignData> {
        private volatile x mNetwork;
        private AuthTokenData tokenData;

        private b() {
            this.mNetwork = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public SignData doInBackground(Object... objArr) {
            Exception e;
            SignData signData;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.SIGN_ADDRESS);
                this.mNetwork.addPostData("kw", SignSingleModel.this.mForumName);
                this.mNetwork.addPostData("fid", SignSingleModel.this.mForumId);
                this.mNetwork.addPostData("authsid", SignSingleModel.this.mAuthSid);
                this.mNetwork.aDU().aEu().mIsNeedTbs = true;
                this.mNetwork.fD(true);
                String postNetData = this.mNetwork.postNetData();
                if (!this.mNetwork.isNetSuccess() || !this.mNetwork.aDU().aEv().isRequestSuccess()) {
                    signData = null;
                } else {
                    SignData signData2 = new SignData();
                    try {
                        signData2.parserJson(postNetData);
                        signData2.forumId = SignSingleModel.this.mForumId;
                        signData2.forumName = SignSingleModel.this.mForumName;
                        signData = signData2;
                    } catch (Exception e2) {
                        signData = signData2;
                        e = e2;
                        BdLog.e(e.getMessage());
                        return signData;
                    }
                }
                try {
                    this.tokenData = AuthTokenData.parse(postNetData);
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return signData;
                }
            } catch (Exception e4) {
                e = e4;
                signData = null;
            }
            return signData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            SignSingleModel.this.jYL = null;
            super.cancel(true);
            SignSingleModel.this.jYM.en(SignSingleModel.this.mForumId, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(SignData signData) {
            SignSingleModel.this.jYL = null;
            if (signData != null || this.mNetwork == null) {
                SignSingleModel.this.jYM.c(signData);
                return;
            }
            SignSingleModel.this.mErrorCode = this.mNetwork.getServerErrorCode();
            SignSingleModel.this.mErrorString = this.mNetwork.getErrorString();
            SignSingleModel.this.jYM.en(SignSingleModel.this.mForumId, SignSingleModel.this.mErrorString);
        }
    }

    public void a(a aVar) {
        this.jYM = aVar;
    }
}
