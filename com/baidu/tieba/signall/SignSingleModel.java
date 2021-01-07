package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
/* loaded from: classes8.dex */
public class SignSingleModel extends BdBaseModel<SignAllForumActivity> {
    private String mAuthSid;
    private String mForumId;
    private String mForumName;
    private b njY;
    private a njZ;

    /* loaded from: classes8.dex */
    public interface a {
        void c(SignData signData);

        void gl(String str, String str2);
    }

    public SignSingleModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.njY = null;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dMU() {
        if (this.njY != null) {
            this.njY.cancel();
            this.njY = null;
        }
    }

    public void gm(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.njY == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.njY = new b();
            this.njY.setPriority(2);
            this.njY.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Object, Integer, SignData> {
        private volatile z mNetwork;
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
        /* renamed from: G */
        public SignData doInBackground(Object... objArr) {
            SignData signData;
            try {
                this.mNetwork = new z(TbConfig.SERVER_ADDRESS + TbConfig.SIGN_ADDRESS);
                this.mNetwork.addPostData("kw", SignSingleModel.this.mForumName);
                this.mNetwork.addPostData("fid", SignSingleModel.this.mForumId);
                this.mNetwork.addPostData("authsid", SignSingleModel.this.mAuthSid);
                this.mNetwork.bvR().bwA().mIsNeedTbs = true;
                this.mNetwork.jM(true);
                String postNetData = this.mNetwork.postNetData();
                if (!this.mNetwork.isNetSuccess() || !this.mNetwork.bvR().bwB().isRequestSuccess()) {
                    signData = null;
                } else {
                    signData = new SignData();
                    try {
                        signData.parserJson(postNetData);
                        signData.forumId = SignSingleModel.this.mForumId;
                        signData.forumName = SignSingleModel.this.mForumName;
                    } catch (Exception e) {
                        e = e;
                        BdLog.e(e.getMessage());
                        return signData;
                    }
                }
                this.tokenData = AuthTokenData.parse(postNetData);
            } catch (Exception e2) {
                e = e2;
                signData = null;
            }
            return signData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            SignSingleModel.this.njY = null;
            super.cancel(true);
            SignSingleModel.this.njZ.gl(SignSingleModel.this.mForumId, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(SignData signData) {
            SignSingleModel.this.njY = null;
            if (signData != null || this.mNetwork == null) {
                SignSingleModel.this.njZ.c(signData);
                return;
            }
            SignSingleModel.this.mErrorCode = this.mNetwork.getServerErrorCode();
            SignSingleModel.this.mErrorString = this.mNetwork.getErrorString();
            SignSingleModel.this.njZ.gl(SignSingleModel.this.mForumId, SignSingleModel.this.mErrorString);
        }
    }

    public void a(a aVar) {
        this.njZ = aVar;
    }
}
