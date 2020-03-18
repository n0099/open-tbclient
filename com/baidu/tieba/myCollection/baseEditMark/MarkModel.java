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
/* loaded from: classes11.dex */
public class MarkModel extends BdBaseModel {
    private boolean iuW;
    private MarkData iuX;
    private a iuY;
    private a.InterfaceC0374a iuZ;

    public void a(a.InterfaceC0374a interfaceC0374a) {
        this.iuZ = interfaceC0374a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.iuW = false;
        this.iuX = null;
        this.iuY = null;
        this.iuZ = null;
        this.iuX = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.iuW = false;
        this.iuX = null;
        this.iuY = null;
        this.iuZ = null;
        this.iuX = new MarkData();
    }

    public boolean ayO() {
        return this.iuW;
    }

    public MarkData ayR() {
        return this.iuX;
    }

    public void a(MarkData markData) {
        this.iuX = markData;
    }

    public void fn(boolean z) {
        this.iuW = z;
    }

    public String ayN() {
        if (this.iuX != null) {
            return this.iuX.getPostId();
        }
        return null;
    }

    public void ayQ() {
        if (this.iuY != null) {
            this.iuY.cancel();
        }
        this.iuY = new a(true);
        this.iuY.setPriority(3);
        this.iuY.execute(new Boolean[0]);
    }

    public void ayP() {
        if (this.iuY != null) {
            this.iuY.cancel();
        }
        this.iuY = new a(false);
        this.iuY.setPriority(3);
        this.iuY.execute(new Boolean[0]);
    }

    /* loaded from: classes11.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x cLQ = null;
        private boolean fPu;
        private c iuS;

        public a(boolean z) {
            this.fPu = true;
            this.iuS = null;
            this.fPu = z;
            this.iuS = new c();
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
            if (this.fPu) {
                this.cLQ = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.iuX);
                this.cLQ.addPostData("data", aVar.cn(0, 1));
            } else {
                this.cLQ = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.cLQ.addPostData("user_id", MarkModel.this.iuX.getAccount());
                this.cLQ.addPostData("tid", MarkModel.this.iuX.getId());
                this.cLQ.addPostData("fid", MarkModel.this.iuX.getForumId());
            }
            this.iuS.parserJson(this.cLQ.postNetData());
            boolean z = this.iuS.getErrorCode() == 0;
            if (this.cLQ.aGk().aGM().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cLQ != null) {
                this.cLQ.cancelNetConnect();
            }
            MarkModel.this.iuY = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.iuS != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.iuS.getErrorCode(), this.iuS.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.iuZ != null) {
                        MarkModel.this.iuZ.c(true, this.fPu, null);
                    }
                } else if (MarkModel.this.iuZ != null) {
                    if (this.cLQ == null || this.cLQ.aGk().aGM().isRequestSuccess()) {
                        MarkModel.this.iuZ.c(false, this.fPu, this.iuS.getErrorString());
                    } else {
                        MarkModel.this.iuZ.c(false, this.fPu, this.cLQ.getErrorString());
                    }
                }
                MarkModel.this.iuY = null;
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
        if (this.iuY != null) {
            this.iuY.cancel();
            return false;
        }
        return false;
    }
}
