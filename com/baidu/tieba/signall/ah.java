package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.base.e<SignAllForumActivity> {
    private b ehp;
    private a ehq;
    private String mForumId;
    private String mForumName;

    /* loaded from: classes.dex */
    public interface a {
        void b(SignData signData);

        void onError(String str, String str2);
    }

    public ah(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.ehp = null;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void aQp() {
        if (this.ehp != null) {
            this.ehp.cancel();
            this.ehp = null;
        }
    }

    public void bB(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.ehp == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.ehp = new b(this, null);
            this.ehp.setPriority(2);
            this.ehp.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, SignData> {
        private volatile com.baidu.tbadk.core.util.ab aiW;

        private b() {
            this.aiW = null;
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
        /* renamed from: w */
        public SignData doInBackground(Object... objArr) {
            SignData signData;
            Exception e;
            try {
                this.aiW = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
                this.aiW.p("kw", ah.this.mForumName);
                this.aiW.p("fid", ah.this.mForumId);
                this.aiW.vU().wO().mIsNeedTbs = true;
                String vw = this.aiW.vw();
                if (!this.aiW.vX() || !this.aiW.vU().wP().qC()) {
                    return null;
                }
                signData = new SignData();
                try {
                    signData.parserJson(vw);
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
            if (this.aiW != null) {
                this.aiW.gX();
            }
            ah.this.ehp = null;
            super.cancel(true);
            ah.this.ehq.onError(ah.this.mForumId, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(SignData signData) {
            ah.this.ehp = null;
            if (signData != null || this.aiW == null) {
                ah.this.ehq.b(signData);
                return;
            }
            ah.this.mErrorCode = this.aiW.vY();
            ah.this.mErrorString = this.aiW.getErrorString();
            ah.this.ehq.onError(ah.this.mForumId, ah.this.mErrorString);
        }
    }

    public void a(a aVar) {
        this.ehq = aVar;
    }
}
