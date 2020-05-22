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
    private boolean jui;
    private MarkData juj;
    private a juk;
    private a.InterfaceC0471a jul;

    public void a(a.InterfaceC0471a interfaceC0471a) {
        this.jul = interfaceC0471a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jui = false;
        this.juj = null;
        this.juk = null;
        this.jul = null;
        this.juj = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.jui = false;
        this.juj = null;
        this.juk = null;
        this.jul = null;
        this.juj = new MarkData();
    }

    public boolean aML() {
        return this.jui;
    }

    public MarkData aMO() {
        return this.juj;
    }

    public void a(MarkData markData) {
        this.juj = markData;
    }

    public void gC(boolean z) {
        this.jui = z;
    }

    public String aMK() {
        if (this.juj != null) {
            return this.juj.getPostId();
        }
        return null;
    }

    public void aMN() {
        if (this.juk != null) {
            this.juk.cancel();
        }
        this.juk = new a(true);
        this.juk.setPriority(3);
        this.juk.execute(new Boolean[0]);
    }

    public void aMM() {
        if (this.juk != null) {
            this.juk.cancel();
        }
        this.juk = new a(false);
        this.juk.setPriority(3);
        this.juk.execute(new Boolean[0]);
    }

    /* loaded from: classes11.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x bth = null;
        private boolean gIS;
        private c jue;

        public a(boolean z) {
            this.gIS = true;
            this.jue = null;
            this.gIS = z;
            this.jue = new c();
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
            if (this.gIS) {
                this.bth = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.juj);
                this.bth.addPostData("data", aVar.cy(0, 1));
            } else {
                this.bth = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.bth.addPostData("user_id", MarkModel.this.juj.getAccount());
                this.bth.addPostData("tid", MarkModel.this.juj.getId());
                this.bth.addPostData("fid", MarkModel.this.juj.getForumId());
            }
            this.jue.parserJson(this.bth.postNetData());
            boolean z = this.jue.getErrorCode() == 0;
            if (this.bth.aUA().aVb().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bth != null) {
                this.bth.cancelNetConnect();
            }
            MarkModel.this.juk = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.jue != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.jue.getErrorCode(), this.jue.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.jul != null) {
                        MarkModel.this.jul.c(true, this.gIS, null);
                    }
                } else if (MarkModel.this.jul != null) {
                    if (this.bth == null || this.bth.aUA().aVb().isRequestSuccess()) {
                        MarkModel.this.jul.c(false, this.gIS, this.jue.getErrorString());
                    } else {
                        MarkModel.this.jul.c(false, this.gIS, this.bth.getErrorString());
                    }
                }
                MarkModel.this.juk = null;
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
        if (this.juk != null) {
            this.juk.cancel();
            return false;
        }
        return false;
    }
}
