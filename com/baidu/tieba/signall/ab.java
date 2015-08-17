package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.base.e<SignAllForumActivity> {
    private b cBH;
    private a cBI;
    private String mForumId;
    private String mForumName;

    /* loaded from: classes.dex */
    public interface a {
        void aZ(String str, String str2);

        void c(SignData signData);
    }

    public ab(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.cBH = null;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void anB() {
        if (this.cBH != null) {
            this.cBH.cancel();
            this.cBH = null;
        }
    }

    public void au(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.cBH == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.cBH = new b(this, null);
            this.cBH.setPriority(2);
            this.cBH.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, SignData> {
        private volatile com.baidu.tbadk.core.util.v afJ;

        private b() {
            this.afJ = null;
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
        /* renamed from: t */
        public SignData doInBackground(Object... objArr) {
            SignData signData;
            Exception e;
            try {
                this.afJ = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
                this.afJ.o("kw", ab.this.mForumName);
                this.afJ.o(ImageViewerConfig.FORUM_ID, ab.this.mForumId);
                this.afJ.ue().uV().mIsNeedTbs = true;
                String tD = this.afJ.tD();
                if (!this.afJ.uh() || !this.afJ.ue().uW().rb()) {
                    return null;
                }
                signData = new SignData();
                try {
                    signData.parserJson(tD);
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
            if (this.afJ != null) {
                this.afJ.gM();
            }
            ab.this.cBH = null;
            super.cancel(true);
            ab.this.cBI.aZ(ab.this.mForumId, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(SignData signData) {
            ab.this.cBH = null;
            if (signData != null || this.afJ == null) {
                ab.this.cBI.c(signData);
                return;
            }
            ab.this.mErrorCode = this.afJ.ui();
            ab.this.mErrorString = this.afJ.getErrorString();
            ab.this.cBI.aZ(ab.this.mForumId, ab.this.mErrorString);
        }
    }

    public void a(a aVar) {
        this.cBI = aVar;
    }
}
