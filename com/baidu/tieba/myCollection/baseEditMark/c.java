package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private boolean cFr;
    private MarkData cFs;
    private a cFt;
    private a.InterfaceC0041a cFu;

    public void a(a.InterfaceC0041a interfaceC0041a) {
        this.cFu = interfaceC0041a;
    }

    public c(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cFr = false;
        this.cFs = null;
        this.cFt = null;
        this.cFu = null;
        this.cFs = new MarkData();
    }

    public boolean qg() {
        return this.cFr;
    }

    public MarkData qj() {
        return this.cFs;
    }

    public void a(MarkData markData) {
        this.cFs = markData;
    }

    public void Y(boolean z) {
        this.cFr = z;
    }

    public String qf() {
        if (this.cFs != null) {
            return this.cFs.getPostId();
        }
        return null;
    }

    public void qi() {
        if (this.cFt != null) {
            this.cFt.cancel();
        }
        this.cFt = new a(true);
        this.cFt.setPriority(3);
        this.cFt.execute(new Boolean[0]);
    }

    public void qh() {
        if (this.cFt != null) {
            this.cFt.cancel();
        }
        this.cFt = new a(false);
        this.cFt.setPriority(3);
        this.cFt.execute(new Boolean[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa Ty = null;
        private boolean aTm;
        private e cFn;

        public a(boolean z) {
            this.aTm = true;
            this.cFn = null;
            this.aTm = z;
            this.cFn = new e();
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
            if (this.aTm) {
                this.Ty = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.b(c.this.cFs);
                this.Ty.p("data", aVar.aL(0, 1));
            } else {
                this.Ty = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
                this.Ty.p("user_id", c.this.cFs.getAccount());
                this.Ty.p("tid", c.this.cFs.getId());
            }
            this.cFn.parserJson(this.Ty.uZ());
            boolean z = this.cFn.getErrorCode() == 0;
            if (this.Ty.vB().ww().rl() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Ty != null) {
                this.Ty.gT();
            }
            c.this.cFt = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            try {
                if (bool.booleanValue()) {
                    if (c.this.cFu != null) {
                        c.this.cFu.a(true, this.aTm, null);
                    }
                } else if (c.this.cFu != null) {
                    if (this.Ty == null || this.Ty.vB().ww().rl()) {
                        c.this.cFu.a(false, this.aTm, this.cFn.getErrorString());
                    } else {
                        c.this.cFu.a(false, this.aTm, this.Ty.getErrorString());
                    }
                }
                c.this.cFt = null;
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
        if (this.cFt != null) {
            this.cFt.cancel();
            return false;
        }
        return false;
    }
}
