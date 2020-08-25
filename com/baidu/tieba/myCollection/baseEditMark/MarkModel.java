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
    private boolean kkB;
    private MarkData kkC;
    private a kkD;
    private a.InterfaceC0535a kkE;

    public void a(a.InterfaceC0535a interfaceC0535a) {
        this.kkE = interfaceC0535a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.kkB = false;
        this.kkC = null;
        this.kkD = null;
        this.kkE = null;
        this.kkC = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.kkB = false;
        this.kkC = null;
        this.kkD = null;
        this.kkE = null;
        this.kkC = new MarkData();
    }

    public boolean baA() {
        return this.kkB;
    }

    public MarkData baD() {
        return this.kkC;
    }

    public void a(MarkData markData) {
        this.kkC = markData;
    }

    public void hA(boolean z) {
        this.kkB = z;
    }

    public String baz() {
        if (this.kkC != null) {
            return this.kkC.getPostId();
        }
        return null;
    }

    public void baC() {
        if (this.kkD != null) {
            this.kkD.cancel();
        }
        this.kkD = new a(true);
        this.kkD.setPriority(3);
        this.kkD.execute(new Boolean[0]);
    }

    public void baB() {
        if (this.kkD != null) {
            this.kkD.cancel();
        }
        this.kkD = new a(false);
        this.kkD.setPriority(3);
        this.kkD.execute(new Boolean[0]);
    }

    /* loaded from: classes18.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa bDY = null;
        private boolean hoz;
        private c kkx;

        public a(boolean z) {
            this.hoz = true;
            this.kkx = null;
            this.hoz = z;
            this.kkx = new c();
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
            if (this.hoz) {
                this.bDY = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.kkC);
                this.bDY.addPostData("data", aVar.cP(0, 1));
            } else {
                this.bDY = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.bDY.addPostData("user_id", MarkModel.this.kkC.getAccount());
                this.bDY.addPostData("tid", MarkModel.this.kkC.getId());
                this.bDY.addPostData("fid", MarkModel.this.kkC.getForumId());
            }
            this.kkx.parserJson(this.bDY.postNetData());
            boolean z = this.kkx.getErrorCode() == 0;
            if (this.bDY.biQ().bjw().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bDY != null) {
                this.bDY.cancelNetConnect();
            }
            MarkModel.this.kkD = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.kkx != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.kkx.getErrorCode(), this.kkx.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.kkE != null) {
                        MarkModel.this.kkE.c(true, this.hoz, null);
                    }
                } else if (MarkModel.this.kkE != null) {
                    if (this.bDY == null || this.bDY.biQ().bjw().isRequestSuccess()) {
                        MarkModel.this.kkE.c(false, this.hoz, this.kkx.getErrorString());
                    } else {
                        MarkModel.this.kkE.c(false, this.hoz, this.bDY.getErrorString());
                    }
                }
                MarkModel.this.kkD = null;
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
        if (this.kkD != null) {
            this.kkD.cancel();
            return false;
        }
        return false;
    }
}
