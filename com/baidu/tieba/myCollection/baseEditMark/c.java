package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private boolean cbX;
    private MarkData cbY;
    private a cbZ;
    private a.InterfaceC0039a cca;

    public void a(a.InterfaceC0039a interfaceC0039a) {
        this.cca = interfaceC0039a;
    }

    public c(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cbX = false;
        this.cbY = null;
        this.cbZ = null;
        this.cca = null;
        this.cbY = new MarkData();
    }

    public boolean qk() {
        return this.cbX;
    }

    public MarkData qn() {
        return this.cbY;
    }

    public void a(MarkData markData) {
        this.cbY = markData;
    }

    public void ab(boolean z) {
        this.cbX = z;
    }

    public String qj() {
        if (this.cbY != null) {
            return this.cbY.getPostId();
        }
        return null;
    }

    public void qm() {
        if (this.cbZ != null) {
            this.cbZ.cancel();
        }
        this.cbZ = new a(true);
        this.cbZ.setPriority(3);
        this.cbZ.execute(new Boolean[0]);
    }

    public void ql() {
        if (this.cbZ != null) {
            this.cbZ.cancel();
        }
        this.cbZ = new a(false);
        this.cbZ.setPriority(3);
        this.cbZ.execute(new Boolean[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private w Th = null;
        private boolean aJG;
        private e cbT;

        public a(boolean z) {
            this.aJG = true;
            this.cbT = null;
            this.aJG = z;
            this.cbT = new e();
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
            if (this.aJG) {
                this.Th = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.b(c.this.cbY);
                this.Th.o("data", aVar.au(0, 1));
            } else {
                this.Th = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
                this.Th.o("user_id", c.this.cbY.getAccount());
                this.Th.o("tid", c.this.cbY.getId());
            }
            this.cbT.parserJson(this.Th.tG());
            boolean z = this.cbT.getErrorCode() == 0;
            if (this.Th.uh().uY().qV() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Th != null) {
                this.Th.gJ();
            }
            c.this.cbZ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            try {
                if (bool.booleanValue()) {
                    if (c.this.cca != null) {
                        c.this.cca.a(true, this.aJG, null);
                    }
                } else if (c.this.cca != null) {
                    if (this.Th == null || this.Th.uh().uY().qV()) {
                        c.this.cca.a(false, this.aJG, this.cbT.getErrorString());
                    } else {
                        c.this.cca.a(false, this.aJG, this.Th.getErrorString());
                    }
                }
                c.this.cbZ = null;
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
        if (this.cbZ != null) {
            this.cbZ.cancel();
            return false;
        }
        return false;
    }
}
