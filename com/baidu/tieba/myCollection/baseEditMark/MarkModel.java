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
import com.baidu.tbadk.core.util.y;
/* loaded from: classes3.dex */
public class MarkModel extends BdBaseModel {
    private boolean fgs;
    private MarkData fgt;
    private a fgu;
    private a.InterfaceC0099a fgv;

    public void a(a.InterfaceC0099a interfaceC0099a) {
        this.fgv = interfaceC0099a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fgs = false;
        this.fgt = null;
        this.fgu = null;
        this.fgv = null;
        this.fgt = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fgs = false;
        this.fgt = null;
        this.fgu = null;
        this.fgv = null;
        this.fgt = new MarkData();
    }

    public boolean sc() {
        return this.fgs;
    }

    public MarkData sf() {
        return this.fgt;
    }

    public void a(MarkData markData) {
        this.fgt = markData;
    }

    public void ah(boolean z) {
        this.fgs = z;
    }

    public String sb() {
        if (this.fgt != null) {
            return this.fgt.getPostId();
        }
        return null;
    }

    public void se() {
        if (this.fgu != null) {
            this.fgu.cancel();
        }
        this.fgu = new a(true);
        this.fgu.setPriority(3);
        this.fgu.execute(new Boolean[0]);
    }

    public void sd() {
        if (this.fgu != null) {
            this.fgu.cancel();
        }
        this.fgu = new a(false);
        this.fgu.setPriority(3);
        this.fgu.execute(new Boolean[0]);
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean cGt;
        private c fgo;
        private y mNetWork = null;

        public a(boolean z) {
            this.cGt = true;
            this.fgo = null;
            this.cGt = z;
            this.fgo = new c();
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
            if (this.cGt) {
                this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.fgt);
                this.mNetWork.o("data", aVar.bl(0, 1));
            } else {
                this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.o("user_id", MarkModel.this.fgt.getAccount());
                this.mNetWork.o("tid", MarkModel.this.fgt.getId());
                this.mNetWork.o(ImageViewerConfig.FORUM_ID, MarkModel.this.fgt.getForumId());
            }
            this.fgo.parserJson(this.mNetWork.yl());
            boolean z = this.fgo.getErrorCode() == 0;
            if (this.mNetWork.yJ().zJ().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            MarkModel.this.fgu = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.fgo != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.fgo.getErrorCode(), this.fgo.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.fgv != null) {
                        MarkModel.this.fgv.a(true, this.cGt, null);
                    }
                } else if (MarkModel.this.fgv != null) {
                    if (this.mNetWork == null || this.mNetWork.yJ().zJ().isRequestSuccess()) {
                        MarkModel.this.fgv.a(false, this.cGt, this.fgo.getErrorString());
                    } else {
                        MarkModel.this.fgv.a(false, this.cGt, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.fgu = null;
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
        if (this.fgu != null) {
            this.fgu.cancel();
            return false;
        }
        return false;
    }
}
