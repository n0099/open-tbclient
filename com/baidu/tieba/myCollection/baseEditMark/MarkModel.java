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
    private boolean hsM;
    private MarkData hsN;
    private a hsO;
    private a.InterfaceC0236a hsP;

    public void a(a.InterfaceC0236a interfaceC0236a) {
        this.hsP = interfaceC0236a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hsM = false;
        this.hsN = null;
        this.hsO = null;
        this.hsP = null;
        this.hsN = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.hsM = false;
        this.hsN = null;
        this.hsO = null;
        this.hsP = null;
        this.hsN = new MarkData();
    }

    public boolean ZC() {
        return this.hsM;
    }

    public MarkData ZF() {
        return this.hsN;
    }

    public void a(MarkData markData) {
        this.hsN = markData;
    }

    public void ds(boolean z) {
        this.hsM = z;
    }

    public String ZB() {
        if (this.hsN != null) {
            return this.hsN.getPostId();
        }
        return null;
    }

    public void ZE() {
        if (this.hsO != null) {
            this.hsO.cancel();
        }
        this.hsO = new a(true);
        this.hsO.setPriority(3);
        this.hsO.execute(new Boolean[0]);
    }

    public void ZD() {
        if (this.hsO != null) {
            this.hsO.cancel();
        }
        this.hsO = new a(false);
        this.hsO.setPriority(3);
        this.hsO.execute(new Boolean[0]);
    }

    /* loaded from: classes6.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean eFJ;
        private c hsI;
        private x mNetWork = null;

        public a(boolean z) {
            this.eFJ = true;
            this.hsI = null;
            this.eFJ = z;
            this.hsI = new c();
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
            if (this.eFJ) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.hsN);
                this.mNetWork.o("data", aVar.bW(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.o("user_id", MarkModel.this.hsN.getAccount());
                this.mNetWork.o("tid", MarkModel.this.hsN.getId());
                this.mNetWork.o("fid", MarkModel.this.hsN.getForumId());
            }
            this.hsI.parserJson(this.mNetWork.ahe());
            boolean z = this.hsI.getErrorCode() == 0;
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
            MarkModel.this.hsO = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.hsI != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.hsI.getErrorCode(), this.hsI.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.hsP != null) {
                        MarkModel.this.hsP.c(true, this.eFJ, null);
                    }
                } else if (MarkModel.this.hsP != null) {
                    if (this.mNetWork == null || this.mNetWork.ahC().aiC().isRequestSuccess()) {
                        MarkModel.this.hsP.c(false, this.eFJ, this.hsI.getErrorString());
                    } else {
                        MarkModel.this.hsP.c(false, this.eFJ, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.hsO = null;
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
        if (this.hsO != null) {
            this.hsO.cancel();
            return false;
        }
        return false;
    }
}
