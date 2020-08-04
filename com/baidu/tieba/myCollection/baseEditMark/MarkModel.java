package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes18.dex */
public class MarkModel extends BdBaseModel {
    private boolean jVf;
    private MarkData jVg;
    private a jVh;
    private a.InterfaceC0489a jVi;

    public void a(a.InterfaceC0489a interfaceC0489a) {
        this.jVi = interfaceC0489a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jVf = false;
        this.jVg = null;
        this.jVh = null;
        this.jVi = null;
        this.jVg = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.jVf = false;
        this.jVg = null;
        this.jVh = null;
        this.jVi = null;
        this.jVg = new MarkData();
    }

    public boolean aSj() {
        return this.jVf;
    }

    public MarkData aSm() {
        return this.jVg;
    }

    public void a(MarkData markData) {
        this.jVg = markData;
    }

    public void he(boolean z) {
        this.jVf = z;
    }

    public String aSi() {
        if (this.jVg != null) {
            return this.jVg.getPostId();
        }
        return null;
    }

    public void aSl() {
        if (this.jVh != null) {
            this.jVh.cancel();
        }
        this.jVh = new a(true);
        this.jVh.setPriority(3);
        this.jVh.execute(new Boolean[0]);
    }

    public void aSk() {
        if (this.jVh != null) {
            this.jVh.cancel();
        }
        this.jVh = new a(false);
        this.jVh.setPriority(3);
        this.jVh.execute(new Boolean[0]);
    }

    /* loaded from: classes18.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private z byq = null;
        private boolean hbI;
        private c jVb;

        public a(boolean z) {
            this.hbI = true;
            this.jVb = null;
            this.hbI = z;
            this.jVb = new c();
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
            if (this.hbI) {
                this.byq = new z(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.jVg);
                this.byq.addPostData("data", aVar.cH(0, 1));
            } else {
                this.byq = new z(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.byq.addPostData("user_id", MarkModel.this.jVg.getAccount());
                this.byq.addPostData("tid", MarkModel.this.jVg.getId());
                this.byq.addPostData("fid", MarkModel.this.jVg.getForumId());
            }
            this.jVb.parserJson(this.byq.postNetData());
            boolean z = this.jVb.getErrorCode() == 0;
            if (this.byq.bav().baX().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.byq != null) {
                this.byq.cancelNetConnect();
            }
            MarkModel.this.jVh = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.jVb != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.jVb.getErrorCode(), this.jVb.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.jVi != null) {
                        MarkModel.this.jVi.c(true, this.hbI, null);
                    }
                } else if (MarkModel.this.jVi != null) {
                    if (this.byq == null || this.byq.bav().baX().isRequestSuccess()) {
                        MarkModel.this.jVi.c(false, this.hbI, this.jVb.getErrorString());
                    } else {
                        MarkModel.this.jVi.c(false, this.hbI, this.byq.getErrorString());
                    }
                }
                MarkModel.this.jVh = null;
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
        if (this.jVh != null) {
            this.jVh.cancel();
            return false;
        }
        return false;
    }
}
