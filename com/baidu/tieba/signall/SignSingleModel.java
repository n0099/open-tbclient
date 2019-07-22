package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
/* loaded from: classes6.dex */
public class SignSingleModel extends BdBaseModel<SignAllForumActivity> {
    private b iYn;
    private a iYo;
    private String mAuthSid;
    private String mForumId;
    private String mForumName;

    /* loaded from: classes6.dex */
    public interface a {
        void b(SignData signData);

        void ef(String str, String str2);
    }

    public SignSingleModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.iYn = null;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void cnA() {
        if (this.iYn != null) {
            this.iYn.cancel();
            this.iYn = null;
        }
    }

    public void eg(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.iYn == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.iYn = new b();
            this.iYn.setPriority(2);
            this.iYn.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
        /* renamed from: F */
        public SignData doInBackground(Object... objArr) {
            Exception e;
            SignData signData;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.SIGN_ADDRESS);
                this.mNetwork.o("kw", SignSingleModel.this.mForumName);
                this.mNetwork.o("fid", SignSingleModel.this.mForumId);
                this.mNetwork.o("authsid", SignSingleModel.this.mAuthSid);
                this.mNetwork.aiE().ajE().mIsNeedTbs = true;
                this.mNetwork.eb(true);
                String aig = this.mNetwork.aig();
                if (!this.mNetwork.aiH() || !this.mNetwork.aiE().ajF().isRequestSuccess()) {
                    signData = null;
                } else {
                    SignData signData2 = new SignData();
                    try {
                        signData2.parserJson(aig);
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
                    this.tokenData = AuthTokenData.parse(aig);
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
                this.mNetwork.ik();
            }
            SignSingleModel.this.iYn = null;
            super.cancel(true);
            SignSingleModel.this.iYo.ef(SignSingleModel.this.mForumId, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(SignData signData) {
            SignSingleModel.this.iYn = null;
            if (signData != null || this.mNetwork == null) {
                SignSingleModel.this.iYo.b(signData);
                return;
            }
            SignSingleModel.this.mErrorCode = this.mNetwork.aiI();
            SignSingleModel.this.mErrorString = this.mNetwork.getErrorString();
            SignSingleModel.this.iYo.ef(SignSingleModel.this.mForumId, SignSingleModel.this.mErrorString);
        }
    }

    public void a(a aVar) {
        this.iYo = aVar;
    }
}
