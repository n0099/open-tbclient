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
    private boolean fzj;
    private MarkData fzk;
    private a fzl;
    private a.InterfaceC0093a fzm;

    public void a(a.InterfaceC0093a interfaceC0093a) {
        this.fzm = interfaceC0093a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fzj = false;
        this.fzk = null;
        this.fzl = null;
        this.fzm = null;
        this.fzk = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fzj = false;
        this.fzk = null;
        this.fzl = null;
        this.fzm = null;
        this.fzk = new MarkData();
    }

    public boolean vX() {
        return this.fzj;
    }

    public MarkData wa() {
        return this.fzk;
    }

    public void a(MarkData markData) {
        this.fzk = markData;
    }

    public void aL(boolean z) {
        this.fzj = z;
    }

    public String vW() {
        if (this.fzk != null) {
            return this.fzk.getPostId();
        }
        return null;
    }

    public void vZ() {
        if (this.fzl != null) {
            this.fzl.cancel();
        }
        this.fzl = new a(true);
        this.fzl.setPriority(3);
        this.fzl.execute(new Boolean[0]);
    }

    public void vY() {
        if (this.fzl != null) {
            this.fzl.cancel();
        }
        this.fzl = new a(false);
        this.fzl.setPriority(3);
        this.fzl.execute(new Boolean[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean deU;
        private c fzf;
        private x mNetWork = null;

        public a(boolean z) {
            this.deU = true;
            this.fzf = null;
            this.deU = z;
            this.fzf = new c();
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
            if (this.deU) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.fzk);
                this.mNetWork.n("data", aVar.cj(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.n("user_id", MarkModel.this.fzk.getAccount());
                this.mNetWork.n("tid", MarkModel.this.fzk.getId());
                this.mNetWork.n(ImageViewerConfig.FORUM_ID, MarkModel.this.fzk.getForumId());
            }
            this.fzf.parserJson(this.mNetWork.Cb());
            boolean z = this.fzf.getErrorCode() == 0;
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
            MarkModel.this.fzl = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.fzf != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.fzf.getErrorCode(), this.fzf.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.fzm != null) {
                        MarkModel.this.fzm.a(true, this.deU, null);
                    }
                } else if (MarkModel.this.fzm != null) {
                    if (this.mNetWork == null || this.mNetWork.Cz().Dx().isRequestSuccess()) {
                        MarkModel.this.fzm.a(false, this.deU, this.fzf.getErrorString());
                    } else {
                        MarkModel.this.fzm.a(false, this.deU, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.fzl = null;
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
        if (this.fzl != null) {
            this.fzl.cancel();
            return false;
        }
        return false;
    }
}
