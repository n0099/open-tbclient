package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes8.dex */
public class MarkModel extends BdBaseModel {
    private boolean lxJ;
    private MarkData lxK;
    private a lxL;
    private a.InterfaceC0554a lxM;

    public void a(a.InterfaceC0554a interfaceC0554a) {
        this.lxM = interfaceC0554a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.lxJ = false;
        this.lxK = null;
        this.lxL = null;
        this.lxM = null;
        this.lxK = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.lxJ = false;
        this.lxK = null;
        this.lxL = null;
        this.lxM = null;
        this.lxK = new MarkData();
    }

    public boolean bjZ() {
        return this.lxJ;
    }

    public MarkData bkc() {
        return this.lxK;
    }

    public void a(MarkData markData) {
        this.lxK = markData;
    }

    public void ja(boolean z) {
        this.lxJ = z;
    }

    public String bjY() {
        if (this.lxK != null) {
            return this.lxK.getPostId();
        }
        return null;
    }

    public void bkb() {
        if (this.lxL != null) {
            this.lxL.cancel();
        }
        this.lxL = new a(true);
        this.lxL.setPriority(3);
        this.lxL.execute(new Boolean[0]);
    }

    public void bka() {
        if (this.lxL != null) {
            this.lxL.cancel();
        }
        this.lxL = new a(false);
        this.lxL.setPriority(3);
        this.lxL.execute(new Boolean[0]);
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa cml = null;
        private boolean iCw;
        private c lxF;

        public a(boolean z) {
            this.iCw = true;
            this.lxF = null;
            this.iCw = z;
            this.lxF = new c();
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
            if (this.iCw) {
                this.cml = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.lxK);
                this.cml.addPostData("data", aVar.cV(0, 1));
            } else {
                this.cml = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.cml.addPostData("user_id", MarkModel.this.lxK.getAccount());
                this.cml.addPostData("tid", MarkModel.this.lxK.getId());
                this.cml.addPostData("fid", MarkModel.this.lxK.getForumId());
            }
            this.lxF.parserJson(this.cml.postNetData());
            boolean z = this.lxF.getErrorCode() == 0;
            if (this.cml.bsr().btb().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cml != null) {
                this.cml.cancelNetConnect();
            }
            MarkModel.this.lxL = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.lxF != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.lxF.getErrorCode(), this.lxF.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.lxM != null) {
                        MarkModel.this.lxM.g(true, this.iCw, null);
                    }
                } else if (MarkModel.this.lxM != null) {
                    if (this.cml == null || this.cml.bsr().btb().isRequestSuccess()) {
                        MarkModel.this.lxM.g(false, this.iCw, this.lxF.getErrorString());
                    } else {
                        MarkModel.this.lxM.g(false, this.iCw, this.cml.getErrorString());
                    }
                }
                MarkModel.this.lxL = null;
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
        if (this.lxL != null) {
            this.lxL.cancel();
            return false;
        }
        return false;
    }
}
