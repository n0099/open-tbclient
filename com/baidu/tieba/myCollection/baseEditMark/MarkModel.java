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
/* loaded from: classes7.dex */
public class MarkModel extends BdBaseModel {
    private boolean lzM;
    private MarkData lzN;
    private a lzO;
    private a.InterfaceC0560a lzP;

    public void a(a.InterfaceC0560a interfaceC0560a) {
        this.lzP = interfaceC0560a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.lzM = false;
        this.lzN = null;
        this.lzO = null;
        this.lzP = null;
        this.lzN = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.lzM = false;
        this.lzN = null;
        this.lzO = null;
        this.lzP = null;
        this.lzN = new MarkData();
    }

    public boolean bkb() {
        return this.lzM;
    }

    public MarkData bke() {
        return this.lzN;
    }

    public void a(MarkData markData) {
        this.lzN = markData;
    }

    public void ja(boolean z) {
        this.lzM = z;
    }

    public String bka() {
        if (this.lzN != null) {
            return this.lzN.getPostId();
        }
        return null;
    }

    public void bkd() {
        if (this.lzO != null) {
            this.lzO.cancel();
        }
        this.lzO = new a(true);
        this.lzO.setPriority(3);
        this.lzO.execute(new Boolean[0]);
    }

    public void bkc() {
        if (this.lzO != null) {
            this.lzO.cancel();
        }
        this.lzO = new a(false);
        this.lzO.setPriority(3);
        this.lzO.execute(new Boolean[0]);
    }

    /* loaded from: classes7.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa cnM = null;
        private boolean iEf;
        private c lzI;

        public a(boolean z) {
            this.iEf = true;
            this.lzI = null;
            this.iEf = z;
            this.lzI = new c();
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
            if (this.iEf) {
                this.cnM = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.lzN);
                this.cnM.addPostData("data", aVar.cV(0, 1));
            } else {
                this.cnM = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.cnM.addPostData("user_id", MarkModel.this.lzN.getAccount());
                this.cnM.addPostData("tid", MarkModel.this.lzN.getId());
                this.cnM.addPostData("fid", MarkModel.this.lzN.getForumId());
            }
            this.lzI.parserJson(this.cnM.postNetData());
            boolean z = this.lzI.getErrorCode() == 0;
            if (this.cnM.bsu().bte().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cnM != null) {
                this.cnM.cancelNetConnect();
            }
            MarkModel.this.lzO = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.lzI != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.lzI.getErrorCode(), this.lzI.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.lzP != null) {
                        MarkModel.this.lzP.e(true, this.iEf, null);
                    }
                } else if (MarkModel.this.lzP != null) {
                    if (this.cnM == null || this.cnM.bsu().bte().isRequestSuccess()) {
                        MarkModel.this.lzP.e(false, this.iEf, this.lzI.getErrorString());
                    } else {
                        MarkModel.this.lzP.e(false, this.iEf, this.cnM.getErrorString());
                    }
                }
                MarkModel.this.lzO = null;
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
        if (this.lzO != null) {
            this.lzO.cancel();
            return false;
        }
        return false;
    }
}
