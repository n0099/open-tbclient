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
    private boolean itk;
    private MarkData itl;
    private a itm;
    private a.InterfaceC0374a itn;

    public void a(a.InterfaceC0374a interfaceC0374a) {
        this.itn = interfaceC0374a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.itk = false;
        this.itl = null;
        this.itm = null;
        this.itn = null;
        this.itl = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.itk = false;
        this.itl = null;
        this.itm = null;
        this.itn = null;
        this.itl = new MarkData();
    }

    public boolean ayL() {
        return this.itk;
    }

    public MarkData ayO() {
        return this.itl;
    }

    public void a(MarkData markData) {
        this.itl = markData;
    }

    public void fm(boolean z) {
        this.itk = z;
    }

    public String ayK() {
        if (this.itl != null) {
            return this.itl.getPostId();
        }
        return null;
    }

    public void ayN() {
        if (this.itm != null) {
            this.itm.cancel();
        }
        this.itm = new a(true);
        this.itm.setPriority(3);
        this.itm.execute(new Boolean[0]);
    }

    public void ayM() {
        if (this.itm != null) {
            this.itm.cancel();
        }
        this.itm = new a(false);
        this.itm.setPriority(3);
        this.itm.execute(new Boolean[0]);
    }

    /* loaded from: classes11.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x cLE = null;
        private boolean fOz;
        private c itg;

        public a(boolean z) {
            this.fOz = true;
            this.itg = null;
            this.fOz = z;
            this.itg = new c();
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
            if (this.fOz) {
                this.cLE = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.itl);
                this.cLE.addPostData("data", aVar.cm(0, 1));
            } else {
                this.cLE = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.cLE.addPostData("user_id", MarkModel.this.itl.getAccount());
                this.cLE.addPostData("tid", MarkModel.this.itl.getId());
                this.cLE.addPostData("fid", MarkModel.this.itl.getForumId());
            }
            this.itg.parserJson(this.cLE.postNetData());
            boolean z = this.itg.getErrorCode() == 0;
            if (this.cLE.aGg().aGI().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cLE != null) {
                this.cLE.cancelNetConnect();
            }
            MarkModel.this.itm = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.itg != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.itg.getErrorCode(), this.itg.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.itn != null) {
                        MarkModel.this.itn.c(true, this.fOz, null);
                    }
                } else if (MarkModel.this.itn != null) {
                    if (this.cLE == null || this.cLE.aGg().aGI().isRequestSuccess()) {
                        MarkModel.this.itn.c(false, this.fOz, this.itg.getErrorString());
                    } else {
                        MarkModel.this.itn.c(false, this.fOz, this.cLE.getErrorString());
                    }
                }
                MarkModel.this.itm = null;
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
        if (this.itm != null) {
            this.itm.cancel();
            return false;
        }
        return false;
    }
}
