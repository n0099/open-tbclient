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
    private boolean cuK;
    private MarkData cuL;
    private a cuM;
    private a.InterfaceC0040a cuN;

    public void a(a.InterfaceC0040a interfaceC0040a) {
        this.cuN = interfaceC0040a;
    }

    public c(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cuK = false;
        this.cuL = null;
        this.cuM = null;
        this.cuN = null;
        this.cuL = new MarkData();
    }

    public boolean qp() {
        return this.cuK;
    }

    public MarkData qs() {
        return this.cuL;
    }

    public void a(MarkData markData) {
        this.cuL = markData;
    }

    public void ab(boolean z) {
        this.cuK = z;
    }

    public String qo() {
        if (this.cuL != null) {
            return this.cuL.getPostId();
        }
        return null;
    }

    public void qr() {
        if (this.cuM != null) {
            this.cuM.cancel();
        }
        this.cuM = new a(true);
        this.cuM.setPriority(3);
        this.cuM.execute(new Boolean[0]);
    }

    public void qq() {
        if (this.cuM != null) {
            this.cuM.cancel();
        }
        this.cuM = new a(false);
        this.cuM.setPriority(3);
        this.cuM.execute(new Boolean[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private ab Ty = null;
        private boolean aNm;
        private e cuG;

        public a(boolean z) {
            this.aNm = true;
            this.cuG = null;
            this.aNm = z;
            this.cuG = new e();
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
            if (this.aNm) {
                this.Ty = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.b(c.this.cuL);
                this.Ty.o("data", aVar.ay(0, 1));
            } else {
                this.Ty = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
                this.Ty.o("user_id", c.this.cuL.getAccount());
                this.Ty.o("tid", c.this.cuL.getId());
            }
            this.cuG.parserJson(this.Ty.ul());
            boolean z = this.cuG.getErrorCode() == 0;
            if (this.Ty.uM().vG().rf() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Ty != null) {
                this.Ty.gL();
            }
            c.this.cuM = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            try {
                if (bool.booleanValue()) {
                    if (c.this.cuN != null) {
                        c.this.cuN.a(true, this.aNm, null);
                    }
                } else if (c.this.cuN != null) {
                    if (this.Ty == null || this.Ty.uM().vG().rf()) {
                        c.this.cuN.a(false, this.aNm, this.cuG.getErrorString());
                    } else {
                        c.this.cuN.a(false, this.aNm, this.Ty.getErrorString());
                    }
                }
                c.this.cuM = null;
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
        if (this.cuM != null) {
            this.cuM.cancel();
            return false;
        }
        return false;
    }
}
