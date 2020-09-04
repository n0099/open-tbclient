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
/* loaded from: classes18.dex */
public class MarkModel extends BdBaseModel {
    private boolean kkI;
    private MarkData kkJ;
    private a kkK;
    private a.InterfaceC0535a kkL;

    public void a(a.InterfaceC0535a interfaceC0535a) {
        this.kkL = interfaceC0535a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.kkI = false;
        this.kkJ = null;
        this.kkK = null;
        this.kkL = null;
        this.kkJ = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.kkI = false;
        this.kkJ = null;
        this.kkK = null;
        this.kkL = null;
        this.kkJ = new MarkData();
    }

    public boolean baA() {
        return this.kkI;
    }

    public MarkData baD() {
        return this.kkJ;
    }

    public void a(MarkData markData) {
        this.kkJ = markData;
    }

    public void hB(boolean z) {
        this.kkI = z;
    }

    public String baz() {
        if (this.kkJ != null) {
            return this.kkJ.getPostId();
        }
        return null;
    }

    public void baC() {
        if (this.kkK != null) {
            this.kkK.cancel();
        }
        this.kkK = new a(true);
        this.kkK.setPriority(3);
        this.kkK.execute(new Boolean[0]);
    }

    public void baB() {
        if (this.kkK != null) {
            this.kkK.cancel();
        }
        this.kkK = new a(false);
        this.kkK.setPriority(3);
        this.kkK.execute(new Boolean[0]);
    }

    /* loaded from: classes18.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa bEb = null;
        private boolean hoD;
        private c kkE;

        public a(boolean z) {
            this.hoD = true;
            this.kkE = null;
            this.hoD = z;
            this.kkE = new c();
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
            if (this.hoD) {
                this.bEb = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.kkJ);
                this.bEb.addPostData("data", aVar.cP(0, 1));
            } else {
                this.bEb = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.bEb.addPostData("user_id", MarkModel.this.kkJ.getAccount());
                this.bEb.addPostData("tid", MarkModel.this.kkJ.getId());
                this.bEb.addPostData("fid", MarkModel.this.kkJ.getForumId());
            }
            this.kkE.parserJson(this.bEb.postNetData());
            boolean z = this.kkE.getErrorCode() == 0;
            if (this.bEb.biQ().bjw().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bEb != null) {
                this.bEb.cancelNetConnect();
            }
            MarkModel.this.kkK = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.kkE != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.kkE.getErrorCode(), this.kkE.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.kkL != null) {
                        MarkModel.this.kkL.c(true, this.hoD, null);
                    }
                } else if (MarkModel.this.kkL != null) {
                    if (this.bEb == null || this.bEb.biQ().bjw().isRequestSuccess()) {
                        MarkModel.this.kkL.c(false, this.hoD, this.kkE.getErrorString());
                    } else {
                        MarkModel.this.kkL.c(false, this.hoD, this.bEb.getErrorString());
                    }
                }
                MarkModel.this.kkK = null;
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
        if (this.kkK != null) {
            this.kkK.cancel();
            return false;
        }
        return false;
    }
}
