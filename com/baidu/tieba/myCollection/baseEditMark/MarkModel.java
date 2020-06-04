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
    private boolean jvo;
    private MarkData jvp;
    private a jvq;
    private a.InterfaceC0471a jvr;

    public void a(a.InterfaceC0471a interfaceC0471a) {
        this.jvr = interfaceC0471a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jvo = false;
        this.jvp = null;
        this.jvq = null;
        this.jvr = null;
        this.jvp = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.jvo = false;
        this.jvp = null;
        this.jvq = null;
        this.jvr = null;
        this.jvp = new MarkData();
    }

    public boolean aML() {
        return this.jvo;
    }

    public MarkData aMO() {
        return this.jvp;
    }

    public void a(MarkData markData) {
        this.jvp = markData;
    }

    public void gC(boolean z) {
        this.jvo = z;
    }

    public String aMK() {
        if (this.jvp != null) {
            return this.jvp.getPostId();
        }
        return null;
    }

    public void aMN() {
        if (this.jvq != null) {
            this.jvq.cancel();
        }
        this.jvq = new a(true);
        this.jvq.setPriority(3);
        this.jvq.execute(new Boolean[0]);
    }

    public void aMM() {
        if (this.jvq != null) {
            this.jvq.cancel();
        }
        this.jvq = new a(false);
        this.jvq.setPriority(3);
        this.jvq.execute(new Boolean[0]);
    }

    /* loaded from: classes11.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x bth = null;
        private boolean gJd;
        private c jvk;

        public a(boolean z) {
            this.gJd = true;
            this.jvk = null;
            this.gJd = z;
            this.jvk = new c();
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
            if (this.gJd) {
                this.bth = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.jvp);
                this.bth.addPostData("data", aVar.cy(0, 1));
            } else {
                this.bth = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.bth.addPostData("user_id", MarkModel.this.jvp.getAccount());
                this.bth.addPostData("tid", MarkModel.this.jvp.getId());
                this.bth.addPostData("fid", MarkModel.this.jvp.getForumId());
            }
            this.jvk.parserJson(this.bth.postNetData());
            boolean z = this.jvk.getErrorCode() == 0;
            if (this.bth.aUA().aVc().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bth != null) {
                this.bth.cancelNetConnect();
            }
            MarkModel.this.jvq = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.jvk != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.jvk.getErrorCode(), this.jvk.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.jvr != null) {
                        MarkModel.this.jvr.c(true, this.gJd, null);
                    }
                } else if (MarkModel.this.jvr != null) {
                    if (this.bth == null || this.bth.aUA().aVc().isRequestSuccess()) {
                        MarkModel.this.jvr.c(false, this.gJd, this.jvk.getErrorString());
                    } else {
                        MarkModel.this.jvr.c(false, this.gJd, this.bth.getErrorString());
                    }
                }
                MarkModel.this.jvq = null;
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
        if (this.jvq != null) {
            this.jvq.cancel();
            return false;
        }
        return false;
    }
}
