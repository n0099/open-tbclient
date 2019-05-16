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
    private boolean hsJ;
    private MarkData hsK;
    private a hsL;
    private a.InterfaceC0236a hsM;

    public void a(a.InterfaceC0236a interfaceC0236a) {
        this.hsM = interfaceC0236a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hsJ = false;
        this.hsK = null;
        this.hsL = null;
        this.hsM = null;
        this.hsK = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.hsJ = false;
        this.hsK = null;
        this.hsL = null;
        this.hsM = null;
        this.hsK = new MarkData();
    }

    public boolean ZC() {
        return this.hsJ;
    }

    public MarkData ZF() {
        return this.hsK;
    }

    public void a(MarkData markData) {
        this.hsK = markData;
    }

    public void ds(boolean z) {
        this.hsJ = z;
    }

    public String ZB() {
        if (this.hsK != null) {
            return this.hsK.getPostId();
        }
        return null;
    }

    public void ZE() {
        if (this.hsL != null) {
            this.hsL.cancel();
        }
        this.hsL = new a(true);
        this.hsL.setPriority(3);
        this.hsL.execute(new Boolean[0]);
    }

    public void ZD() {
        if (this.hsL != null) {
            this.hsL.cancel();
        }
        this.hsL = new a(false);
        this.hsL.setPriority(3);
        this.hsL.execute(new Boolean[0]);
    }

    /* loaded from: classes6.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean eFI;
        private c hsF;
        private x mNetWork = null;

        public a(boolean z) {
            this.eFI = true;
            this.hsF = null;
            this.eFI = z;
            this.hsF = new c();
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
            if (this.eFI) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.hsK);
                this.mNetWork.o("data", aVar.bW(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.o("user_id", MarkModel.this.hsK.getAccount());
                this.mNetWork.o("tid", MarkModel.this.hsK.getId());
                this.mNetWork.o("fid", MarkModel.this.hsK.getForumId());
            }
            this.hsF.parserJson(this.mNetWork.ahe());
            boolean z = this.hsF.getErrorCode() == 0;
            if (this.mNetWork.ahC().aiC().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ia();
            }
            MarkModel.this.hsL = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.hsF != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.hsF.getErrorCode(), this.hsF.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.hsM != null) {
                        MarkModel.this.hsM.c(true, this.eFI, null);
                    }
                } else if (MarkModel.this.hsM != null) {
                    if (this.mNetWork == null || this.mNetWork.ahC().aiC().isRequestSuccess()) {
                        MarkModel.this.hsM.c(false, this.eFI, this.hsF.getErrorString());
                    } else {
                        MarkModel.this.hsM.c(false, this.eFI, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.hsL = null;
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
        if (this.hsL != null) {
            this.hsL.cancel();
            return false;
        }
        return false;
    }
}
