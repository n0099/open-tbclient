package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.base.e<SignAllForumActivity> {
    private b ekB;
    private a ekC;
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
        this.ekB = null;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void aQI() {
        if (this.ekB != null) {
            this.ekB.cancel();
            this.ekB = null;
        }
    }

    public void bG(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.ekB == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.ekB = new b(this, null);
            this.ekB.setPriority(2);
            this.ekB.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, SignData> {
        private volatile com.baidu.tbadk.core.util.ab aeI;

        private b() {
            this.aeI = null;
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
        /* renamed from: y */
        public SignData doInBackground(Object... objArr) {
            SignData signData;
            Exception e;
            try {
                this.aeI = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
                this.aeI.n("kw", ah.this.mForumName);
                this.aeI.n("fid", ah.this.mForumId);
                this.aeI.tA().uu().mIsNeedTbs = true;
                String tc = this.aeI.tc();
                if (!this.aeI.tD() || !this.aeI.tA().uv().nZ()) {
                    return null;
                }
                signData = new SignData();
                try {
                    signData.parserJson(tc);
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
            if (this.aeI != null) {
                this.aeI.dl();
            }
            ah.this.ekB = null;
            super.cancel(true);
            ah.this.ekC.onError(ah.this.mForumId, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(SignData signData) {
            ah.this.ekB = null;
            if (signData != null || this.aeI == null) {
                ah.this.ekC.b(signData);
                return;
            }
            ah.this.mErrorCode = this.aeI.tE();
            ah.this.mErrorString = this.aeI.getErrorString();
            ah.this.ekC.onError(ah.this.mForumId, ah.this.mErrorString);
        }
    }

    public void a(a aVar) {
        this.ekC = aVar;
    }
}
