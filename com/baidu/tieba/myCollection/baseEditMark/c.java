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
    private boolean cci;
    private MarkData ccj;
    private a cck;
    private a.InterfaceC0039a ccl;

    public void a(a.InterfaceC0039a interfaceC0039a) {
        this.ccl = interfaceC0039a;
    }

    public c(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cci = false;
        this.ccj = null;
        this.cck = null;
        this.ccl = null;
        this.ccj = new MarkData();
    }

    public boolean qh() {
        return this.cci;
    }

    public MarkData qk() {
        return this.ccj;
    }

    public void a(MarkData markData) {
        this.ccj = markData;
    }

    public void ab(boolean z) {
        this.cci = z;
    }

    public String qg() {
        if (this.ccj != null) {
            return this.ccj.getPostId();
        }
        return null;
    }

    public void qj() {
        if (this.cck != null) {
            this.cck.cancel();
        }
        this.cck = new a(true);
        this.cck.setPriority(3);
        this.cck.execute(new Boolean[0]);
    }

    public void qi() {
        if (this.cck != null) {
            this.cck.cancel();
        }
        this.cck = new a(false);
        this.cck.setPriority(3);
        this.cck.execute(new Boolean[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private w Ti = null;
        private boolean aJR;
        private e cce;

        public a(boolean z) {
            this.aJR = true;
            this.cce = null;
            this.aJR = z;
            this.cce = new e();
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
            if (this.aJR) {
                this.Ti = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.b(c.this.ccj);
                this.Ti.o("data", aVar.au(0, 1));
            } else {
                this.Ti = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
                this.Ti.o("user_id", c.this.ccj.getAccount());
                this.Ti.o("tid", c.this.ccj.getId());
            }
            this.cce.parserJson(this.Ti.tD());
            boolean z = this.cce.getErrorCode() == 0;
            if (this.Ti.ue().uW().qS() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Ti != null) {
                this.Ti.gJ();
            }
            c.this.cck = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            try {
                if (bool.booleanValue()) {
                    if (c.this.ccl != null) {
                        c.this.ccl.a(true, this.aJR, null);
                    }
                } else if (c.this.ccl != null) {
                    if (this.Ti == null || this.Ti.ue().uW().qS()) {
                        c.this.ccl.a(false, this.aJR, this.cce.getErrorString());
                    } else {
                        c.this.ccl.a(false, this.aJR, this.Ti.getErrorString());
                    }
                }
                c.this.cck = null;
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
        if (this.cck != null) {
            this.cck.cancel();
            return false;
        }
        return false;
    }
}
