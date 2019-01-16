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
    private a.InterfaceC0154a fLA;
    private boolean fLx;
    private MarkData fLy;
    private a fLz;

    public void a(a.InterfaceC0154a interfaceC0154a) {
        this.fLA = interfaceC0154a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fLx = false;
        this.fLy = null;
        this.fLz = null;
        this.fLA = null;
        this.fLy = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fLx = false;
        this.fLy = null;
        this.fLz = null;
        this.fLA = null;
        this.fLy = new MarkData();
    }

    public boolean wx() {
        return this.fLx;
    }

    public MarkData wA() {
        return this.fLy;
    }

    public void a(MarkData markData) {
        this.fLy = markData;
    }

    public void aQ(boolean z) {
        this.fLx = z;
    }

    public String ww() {
        if (this.fLy != null) {
            return this.fLy.getPostId();
        }
        return null;
    }

    public void wz() {
        if (this.fLz != null) {
            this.fLz.cancel();
        }
        this.fLz = new a(true);
        this.fLz.setPriority(3);
        this.fLz.execute(new Boolean[0]);
    }

    public void wy() {
        if (this.fLz != null) {
            this.fLz.cancel();
        }
        this.fLz = new a(false);
        this.fLz.setPriority(3);
        this.fLz.execute(new Boolean[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean dgs;
        private c fLt;
        private x mNetWork = null;

        public a(boolean z) {
            this.dgs = true;
            this.fLt = null;
            this.dgs = z;
            this.fLt = new c();
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
            if (this.dgs) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.fLy);
                this.mNetWork.x("data", aVar.bt(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.x("user_id", MarkModel.this.fLy.getAccount());
                this.mNetWork.x("tid", MarkModel.this.fLy.getId());
                this.mNetWork.x(ImageViewerConfig.FORUM_ID, MarkModel.this.fLy.getForumId());
            }
            this.fLt.parserJson(this.mNetWork.CY());
            boolean z = this.fLt.getErrorCode() == 0;
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
            MarkModel.this.fLz = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.fLt != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.fLt.getErrorCode(), this.fLt.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.fLA != null) {
                        MarkModel.this.fLA.a(true, this.dgs, null);
                    }
                } else if (MarkModel.this.fLA != null) {
                    if (this.mNetWork == null || this.mNetWork.Dw().Ev().isRequestSuccess()) {
                        MarkModel.this.fLA.a(false, this.dgs, this.fLt.getErrorString());
                    } else {
                        MarkModel.this.fLA.a(false, this.dgs, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.fLz = null;
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
        if (this.fLz != null) {
            this.fLz.cancel();
            return false;
        }
        return false;
    }
}
