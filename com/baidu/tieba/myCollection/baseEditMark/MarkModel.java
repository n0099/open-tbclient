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
/* loaded from: classes6.dex */
public class MarkModel extends BdBaseModel {
    private boolean hbs;
    private MarkData hbt;
    private a hbu;
    private a.InterfaceC0221a hbv;

    public void a(a.InterfaceC0221a interfaceC0221a) {
        this.hbv = interfaceC0221a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hbs = false;
        this.hbt = null;
        this.hbu = null;
        this.hbv = null;
        this.hbt = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.hbs = false;
        this.hbt = null;
        this.hbu = null;
        this.hbv = null;
        this.hbt = new MarkData();
    }

    public boolean UY() {
        return this.hbs;
    }

    public MarkData Vb() {
        return this.hbt;
    }

    public void a(MarkData markData) {
        this.hbt = markData;
    }

    public void cZ(boolean z) {
        this.hbs = z;
    }

    public String UX() {
        if (this.hbt != null) {
            return this.hbt.getPostId();
        }
        return null;
    }

    public void Va() {
        if (this.hbu != null) {
            this.hbu.cancel();
        }
        this.hbu = new a(true);
        this.hbu.setPriority(3);
        this.hbu.execute(new Boolean[0]);
    }

    public void UZ() {
        if (this.hbu != null) {
            this.hbu.cancel();
        }
        this.hbu = new a(false);
        this.hbu.setPriority(3);
        this.hbu.execute(new Boolean[0]);
    }

    /* loaded from: classes6.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean eqb;
        private c hbo;
        private x mNetWork = null;

        public a(boolean z) {
            this.eqb = true;
            this.hbo = null;
            this.eqb = z;
            this.hbo = new c();
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
            if (this.eqb) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.hbt);
                this.mNetWork.x("data", aVar.bP(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.x("user_id", MarkModel.this.hbt.getAccount());
                this.mNetWork.x("tid", MarkModel.this.hbt.getId());
                this.mNetWork.x(ImageViewerConfig.FORUM_ID, MarkModel.this.hbt.getForumId());
            }
            this.hbo.parserJson(this.mNetWork.acg());
            boolean z = this.hbo.getErrorCode() == 0;
            if (this.mNetWork.acE().adD().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ji();
            }
            MarkModel.this.hbu = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.hbo != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.hbo.getErrorCode(), this.hbo.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.hbv != null) {
                        MarkModel.this.hbv.c(true, this.eqb, null);
                    }
                } else if (MarkModel.this.hbv != null) {
                    if (this.mNetWork == null || this.mNetWork.acE().adD().isRequestSuccess()) {
                        MarkModel.this.hbv.c(false, this.eqb, this.hbo.getErrorString());
                    } else {
                        MarkModel.this.hbv.c(false, this.eqb, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.hbu = null;
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
        if (this.hbu != null) {
            this.hbu.cancel();
            return false;
        }
        return false;
    }
}
