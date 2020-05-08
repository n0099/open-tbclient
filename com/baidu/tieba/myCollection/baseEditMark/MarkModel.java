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
    private boolean jff;
    private MarkData jfg;
    private a jfh;
    private a.InterfaceC0425a jfi;

    public void a(a.InterfaceC0425a interfaceC0425a) {
        this.jfi = interfaceC0425a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jff = false;
        this.jfg = null;
        this.jfh = null;
        this.jfi = null;
        this.jfg = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.jff = false;
        this.jfg = null;
        this.jfh = null;
        this.jfi = null;
        this.jfg = new MarkData();
    }

    public boolean aGX() {
        return this.jff;
    }

    public MarkData aHa() {
        return this.jfg;
    }

    public void a(MarkData markData) {
        this.jfg = markData;
    }

    public void gk(boolean z) {
        this.jff = z;
    }

    public String aGW() {
        if (this.jfg != null) {
            return this.jfg.getPostId();
        }
        return null;
    }

    public void aGZ() {
        if (this.jfh != null) {
            this.jfh.cancel();
        }
        this.jfh = new a(true);
        this.jfh.setPriority(3);
        this.jfh.execute(new Boolean[0]);
    }

    public void aGY() {
        if (this.jfh != null) {
            this.jfh.cancel();
        }
        this.jfh = new a(false);
        this.jfh.setPriority(3);
        this.jfh.execute(new Boolean[0]);
    }

    /* loaded from: classes11.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x blK = null;
        private boolean guh;
        private c jfb;

        public a(boolean z) {
            this.guh = true;
            this.jfb = null;
            this.guh = z;
            this.jfb = new c();
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
            if (this.guh) {
                this.blK = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.jfg);
                this.blK.addPostData("data", aVar.ct(0, 1));
            } else {
                this.blK = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.blK.addPostData("user_id", MarkModel.this.jfg.getAccount());
                this.blK.addPostData("tid", MarkModel.this.jfg.getId());
                this.blK.addPostData("fid", MarkModel.this.jfg.getForumId());
            }
            this.jfb.parserJson(this.blK.postNetData());
            boolean z = this.jfb.getErrorCode() == 0;
            if (this.blK.aOw().aOX().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.blK != null) {
                this.blK.cancelNetConnect();
            }
            MarkModel.this.jfh = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.jfb != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.jfb.getErrorCode(), this.jfb.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.jfi != null) {
                        MarkModel.this.jfi.c(true, this.guh, null);
                    }
                } else if (MarkModel.this.jfi != null) {
                    if (this.blK == null || this.blK.aOw().aOX().isRequestSuccess()) {
                        MarkModel.this.jfi.c(false, this.guh, this.jfb.getErrorString());
                    } else {
                        MarkModel.this.jfi.c(false, this.guh, this.blK.getErrorString());
                    }
                }
                MarkModel.this.jfh = null;
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
        if (this.jfh != null) {
            this.jfh.cancel();
            return false;
        }
        return false;
    }
}
