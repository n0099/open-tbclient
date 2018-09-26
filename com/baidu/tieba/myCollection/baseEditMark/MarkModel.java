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
    private boolean frT;
    private MarkData frU;
    private a frV;
    private a.InterfaceC0096a frW;

    public void a(a.InterfaceC0096a interfaceC0096a) {
        this.frW = interfaceC0096a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.frT = false;
        this.frU = null;
        this.frV = null;
        this.frW = null;
        this.frU = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.frT = false;
        this.frU = null;
        this.frV = null;
        this.frW = null;
        this.frU = new MarkData();
    }

    public boolean sR() {
        return this.frT;
    }

    public MarkData sU() {
        return this.frU;
    }

    public void a(MarkData markData) {
        this.frU = markData;
    }

    public void an(boolean z) {
        this.frT = z;
    }

    public String sQ() {
        if (this.frU != null) {
            return this.frU.getPostId();
        }
        return null;
    }

    public void sT() {
        if (this.frV != null) {
            this.frV.cancel();
        }
        this.frV = new a(true);
        this.frV.setPriority(3);
        this.frV.execute(new Boolean[0]);
    }

    public void sS() {
        if (this.frV != null) {
            this.frV.cancel();
        }
        this.frV = new a(false);
        this.frV.setPriority(3);
        this.frV.execute(new Boolean[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean cMG;
        private c frP;
        private x mNetWork = null;

        public a(boolean z) {
            this.cMG = true;
            this.frP = null;
            this.cMG = z;
            this.frP = new c();
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
            if (this.cMG) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.frU);
                this.mNetWork.u("data", aVar.bp(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.u("user_id", MarkModel.this.frU.getAccount());
                this.mNetWork.u("tid", MarkModel.this.frU.getId());
                this.mNetWork.u(ImageViewerConfig.FORUM_ID, MarkModel.this.frU.getForumId());
            }
            this.frP.parserJson(this.mNetWork.zt());
            boolean z = this.frP.getErrorCode() == 0;
            if (this.mNetWork.zR().AQ().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.iT();
            }
            MarkModel.this.frV = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.frP != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.frP.getErrorCode(), this.frP.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.frW != null) {
                        MarkModel.this.frW.a(true, this.cMG, null);
                    }
                } else if (MarkModel.this.frW != null) {
                    if (this.mNetWork == null || this.mNetWork.zR().AQ().isRequestSuccess()) {
                        MarkModel.this.frW.a(false, this.cMG, this.frP.getErrorString());
                    } else {
                        MarkModel.this.frW.a(false, this.cMG, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.frV = null;
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
        if (this.frV != null) {
            this.frV.cancel();
            return false;
        }
        return false;
    }
}
