package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.base.e<SignAllForumActivity> {
    private b cRa;
    private a cRb;
    private String mForumId;
    private String mForumName;

    /* loaded from: classes.dex */
    public interface a {
        void bd(String str, String str2);

        void c(SignData signData);
    }

    public ab(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.cRa = null;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void atY() {
        if (this.cRa != null) {
            this.cRa.cancel();
            this.cRa = null;
        }
    }

    public void au(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.cRa == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.cRa = new b(this, null);
            this.cRa.setPriority(2);
            this.cRa.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, SignData> {
        private volatile com.baidu.tbadk.core.util.w afg;

        private b() {
            this.afg = null;
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
                this.afg = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
                this.afg.o("kw", ab.this.mForumName);
                this.afg.o(ImageViewerConfig.FORUM_ID, ab.this.mForumId);
                this.afg.uh().uX().mIsNeedTbs = true;
                String tG = this.afg.tG();
                if (!this.afg.uk() || !this.afg.uh().uY().qV()) {
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
            if (this.afg != null) {
                this.afg.gJ();
            }
            ab.this.cRa = null;
            super.cancel(true);
            ab.this.cRb.bd(ab.this.mForumId, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(SignData signData) {
            ab.this.cRa = null;
            if (signData != null || this.afg == null) {
                ab.this.cRb.c(signData);
                return;
            }
            ab.this.mErrorCode = this.afg.ul();
            ab.this.mErrorString = this.afg.getErrorString();
            ab.this.cRb.bd(ab.this.mForumId, ab.this.mErrorString);
        }
    }

    public void a(a aVar) {
        this.cRb = aVar;
    }
}
