package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes6.dex */
public class MarkModel extends BdBaseModel {
    private boolean hzF;
    private MarkData hzG;
    private a hzH;
    private a.InterfaceC0274a hzI;

    public void a(a.InterfaceC0274a interfaceC0274a) {
        this.hzI = interfaceC0274a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hzF = false;
        this.hzG = null;
        this.hzH = null;
        this.hzI = null;
        this.hzG = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.hzF = false;
        this.hzG = null;
        this.hzH = null;
        this.hzI = null;
        this.hzG = new MarkData();
    }

    public boolean afk() {
        return this.hzF;
    }

    public MarkData afn() {
        return this.hzG;
    }

    public void a(MarkData markData) {
        this.hzG = markData;
    }

    public void dO(boolean z) {
        this.hzF = z;
    }

    public String afj() {
        if (this.hzG != null) {
            return this.hzG.getPostId();
        }
        return null;
    }

    public void afm() {
        if (this.hzH != null) {
            this.hzH.cancel();
        }
        this.hzH = new a(true);
        this.hzH.setPriority(3);
        this.hzH.execute(new Boolean[0]);
    }

    public void afl() {
        if (this.hzH != null) {
            this.hzH.cancel();
        }
        this.hzH = new a(false);
        this.hzH.setPriority(3);
        this.hzH.execute(new Boolean[0]);
    }

    /* loaded from: classes6.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x bUY = null;
        private boolean eUk;
        private c hzB;

        public a(boolean z) {
            this.eUk = true;
            this.hzB = null;
            this.eUk = z;
            this.hzB = new c();
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
            if (this.eUk) {
                this.bUY = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.hzG);
                this.bUY.addPostData("data", aVar.bT(0, 1));
            } else {
                this.bUY = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.bUY.addPostData("user_id", MarkModel.this.hzG.getAccount());
                this.bUY.addPostData("tid", MarkModel.this.hzG.getId());
                this.bUY.addPostData("fid", MarkModel.this.hzG.getForumId());
            }
            this.hzB.parserJson(this.bUY.postNetData());
            boolean z = this.hzB.getErrorCode() == 0;
            if (this.bUY.amp().amQ().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bUY != null) {
                this.bUY.cancelNetConnect();
            }
            MarkModel.this.hzH = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.hzB != null) {
                    com.baidu.tbadk.core.e.a.a("collection", 0L, 0, "add_collection_thread", this.hzB.getErrorCode(), this.hzB.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.hzI != null) {
                        MarkModel.this.hzI.c(true, this.eUk, null);
                    }
                } else if (MarkModel.this.hzI != null) {
                    if (this.bUY == null || this.bUY.amp().amQ().isRequestSuccess()) {
                        MarkModel.this.hzI.c(false, this.eUk, this.hzB.getErrorString());
                    } else {
                        MarkModel.this.hzI.c(false, this.eUk, this.bUY.getErrorString());
                    }
                }
                MarkModel.this.hzH = null;
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
        if (this.hzH != null) {
            this.hzH.cancel();
            return false;
        }
        return false;
    }
}
