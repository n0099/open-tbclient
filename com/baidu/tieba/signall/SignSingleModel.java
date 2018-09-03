package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes3.dex */
public class SignSingleModel extends BdBaseModel<SignAllForumActivity> {
    private b gGk;
    private a gGl;
    private String mForumId;
    private String mForumName;

    /* loaded from: classes3.dex */
    public interface a {
        void b(SignData signData);

        void cf(String str, String str2);
    }

    public SignSingleModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.gGk = null;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void btg() {
        if (this.gGk != null) {
            this.gGk.cancel();
            this.gGk = null;
        }
    }

    public void cg(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.gGk == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.gGk = new b();
            this.gGk.setPriority(2);
            this.gGk.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Object, Integer, SignData> {
        private volatile y mNetwork;

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
        /* renamed from: D */
        public SignData doInBackground(Object... objArr) {
            SignData signData;
            Exception e;
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + TbConfig.SIGN_ADDRESS);
                this.mNetwork.o("kw", SignSingleModel.this.mForumName);
                this.mNetwork.o(ImageViewerConfig.FORUM_ID, SignSingleModel.this.mForumId);
                this.mNetwork.yM().zK().mIsNeedTbs = true;
                String yo = this.mNetwork.yo();
                if (!this.mNetwork.yP() || !this.mNetwork.yM().zL().isRequestSuccess()) {
                    return null;
                }
                signData = new SignData();
                try {
                    signData.parserJson(yo);
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
                this.mNetwork.hN();
            }
            SignSingleModel.this.gGk = null;
            super.cancel(true);
            SignSingleModel.this.gGl.cf(SignSingleModel.this.mForumId, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(SignData signData) {
            SignSingleModel.this.gGk = null;
            if (signData != null || this.mNetwork == null) {
                SignSingleModel.this.gGl.b(signData);
                return;
            }
            SignSingleModel.this.mErrorCode = this.mNetwork.yQ();
            SignSingleModel.this.mErrorString = this.mNetwork.getErrorString();
            SignSingleModel.this.gGl.cf(SignSingleModel.this.mForumId, SignSingleModel.this.mErrorString);
        }
    }

    public void a(a aVar) {
        this.gGl = aVar;
    }
}
