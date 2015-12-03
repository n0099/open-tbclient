package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.base.e<SignAllForumActivity> {
    private b drr;
    private a drs;
    private String mForumId;
    private String mForumName;

    /* loaded from: classes.dex */
    public interface a {
        void bf(String str, String str2);

        void c(SignData signData);
    }

    public ab(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.drr = null;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void aAi() {
        if (this.drr != null) {
            this.drr.cancel();
            this.drr = null;
        }
    }

    public void aw(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.drr == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.drr = new b(this, null);
            this.drr.setPriority(2);
            this.drr.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, SignData> {
        private volatile com.baidu.tbadk.core.util.ab agS;

        private b() {
            this.agS = null;
        }

        /* synthetic */ b(ab abVar, b bVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: s */
        public SignData doInBackground(Object... objArr) {
            SignData signData;
            Exception e;
            try {
                this.agS = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
                this.agS.o("kw", ab.this.mForumName);
                this.agS.o(ImageViewerConfig.FORUM_ID, ab.this.mForumId);
                this.agS.uM().vF().mIsNeedTbs = true;
                String ul = this.agS.ul();
                if (!this.agS.uP() || !this.agS.uM().vG().rf()) {
                    return null;
                }
                signData = new SignData();
                try {
                    signData.parserJson(ul);
                    signData.setForumId(ab.this.mForumId);
                    signData.setForumName(ab.this.mForumName);
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
            if (this.agS != null) {
                this.agS.gL();
            }
            ab.this.drr = null;
            super.cancel(true);
            ab.this.drs.bf(ab.this.mForumId, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(SignData signData) {
            ab.this.drr = null;
            if (signData != null || this.agS == null) {
                ab.this.drs.c(signData);
                return;
            }
            ab.this.mErrorCode = this.agS.uQ();
            ab.this.mErrorString = this.agS.getErrorString();
            ab.this.drs.bf(ab.this.mForumId, ab.this.mErrorString);
        }
    }

    public void a(a aVar) {
        this.drs = aVar;
    }
}
