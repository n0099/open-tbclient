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
/* loaded from: classes8.dex */
public class MarkModel extends BdBaseModel {
    private boolean ltX;
    private MarkData ltY;
    private a ltZ;
    private a.InterfaceC0574a lua;

    public void a(a.InterfaceC0574a interfaceC0574a) {
        this.lua = interfaceC0574a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.ltX = false;
        this.ltY = null;
        this.ltZ = null;
        this.lua = null;
        this.ltY = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.ltX = false;
        this.ltY = null;
        this.ltZ = null;
        this.lua = null;
        this.ltY = new MarkData();
    }

    public boolean bnx() {
        return this.ltX;
    }

    public MarkData bnA() {
        return this.ltY;
    }

    public void a(MarkData markData) {
        this.ltY = markData;
    }

    public void jc(boolean z) {
        this.ltX = z;
    }

    public String bnw() {
        if (this.ltY != null) {
            return this.ltY.getPostId();
        }
        return null;
    }

    public void bnz() {
        if (this.ltZ != null) {
            this.ltZ.cancel();
        }
        this.ltZ = new a(true);
        this.ltZ.setPriority(3);
        this.ltZ.execute(new Boolean[0]);
    }

    public void bny() {
        if (this.ltZ != null) {
            this.ltZ.cancel();
        }
        this.ltZ = new a(false);
        this.ltZ.setPriority(3);
        this.ltZ.execute(new Boolean[0]);
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private z cmJ = null;
        private boolean iBf;
        private c ltT;

        public a(boolean z) {
            this.iBf = true;
            this.ltT = null;
            this.iBf = z;
            this.ltT = new c();
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
            if (this.iBf) {
                this.cmJ = new z(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.ltY);
                this.cmJ.addPostData("data", aVar.cX(0, 1));
            } else {
                this.cmJ = new z(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.cmJ.addPostData("user_id", MarkModel.this.ltY.getAccount());
                this.cmJ.addPostData("tid", MarkModel.this.ltY.getId());
                this.cmJ.addPostData("fid", MarkModel.this.ltY.getForumId());
            }
            this.ltT.parserJson(this.cmJ.postNetData());
            boolean z = this.ltT.getErrorCode() == 0;
            if (this.cmJ.bvQ().bwA().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cmJ != null) {
                this.cmJ.cancelNetConnect();
            }
            MarkModel.this.ltZ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.ltT != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.ltT.getErrorCode(), this.ltT.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.lua != null) {
                        MarkModel.this.lua.g(true, this.iBf, null);
                    }
                } else if (MarkModel.this.lua != null) {
                    if (this.cmJ == null || this.cmJ.bvQ().bwA().isRequestSuccess()) {
                        MarkModel.this.lua.g(false, this.iBf, this.ltT.getErrorString());
                    } else {
                        MarkModel.this.lua.g(false, this.iBf, this.cmJ.getErrorString());
                    }
                }
                MarkModel.this.ltZ = null;
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
        if (this.ltZ != null) {
            this.ltZ.cancel();
            return false;
        }
        return false;
    }
}
