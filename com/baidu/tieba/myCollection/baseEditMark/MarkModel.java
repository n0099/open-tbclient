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
    private boolean hzR;
    private MarkData hzS;
    private a hzT;
    private a.InterfaceC0238a hzU;

    public void a(a.InterfaceC0238a interfaceC0238a) {
        this.hzU = interfaceC0238a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hzR = false;
        this.hzS = null;
        this.hzT = null;
        this.hzU = null;
        this.hzS = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.hzR = false;
        this.hzS = null;
        this.hzT = null;
        this.hzU = null;
        this.hzS = new MarkData();
    }

    public boolean aaB() {
        return this.hzR;
    }

    public MarkData aaE() {
        return this.hzS;
    }

    public void a(MarkData markData) {
        this.hzS = markData;
    }

    public void dx(boolean z) {
        this.hzR = z;
    }

    public String aaA() {
        if (this.hzS != null) {
            return this.hzS.getPostId();
        }
        return null;
    }

    public void aaD() {
        if (this.hzT != null) {
            this.hzT.cancel();
        }
        this.hzT = new a(true);
        this.hzT.setPriority(3);
        this.hzT.execute(new Boolean[0]);
    }

    public void aaC() {
        if (this.hzT != null) {
            this.hzT.cancel();
        }
        this.hzT = new a(false);
        this.hzT.setPriority(3);
        this.hzT.execute(new Boolean[0]);
    }

    /* loaded from: classes6.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean eKM;
        private c hzN;
        private x mNetWork = null;

        public a(boolean z) {
            this.eKM = true;
            this.hzN = null;
            this.eKM = z;
            this.hzN = new c();
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
            if (this.eKM) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.hzS);
                this.mNetWork.o("data", aVar.cc(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.o("user_id", MarkModel.this.hzS.getAccount());
                this.mNetWork.o("tid", MarkModel.this.hzS.getId());
                this.mNetWork.o("fid", MarkModel.this.hzS.getForumId());
            }
            this.hzN.parserJson(this.mNetWork.aii());
            boolean z = this.hzN.getErrorCode() == 0;
            if (this.mNetWork.aiG().ajH().isRequestSuccess() && z) {
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
            MarkModel.this.hzT = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.hzN != null) {
                    com.baidu.tbadk.core.e.a.a("collection", 0L, 0, "add_collection_thread", this.hzN.getErrorCode(), this.hzN.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.hzU != null) {
                        MarkModel.this.hzU.c(true, this.eKM, null);
                    }
                } else if (MarkModel.this.hzU != null) {
                    if (this.mNetWork == null || this.mNetWork.aiG().ajH().isRequestSuccess()) {
                        MarkModel.this.hzU.c(false, this.eKM, this.hzN.getErrorString());
                    } else {
                        MarkModel.this.hzU.c(false, this.eKM, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.hzT = null;
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
        if (this.hzT != null) {
            this.hzT.cancel();
            return false;
        }
        return false;
    }
}
