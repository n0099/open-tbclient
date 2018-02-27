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
    private boolean fyT;
    private MarkData fyU;
    private a fyV;
    private a.InterfaceC0093a fyW;

    public void a(a.InterfaceC0093a interfaceC0093a) {
        this.fyW = interfaceC0093a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fyT = false;
        this.fyU = null;
        this.fyV = null;
        this.fyW = null;
        this.fyU = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fyT = false;
        this.fyU = null;
        this.fyV = null;
        this.fyW = null;
        this.fyU = new MarkData();
    }

    public boolean vX() {
        return this.fyT;
    }

    public MarkData wa() {
        return this.fyU;
    }

    public void a(MarkData markData) {
        this.fyU = markData;
    }

    public void aL(boolean z) {
        this.fyT = z;
    }

    public String vW() {
        if (this.fyU != null) {
            return this.fyU.getPostId();
        }
        return null;
    }

    public void vZ() {
        if (this.fyV != null) {
            this.fyV.cancel();
        }
        this.fyV = new a(true);
        this.fyV.setPriority(3);
        this.fyV.execute(new Boolean[0]);
    }

    public void vY() {
        if (this.fyV != null) {
            this.fyV.cancel();
        }
        this.fyV = new a(false);
        this.fyV.setPriority(3);
        this.fyV.execute(new Boolean[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean deR;
        private c fyP;
        private x mNetWork = null;

        public a(boolean z) {
            this.deR = true;
            this.fyP = null;
            this.deR = z;
            this.fyP = new c();
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
            if (this.deR) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.fyU);
                this.mNetWork.n("data", aVar.cj(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.n("user_id", MarkModel.this.fyU.getAccount());
                this.mNetWork.n("tid", MarkModel.this.fyU.getId());
                this.mNetWork.n(ImageViewerConfig.FORUM_ID, MarkModel.this.fyU.getForumId());
            }
            this.fyP.parserJson(this.mNetWork.Ca());
            boolean z = this.fyP.getErrorCode() == 0;
            if (this.mNetWork.Cy().Dw().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.mS();
            }
            MarkModel.this.fyV = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.fyP != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.fyP.getErrorCode(), this.fyP.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.fyW != null) {
                        MarkModel.this.fyW.a(true, this.deR, null);
                    }
                } else if (MarkModel.this.fyW != null) {
                    if (this.mNetWork == null || this.mNetWork.Cy().Dw().isRequestSuccess()) {
                        MarkModel.this.fyW.a(false, this.deR, this.fyP.getErrorString());
                    } else {
                        MarkModel.this.fyW.a(false, this.deR, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.fyV = null;
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
        if (this.fyV != null) {
            this.fyV.cancel();
            return false;
        }
        return false;
    }
}
