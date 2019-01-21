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
    private a fLA;
    private a.InterfaceC0154a fLB;
    private boolean fLy;
    private MarkData fLz;

    public void a(a.InterfaceC0154a interfaceC0154a) {
        this.fLB = interfaceC0154a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fLy = false;
        this.fLz = null;
        this.fLA = null;
        this.fLB = null;
        this.fLz = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fLy = false;
        this.fLz = null;
        this.fLA = null;
        this.fLB = null;
        this.fLz = new MarkData();
    }

    public boolean wx() {
        return this.fLy;
    }

    public MarkData wA() {
        return this.fLz;
    }

    public void a(MarkData markData) {
        this.fLz = markData;
    }

    public void aQ(boolean z) {
        this.fLy = z;
    }

    public String ww() {
        if (this.fLz != null) {
            return this.fLz.getPostId();
        }
        return null;
    }

    public void wz() {
        if (this.fLA != null) {
            this.fLA.cancel();
        }
        this.fLA = new a(true);
        this.fLA.setPriority(3);
        this.fLA.execute(new Boolean[0]);
    }

    public void wy() {
        if (this.fLA != null) {
            this.fLA.cancel();
        }
        this.fLA = new a(false);
        this.fLA.setPriority(3);
        this.fLA.execute(new Boolean[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean dgt;
        private c fLu;
        private x mNetWork = null;

        public a(boolean z) {
            this.dgt = true;
            this.fLu = null;
            this.dgt = z;
            this.fLu = new c();
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
            if (this.dgt) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.fLz);
                this.mNetWork.x("data", aVar.bt(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.x("user_id", MarkModel.this.fLz.getAccount());
                this.mNetWork.x("tid", MarkModel.this.fLz.getId());
                this.mNetWork.x(ImageViewerConfig.FORUM_ID, MarkModel.this.fLz.getForumId());
            }
            this.fLu.parserJson(this.mNetWork.CY());
            boolean z = this.fLu.getErrorCode() == 0;
            if (this.mNetWork.Dw().Ev().isRequestSuccess() && z) {
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
            MarkModel.this.fLA = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.fLu != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.fLu.getErrorCode(), this.fLu.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.fLB != null) {
                        MarkModel.this.fLB.a(true, this.dgt, null);
                    }
                } else if (MarkModel.this.fLB != null) {
                    if (this.mNetWork == null || this.mNetWork.Dw().Ev().isRequestSuccess()) {
                        MarkModel.this.fLB.a(false, this.dgt, this.fLu.getErrorString());
                    } else {
                        MarkModel.this.fLB.a(false, this.dgt, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.fLA = null;
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
        if (this.fLA != null) {
            this.fLA.cancel();
            return false;
        }
        return false;
    }
}
