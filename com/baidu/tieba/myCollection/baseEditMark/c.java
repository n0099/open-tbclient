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
    private boolean ccJ;
    private MarkData ccK;
    private a ccL;
    private a.InterfaceC0039a ccM;

    public void a(a.InterfaceC0039a interfaceC0039a) {
        this.ccM = interfaceC0039a;
    }

    public c(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.ccJ = false;
        this.ccK = null;
        this.ccL = null;
        this.ccM = null;
        this.ccK = new MarkData();
    }

    public boolean qi() {
        return this.ccJ;
    }

    public MarkData ql() {
        return this.ccK;
    }

    public void a(MarkData markData) {
        this.ccK = markData;
    }

    public void ab(boolean z) {
        this.ccJ = z;
    }

    public String qh() {
        if (this.ccK != null) {
            return this.ccK.getPostId();
        }
        return null;
    }

    public void qk() {
        if (this.ccL != null) {
            this.ccL.cancel();
        }
        this.ccL = new a(true);
        this.ccL.setPriority(3);
        this.ccL.execute(new Boolean[0]);
    }

    public void qj() {
        if (this.ccL != null) {
            this.ccL.cancel();
        }
        this.ccL = new a(false);
        this.ccL.setPriority(3);
        this.ccL.execute(new Boolean[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private w Tj = null;
        private boolean aIL;
        private e ccF;

        public a(boolean z) {
            this.aIL = true;
            this.ccF = null;
            this.aIL = z;
            this.ccF = new e();
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
            if (this.aIL) {
                this.Tj = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.b(c.this.ccK);
                this.Tj.o("data", aVar.aw(0, 1));
            } else {
                this.Tj = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
                this.Tj.o("user_id", c.this.ccK.getAccount());
                this.Tj.o("tid", c.this.ccK.getId());
            }
            this.ccF.parserJson(this.Tj.tG());
            boolean z = this.ccF.getErrorCode() == 0;
            if (this.Tj.uh().va().qT() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Tj != null) {
                this.Tj.gJ();
            }
            c.this.ccL = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            try {
                if (bool.booleanValue()) {
                    if (c.this.ccM != null) {
                        c.this.ccM.a(true, this.aIL, null);
                    }
                } else if (c.this.ccM != null) {
                    if (this.Tj == null || this.Tj.uh().va().qT()) {
                        c.this.ccM.a(false, this.aIL, this.ccF.getErrorString());
                    } else {
                        c.this.ccM.a(false, this.aIL, this.Tj.getErrorString());
                    }
                }
                c.this.ccL = null;
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
        if (this.ccL != null) {
            this.ccL.cancel();
            return false;
        }
        return false;
    }
}
