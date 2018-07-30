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
    private boolean fkC;
    private MarkData fkD;
    private a fkE;
    private a.InterfaceC0097a fkF;

    public void a(a.InterfaceC0097a interfaceC0097a) {
        this.fkF = interfaceC0097a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fkC = false;
        this.fkD = null;
        this.fkE = null;
        this.fkF = null;
        this.fkD = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fkC = false;
        this.fkD = null;
        this.fkE = null;
        this.fkF = null;
        this.fkD = new MarkData();
    }

    public boolean rN() {
        return this.fkC;
    }

    public MarkData rQ() {
        return this.fkD;
    }

    public void a(MarkData markData) {
        this.fkD = markData;
    }

    public void ad(boolean z) {
        this.fkC = z;
    }

    public String rM() {
        if (this.fkD != null) {
            return this.fkD.getPostId();
        }
        return null;
    }

    public void rP() {
        if (this.fkE != null) {
            this.fkE.cancel();
        }
        this.fkE = new a(true);
        this.fkE.setPriority(3);
        this.fkE.execute(new Boolean[0]);
    }

    public void rO() {
        if (this.fkE != null) {
            this.fkE.cancel();
        }
        this.fkE = new a(false);
        this.fkE.setPriority(3);
        this.fkE.execute(new Boolean[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean cGS;
        private c fky;
        private y mNetWork = null;

        public a(boolean z) {
            this.cGS = true;
            this.fky = null;
            this.cGS = z;
            this.fky = new c();
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
            if (this.cGS) {
                this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.fkD);
                this.mNetWork.o("data", aVar.bl(0, 1));
            } else {
                this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.o("user_id", MarkModel.this.fkD.getAccount());
                this.mNetWork.o("tid", MarkModel.this.fkD.getId());
                this.mNetWork.o(ImageViewerConfig.FORUM_ID, MarkModel.this.fkD.getForumId());
            }
            this.fky.parserJson(this.mNetWork.yq());
            boolean z = this.fky.getErrorCode() == 0;
            if (this.mNetWork.yO().zN().isRequestSuccess() && z) {
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
            MarkModel.this.fkE = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.fky != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.fky.getErrorCode(), this.fky.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.fkF != null) {
                        MarkModel.this.fkF.a(true, this.cGS, null);
                    }
                } else if (MarkModel.this.fkF != null) {
                    if (this.mNetWork == null || this.mNetWork.yO().zN().isRequestSuccess()) {
                        MarkModel.this.fkF.a(false, this.cGS, this.fky.getErrorString());
                    } else {
                        MarkModel.this.fkF.a(false, this.cGS, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.fkE = null;
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
        if (this.fkE != null) {
            this.fkE.cancel();
            return false;
        }
        return false;
    }
}
