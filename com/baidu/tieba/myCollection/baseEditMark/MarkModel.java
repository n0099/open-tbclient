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
    private boolean hyZ;
    private MarkData hza;
    private a hzb;
    private a.InterfaceC0238a hzc;

    public void a(a.InterfaceC0238a interfaceC0238a) {
        this.hzc = interfaceC0238a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hyZ = false;
        this.hza = null;
        this.hzb = null;
        this.hzc = null;
        this.hza = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.hyZ = false;
        this.hza = null;
        this.hzb = null;
        this.hzc = null;
        this.hza = new MarkData();
    }

    public boolean aaB() {
        return this.hyZ;
    }

    public MarkData aaE() {
        return this.hza;
    }

    public void a(MarkData markData) {
        this.hza = markData;
    }

    public void dx(boolean z) {
        this.hyZ = z;
    }

    public String aaA() {
        if (this.hza != null) {
            return this.hza.getPostId();
        }
        return null;
    }

    public void aaD() {
        if (this.hzb != null) {
            this.hzb.cancel();
        }
        this.hzb = new a(true);
        this.hzb.setPriority(3);
        this.hzb.execute(new Boolean[0]);
    }

    public void aaC() {
        if (this.hzb != null) {
            this.hzb.cancel();
        }
        this.hzb = new a(false);
        this.hzb.setPriority(3);
        this.hzb.execute(new Boolean[0]);
    }

    /* loaded from: classes6.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private boolean eKF;
        private c hyV;
        private x mNetWork = null;

        public a(boolean z) {
            this.eKF = true;
            this.hyV = null;
            this.eKF = z;
            this.hyV = new c();
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
            if (this.eKF) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.hza);
                this.mNetWork.o("data", aVar.cc(0, 1));
            } else {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.mNetWork.o("user_id", MarkModel.this.hza.getAccount());
                this.mNetWork.o("tid", MarkModel.this.hza.getId());
                this.mNetWork.o("fid", MarkModel.this.hza.getForumId());
            }
            this.hyV.parserJson(this.mNetWork.aig());
            boolean z = this.hyV.getErrorCode() == 0;
            if (this.mNetWork.aiE().ajF().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ik();
            }
            MarkModel.this.hzb = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.hyV != null) {
                    com.baidu.tbadk.core.e.a.a("collection", 0L, 0, "add_collection_thread", this.hyV.getErrorCode(), this.hyV.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.hzc != null) {
                        MarkModel.this.hzc.c(true, this.eKF, null);
                    }
                } else if (MarkModel.this.hzc != null) {
                    if (this.mNetWork == null || this.mNetWork.aiE().ajF().isRequestSuccess()) {
                        MarkModel.this.hzc.c(false, this.eKF, this.hyV.getErrorString());
                    } else {
                        MarkModel.this.hzc.c(false, this.eKF, this.mNetWork.getErrorString());
                    }
                }
                MarkModel.this.hzb = null;
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
        if (this.hzb != null) {
            this.hzb.cancel();
            return false;
        }
        return false;
    }
}
