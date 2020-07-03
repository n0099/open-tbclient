package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes11.dex */
public class MarkModel extends BdBaseModel {
    private boolean jMF;
    private MarkData jMG;
    private a jMH;
    private a.InterfaceC0477a jMI;

    public void a(a.InterfaceC0477a interfaceC0477a) {
        this.jMI = interfaceC0477a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jMF = false;
        this.jMG = null;
        this.jMH = null;
        this.jMI = null;
        this.jMG = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.jMF = false;
        this.jMG = null;
        this.jMH = null;
        this.jMI = null;
        this.jMG = new MarkData();
    }

    public boolean aOo() {
        return this.jMF;
    }

    public MarkData aOr() {
        return this.jMG;
    }

    public void a(MarkData markData) {
        this.jMG = markData;
    }

    public void gJ(boolean z) {
        this.jMF = z;
    }

    public String aOn() {
        if (this.jMG != null) {
            return this.jMG.getPostId();
        }
        return null;
    }

    public void aOq() {
        if (this.jMH != null) {
            this.jMH.cancel();
        }
        this.jMH = new a(true);
        this.jMH.setPriority(3);
        this.jMH.execute(new Boolean[0]);
    }

    public void aOp() {
        if (this.jMH != null) {
            this.jMH.cancel();
        }
        this.jMH = new a(false);
        this.jMH.setPriority(3);
        this.jMH.execute(new Boolean[0]);
    }

    /* loaded from: classes11.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private y byb = null;
        private boolean gWd;
        private c jMB;

        public a(boolean z) {
            this.gWd = true;
            this.jMB = null;
            this.gWd = z;
            this.jMB = new c();
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
            if (this.gWd) {
                this.byb = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.jMG);
                this.byb.addPostData("data", aVar.cE(0, 1));
            } else {
                this.byb = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.byb.addPostData("user_id", MarkModel.this.jMG.getAccount());
                this.byb.addPostData("tid", MarkModel.this.jMG.getId());
                this.byb.addPostData("fid", MarkModel.this.jMG.getForumId());
            }
            this.jMB.parserJson(this.byb.postNetData());
            boolean z = this.jMB.getErrorCode() == 0;
            if (this.byb.aWu().aWW().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.byb != null) {
                this.byb.cancelNetConnect();
            }
            MarkModel.this.jMH = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.jMB != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.jMB.getErrorCode(), this.jMB.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.jMI != null) {
                        MarkModel.this.jMI.c(true, this.gWd, null);
                    }
                } else if (MarkModel.this.jMI != null) {
                    if (this.byb == null || this.byb.aWu().aWW().isRequestSuccess()) {
                        MarkModel.this.jMI.c(false, this.gWd, this.jMB.getErrorString());
                    } else {
                        MarkModel.this.jMI.c(false, this.gWd, this.byb.getErrorString());
                    }
                }
                MarkModel.this.jMH = null;
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
        if (this.jMH != null) {
            this.jMH.cancel();
            return false;
        }
        return false;
    }
}
