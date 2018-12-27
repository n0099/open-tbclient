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
    private boolean fKD;
    private MarkData fKE;
    private a fKF;
    private a.InterfaceC0154a fKG;

    public void a(a.InterfaceC0154a interfaceC0154a) {
        this.fKG = interfaceC0154a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fKD = false;
        this.fKE = null;
        this.fKF = null;
        this.fKG = null;
        this.fKE = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fKD = false;
        this.fKE = null;
        this.fKF = null;
        this.fKG = null;
        this.fKE = new MarkData();
    }

    public boolean wq() {
        return this.fKD;
    }

    public MarkData wt() {
        return this.fKE;
    }

    public void a(MarkData markData) {
        this.fKE = markData;
    }

    public void aP(boolean z) {
        this.fKD = z;
    }

    public String wp() {
        if (this.fKE != null) {
            return this.fKE.getPostId();
        }
        return null;
    }

    public void ws() {
        if (this.fKF != null) {
            this.fKF.cancel();
        }
        this.fKF = new a(true);
        this.fKF.setPriority(3);
        this.fKF.execute(new Boolean[0]);
    }

    public void wr() {
        if (this.fKF != null) {
            this.fKF.cancel();
        }
        this.fKF = new a(false);
        this.fKF.setPriority(3);
        this.fKF.execute(new Boolean[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean dfG;
        private c fKz;
        private x mNetWork = null;

        public a(boolean z) {
            this.dfG = true;
            this.fKz = null;
            this.dfG = z;
            this.fKz = new c();
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
            if (this.dfG) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.fKE);
                this.mNetWork.x("data", aVar.bt(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.x("user_id", MarkModel.this.fKE.getAccount());
                this.mNetWork.x("tid", MarkModel.this.fKE.getId());
                this.mNetWork.x(ImageViewerConfig.FORUM_ID, MarkModel.this.fKE.getForumId());
            }
            this.fKz.parserJson(this.mNetWork.CL());
            boolean z = this.fKz.getErrorCode() == 0;
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
            MarkModel.this.fKF = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.fKz != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.fKz.getErrorCode(), this.fKz.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.fKG != null) {
                        MarkModel.this.fKG.a(true, this.dfG, null);
                    }
                } else if (MarkModel.this.fKG != null) {
                    if (this.mNetWork == null || this.mNetWork.Dj().Ei().isRequestSuccess()) {
                        MarkModel.this.fKG.a(false, this.dfG, this.fKz.getErrorString());
                    } else {
                        MarkModel.this.fKG.a(false, this.dfG, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.fKF = null;
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
        if (this.fKF != null) {
            this.fKF.cancel();
            return false;
        }
        return false;
    }
}
