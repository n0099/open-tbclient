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
    private boolean eUY;
    private MarkData eUZ;
    private a eVa;
    private a.InterfaceC0082a eVb;

    public void a(a.InterfaceC0082a interfaceC0082a) {
        this.eVb = interfaceC0082a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eUY = false;
        this.eUZ = null;
        this.eVa = null;
        this.eVb = null;
        this.eUZ = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.eUY = false;
        this.eUZ = null;
        this.eVa = null;
        this.eVb = null;
        this.eUZ = new MarkData();
    }

    public boolean oH() {
        return this.eUY;
    }

    public MarkData oK() {
        return this.eUZ;
    }

    public void a(MarkData markData) {
        this.eUZ = markData;
    }

    public void ae(boolean z) {
        this.eUY = z;
    }

    public String oG() {
        if (this.eUZ != null) {
            return this.eUZ.getPostId();
        }
        return null;
    }

    public void oJ() {
        if (this.eVa != null) {
            this.eVa.cancel();
        }
        this.eVa = new a(true);
        this.eVa.setPriority(3);
        this.eVa.execute(new Boolean[0]);
    }

    public void oI() {
        if (this.eVa != null) {
            this.eVa.cancel();
        }
        this.eVa = new a(false);
        this.eVa.setPriority(3);
        this.eVa.execute(new Boolean[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean cxQ;
        private c eUU;
        private x mNetWork = null;

        public a(boolean z) {
            this.cxQ = true;
            this.eUU = null;
            this.cxQ = z;
            this.eUU = new c();
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
            if (this.cxQ) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.eUZ);
                this.mNetWork.n("data", aVar.bj(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.n("user_id", MarkModel.this.eUZ.getAccount());
                this.mNetWork.n("tid", MarkModel.this.eUZ.getId());
                this.mNetWork.n(ImageViewerConfig.FORUM_ID, MarkModel.this.eUZ.getForumId());
            }
            this.eUU.parserJson(this.mNetWork.uK());
            boolean z = this.eUU.getErrorCode() == 0;
            if (this.mNetWork.vi().wi().isRequestSuccess() && z) {
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
            MarkModel.this.eVa = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.eUU != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.eUU.getErrorCode(), this.eUU.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.eVb != null) {
                        MarkModel.this.eVb.a(true, this.cxQ, null);
                    }
                } else if (MarkModel.this.eVb != null) {
                    if (this.mNetWork == null || this.mNetWork.vi().wi().isRequestSuccess()) {
                        MarkModel.this.eVb.a(false, this.cxQ, this.eUU.getErrorString());
                    } else {
                        MarkModel.this.eVb.a(false, this.cxQ, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.eVa = null;
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
        if (this.eVa != null) {
            this.eVa.cancel();
            return false;
        }
        return false;
    }
}
