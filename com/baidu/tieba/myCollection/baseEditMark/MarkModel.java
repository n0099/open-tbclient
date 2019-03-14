package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes6.dex */
public class MarkModel extends BdBaseModel {
    private boolean hbE;
    private MarkData hbF;
    private a hbG;
    private a.InterfaceC0221a hbH;

    public void a(a.InterfaceC0221a interfaceC0221a) {
        this.hbH = interfaceC0221a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hbE = false;
        this.hbF = null;
        this.hbG = null;
        this.hbH = null;
        this.hbF = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.hbE = false;
        this.hbF = null;
        this.hbG = null;
        this.hbH = null;
        this.hbF = new MarkData();
    }

    public boolean Vb() {
        return this.hbE;
    }

    public MarkData Ve() {
        return this.hbF;
    }

    public void a(MarkData markData) {
        this.hbF = markData;
    }

    public void cZ(boolean z) {
        this.hbE = z;
    }

    public String Va() {
        if (this.hbF != null) {
            return this.hbF.getPostId();
        }
        return null;
    }

    public void Vd() {
        if (this.hbG != null) {
            this.hbG.cancel();
        }
        this.hbG = new a(true);
        this.hbG.setPriority(3);
        this.hbG.execute(new Boolean[0]);
    }

    public void Vc() {
        if (this.hbG != null) {
            this.hbG.cancel();
        }
        this.hbG = new a(false);
        this.hbG.setPriority(3);
        this.hbG.execute(new Boolean[0]);
    }

    /* loaded from: classes6.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean eqo;
        private c hbA;
        private x mNetWork = null;

        public a(boolean z) {
            this.eqo = true;
            this.hbA = null;
            this.eqo = z;
            this.hbA = new c();
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
            if (this.eqo) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.hbF);
                this.mNetWork.x("data", aVar.bP(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.x("user_id", MarkModel.this.hbF.getAccount());
                this.mNetWork.x("tid", MarkModel.this.hbF.getId());
                this.mNetWork.x(ImageViewerConfig.FORUM_ID, MarkModel.this.hbF.getForumId());
            }
            this.hbA.parserJson(this.mNetWork.acj());
            boolean z = this.hbA.getErrorCode() == 0;
            if (this.mNetWork.acH().adG().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ji();
            }
            MarkModel.this.hbG = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.hbA != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.hbA.getErrorCode(), this.hbA.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.hbH != null) {
                        MarkModel.this.hbH.c(true, this.eqo, null);
                    }
                } else if (MarkModel.this.hbH != null) {
                    if (this.mNetWork == null || this.mNetWork.acH().adG().isRequestSuccess()) {
                        MarkModel.this.hbH.c(false, this.eqo, this.hbA.getErrorString());
                    } else {
                        MarkModel.this.hbH.c(false, this.eqo, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.hbG = null;
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
        if (this.hbG != null) {
            this.hbG.cancel();
            return false;
        }
        return false;
    }
}
