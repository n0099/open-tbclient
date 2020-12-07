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
    private boolean loG;
    private MarkData loH;
    private a loI;
    private a.InterfaceC0583a loJ;

    public void a(a.InterfaceC0583a interfaceC0583a) {
        this.loJ = interfaceC0583a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.loG = false;
        this.loH = null;
        this.loI = null;
        this.loJ = null;
        this.loH = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.loG = false;
        this.loH = null;
        this.loI = null;
        this.loJ = null;
        this.loH = new MarkData();
    }

    public boolean bkY() {
        return this.loG;
    }

    public MarkData blb() {
        return this.loH;
    }

    public void a(MarkData markData) {
        this.loH = markData;
    }

    public void iH(boolean z) {
        this.loG = z;
    }

    public String bkX() {
        if (this.loH != null) {
            return this.loH.getPostId();
        }
        return null;
    }

    public void bla() {
        if (this.loI != null) {
            this.loI.cancel();
        }
        this.loI = new a(true);
        this.loI.setPriority(3);
        this.loI.execute(new Boolean[0]);
    }

    public void bkZ() {
        if (this.loI != null) {
            this.loI.cancel();
        }
        this.loI = new a(false);
        this.loI.setPriority(3);
        this.loI.execute(new Boolean[0]);
    }

    /* loaded from: classes24.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa cfI = null;
        private boolean ioJ;
        private c loC;

        public a(boolean z) {
            this.ioJ = true;
            this.loC = null;
            this.ioJ = z;
            this.loC = new c();
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
            if (this.ioJ) {
                this.cfI = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.loH);
                this.cfI.addPostData("data", aVar.db(0, 1));
            } else {
                this.cfI = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.cfI.addPostData("user_id", MarkModel.this.loH.getAccount());
                this.cfI.addPostData("tid", MarkModel.this.loH.getId());
                this.cfI.addPostData("fid", MarkModel.this.loH.getForumId());
            }
            this.loC.parserJson(this.cfI.postNetData());
            boolean z = this.loC.getErrorCode() == 0;
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
            MarkModel.this.loI = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.loC != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.loC.getErrorCode(), this.loC.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.loJ != null) {
                        MarkModel.this.loJ.d(true, this.ioJ, null);
                    }
                } else if (MarkModel.this.loJ != null) {
                    if (this.cfI == null || this.cfI.btv().buf().isRequestSuccess()) {
                        MarkModel.this.loJ.d(false, this.ioJ, this.loC.getErrorString());
                    } else {
                        MarkModel.this.loJ.d(false, this.ioJ, this.cfI.getErrorString());
                    }
                }
                MarkModel.this.loI = null;
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
        if (this.loI != null) {
            this.loI.cancel();
            return false;
        }
        return false;
    }
}
