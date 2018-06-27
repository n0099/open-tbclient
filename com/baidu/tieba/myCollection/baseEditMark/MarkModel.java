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
import com.baidu.tbadk.core.util.y;
/* loaded from: classes3.dex */
public class MarkModel extends BdBaseModel {
    private boolean fkq;
    private MarkData fkr;
    private a fks;
    private a.InterfaceC0100a fkt;

    public void a(a.InterfaceC0100a interfaceC0100a) {
        this.fkt = interfaceC0100a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fkq = false;
        this.fkr = null;
        this.fks = null;
        this.fkt = null;
        this.fkr = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fkq = false;
        this.fkr = null;
        this.fks = null;
        this.fkt = null;
        this.fkr = new MarkData();
    }

    public boolean sc() {
        return this.fkq;
    }

    public MarkData sf() {
        return this.fkr;
    }

    public void a(MarkData markData) {
        this.fkr = markData;
    }

    public void ah(boolean z) {
        this.fkq = z;
    }

    public String sb() {
        if (this.fkr != null) {
            return this.fkr.getPostId();
        }
        return null;
    }

    public void se() {
        if (this.fks != null) {
            this.fks.cancel();
        }
        this.fks = new a(true);
        this.fks.setPriority(3);
        this.fks.execute(new Boolean[0]);
    }

    public void sd() {
        if (this.fks != null) {
            this.fks.cancel();
        }
        this.fks = new a(false);
        this.fks.setPriority(3);
        this.fks.execute(new Boolean[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean cEm;
        private c fkm;
        private y mNetWork = null;

        public a(boolean z) {
            this.cEm = true;
            this.fkm = null;
            this.cEm = z;
            this.fkm = new c();
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
            if (this.cEm) {
                this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.fkr);
                this.mNetWork.o("data", aVar.bk(0, 1));
            } else {
                this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.o("user_id", MarkModel.this.fkr.getAccount());
                this.mNetWork.o("tid", MarkModel.this.fkr.getId());
                this.mNetWork.o(ImageViewerConfig.FORUM_ID, MarkModel.this.fkr.getForumId());
            }
            this.fkm.parserJson(this.mNetWork.yz());
            boolean z = this.fkm.getErrorCode() == 0;
            if (this.mNetWork.yX().zY().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            MarkModel.this.fks = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.fkm != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.fkm.getErrorCode(), this.fkm.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.fkt != null) {
                        MarkModel.this.fkt.a(true, this.cEm, null);
                    }
                } else if (MarkModel.this.fkt != null) {
                    if (this.mNetWork == null || this.mNetWork.yX().zY().isRequestSuccess()) {
                        MarkModel.this.fkt.a(false, this.cEm, this.fkm.getErrorString());
                    } else {
                        MarkModel.this.fkt.a(false, this.cEm, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.fks = null;
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
        if (this.fks != null) {
            this.fks.cancel();
            return false;
        }
        return false;
    }
}
