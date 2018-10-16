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
    private a.InterfaceC0120a fzA;
    private boolean fzx;
    private MarkData fzy;
    private a fzz;

    public void a(a.InterfaceC0120a interfaceC0120a) {
        this.fzA = interfaceC0120a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fzx = false;
        this.fzy = null;
        this.fzz = null;
        this.fzA = null;
        this.fzy = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fzx = false;
        this.fzy = null;
        this.fzz = null;
        this.fzA = null;
        this.fzy = new MarkData();
    }

    public boolean vc() {
        return this.fzx;
    }

    public MarkData vf() {
        return this.fzy;
    }

    public void a(MarkData markData) {
        this.fzy = markData;
    }

    public void ay(boolean z) {
        this.fzx = z;
    }

    public String vb() {
        if (this.fzy != null) {
            return this.fzy.getPostId();
        }
        return null;
    }

    public void ve() {
        if (this.fzz != null) {
            this.fzz.cancel();
        }
        this.fzz = new a(true);
        this.fzz.setPriority(3);
        this.fzz.execute(new Boolean[0]);
    }

    public void vd() {
        if (this.fzz != null) {
            this.fzz.cancel();
        }
        this.fzz = new a(false);
        this.fzz.setPriority(3);
        this.fzz.execute(new Boolean[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean cUY;
        private c fzt;
        private x mNetWork = null;

        public a(boolean z) {
            this.cUY = true;
            this.fzt = null;
            this.cUY = z;
            this.fzt = new c();
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
            if (this.cUY) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.fzy);
                this.mNetWork.x("data", aVar.bs(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.x("user_id", MarkModel.this.fzy.getAccount());
                this.mNetWork.x("tid", MarkModel.this.fzy.getId());
                this.mNetWork.x(ImageViewerConfig.FORUM_ID, MarkModel.this.fzy.getForumId());
            }
            this.fzt.parserJson(this.mNetWork.BA());
            boolean z = this.fzt.getErrorCode() == 0;
            if (this.mNetWork.BY().CX().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ji();
            }
            MarkModel.this.fzz = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.fzt != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.fzt.getErrorCode(), this.fzt.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.fzA != null) {
                        MarkModel.this.fzA.a(true, this.cUY, null);
                    }
                } else if (MarkModel.this.fzA != null) {
                    if (this.mNetWork == null || this.mNetWork.BY().CX().isRequestSuccess()) {
                        MarkModel.this.fzA.a(false, this.cUY, this.fzt.getErrorString());
                    } else {
                        MarkModel.this.fzA.a(false, this.cUY, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.fzz = null;
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
        if (this.fzz != null) {
            this.fzz.cancel();
            return false;
        }
        return false;
    }
}
