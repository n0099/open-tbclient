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
    private boolean kIt;
    private MarkData kIu;
    private a kIv;
    private a.InterfaceC0547a kIw;

    public void a(a.InterfaceC0547a interfaceC0547a) {
        this.kIw = interfaceC0547a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.kIt = false;
        this.kIu = null;
        this.kIv = null;
        this.kIw = null;
        this.kIu = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.kIt = false;
        this.kIu = null;
        this.kIv = null;
        this.kIw = null;
        this.kIu = new MarkData();
    }

    public boolean bec() {
        return this.kIt;
    }

    public MarkData bef() {
        return this.kIu;
    }

    public void a(MarkData markData) {
        this.kIu = markData;
    }

    public void hU(boolean z) {
        this.kIt = z;
    }

    public String beb() {
        if (this.kIu != null) {
            return this.kIu.getPostId();
        }
        return null;
    }

    public void bee() {
        if (this.kIv != null) {
            this.kIv.cancel();
        }
        this.kIv = new a(true);
        this.kIv.setPriority(3);
        this.kIv.execute(new Boolean[0]);
    }

    public void bed() {
        if (this.kIv != null) {
            this.kIv.cancel();
        }
        this.kIv = new a(false);
        this.kIv.setPriority(3);
        this.kIv.execute(new Boolean[0]);
    }

    /* loaded from: classes24.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa bML = null;
        private boolean hKC;
        private c kIp;

        public a(boolean z) {
            this.hKC = true;
            this.kIp = null;
            this.hKC = z;
            this.kIp = new c();
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
            if (this.hKC) {
                this.bML = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.kIu);
                this.bML.addPostData("data", aVar.cS(0, 1));
            } else {
                this.bML = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.bML.addPostData("user_id", MarkModel.this.kIu.getAccount());
                this.bML.addPostData("tid", MarkModel.this.kIu.getId());
                this.bML.addPostData("fid", MarkModel.this.kIu.getForumId());
            }
            this.kIp.parserJson(this.bML.postNetData());
            boolean z = this.kIp.getErrorCode() == 0;
            if (this.bML.bmu().bnb().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bML != null) {
                this.bML.cancelNetConnect();
            }
            MarkModel.this.kIv = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.kIp != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.kIp.getErrorCode(), this.kIp.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.kIw != null) {
                        MarkModel.this.kIw.c(true, this.hKC, null);
                    }
                } else if (MarkModel.this.kIw != null) {
                    if (this.bML == null || this.bML.bmu().bnb().isRequestSuccess()) {
                        MarkModel.this.kIw.c(false, this.hKC, this.kIp.getErrorString());
                    } else {
                        MarkModel.this.kIw.c(false, this.hKC, this.bML.getErrorString());
                    }
                }
                MarkModel.this.kIv = null;
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
        if (this.kIv != null) {
            this.kIv.cancel();
            return false;
        }
        return false;
    }
}
