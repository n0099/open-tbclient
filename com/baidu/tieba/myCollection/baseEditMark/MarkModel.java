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
    private boolean fkw;
    private MarkData fkx;
    private a fky;
    private a.InterfaceC0097a fkz;

    public void a(a.InterfaceC0097a interfaceC0097a) {
        this.fkz = interfaceC0097a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fkw = false;
        this.fkx = null;
        this.fky = null;
        this.fkz = null;
        this.fkx = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fkw = false;
        this.fkx = null;
        this.fky = null;
        this.fkz = null;
        this.fkx = new MarkData();
    }

    public boolean rL() {
        return this.fkw;
    }

    public MarkData rO() {
        return this.fkx;
    }

    public void a(MarkData markData) {
        this.fkx = markData;
    }

    public void ae(boolean z) {
        this.fkw = z;
    }

    public String rK() {
        if (this.fkx != null) {
            return this.fkx.getPostId();
        }
        return null;
    }

    public void rN() {
        if (this.fky != null) {
            this.fky.cancel();
        }
        this.fky = new a(true);
        this.fky.setPriority(3);
        this.fky.execute(new Boolean[0]);
    }

    public void rM() {
        if (this.fky != null) {
            this.fky.cancel();
        }
        this.fky = new a(false);
        this.fky.setPriority(3);
        this.fky.execute(new Boolean[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean cGP;
        private c fks;
        private y mNetWork = null;

        public a(boolean z) {
            this.cGP = true;
            this.fks = null;
            this.cGP = z;
            this.fks = new c();
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
            if (this.cGP) {
                this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.fkx);
                this.mNetWork.o("data", aVar.bl(0, 1));
            } else {
                this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.o("user_id", MarkModel.this.fkx.getAccount());
                this.mNetWork.o("tid", MarkModel.this.fkx.getId());
                this.mNetWork.o(ImageViewerConfig.FORUM_ID, MarkModel.this.fkx.getForumId());
            }
            this.fks.parserJson(this.mNetWork.yo());
            boolean z = this.fks.getErrorCode() == 0;
            if (this.mNetWork.yM().zL().isRequestSuccess() && z) {
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
            MarkModel.this.fky = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.fks != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.fks.getErrorCode(), this.fks.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.fkz != null) {
                        MarkModel.this.fkz.a(true, this.cGP, null);
                    }
                } else if (MarkModel.this.fkz != null) {
                    if (this.mNetWork == null || this.mNetWork.yM().zL().isRequestSuccess()) {
                        MarkModel.this.fkz.a(false, this.cGP, this.fks.getErrorString());
                    } else {
                        MarkModel.this.fkz.a(false, this.cGP, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.fky = null;
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
        if (this.fky != null) {
            this.fky.cancel();
            return false;
        }
        return false;
    }
}
