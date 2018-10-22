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
    private a fzA;
    private a.InterfaceC0120a fzB;
    private boolean fzy;
    private MarkData fzz;

    public void a(a.InterfaceC0120a interfaceC0120a) {
        this.fzB = interfaceC0120a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fzy = false;
        this.fzz = null;
        this.fzA = null;
        this.fzB = null;
        this.fzz = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fzy = false;
        this.fzz = null;
        this.fzA = null;
        this.fzB = null;
        this.fzz = new MarkData();
    }

    public boolean vc() {
        return this.fzy;
    }

    public MarkData vf() {
        return this.fzz;
    }

    public void a(MarkData markData) {
        this.fzz = markData;
    }

    public void ay(boolean z) {
        this.fzy = z;
    }

    public String vb() {
        if (this.fzz != null) {
            return this.fzz.getPostId();
        }
        return null;
    }

    public void ve() {
        if (this.fzA != null) {
            this.fzA.cancel();
        }
        this.fzA = new a(true);
        this.fzA.setPriority(3);
        this.fzA.execute(new Boolean[0]);
    }

    public void vd() {
        if (this.fzA != null) {
            this.fzA.cancel();
        }
        this.fzA = new a(false);
        this.fzA.setPriority(3);
        this.fzA.execute(new Boolean[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean cUY;
        private c fzu;
        private x mNetWork = null;

        public a(boolean z) {
            this.cUY = true;
            this.fzu = null;
            this.cUY = z;
            this.fzu = new c();
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
                aVar.f(MarkModel.this.fzz);
                this.mNetWork.x("data", aVar.bs(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.x("user_id", MarkModel.this.fzz.getAccount());
                this.mNetWork.x("tid", MarkModel.this.fzz.getId());
                this.mNetWork.x(ImageViewerConfig.FORUM_ID, MarkModel.this.fzz.getForumId());
            }
            this.fzu.parserJson(this.mNetWork.BA());
            boolean z = this.fzu.getErrorCode() == 0;
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
            MarkModel.this.fzA = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.fzu != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.fzu.getErrorCode(), this.fzu.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.fzB != null) {
                        MarkModel.this.fzB.a(true, this.cUY, null);
                    }
                } else if (MarkModel.this.fzB != null) {
                    if (this.mNetWork == null || this.mNetWork.BY().CX().isRequestSuccess()) {
                        MarkModel.this.fzB.a(false, this.cUY, this.fzu.getErrorString());
                    } else {
                        MarkModel.this.fzB.a(false, this.cUY, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.fzA = null;
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
        if (this.fzA != null) {
            this.fzA.cancel();
            return false;
        }
        return false;
    }
}
