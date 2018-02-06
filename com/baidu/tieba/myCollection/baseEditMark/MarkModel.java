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
    private boolean fzf;
    private MarkData fzg;
    private a fzh;
    private a.InterfaceC0092a fzi;

    public void a(a.InterfaceC0092a interfaceC0092a) {
        this.fzi = interfaceC0092a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fzf = false;
        this.fzg = null;
        this.fzh = null;
        this.fzi = null;
        this.fzg = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fzf = false;
        this.fzg = null;
        this.fzh = null;
        this.fzi = null;
        this.fzg = new MarkData();
    }

    public boolean vX() {
        return this.fzf;
    }

    public MarkData wa() {
        return this.fzg;
    }

    public void a(MarkData markData) {
        this.fzg = markData;
    }

    public void aL(boolean z) {
        this.fzf = z;
    }

    public String vW() {
        if (this.fzg != null) {
            return this.fzg.getPostId();
        }
        return null;
    }

    public void vZ() {
        if (this.fzh != null) {
            this.fzh.cancel();
        }
        this.fzh = new a(true);
        this.fzh.setPriority(3);
        this.fzh.execute(new Boolean[0]);
    }

    public void vY() {
        if (this.fzh != null) {
            this.fzh.cancel();
        }
        this.fzh = new a(false);
        this.fzh.setPriority(3);
        this.fzh.execute(new Boolean[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean dfd;
        private c fzb;
        private x mNetWork = null;

        public a(boolean z) {
            this.dfd = true;
            this.fzb = null;
            this.dfd = z;
            this.fzb = new c();
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
            if (this.dfd) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.fzg);
                this.mNetWork.n("data", aVar.cj(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.n("user_id", MarkModel.this.fzg.getAccount());
                this.mNetWork.n("tid", MarkModel.this.fzg.getId());
                this.mNetWork.n(ImageViewerConfig.FORUM_ID, MarkModel.this.fzg.getForumId());
            }
            this.fzb.parserJson(this.mNetWork.Cb());
            boolean z = this.fzb.getErrorCode() == 0;
            if (this.mNetWork.Cz().Dx().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.mS();
            }
            MarkModel.this.fzh = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.fzb != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.fzb.getErrorCode(), this.fzb.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.fzi != null) {
                        MarkModel.this.fzi.a(true, this.dfd, null);
                    }
                } else if (MarkModel.this.fzi != null) {
                    if (this.mNetWork == null || this.mNetWork.Cz().Dx().isRequestSuccess()) {
                        MarkModel.this.fzi.a(false, this.dfd, this.fzb.getErrorString());
                    } else {
                        MarkModel.this.fzi.a(false, this.dfd, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.fzh = null;
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
        if (this.fzh != null) {
            this.fzh.cancel();
            return false;
        }
        return false;
    }
}
