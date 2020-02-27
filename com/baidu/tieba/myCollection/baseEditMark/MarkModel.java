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
    private boolean iti;
    private MarkData itj;
    private a itk;
    private a.InterfaceC0374a itl;

    public void a(a.InterfaceC0374a interfaceC0374a) {
        this.itl = interfaceC0374a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.iti = false;
        this.itj = null;
        this.itk = null;
        this.itl = null;
        this.itj = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.iti = false;
        this.itj = null;
        this.itk = null;
        this.itl = null;
        this.itj = new MarkData();
    }

    public boolean ayJ() {
        return this.iti;
    }

    public MarkData ayM() {
        return this.itj;
    }

    public void a(MarkData markData) {
        this.itj = markData;
    }

    public void fm(boolean z) {
        this.iti = z;
    }

    public String ayI() {
        if (this.itj != null) {
            return this.itj.getPostId();
        }
        return null;
    }

    public void ayL() {
        if (this.itk != null) {
            this.itk.cancel();
        }
        this.itk = new a(true);
        this.itk.setPriority(3);
        this.itk.execute(new Boolean[0]);
    }

    public void ayK() {
        if (this.itk != null) {
            this.itk.cancel();
        }
        this.itk = new a(false);
        this.itk.setPriority(3);
        this.itk.execute(new Boolean[0]);
    }

    /* loaded from: classes11.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x cLD = null;
        private boolean fOx;
        private c ite;

        public a(boolean z) {
            this.fOx = true;
            this.ite = null;
            this.fOx = z;
            this.ite = new c();
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
            if (this.fOx) {
                this.cLD = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.itj);
                this.cLD.addPostData("data", aVar.cm(0, 1));
            } else {
                this.cLD = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.cLD.addPostData("user_id", MarkModel.this.itj.getAccount());
                this.cLD.addPostData("tid", MarkModel.this.itj.getId());
                this.cLD.addPostData("fid", MarkModel.this.itj.getForumId());
            }
            this.ite.parserJson(this.cLD.postNetData());
            boolean z = this.ite.getErrorCode() == 0;
            if (this.cLD.aGe().aGG().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cLD != null) {
                this.cLD.cancelNetConnect();
            }
            MarkModel.this.itk = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.ite != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.ite.getErrorCode(), this.ite.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.itl != null) {
                        MarkModel.this.itl.c(true, this.fOx, null);
                    }
                } else if (MarkModel.this.itl != null) {
                    if (this.cLD == null || this.cLD.aGe().aGG().isRequestSuccess()) {
                        MarkModel.this.itl.c(false, this.fOx, this.ite.getErrorString());
                    } else {
                        MarkModel.this.itl.c(false, this.fOx, this.cLD.getErrorString());
                    }
                }
                MarkModel.this.itk = null;
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
        if (this.itk != null) {
            this.itk.cancel();
            return false;
        }
        return false;
    }
}
