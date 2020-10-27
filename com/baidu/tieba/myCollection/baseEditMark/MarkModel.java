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
/* loaded from: classes24.dex */
public class MarkModel extends BdBaseModel {
    private boolean kUQ;
    private MarkData kUR;
    private a kUS;
    private a.InterfaceC0561a kUT;

    public void a(a.InterfaceC0561a interfaceC0561a) {
        this.kUT = interfaceC0561a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.kUQ = false;
        this.kUR = null;
        this.kUS = null;
        this.kUT = null;
        this.kUR = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.kUQ = false;
        this.kUR = null;
        this.kUS = null;
        this.kUT = null;
        this.kUR = new MarkData();
    }

    public boolean bfV() {
        return this.kUQ;
    }

    public MarkData bfY() {
        return this.kUR;
    }

    public void a(MarkData markData) {
        this.kUR = markData;
    }

    public void ih(boolean z) {
        this.kUQ = z;
    }

    public String bfU() {
        if (this.kUR != null) {
            return this.kUR.getPostId();
        }
        return null;
    }

    public void bfX() {
        if (this.kUS != null) {
            this.kUS.cancel();
        }
        this.kUS = new a(true);
        this.kUS.setPriority(3);
        this.kUS.execute(new Boolean[0]);
    }

    public void bfW() {
        if (this.kUS != null) {
            this.kUS.cancel();
        }
        this.kUS = new a(false);
        this.kUS.setPriority(3);
        this.kUS.execute(new Boolean[0]);
    }

    /* loaded from: classes24.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa bVi = null;
        private boolean hWZ;
        private c kUM;

        public a(boolean z) {
            this.hWZ = true;
            this.kUM = null;
            this.hWZ = z;
            this.kUM = new c();
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
            if (this.hWZ) {
                this.bVi = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.kUR);
                this.bVi.addPostData("data", aVar.cU(0, 1));
            } else {
                this.bVi = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.bVi.addPostData("user_id", MarkModel.this.kUR.getAccount());
                this.bVi.addPostData("tid", MarkModel.this.kUR.getId());
                this.bVi.addPostData("fid", MarkModel.this.kUR.getForumId());
            }
            this.kUM.parserJson(this.bVi.postNetData());
            boolean z = this.kUM.getErrorCode() == 0;
            if (this.bVi.bon().boU().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bVi != null) {
                this.bVi.cancelNetConnect();
            }
            MarkModel.this.kUS = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.kUM != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.kUM.getErrorCode(), this.kUM.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.kUT != null) {
                        MarkModel.this.kUT.d(true, this.hWZ, null);
                    }
                } else if (MarkModel.this.kUT != null) {
                    if (this.bVi == null || this.bVi.bon().boU().isRequestSuccess()) {
                        MarkModel.this.kUT.d(false, this.hWZ, this.kUM.getErrorString());
                    } else {
                        MarkModel.this.kUT.d(false, this.hWZ, this.bVi.getErrorString());
                    }
                }
                MarkModel.this.kUS = null;
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
        if (this.kUS != null) {
            this.kUS.cancel();
            return false;
        }
        return false;
    }
}
