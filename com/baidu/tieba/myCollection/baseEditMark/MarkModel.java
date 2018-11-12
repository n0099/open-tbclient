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
    private boolean fAV;
    private MarkData fAW;
    private a fAX;
    private a.InterfaceC0144a fAY;

    public void a(a.InterfaceC0144a interfaceC0144a) {
        this.fAY = interfaceC0144a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fAV = false;
        this.fAW = null;
        this.fAX = null;
        this.fAY = null;
        this.fAW = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fAV = false;
        this.fAW = null;
        this.fAX = null;
        this.fAY = null;
        this.fAW = new MarkData();
    }

    public boolean vm() {
        return this.fAV;
    }

    public MarkData vp() {
        return this.fAW;
    }

    public void a(MarkData markData) {
        this.fAW = markData;
    }

    public void aO(boolean z) {
        this.fAV = z;
    }

    public String vl() {
        if (this.fAW != null) {
            return this.fAW.getPostId();
        }
        return null;
    }

    public void vo() {
        if (this.fAX != null) {
            this.fAX.cancel();
        }
        this.fAX = new a(true);
        this.fAX.setPriority(3);
        this.fAX.execute(new Boolean[0]);
    }

    public void vn() {
        if (this.fAX != null) {
            this.fAX.cancel();
        }
        this.fAX = new a(false);
        this.fAX.setPriority(3);
        this.fAX.execute(new Boolean[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean cWe;
        private c fAR;
        private x mNetWork = null;

        public a(boolean z) {
            this.cWe = true;
            this.fAR = null;
            this.cWe = z;
            this.fAR = new c();
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
            if (this.cWe) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.fAW);
                this.mNetWork.x("data", aVar.bu(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.x("user_id", MarkModel.this.fAW.getAccount());
                this.mNetWork.x("tid", MarkModel.this.fAW.getId());
                this.mNetWork.x(ImageViewerConfig.FORUM_ID, MarkModel.this.fAW.getForumId());
            }
            this.fAR.parserJson(this.mNetWork.BH());
            boolean z = this.fAR.getErrorCode() == 0;
            if (this.mNetWork.Cf().De().isRequestSuccess() && z) {
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
            MarkModel.this.fAX = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.fAR != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.fAR.getErrorCode(), this.fAR.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.fAY != null) {
                        MarkModel.this.fAY.a(true, this.cWe, null);
                    }
                } else if (MarkModel.this.fAY != null) {
                    if (this.mNetWork == null || this.mNetWork.Cf().De().isRequestSuccess()) {
                        MarkModel.this.fAY.a(false, this.cWe, this.fAR.getErrorString());
                    } else {
                        MarkModel.this.fAY.a(false, this.cWe, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.fAX = null;
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
        if (this.fAX != null) {
            this.fAX.cancel();
            return false;
        }
        return false;
    }
}
