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
/* loaded from: classes23.dex */
public class MarkModel extends BdBaseModel {
    private boolean kth;
    private MarkData kti;
    private a ktj;
    private a.InterfaceC0530a ktk;

    public void a(a.InterfaceC0530a interfaceC0530a) {
        this.ktk = interfaceC0530a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.kth = false;
        this.kti = null;
        this.ktj = null;
        this.ktk = null;
        this.kti = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.kth = false;
        this.kti = null;
        this.ktj = null;
        this.ktk = null;
        this.kti = new MarkData();
    }

    public boolean bbu() {
        return this.kth;
    }

    public MarkData bbx() {
        return this.kti;
    }

    public void a(MarkData markData) {
        this.kti = markData;
    }

    public void hy(boolean z) {
        this.kth = z;
    }

    public String bbt() {
        if (this.kti != null) {
            return this.kti.getPostId();
        }
        return null;
    }

    public void bbw() {
        if (this.ktj != null) {
            this.ktj.cancel();
        }
        this.ktj = new a(true);
        this.ktj.setPriority(3);
        this.ktj.execute(new Boolean[0]);
    }

    public void bbv() {
        if (this.ktj != null) {
            this.ktj.cancel();
        }
        this.ktj = new a(false);
        this.ktj.setPriority(3);
        this.ktj.execute(new Boolean[0]);
    }

    /* loaded from: classes23.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa bGb = null;
        private boolean hvH;
        private c ktd;

        public a(boolean z) {
            this.hvH = true;
            this.ktd = null;
            this.hvH = z;
            this.ktd = new c();
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
            if (this.hvH) {
                this.bGb = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.kti);
                this.bGb.addPostData("data", aVar.cS(0, 1));
            } else {
                this.bGb = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.bGb.addPostData("user_id", MarkModel.this.kti.getAccount());
                this.bGb.addPostData("tid", MarkModel.this.kti.getId());
                this.bGb.addPostData("fid", MarkModel.this.kti.getForumId());
            }
            this.ktd.parserJson(this.bGb.postNetData());
            boolean z = this.ktd.getErrorCode() == 0;
            if (this.bGb.bjL().bkr().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bGb != null) {
                this.bGb.cancelNetConnect();
            }
            MarkModel.this.ktj = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.ktd != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.ktd.getErrorCode(), this.ktd.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.ktk != null) {
                        MarkModel.this.ktk.c(true, this.hvH, null);
                    }
                } else if (MarkModel.this.ktk != null) {
                    if (this.bGb == null || this.bGb.bjL().bkr().isRequestSuccess()) {
                        MarkModel.this.ktk.c(false, this.hvH, this.ktd.getErrorString());
                    } else {
                        MarkModel.this.ktk.c(false, this.hvH, this.bGb.getErrorString());
                    }
                }
                MarkModel.this.ktj = null;
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
        if (this.ktj != null) {
            this.ktj.cancel();
            return false;
        }
        return false;
    }
}
