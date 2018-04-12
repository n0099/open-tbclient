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
    private boolean eTU;
    private MarkData eTV;
    private a eTW;
    private a.InterfaceC0082a eTX;

    public void a(a.InterfaceC0082a interfaceC0082a) {
        this.eTX = interfaceC0082a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eTU = false;
        this.eTV = null;
        this.eTW = null;
        this.eTX = null;
        this.eTV = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.eTU = false;
        this.eTV = null;
        this.eTW = null;
        this.eTX = null;
        this.eTV = new MarkData();
    }

    public boolean oI() {
        return this.eTU;
    }

    public MarkData oL() {
        return this.eTV;
    }

    public void a(MarkData markData) {
        this.eTV = markData;
    }

    public void ae(boolean z) {
        this.eTU = z;
    }

    public String oH() {
        if (this.eTV != null) {
            return this.eTV.getPostId();
        }
        return null;
    }

    public void oK() {
        if (this.eTW != null) {
            this.eTW.cancel();
        }
        this.eTW = new a(true);
        this.eTW.setPriority(3);
        this.eTW.execute(new Boolean[0]);
    }

    public void oJ() {
        if (this.eTW != null) {
            this.eTW.cancel();
        }
        this.eTW = new a(false);
        this.eTW.setPriority(3);
        this.eTW.execute(new Boolean[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean cwK;
        private c eTQ;
        private x mNetWork = null;

        public a(boolean z) {
            this.cwK = true;
            this.eTQ = null;
            this.cwK = z;
            this.eTQ = new c();
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
            if (this.cwK) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.eTV);
                this.mNetWork.n("data", aVar.bk(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.n("user_id", MarkModel.this.eTV.getAccount());
                this.mNetWork.n("tid", MarkModel.this.eTV.getId());
                this.mNetWork.n(ImageViewerConfig.FORUM_ID, MarkModel.this.eTV.getForumId());
            }
            this.eTQ.parserJson(this.mNetWork.uL());
            boolean z = this.eTQ.getErrorCode() == 0;
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
            MarkModel.this.eTW = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.eTQ != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.eTQ.getErrorCode(), this.eTQ.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.eTX != null) {
                        MarkModel.this.eTX.a(true, this.cwK, null);
                    }
                } else if (MarkModel.this.eTX != null) {
                    if (this.mNetWork == null || this.mNetWork.vj().wj().isRequestSuccess()) {
                        MarkModel.this.eTX.a(false, this.cwK, this.eTQ.getErrorString());
                    } else {
                        MarkModel.this.eTX.a(false, this.cwK, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.eTW = null;
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
        if (this.eTW != null) {
            this.eTW.cancel();
            return false;
        }
        return false;
    }
}
