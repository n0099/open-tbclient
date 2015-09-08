package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private boolean bYl;
    private MarkData bYm;
    private a bYn;
    private a.InterfaceC0039a bYo;

    public void a(a.InterfaceC0039a interfaceC0039a) {
        this.bYo = interfaceC0039a;
    }

    public c(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bYl = false;
        this.bYm = null;
        this.bYn = null;
        this.bYo = null;
        this.bYm = new MarkData();
    }

    public boolean qo() {
        return this.bYl;
    }

    public MarkData qr() {
        return this.bYm;
    }

    public void a(MarkData markData) {
        this.bYm = markData;
    }

    public void ab(boolean z) {
        this.bYl = z;
    }

    public String qn() {
        if (this.bYm != null) {
            return this.bYm.getPostId();
        }
        return null;
    }

    public void qq() {
        if (this.bYn != null) {
            this.bYn.cancel();
        }
        this.bYn = new a(true);
        this.bYn.setPriority(3);
        this.bYn.execute(new Boolean[0]);
    }

    public void qp() {
        if (this.bYn != null) {
            this.bYn.cancel();
        }
        this.bYn = new a(false);
        this.bYn.setPriority(3);
        this.bYn.execute(new Boolean[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private v Tv = null;
        private boolean aKN;
        private e bYh;

        public a(boolean z) {
            this.aKN = true;
            this.bYh = null;
            this.aKN = z;
            this.bYh = new e();
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
            if (this.aKN) {
                this.Tv = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.b(c.this.bYm);
                this.Tv.o("data", aVar.at(0, 1));
            } else {
                this.Tv = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
                this.Tv.o("user_id", c.this.bYm.getAccount());
                this.Tv.o("tid", c.this.bYm.getId());
            }
            this.bYh.parserJson(this.Tv.tI());
            boolean z = this.bYh.getErrorCode() == 0;
            if (this.Tv.uj().va().qZ() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Tv != null) {
                this.Tv.gJ();
            }
            c.this.bYn = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            try {
                if (bool.booleanValue()) {
                    if (c.this.bYo != null) {
                        c.this.bYo.a(true, this.aKN, null);
                    }
                } else if (c.this.bYo != null) {
                    if (this.Tv == null || this.Tv.uj().va().qZ()) {
                        c.this.bYo.a(false, this.aKN, this.bYh.getErrorString());
                    } else {
                        c.this.bYo.a(false, this.aKN, this.Tv.getErrorString());
                    }
                }
                c.this.bYn = null;
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
        if (this.bYn != null) {
            this.bYn.cancel();
            return false;
        }
        return false;
    }
}
