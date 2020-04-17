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
    private boolean jfb;
    private MarkData jfc;
    private a jfd;
    private a.InterfaceC0404a jfe;

    public void a(a.InterfaceC0404a interfaceC0404a) {
        this.jfe = interfaceC0404a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jfb = false;
        this.jfc = null;
        this.jfd = null;
        this.jfe = null;
        this.jfc = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.jfb = false;
        this.jfc = null;
        this.jfd = null;
        this.jfe = null;
        this.jfc = new MarkData();
    }

    public boolean aGZ() {
        return this.jfb;
    }

    public MarkData aHc() {
        return this.jfc;
    }

    public void a(MarkData markData) {
        this.jfc = markData;
    }

    public void gk(boolean z) {
        this.jfb = z;
    }

    public String aGY() {
        if (this.jfc != null) {
            return this.jfc.getPostId();
        }
        return null;
    }

    public void aHb() {
        if (this.jfd != null) {
            this.jfd.cancel();
        }
        this.jfd = new a(true);
        this.jfd.setPriority(3);
        this.jfd.execute(new Boolean[0]);
    }

    public void aHa() {
        if (this.jfd != null) {
            this.jfd.cancel();
        }
        this.jfd = new a(false);
        this.jfd.setPriority(3);
        this.jfd.execute(new Boolean[0]);
    }

    /* loaded from: classes11.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x blF = null;
        private boolean gub;
        private c jeX;

        public a(boolean z) {
            this.gub = true;
            this.jeX = null;
            this.gub = z;
            this.jeX = new c();
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
            if (this.gub) {
                this.blF = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.jfc);
                this.blF.addPostData("data", aVar.ct(0, 1));
            } else {
                this.blF = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.blF.addPostData("user_id", MarkModel.this.jfc.getAccount());
                this.blF.addPostData("tid", MarkModel.this.jfc.getId());
                this.blF.addPostData("fid", MarkModel.this.jfc.getForumId());
            }
            this.jeX.parserJson(this.blF.postNetData());
            boolean z = this.jeX.getErrorCode() == 0;
            if (this.blF.aOy().aPa().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.blF != null) {
                this.blF.cancelNetConnect();
            }
            MarkModel.this.jfd = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.jeX != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.jeX.getErrorCode(), this.jeX.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.jfe != null) {
                        MarkModel.this.jfe.c(true, this.gub, null);
                    }
                } else if (MarkModel.this.jfe != null) {
                    if (this.blF == null || this.blF.aOy().aPa().isRequestSuccess()) {
                        MarkModel.this.jfe.c(false, this.gub, this.jeX.getErrorString());
                    } else {
                        MarkModel.this.jfe.c(false, this.gub, this.blF.getErrorString());
                    }
                }
                MarkModel.this.jfd = null;
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
        if (this.jfd != null) {
            this.jfd.cancel();
            return false;
        }
        return false;
    }
}
