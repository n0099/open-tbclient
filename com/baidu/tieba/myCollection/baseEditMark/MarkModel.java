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
/* loaded from: classes6.dex */
public class MarkModel extends BdBaseModel {
    private boolean hBN;
    private MarkData hBO;
    private a hBP;
    private a.InterfaceC0247a hBQ;

    public void a(a.InterfaceC0247a interfaceC0247a) {
        this.hBQ = interfaceC0247a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hBN = false;
        this.hBO = null;
        this.hBP = null;
        this.hBQ = null;
        this.hBO = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.hBN = false;
        this.hBO = null;
        this.hBP = null;
        this.hBQ = null;
        this.hBO = new MarkData();
    }

    public boolean aaF() {
        return this.hBN;
    }

    public MarkData aaI() {
        return this.hBO;
    }

    public void a(MarkData markData) {
        this.hBO = markData;
    }

    public void dx(boolean z) {
        this.hBN = z;
    }

    public String aaE() {
        if (this.hBO != null) {
            return this.hBO.getPostId();
        }
        return null;
    }

    public void aaH() {
        if (this.hBP != null) {
            this.hBP.cancel();
        }
        this.hBP = new a(true);
        this.hBP.setPriority(3);
        this.hBP.execute(new Boolean[0]);
    }

    public void aaG() {
        if (this.hBP != null) {
            this.hBP.cancel();
        }
        this.hBP = new a(false);
        this.hBP.setPriority(3);
        this.hBP.execute(new Boolean[0]);
    }

    /* loaded from: classes6.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean eMv;
        private c hBJ;
        private x mNetWork = null;

        public a(boolean z) {
            this.eMv = true;
            this.hBJ = null;
            this.eMv = z;
            this.hBJ = new c();
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
            if (this.eMv) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.hBO);
                this.mNetWork.o("data", aVar.cc(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.o("user_id", MarkModel.this.hBO.getAccount());
                this.mNetWork.o("tid", MarkModel.this.hBO.getId());
                this.mNetWork.o("fid", MarkModel.this.hBO.getForumId());
            }
            this.hBJ.parserJson(this.mNetWork.aim());
            boolean z = this.hBJ.getErrorCode() == 0;
            if (this.mNetWork.aiK().ajN().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ik();
            }
            MarkModel.this.hBP = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.hBJ != null) {
                    com.baidu.tbadk.core.e.a.a("collection", 0L, 0, "add_collection_thread", this.hBJ.getErrorCode(), this.hBJ.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.hBQ != null) {
                        MarkModel.this.hBQ.c(true, this.eMv, null);
                    }
                } else if (MarkModel.this.hBQ != null) {
                    if (this.mNetWork == null || this.mNetWork.aiK().ajN().isRequestSuccess()) {
                        MarkModel.this.hBQ.c(false, this.eMv, this.hBJ.getErrorString());
                    } else {
                        MarkModel.this.hBQ.c(false, this.eMv, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.hBP = null;
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
        if (this.hBP != null) {
            this.hBP.cancel();
            return false;
        }
        return false;
    }
}
