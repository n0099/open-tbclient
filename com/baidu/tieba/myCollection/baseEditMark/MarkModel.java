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
/* loaded from: classes3.dex */
public class MarkModel extends BdBaseModel {
    private boolean fHL;
    private MarkData fHM;
    private a fHN;
    private a.InterfaceC0154a fHO;

    public void a(a.InterfaceC0154a interfaceC0154a) {
        this.fHO = interfaceC0154a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fHL = false;
        this.fHM = null;
        this.fHN = null;
        this.fHO = null;
        this.fHM = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fHL = false;
        this.fHM = null;
        this.fHN = null;
        this.fHO = null;
        this.fHM = new MarkData();
    }

    public boolean wq() {
        return this.fHL;
    }

    public MarkData wt() {
        return this.fHM;
    }

    public void a(MarkData markData) {
        this.fHM = markData;
    }

    public void aP(boolean z) {
        this.fHL = z;
    }

    public String wp() {
        if (this.fHM != null) {
            return this.fHM.getPostId();
        }
        return null;
    }

    public void ws() {
        if (this.fHN != null) {
            this.fHN.cancel();
        }
        this.fHN = new a(true);
        this.fHN.setPriority(3);
        this.fHN.execute(new Boolean[0]);
    }

    public void wr() {
        if (this.fHN != null) {
            this.fHN.cancel();
        }
        this.fHN = new a(false);
        this.fHN.setPriority(3);
        this.fHN.execute(new Boolean[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean dcO;
        private c fHH;
        private x mNetWork = null;

        public a(boolean z) {
            this.dcO = true;
            this.fHH = null;
            this.dcO = z;
            this.fHH = new c();
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
            if (this.dcO) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.fHM);
                this.mNetWork.x("data", aVar.bs(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.x("user_id", MarkModel.this.fHM.getAccount());
                this.mNetWork.x("tid", MarkModel.this.fHM.getId());
                this.mNetWork.x(ImageViewerConfig.FORUM_ID, MarkModel.this.fHM.getForumId());
            }
            this.fHH.parserJson(this.mNetWork.CL());
            boolean z = this.fHH.getErrorCode() == 0;
            if (this.mNetWork.Dj().Ei().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            MarkModel.this.fHN = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.fHH != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.fHH.getErrorCode(), this.fHH.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.fHO != null) {
                        MarkModel.this.fHO.a(true, this.dcO, null);
                    }
                } else if (MarkModel.this.fHO != null) {
                    if (this.mNetWork == null || this.mNetWork.Dj().Ei().isRequestSuccess()) {
                        MarkModel.this.fHO.a(false, this.dcO, this.fHH.getErrorString());
                    } else {
                        MarkModel.this.fHO.a(false, this.dcO, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.fHN = null;
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
        if (this.fHN != null) {
            this.fHN.cancel();
            return false;
        }
        return false;
    }
}
