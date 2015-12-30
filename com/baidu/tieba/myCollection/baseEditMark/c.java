package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.util.ab;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private boolean cyK;
    private MarkData cyL;
    private a cyM;
    private a.InterfaceC0040a cyN;

    public void a(a.InterfaceC0040a interfaceC0040a) {
        this.cyN = interfaceC0040a;
    }

    public c(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cyK = false;
        this.cyL = null;
        this.cyM = null;
        this.cyN = null;
        this.cyL = new MarkData();
    }

    public boolean pN() {
        return this.cyK;
    }

    public MarkData pQ() {
        return this.cyL;
    }

    public void a(MarkData markData) {
        this.cyL = markData;
    }

    public void Y(boolean z) {
        this.cyK = z;
    }

    public String pM() {
        if (this.cyL != null) {
            return this.cyL.getPostId();
        }
        return null;
    }

    public void pP() {
        if (this.cyM != null) {
            this.cyM.cancel();
        }
        this.cyM = new a(true);
        this.cyM.setPriority(3);
        this.cyM.execute(new Boolean[0]);
    }

    public void pO() {
        if (this.cyM != null) {
            this.cyM.cancel();
        }
        this.cyM = new a(false);
        this.cyM.setPriority(3);
        this.cyM.execute(new Boolean[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private ab Ua = null;
        private boolean aRf;
        private e cyG;

        public a(boolean z) {
            this.aRf = true;
            this.cyG = null;
            this.aRf = z;
            this.cyG = new e();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            if (this.aRf) {
                this.Ua = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.b(c.this.cyL);
                this.Ua.o("data", aVar.aK(0, 1));
            } else {
                this.Ua = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
                this.Ua.o("user_id", c.this.cyL.getAccount());
                this.Ua.o("tid", c.this.cyL.getId());
            }
            this.cyG.parserJson(this.Ua.tV());
            boolean z = this.cyG.getErrorCode() == 0;
            if (this.Ua.uw().vq().qO() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Ua != null) {
                this.Ua.gL();
            }
            c.this.cyM = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            try {
                if (bool.booleanValue()) {
                    if (c.this.cyN != null) {
                        c.this.cyN.a(true, this.aRf, null);
                    }
                } else if (c.this.cyN != null) {
                    if (this.Ua == null || this.Ua.uw().vq().qO()) {
                        c.this.cyN.a(false, this.aRf, this.cyG.getErrorString());
                    } else {
                        c.this.cyN.a(false, this.aRf, this.Ua.getErrorString());
                    }
                }
                c.this.cyM = null;
            } catch (Throwable th) {
                BdLog.e(th.toString());
            }
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.cyM != null) {
            this.cyM.cancel();
            return false;
        }
        return false;
    }
}
