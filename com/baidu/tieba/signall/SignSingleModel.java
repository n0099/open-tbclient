package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
/* loaded from: classes24.dex */
public class SignSingleModel extends BdBaseModel<SignAllForumActivity> {
    private String mAuthSid;
    private String mForumId;
    private String mForumName;
    private b nes;
    private a neu;

    /* loaded from: classes24.dex */
    public interface a {
        void c(SignData signData);

        void go(String str, String str2);
    }

    public SignSingleModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.nes = null;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dNb() {
        if (this.nes != null) {
            this.nes.cancel();
            this.nes = null;
        }
    }

    public void gp(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.nes == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.nes = new b();
            this.nes.setPriority(2);
            this.nes.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class b extends BdAsyncTask<Object, Integer, SignData> {
        private volatile aa mNetwork;
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
        /* renamed from: F */
        public SignData doInBackground(Object... objArr) {
            Exception e;
            SignData signData;
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + TbConfig.SIGN_ADDRESS);
                this.mNetwork.addPostData("kw", SignSingleModel.this.mForumName);
                this.mNetwork.addPostData("fid", SignSingleModel.this.mForumId);
                this.mNetwork.addPostData("authsid", SignSingleModel.this.mAuthSid);
                this.mNetwork.btv().bue().mIsNeedTbs = true;
                this.mNetwork.jq(true);
                String postNetData = this.mNetwork.postNetData();
                if (!this.mNetwork.isNetSuccess() || !this.mNetwork.btv().buf().isRequestSuccess()) {
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
            SignSingleModel.this.nes = null;
            super.cancel(true);
            SignSingleModel.this.neu.go(SignSingleModel.this.mForumId, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(SignData signData) {
            SignSingleModel.this.nes = null;
            if (signData != null || this.mNetwork == null) {
                SignSingleModel.this.neu.c(signData);
                return;
            }
            SignSingleModel.this.mErrorCode = this.mNetwork.getServerErrorCode();
            SignSingleModel.this.mErrorString = this.mNetwork.getErrorString();
            SignSingleModel.this.neu.go(SignSingleModel.this.mForumId, SignSingleModel.this.mErrorString);
        }
    }

    public void a(a aVar) {
        this.neu = aVar;
    }
}
