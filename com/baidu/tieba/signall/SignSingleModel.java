package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
/* loaded from: classes3.dex */
public class SignSingleModel extends BdBaseModel<SignAllForumActivity> {
    private a hdA;
    private b hdz;
    private String mAuthSid;
    private String mForumId;
    private String mForumName;

    /* loaded from: classes3.dex */
    public interface a {
        void b(SignData signData);

        void cF(String str, String str2);
    }

    public SignSingleModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.hdz = null;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void bAq() {
        if (this.hdz != null) {
            this.hdz.cancel();
            this.hdz = null;
        }
    }

    public void cG(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.hdz == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.hdz = new b();
            this.hdz.setPriority(2);
            this.hdz.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
        /* renamed from: E */
        public SignData doInBackground(Object... objArr) {
            Exception e;
            SignData signData;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.SIGN_ADDRESS);
                this.mNetwork.x("kw", SignSingleModel.this.mForumName);
                this.mNetwork.x(ImageViewerConfig.FORUM_ID, SignSingleModel.this.mForumId);
                this.mNetwork.x("authsid", SignSingleModel.this.mAuthSid);
                this.mNetwork.Dj().Eh().mIsNeedTbs = true;
                this.mNetwork.bs(true);
                String CL = this.mNetwork.CL();
                if (!this.mNetwork.Dm() || !this.mNetwork.Dj().Ei().isRequestSuccess()) {
                    signData = null;
                } else {
                    SignData signData2 = new SignData();
                    try {
                        signData2.parserJson(CL);
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
                    this.tokenData = AuthTokenData.parse(CL);
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
                this.mNetwork.jg();
            }
            SignSingleModel.this.hdz = null;
            super.cancel(true);
            SignSingleModel.this.hdA.cF(SignSingleModel.this.mForumId, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(SignData signData) {
            SignSingleModel.this.hdz = null;
            if (signData != null || this.mNetwork == null) {
                SignSingleModel.this.hdA.b(signData);
                return;
            }
            SignSingleModel.this.mErrorCode = this.mNetwork.Dn();
            SignSingleModel.this.mErrorString = this.mNetwork.getErrorString();
            SignSingleModel.this.hdA.cF(SignSingleModel.this.mForumId, SignSingleModel.this.mErrorString);
        }
    }

    public void a(a aVar) {
        this.hdA = aVar;
    }
}
