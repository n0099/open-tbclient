package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes3.dex */
public class SignSingleModel extends BdBaseModel<SignAllForumActivity> {
    private b gTx;
    private a gTy;
    private String mForumId;
    private String mForumName;

    /* loaded from: classes3.dex */
    public interface a {
        void b(SignData signData);

        void bX(String str, String str2);
    }

    public SignSingleModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.gTx = null;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void btW() {
        if (this.gTx != null) {
            this.gTx.cancel();
            this.gTx = null;
        }
    }

    public void bY(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.gTx == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.gTx = new b();
            this.gTx.setPriority(2);
            this.gTx.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Object, Integer, SignData> {
        private volatile x mNetwork;

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
            Exception e;
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.SIGN_ADDRESS);
                this.mNetwork.n("kw", SignSingleModel.this.mForumName);
                this.mNetwork.n(ImageViewerConfig.FORUM_ID, SignSingleModel.this.mForumId);
                this.mNetwork.Cz().Dw().mIsNeedTbs = true;
                String Cb = this.mNetwork.Cb();
                if (!this.mNetwork.CC() || !this.mNetwork.Cz().Dx().isRequestSuccess()) {
                    return null;
                }
                signData = new SignData();
                try {
                    signData.parserJson(Cb);
                    signData.forumId = SignSingleModel.this.mForumId;
                    signData.forumName = SignSingleModel.this.mForumName;
                    return signData;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    return signData;
                }
            } catch (Exception e3) {
                signData = null;
                e = e3;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mS();
            }
            SignSingleModel.this.gTx = null;
            super.cancel(true);
            SignSingleModel.this.gTy.bX(SignSingleModel.this.mForumId, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(SignData signData) {
            SignSingleModel.this.gTx = null;
            if (signData != null || this.mNetwork == null) {
                SignSingleModel.this.gTy.b(signData);
                return;
            }
            SignSingleModel.this.mErrorCode = this.mNetwork.CD();
            SignSingleModel.this.mErrorString = this.mNetwork.getErrorString();
            SignSingleModel.this.gTy.bX(SignSingleModel.this.mForumId, SignSingleModel.this.mErrorString);
        }
    }

    public void a(a aVar) {
        this.gTy = aVar;
    }
}
