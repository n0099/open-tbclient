package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes8.dex */
public class MarkModel extends BdBaseModel {
    private boolean lxv;
    private MarkData lxw;
    private a lxx;
    private a.InterfaceC0554a lxy;

    public void a(a.InterfaceC0554a interfaceC0554a) {
        this.lxy = interfaceC0554a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.lxv = false;
        this.lxw = null;
        this.lxx = null;
        this.lxy = null;
        this.lxw = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.lxv = false;
        this.lxw = null;
        this.lxx = null;
        this.lxy = null;
        this.lxw = new MarkData();
    }

    public boolean bjZ() {
        return this.lxv;
    }

    public MarkData bkc() {
        return this.lxw;
    }

    public void a(MarkData markData) {
        this.lxw = markData;
    }

    public void ja(boolean z) {
        this.lxv = z;
    }

    public String bjY() {
        if (this.lxw != null) {
            return this.lxw.getPostId();
        }
        return null;
    }

    public void bkb() {
        if (this.lxx != null) {
            this.lxx.cancel();
        }
        this.lxx = new a(true);
        this.lxx.setPriority(3);
        this.lxx.execute(new Boolean[0]);
    }

    public void bka() {
        if (this.lxx != null) {
            this.lxx.cancel();
        }
        this.lxx = new a(false);
        this.lxx.setPriority(3);
        this.lxx.execute(new Boolean[0]);
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa cml = null;
        private boolean iCi;
        private c lxr;

        public a(boolean z) {
            this.iCi = true;
            this.lxr = null;
            this.iCi = z;
            this.lxr = new c();
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
            if (this.iCi) {
                this.cml = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.lxw);
                this.cml.addPostData("data", aVar.cU(0, 1));
            } else {
                this.cml = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.cml.addPostData("user_id", MarkModel.this.lxw.getAccount());
                this.cml.addPostData("tid", MarkModel.this.lxw.getId());
                this.cml.addPostData("fid", MarkModel.this.lxw.getForumId());
            }
            this.lxr.parserJson(this.cml.postNetData());
            boolean z = this.lxr.getErrorCode() == 0;
            if (this.cml.bsr().btb().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cml != null) {
                this.cml.cancelNetConnect();
            }
            MarkModel.this.lxx = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.lxr != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.lxr.getErrorCode(), this.lxr.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.lxy != null) {
                        MarkModel.this.lxy.g(true, this.iCi, null);
                    }
                } else if (MarkModel.this.lxy != null) {
                    if (this.cml == null || this.cml.bsr().btb().isRequestSuccess()) {
                        MarkModel.this.lxy.g(false, this.iCi, this.lxr.getErrorString());
                    } else {
                        MarkModel.this.lxy.g(false, this.iCi, this.cml.getErrorString());
                    }
                }
                MarkModel.this.lxx = null;
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
        if (this.lxx != null) {
            this.lxx.cancel();
            return false;
        }
        return false;
    }
}
