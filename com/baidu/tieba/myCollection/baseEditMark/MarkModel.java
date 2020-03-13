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
/* loaded from: classes11.dex */
public class MarkModel extends BdBaseModel {
    private boolean itw;
    private MarkData itx;
    private a ity;
    private a.InterfaceC0374a itz;

    public void a(a.InterfaceC0374a interfaceC0374a) {
        this.itz = interfaceC0374a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.itw = false;
        this.itx = null;
        this.ity = null;
        this.itz = null;
        this.itx = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.itw = false;
        this.itx = null;
        this.ity = null;
        this.itz = null;
        this.itx = new MarkData();
    }

    public boolean ayL() {
        return this.itw;
    }

    public MarkData ayO() {
        return this.itx;
    }

    public void a(MarkData markData) {
        this.itx = markData;
    }

    public void fm(boolean z) {
        this.itw = z;
    }

    public String ayK() {
        if (this.itx != null) {
            return this.itx.getPostId();
        }
        return null;
    }

    public void ayN() {
        if (this.ity != null) {
            this.ity.cancel();
        }
        this.ity = new a(true);
        this.ity.setPriority(3);
        this.ity.execute(new Boolean[0]);
    }

    public void ayM() {
        if (this.ity != null) {
            this.ity.cancel();
        }
        this.ity = new a(false);
        this.ity.setPriority(3);
        this.ity.execute(new Boolean[0]);
    }

    /* loaded from: classes11.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x cLF = null;
        private boolean fOM;
        private c its;

        public a(boolean z) {
            this.fOM = true;
            this.its = null;
            this.fOM = z;
            this.its = new c();
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
            if (this.fOM) {
                this.cLF = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.itx);
                this.cLF.addPostData("data", aVar.cm(0, 1));
            } else {
                this.cLF = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.cLF.addPostData("user_id", MarkModel.this.itx.getAccount());
                this.cLF.addPostData("tid", MarkModel.this.itx.getId());
                this.cLF.addPostData("fid", MarkModel.this.itx.getForumId());
            }
            this.its.parserJson(this.cLF.postNetData());
            boolean z = this.its.getErrorCode() == 0;
            if (this.cLF.aGg().aGI().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cLF != null) {
                this.cLF.cancelNetConnect();
            }
            MarkModel.this.ity = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.its != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.its.getErrorCode(), this.its.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.itz != null) {
                        MarkModel.this.itz.c(true, this.fOM, null);
                    }
                } else if (MarkModel.this.itz != null) {
                    if (this.cLF == null || this.cLF.aGg().aGI().isRequestSuccess()) {
                        MarkModel.this.itz.c(false, this.fOM, this.its.getErrorString());
                    } else {
                        MarkModel.this.itz.c(false, this.fOM, this.cLF.getErrorString());
                    }
                }
                MarkModel.this.ity = null;
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
        if (this.ity != null) {
            this.ity.cancel();
            return false;
        }
        return false;
    }
}
