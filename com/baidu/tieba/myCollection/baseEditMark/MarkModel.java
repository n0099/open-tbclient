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
    private boolean hbr;
    private MarkData hbs;
    private a hbt;
    private a.InterfaceC0221a hbu;

    public void a(a.InterfaceC0221a interfaceC0221a) {
        this.hbu = interfaceC0221a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hbr = false;
        this.hbs = null;
        this.hbt = null;
        this.hbu = null;
        this.hbs = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.hbr = false;
        this.hbs = null;
        this.hbt = null;
        this.hbu = null;
        this.hbs = new MarkData();
    }

    public boolean UY() {
        return this.hbr;
    }

    public MarkData Vb() {
        return this.hbs;
    }

    public void a(MarkData markData) {
        this.hbs = markData;
    }

    public void cZ(boolean z) {
        this.hbr = z;
    }

    public String UX() {
        if (this.hbs != null) {
            return this.hbs.getPostId();
        }
        return null;
    }

    public void Va() {
        if (this.hbt != null) {
            this.hbt.cancel();
        }
        this.hbt = new a(true);
        this.hbt.setPriority(3);
        this.hbt.execute(new Boolean[0]);
    }

    public void UZ() {
        if (this.hbt != null) {
            this.hbt.cancel();
        }
        this.hbt = new a(false);
        this.hbt.setPriority(3);
        this.hbt.execute(new Boolean[0]);
    }

    /* loaded from: classes6.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean eqa;
        private c hbn;
        private x mNetWork = null;

        public a(boolean z) {
            this.eqa = true;
            this.hbn = null;
            this.eqa = z;
            this.hbn = new c();
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
            if (this.eqa) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.hbs);
                this.mNetWork.x("data", aVar.bP(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.x("user_id", MarkModel.this.hbs.getAccount());
                this.mNetWork.x("tid", MarkModel.this.hbs.getId());
                this.mNetWork.x(ImageViewerConfig.FORUM_ID, MarkModel.this.hbs.getForumId());
            }
            this.hbn.parserJson(this.mNetWork.acg());
            boolean z = this.hbn.getErrorCode() == 0;
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
            MarkModel.this.hbt = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.hbn != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.hbn.getErrorCode(), this.hbn.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.hbu != null) {
                        MarkModel.this.hbu.c(true, this.eqa, null);
                    }
                } else if (MarkModel.this.hbu != null) {
                    if (this.mNetWork == null || this.mNetWork.acE().adD().isRequestSuccess()) {
                        MarkModel.this.hbu.c(false, this.eqa, this.hbn.getErrorString());
                    } else {
                        MarkModel.this.hbu.c(false, this.eqa, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.hbt = null;
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
        if (this.hbt != null) {
            this.hbt.cancel();
            return false;
        }
        return false;
    }
}
