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
    private boolean jVd;
    private MarkData jVe;
    private a jVf;
    private a.InterfaceC0489a jVg;

    public void a(a.InterfaceC0489a interfaceC0489a) {
        this.jVg = interfaceC0489a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jVd = false;
        this.jVe = null;
        this.jVf = null;
        this.jVg = null;
        this.jVe = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.jVd = false;
        this.jVe = null;
        this.jVf = null;
        this.jVg = null;
        this.jVe = new MarkData();
    }

    public boolean aSj() {
        return this.jVd;
    }

    public MarkData aSm() {
        return this.jVe;
    }

    public void a(MarkData markData) {
        this.jVe = markData;
    }

    public void he(boolean z) {
        this.jVd = z;
    }

    public String aSi() {
        if (this.jVe != null) {
            return this.jVe.getPostId();
        }
        return null;
    }

    public void aSl() {
        if (this.jVf != null) {
            this.jVf.cancel();
        }
        this.jVf = new a(true);
        this.jVf.setPriority(3);
        this.jVf.execute(new Boolean[0]);
    }

    public void aSk() {
        if (this.jVf != null) {
            this.jVf.cancel();
        }
        this.jVf = new a(false);
        this.jVf.setPriority(3);
        this.jVf.execute(new Boolean[0]);
    }

    /* loaded from: classes18.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private z byq = null;
        private boolean hbI;
        private c jUZ;

        public a(boolean z) {
            this.hbI = true;
            this.jUZ = null;
            this.hbI = z;
            this.jUZ = new c();
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
                aVar.f(MarkModel.this.jVe);
                this.byq.addPostData("data", aVar.cH(0, 1));
            } else {
                this.byq = new z(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.byq.addPostData("user_id", MarkModel.this.jVe.getAccount());
                this.byq.addPostData("tid", MarkModel.this.jVe.getId());
                this.byq.addPostData("fid", MarkModel.this.jVe.getForumId());
            }
            this.jUZ.parserJson(this.byq.postNetData());
            boolean z = this.jUZ.getErrorCode() == 0;
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
            MarkModel.this.jVf = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.jUZ != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.jUZ.getErrorCode(), this.jUZ.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.jVg != null) {
                        MarkModel.this.jVg.c(true, this.hbI, null);
                    }
                } else if (MarkModel.this.jVg != null) {
                    if (this.byq == null || this.byq.bav().baX().isRequestSuccess()) {
                        MarkModel.this.jVg.c(false, this.hbI, this.jUZ.getErrorString());
                    } else {
                        MarkModel.this.jVg.c(false, this.hbI, this.byq.getErrorString());
                    }
                }
                MarkModel.this.jVf = null;
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
        if (this.jVf != null) {
            this.jVf.cancel();
            return false;
        }
        return false;
    }
}
