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
    private boolean laN;
    private MarkData laO;
    private a laP;
    private a.InterfaceC0573a laQ;

    public void a(a.InterfaceC0573a interfaceC0573a) {
        this.laQ = interfaceC0573a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.laN = false;
        this.laO = null;
        this.laP = null;
        this.laQ = null;
        this.laO = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.laN = false;
        this.laO = null;
        this.laP = null;
        this.laQ = null;
        this.laO = new MarkData();
    }

    public boolean biv() {
        return this.laN;
    }

    public MarkData biy() {
        return this.laO;
    }

    public void a(MarkData markData) {
        this.laO = markData;
    }

    public void iq(boolean z) {
        this.laN = z;
    }

    public String biu() {
        if (this.laO != null) {
            return this.laO.getPostId();
        }
        return null;
    }

    public void bix() {
        if (this.laP != null) {
            this.laP.cancel();
        }
        this.laP = new a(true);
        this.laP.setPriority(3);
        this.laP.execute(new Boolean[0]);
    }

    public void biw() {
        if (this.laP != null) {
            this.laP.cancel();
        }
        this.laP = new a(false);
        this.laP.setPriority(3);
        this.laP.execute(new Boolean[0]);
    }

    /* loaded from: classes24.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa caS = null;
        private boolean icW;
        private c laJ;

        public a(boolean z) {
            this.icW = true;
            this.laJ = null;
            this.icW = z;
            this.laJ = new c();
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
            if (this.icW) {
                this.caS = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.laO);
                this.caS.addPostData("data", aVar.cW(0, 1));
            } else {
                this.caS = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.caS.addPostData("user_id", MarkModel.this.laO.getAccount());
                this.caS.addPostData("tid", MarkModel.this.laO.getId());
                this.caS.addPostData("fid", MarkModel.this.laO.getForumId());
            }
            this.laJ.parserJson(this.caS.postNetData());
            boolean z = this.laJ.getErrorCode() == 0;
            if (this.caS.bqN().bru().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.caS != null) {
                this.caS.cancelNetConnect();
            }
            MarkModel.this.laP = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.laJ != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.laJ.getErrorCode(), this.laJ.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.laQ != null) {
                        MarkModel.this.laQ.d(true, this.icW, null);
                    }
                } else if (MarkModel.this.laQ != null) {
                    if (this.caS == null || this.caS.bqN().bru().isRequestSuccess()) {
                        MarkModel.this.laQ.d(false, this.icW, this.laJ.getErrorString());
                    } else {
                        MarkModel.this.laQ.d(false, this.icW, this.caS.getErrorString());
                    }
                }
                MarkModel.this.laP = null;
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
        if (this.laP != null) {
            this.laP.cancel();
            return false;
        }
        return false;
    }
}
