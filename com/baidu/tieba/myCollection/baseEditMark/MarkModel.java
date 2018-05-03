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
    private boolean eTR;
    private MarkData eTS;
    private a eTT;
    private a.InterfaceC0082a eTU;

    public void a(a.InterfaceC0082a interfaceC0082a) {
        this.eTU = interfaceC0082a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eTR = false;
        this.eTS = null;
        this.eTT = null;
        this.eTU = null;
        this.eTS = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.eTR = false;
        this.eTS = null;
        this.eTT = null;
        this.eTU = null;
        this.eTS = new MarkData();
    }

    public boolean oI() {
        return this.eTR;
    }

    public MarkData oL() {
        return this.eTS;
    }

    public void a(MarkData markData) {
        this.eTS = markData;
    }

    public void ae(boolean z) {
        this.eTR = z;
    }

    public String oH() {
        if (this.eTS != null) {
            return this.eTS.getPostId();
        }
        return null;
    }

    public void oK() {
        if (this.eTT != null) {
            this.eTT.cancel();
        }
        this.eTT = new a(true);
        this.eTT.setPriority(3);
        this.eTT.execute(new Boolean[0]);
    }

    public void oJ() {
        if (this.eTT != null) {
            this.eTT.cancel();
        }
        this.eTT = new a(false);
        this.eTT.setPriority(3);
        this.eTT.execute(new Boolean[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean cwH;
        private c eTN;
        private x mNetWork = null;

        public a(boolean z) {
            this.cwH = true;
            this.eTN = null;
            this.cwH = z;
            this.eTN = new c();
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
            if (this.cwH) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.eTS);
                this.mNetWork.n("data", aVar.bj(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.n("user_id", MarkModel.this.eTS.getAccount());
                this.mNetWork.n("tid", MarkModel.this.eTS.getId());
                this.mNetWork.n(ImageViewerConfig.FORUM_ID, MarkModel.this.eTS.getForumId());
            }
            this.eTN.parserJson(this.mNetWork.uL());
            boolean z = this.eTN.getErrorCode() == 0;
            if (this.mNetWork.vj().wj().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.eW();
            }
            MarkModel.this.eTT = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.eTN != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.eTN.getErrorCode(), this.eTN.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.eTU != null) {
                        MarkModel.this.eTU.a(true, this.cwH, null);
                    }
                } else if (MarkModel.this.eTU != null) {
                    if (this.mNetWork == null || this.mNetWork.vj().wj().isRequestSuccess()) {
                        MarkModel.this.eTU.a(false, this.cwH, this.eTN.getErrorString());
                    } else {
                        MarkModel.this.eTU.a(false, this.cwH, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.eTT = null;
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
        if (this.eTT != null) {
            this.eTT.cancel();
            return false;
        }
        return false;
    }
}
