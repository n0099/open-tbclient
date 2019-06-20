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
    private boolean hsN;
    private MarkData hsO;
    private a hsP;
    private a.InterfaceC0236a hsQ;

    public void a(a.InterfaceC0236a interfaceC0236a) {
        this.hsQ = interfaceC0236a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hsN = false;
        this.hsO = null;
        this.hsP = null;
        this.hsQ = null;
        this.hsO = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.hsN = false;
        this.hsO = null;
        this.hsP = null;
        this.hsQ = null;
        this.hsO = new MarkData();
    }

    public boolean ZC() {
        return this.hsN;
    }

    public MarkData ZF() {
        return this.hsO;
    }

    public void a(MarkData markData) {
        this.hsO = markData;
    }

    public void ds(boolean z) {
        this.hsN = z;
    }

    public String ZB() {
        if (this.hsO != null) {
            return this.hsO.getPostId();
        }
        return null;
    }

    public void ZE() {
        if (this.hsP != null) {
            this.hsP.cancel();
        }
        this.hsP = new a(true);
        this.hsP.setPriority(3);
        this.hsP.execute(new Boolean[0]);
    }

    public void ZD() {
        if (this.hsP != null) {
            this.hsP.cancel();
        }
        this.hsP = new a(false);
        this.hsP.setPriority(3);
        this.hsP.execute(new Boolean[0]);
    }

    /* loaded from: classes6.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean eFJ;
        private c hsJ;
        private x mNetWork = null;

        public a(boolean z) {
            this.eFJ = true;
            this.hsJ = null;
            this.eFJ = z;
            this.hsJ = new c();
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
                aVar.f(MarkModel.this.hsO);
                this.mNetWork.o("data", aVar.bW(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.o("user_id", MarkModel.this.hsO.getAccount());
                this.mNetWork.o("tid", MarkModel.this.hsO.getId());
                this.mNetWork.o("fid", MarkModel.this.hsO.getForumId());
            }
            this.hsJ.parserJson(this.mNetWork.ahe());
            boolean z = this.hsJ.getErrorCode() == 0;
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
            MarkModel.this.hsP = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.hsJ != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.hsJ.getErrorCode(), this.hsJ.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.hsQ != null) {
                        MarkModel.this.hsQ.c(true, this.eFJ, null);
                    }
                } else if (MarkModel.this.hsQ != null) {
                    if (this.mNetWork == null || this.mNetWork.ahC().aiC().isRequestSuccess()) {
                        MarkModel.this.hsQ.c(false, this.eFJ, this.hsJ.getErrorString());
                    } else {
                        MarkModel.this.hsQ.c(false, this.eFJ, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.hsP = null;
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
        if (this.hsP != null) {
            this.hsP.cancel();
            return false;
        }
        return false;
    }
}
