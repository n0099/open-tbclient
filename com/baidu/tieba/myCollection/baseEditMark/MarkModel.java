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
/* loaded from: classes6.dex */
public class MarkModel extends BdBaseModel {
    private boolean hAw;
    private MarkData hAx;
    private a hAy;
    private a.InterfaceC0279a hAz;

    public void a(a.InterfaceC0279a interfaceC0279a) {
        this.hAz = interfaceC0279a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hAw = false;
        this.hAx = null;
        this.hAy = null;
        this.hAz = null;
        this.hAx = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.hAw = false;
        this.hAx = null;
        this.hAy = null;
        this.hAz = null;
        this.hAx = new MarkData();
    }

    public boolean afm() {
        return this.hAw;
    }

    public MarkData afp() {
        return this.hAx;
    }

    public void a(MarkData markData) {
        this.hAx = markData;
    }

    public void dO(boolean z) {
        this.hAw = z;
    }

    public String afl() {
        if (this.hAx != null) {
            return this.hAx.getPostId();
        }
        return null;
    }

    public void afo() {
        if (this.hAy != null) {
            this.hAy.cancel();
        }
        this.hAy = new a(true);
        this.hAy.setPriority(3);
        this.hAy.execute(new Boolean[0]);
    }

    public void afn() {
        if (this.hAy != null) {
            this.hAy.cancel();
        }
        this.hAy = new a(false);
        this.hAy.setPriority(3);
        this.hAy.execute(new Boolean[0]);
    }

    /* loaded from: classes6.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x bVP = null;
        private boolean eVb;
        private c hAs;

        public a(boolean z) {
            this.eVb = true;
            this.hAs = null;
            this.eVb = z;
            this.hAs = new c();
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
            if (this.eVb) {
                this.bVP = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.hAx);
                this.bVP.addPostData("data", aVar.bV(0, 1));
            } else {
                this.bVP = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.bVP.addPostData("user_id", MarkModel.this.hAx.getAccount());
                this.bVP.addPostData("tid", MarkModel.this.hAx.getId());
                this.bVP.addPostData("fid", MarkModel.this.hAx.getForumId());
            }
            this.hAs.parserJson(this.bVP.postNetData());
            boolean z = this.hAs.getErrorCode() == 0;
            if (this.bVP.amr().amS().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bVP != null) {
                this.bVP.cancelNetConnect();
            }
            MarkModel.this.hAy = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.hAs != null) {
                    com.baidu.tbadk.core.e.a.a("collection", 0L, 0, "add_collection_thread", this.hAs.getErrorCode(), this.hAs.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.hAz != null) {
                        MarkModel.this.hAz.c(true, this.eVb, null);
                    }
                } else if (MarkModel.this.hAz != null) {
                    if (this.bVP == null || this.bVP.amr().amS().isRequestSuccess()) {
                        MarkModel.this.hAz.c(false, this.eVb, this.hAs.getErrorString());
                    } else {
                        MarkModel.this.hAz.c(false, this.eVb, this.bVP.getErrorString());
                    }
                }
                MarkModel.this.hAy = null;
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
        if (this.hAy != null) {
            this.hAy.cancel();
            return false;
        }
        return false;
    }
}
