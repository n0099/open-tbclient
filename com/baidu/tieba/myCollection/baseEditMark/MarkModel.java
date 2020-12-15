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
    private boolean loI;
    private MarkData loJ;
    private a loK;
    private a.InterfaceC0583a loL;

    public void a(a.InterfaceC0583a interfaceC0583a) {
        this.loL = interfaceC0583a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.loI = false;
        this.loJ = null;
        this.loK = null;
        this.loL = null;
        this.loJ = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.loI = false;
        this.loJ = null;
        this.loK = null;
        this.loL = null;
        this.loJ = new MarkData();
    }

    public boolean bkY() {
        return this.loI;
    }

    public MarkData blb() {
        return this.loJ;
    }

    public void a(MarkData markData) {
        this.loJ = markData;
    }

    public void iH(boolean z) {
        this.loI = z;
    }

    public String bkX() {
        if (this.loJ != null) {
            return this.loJ.getPostId();
        }
        return null;
    }

    public void bla() {
        if (this.loK != null) {
            this.loK.cancel();
        }
        this.loK = new a(true);
        this.loK.setPriority(3);
        this.loK.execute(new Boolean[0]);
    }

    public void bkZ() {
        if (this.loK != null) {
            this.loK.cancel();
        }
        this.loK = new a(false);
        this.loK.setPriority(3);
        this.loK.execute(new Boolean[0]);
    }

    /* loaded from: classes24.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa cfI = null;
        private boolean ioL;
        private c loE;

        public a(boolean z) {
            this.ioL = true;
            this.loE = null;
            this.ioL = z;
            this.loE = new c();
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
            if (this.ioL) {
                this.cfI = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.loJ);
                this.cfI.addPostData("data", aVar.db(0, 1));
            } else {
                this.cfI = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.cfI.addPostData("user_id", MarkModel.this.loJ.getAccount());
                this.cfI.addPostData("tid", MarkModel.this.loJ.getId());
                this.cfI.addPostData("fid", MarkModel.this.loJ.getForumId());
            }
            this.loE.parserJson(this.cfI.postNetData());
            boolean z = this.loE.getErrorCode() == 0;
            if (this.cfI.btv().buf().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cfI != null) {
                this.cfI.cancelNetConnect();
            }
            MarkModel.this.loK = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.loE != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.loE.getErrorCode(), this.loE.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.loL != null) {
                        MarkModel.this.loL.d(true, this.ioL, null);
                    }
                } else if (MarkModel.this.loL != null) {
                    if (this.cfI == null || this.cfI.btv().buf().isRequestSuccess()) {
                        MarkModel.this.loL.d(false, this.ioL, this.loE.getErrorString());
                    } else {
                        MarkModel.this.loL.d(false, this.ioL, this.cfI.getErrorString());
                    }
                }
                MarkModel.this.loK = null;
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
        if (this.loK != null) {
            this.loK.cancel();
            return false;
        }
        return false;
    }
}
