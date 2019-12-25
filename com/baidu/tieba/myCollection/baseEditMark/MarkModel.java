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
/* loaded from: classes8.dex */
public class MarkModel extends BdBaseModel {
    private boolean inJ;
    private MarkData inK;
    private a inL;
    private a.InterfaceC0362a inM;

    public void a(a.InterfaceC0362a interfaceC0362a) {
        this.inM = interfaceC0362a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.inJ = false;
        this.inK = null;
        this.inL = null;
        this.inM = null;
        this.inK = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.inJ = false;
        this.inK = null;
        this.inL = null;
        this.inM = null;
        this.inK = new MarkData();
    }

    public boolean awd() {
        return this.inJ;
    }

    public MarkData awg() {
        return this.inK;
    }

    public void a(MarkData markData) {
        this.inK = markData;
    }

    public void fa(boolean z) {
        this.inJ = z;
    }

    public String awc() {
        if (this.inK != null) {
            return this.inK.getPostId();
        }
        return null;
    }

    public void awf() {
        if (this.inL != null) {
            this.inL.cancel();
        }
        this.inL = new a(true);
        this.inL.setPriority(3);
        this.inL.execute(new Boolean[0]);
    }

    public void awe() {
        if (this.inL != null) {
            this.inL.cancel();
        }
        this.inL = new a(false);
        this.inL.setPriority(3);
        this.inL.execute(new Boolean[0]);
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x cHo = null;
        private boolean fIR;
        private c inF;

        public a(boolean z) {
            this.fIR = true;
            this.inF = null;
            this.fIR = z;
            this.inF = new c();
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
            if (this.fIR) {
                this.cHo = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.inK);
                this.cHo.addPostData("data", aVar.cm(0, 1));
            } else {
                this.cHo = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.cHo.addPostData("user_id", MarkModel.this.inK.getAccount());
                this.cHo.addPostData("tid", MarkModel.this.inK.getId());
                this.cHo.addPostData("fid", MarkModel.this.inK.getForumId());
            }
            this.inF.parserJson(this.cHo.postNetData());
            boolean z = this.inF.getErrorCode() == 0;
            if (this.cHo.aDB().aEc().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cHo != null) {
                this.cHo.cancelNetConnect();
            }
            MarkModel.this.inL = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.inF != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.inF.getErrorCode(), this.inF.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.inM != null) {
                        MarkModel.this.inM.c(true, this.fIR, null);
                    }
                } else if (MarkModel.this.inM != null) {
                    if (this.cHo == null || this.cHo.aDB().aEc().isRequestSuccess()) {
                        MarkModel.this.inM.c(false, this.fIR, this.inF.getErrorString());
                    } else {
                        MarkModel.this.inM.c(false, this.fIR, this.cHo.getErrorString());
                    }
                }
                MarkModel.this.inL = null;
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
        if (this.inL != null) {
            this.inL.cancel();
            return false;
        }
        return false;
    }
}
