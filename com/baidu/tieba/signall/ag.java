package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.base.e<SignAllForumActivity> {
    private b dyL;
    private a dyM;
    private String mForumId;
    private String mForumName;

    /* loaded from: classes.dex */
    public interface a {
        void bb(String str, String str2);

        void c(SignData signData);
    }

    public ag(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.dyL = null;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void aCq() {
        if (this.dyL != null) {
            this.dyL.cancel();
            this.dyL = null;
        }
    }

    public void au(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.dyL == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.dyL = new b(this, null);
            this.dyL.setPriority(2);
            this.dyL.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, SignData> {
        private volatile com.baidu.tbadk.core.util.ab ahV;

        private b() {
            this.ahV = null;
        }

        /* synthetic */ b(ag agVar, b bVar) {
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
                this.ahV = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SIGN_ADDRESS);
                this.ahV.o("kw", ag.this.mForumName);
                this.ahV.o(ImageViewerConfig.FORUM_ID, ag.this.mForumId);
                this.ahV.uw().vp().mIsNeedTbs = true;
                String tV = this.ahV.tV();
                if (!this.ahV.uz() || !this.ahV.uw().vq().qO()) {
                    return null;
                }
                signData = new SignData();
                try {
                    signData.parserJson(tV);
                    signData.setForumId(ag.this.mForumId);
                    signData.setForumName(ag.this.mForumName);
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
            if (this.ahV != null) {
                this.ahV.gL();
            }
            ag.this.dyL = null;
            super.cancel(true);
            ag.this.dyM.bb(ag.this.mForumId, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(SignData signData) {
            ag.this.dyL = null;
            if (signData != null || this.ahV == null) {
                ag.this.dyM.c(signData);
                return;
            }
            ag.this.mErrorCode = this.ahV.uA();
            ag.this.mErrorString = this.ahV.getErrorString();
            ag.this.dyM.bb(ag.this.mForumId, ag.this.mErrorString);
        }
    }

    public void a(a aVar) {
        this.dyM = aVar;
    }
}
