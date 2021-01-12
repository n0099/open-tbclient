package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes7.dex */
public class MarkModel extends BdBaseModel {
    private boolean lpr;
    private MarkData lps;
    private a lpt;
    private a.InterfaceC0557a lpu;

    public void a(a.InterfaceC0557a interfaceC0557a) {
        this.lpu = interfaceC0557a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.lpr = false;
        this.lps = null;
        this.lpt = null;
        this.lpu = null;
        this.lps = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.lpr = false;
        this.lps = null;
        this.lpt = null;
        this.lpu = null;
        this.lps = new MarkData();
    }

    public boolean bjE() {
        return this.lpr;
    }

    public MarkData bjH() {
        return this.lps;
    }

    public void a(MarkData markData) {
        this.lps = markData;
    }

    public void iY(boolean z) {
        this.lpr = z;
    }

    public String bjD() {
        if (this.lps != null) {
            return this.lps.getPostId();
        }
        return null;
    }

    public void bjG() {
        if (this.lpt != null) {
            this.lpt.cancel();
        }
        this.lpt = new a(true);
        this.lpt.setPriority(3);
        this.lpt.execute(new Boolean[0]);
    }

    public void bjF() {
        if (this.lpt != null) {
            this.lpt.cancel();
        }
        this.lpt = new a(false);
        this.lpt.setPriority(3);
        this.lpt.execute(new Boolean[0]);
    }

    /* loaded from: classes7.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private z chV = null;
        private boolean iwy;
        private c lpn;

        public a(boolean z) {
            this.iwy = true;
            this.lpn = null;
            this.iwy = z;
            this.lpn = new c();
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
            if (this.iwy) {
                this.chV = new z(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.lps);
                this.chV.addPostData("data", aVar.cX(0, 1));
            } else {
                this.chV = new z(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.chV.addPostData("user_id", MarkModel.this.lps.getAccount());
                this.chV.addPostData("tid", MarkModel.this.lps.getId());
                this.chV.addPostData("fid", MarkModel.this.lps.getForumId());
            }
            this.lpn.parserJson(this.chV.postNetData());
            boolean z = this.lpn.getErrorCode() == 0;
            if (this.chV.brX().bsH().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.chV != null) {
                this.chV.cancelNetConnect();
            }
            MarkModel.this.lpt = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.lpn != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.lpn.getErrorCode(), this.lpn.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.lpu != null) {
                        MarkModel.this.lpu.g(true, this.iwy, null);
                    }
                } else if (MarkModel.this.lpu != null) {
                    if (this.chV == null || this.chV.brX().bsH().isRequestSuccess()) {
                        MarkModel.this.lpu.g(false, this.iwy, this.lpn.getErrorString());
                    } else {
                        MarkModel.this.lpu.g(false, this.iwy, this.chV.getErrorString());
                    }
                }
                MarkModel.this.lpt = null;
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
        if (this.lpt != null) {
            this.lpt.cancel();
            return false;
        }
        return false;
    }
}
