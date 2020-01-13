package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes9.dex */
public class MarkModel extends BdBaseModel {
    private boolean irn;
    private MarkData iro;
    private a irp;
    private a.InterfaceC0364a irq;

    public void a(a.InterfaceC0364a interfaceC0364a) {
        this.irq = interfaceC0364a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.irn = false;
        this.iro = null;
        this.irp = null;
        this.irq = null;
        this.iro = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.irn = false;
        this.iro = null;
        this.irp = null;
        this.irq = null;
        this.iro = new MarkData();
    }

    public boolean aww() {
        return this.irn;
    }

    public MarkData awz() {
        return this.iro;
    }

    public void a(MarkData markData) {
        this.iro = markData;
    }

    public void ff(boolean z) {
        this.irn = z;
    }

    public String awv() {
        if (this.iro != null) {
            return this.iro.getPostId();
        }
        return null;
    }

    public void awy() {
        if (this.irp != null) {
            this.irp.cancel();
        }
        this.irp = new a(true);
        this.irp.setPriority(3);
        this.irp.execute(new Boolean[0]);
    }

    public void awx() {
        if (this.irp != null) {
            this.irp.cancel();
        }
        this.irp = new a(false);
        this.irp.setPriority(3);
        this.irp.execute(new Boolean[0]);
    }

    /* loaded from: classes9.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x cHA = null;
        private boolean fMb;
        private c irj;

        public a(boolean z) {
            this.fMb = true;
            this.irj = null;
            this.fMb = z;
            this.irj = new c();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            if (this.fMb) {
                this.cHA = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.iro);
                this.cHA.addPostData("data", aVar.cl(0, 1));
            } else {
                this.cHA = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.cHA.addPostData("user_id", MarkModel.this.iro.getAccount());
                this.cHA.addPostData("tid", MarkModel.this.iro.getId());
                this.cHA.addPostData("fid", MarkModel.this.iro.getForumId());
            }
            this.irj.parserJson(this.cHA.postNetData());
            boolean z = this.irj.getErrorCode() == 0;
            if (this.cHA.aDU().aEv().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cHA != null) {
                this.cHA.cancelNetConnect();
            }
            MarkModel.this.irp = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.irj != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.irj.getErrorCode(), this.irj.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.irq != null) {
                        MarkModel.this.irq.c(true, this.fMb, null);
                    }
                } else if (MarkModel.this.irq != null) {
                    if (this.cHA == null || this.cHA.aDU().aEv().isRequestSuccess()) {
                        MarkModel.this.irq.c(false, this.fMb, this.irj.getErrorString());
                    } else {
                        MarkModel.this.irq.c(false, this.fMb, this.cHA.getErrorString());
                    }
                }
                MarkModel.this.irp = null;
            } catch (Throwable th) {
                BdLog.e(th.toString());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.irp != null) {
            this.irp.cancel();
            return false;
        }
        return false;
    }
}
