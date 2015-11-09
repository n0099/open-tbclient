package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.base.e<SignAllForumActivity> {
    private b cSU;
    private a cSV;
    private String mForumId;
    private String mForumName;

    /* loaded from: classes.dex */
    public interface a {
        void bc(String str, String str2);

        void c(SignData signData);
    }

    public ab(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.cSU = null;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void auG() {
        if (this.cSU != null) {
            this.cSU.cancel();
            this.cSU = null;
        }
    }

    public void at(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.cSU == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.cSU = new b(this, null);
            this.cSU.setPriority(2);
            this.cSU.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, SignData> {
        private volatile com.baidu.tbadk.core.util.w afm;

        private b() {
            this.afm = null;
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
                this.afm = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
                this.afm.o("kw", ab.this.mForumName);
                this.afm.o(ImageViewerConfig.FORUM_ID, ab.this.mForumId);
                this.afm.uh().uZ().mIsNeedTbs = true;
                String tG = this.afm.tG();
                if (!this.afm.uk() || !this.afm.uh().va().qT()) {
                    return null;
                }
                signData = new SignData();
                try {
                    signData.parserJson(tG);
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
            if (this.afm != null) {
                this.afm.gJ();
            }
            ab.this.cSU = null;
            super.cancel(true);
            ab.this.cSV.bc(ab.this.mForumId, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(SignData signData) {
            ab.this.cSU = null;
            if (signData != null || this.afm == null) {
                ab.this.cSV.c(signData);
                return;
            }
            ab.this.mErrorCode = this.afm.ul();
            ab.this.mErrorString = this.afm.getErrorString();
            ab.this.cSV.bc(ab.this.mForumId, ab.this.mErrorString);
        }
    }

    public void a(a aVar) {
        this.cSV = aVar;
    }
}
