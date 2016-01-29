package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.base.e<SignAllForumActivity> {
    private b dOP;
    private a dOQ;
    private String mForumId;
    private String mForumName;

    /* loaded from: classes.dex */
    public interface a {
        void c(SignData signData);

        void onError(String str, String str2);
    }

    public ah(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.dOP = null;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void aJy() {
        if (this.dOP != null) {
            this.dOP.cancel();
            this.dOP = null;
        }
    }

    public void au(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.dOP == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.dOP = new b(this, null);
            this.dOP.setPriority(2);
            this.dOP.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, SignData> {
        private volatile com.baidu.tbadk.core.util.aa aiG;

        private b() {
            this.aiG = null;
        }

        /* synthetic */ b(ah ahVar, b bVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public SignData doInBackground(Object... objArr) {
            SignData signData;
            Exception e;
            try {
                this.aiG = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
                this.aiG.p("kw", ah.this.mForumName);
                this.aiG.p(ImageViewerConfig.FORUM_ID, ah.this.mForumId);
                this.aiG.vB().wv().mIsNeedTbs = true;
                String uZ = this.aiG.uZ();
                if (!this.aiG.vE() || !this.aiG.vB().ww().rl()) {
                    return null;
                }
                signData = new SignData();
                try {
                    signData.parserJson(uZ);
                    signData.setForumId(ah.this.mForumId);
                    signData.setForumName(ah.this.mForumName);
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
            if (this.aiG != null) {
                this.aiG.gT();
            }
            ah.this.dOP = null;
            super.cancel(true);
            ah.this.dOQ.onError(ah.this.mForumId, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(SignData signData) {
            ah.this.dOP = null;
            if (signData != null || this.aiG == null) {
                ah.this.dOQ.c(signData);
                return;
            }
            ah.this.mErrorCode = this.aiG.vF();
            ah.this.mErrorString = this.aiG.getErrorString();
            ah.this.dOQ.onError(ah.this.mForumId, ah.this.mErrorString);
        }
    }

    public void a(a aVar) {
        this.dOQ = aVar;
    }
}
