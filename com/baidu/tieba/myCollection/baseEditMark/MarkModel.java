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
/* loaded from: classes23.dex */
public class MarkModel extends BdBaseModel {
    private boolean lbg;
    private MarkData lbh;
    private a lbi;
    private a.InterfaceC0571a lbj;

    public void a(a.InterfaceC0571a interfaceC0571a) {
        this.lbj = interfaceC0571a;
    }

    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.lbg = false;
        this.lbh = null;
        this.lbi = null;
        this.lbj = null;
        this.lbh = new MarkData();
    }

    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.lbg = false;
        this.lbh = null;
        this.lbi = null;
        this.lbj = null;
        this.lbh = new MarkData();
    }

    public boolean bhP() {
        return this.lbg;
    }

    public MarkData bhS() {
        return this.lbh;
    }

    public void a(MarkData markData) {
        this.lbh = markData;
    }

    public void is(boolean z) {
        this.lbg = z;
    }

    public String bhO() {
        if (this.lbh != null) {
            return this.lbh.getPostId();
        }
        return null;
    }

    public void bhR() {
        if (this.lbi != null) {
            this.lbi.cancel();
        }
        this.lbi = new a(true);
        this.lbi.setPriority(3);
        this.lbi.execute(new Boolean[0]);
    }

    public void bhQ() {
        if (this.lbi != null) {
            this.lbi.cancel();
        }
        this.lbi = new a(false);
        this.lbi.setPriority(3);
        this.lbi.execute(new Boolean[0]);
    }

    /* loaded from: classes23.dex */
    private class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa bZh = null;
        private boolean idP;
        private c lbc;

        public a(boolean z) {
            this.idP = true;
            this.lbc = null;
            this.idP = z;
            this.lbc = new c();
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
            if (this.idP) {
                this.bZh = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                com.baidu.tieba.myCollection.baseEditMark.a aVar = new com.baidu.tieba.myCollection.baseEditMark.a();
                aVar.f(MarkModel.this.lbh);
                this.bZh.addPostData("data", aVar.cW(0, 1));
            } else {
                this.bZh = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.bZh.addPostData("user_id", MarkModel.this.lbh.getAccount());
                this.bZh.addPostData("tid", MarkModel.this.lbh.getId());
                this.bZh.addPostData("fid", MarkModel.this.lbh.getForumId());
            }
            this.lbc.parserJson(this.bZh.postNetData());
            boolean z = this.lbc.getErrorCode() == 0;
            if (this.bZh.bqa().bqI().isRequestSuccess() && z) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bZh != null) {
                this.bZh.cancelNetConnect();
            }
            MarkModel.this.lbi = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            try {
                if (this.lbc != null) {
                    com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "add_collection_thread", this.lbc.getErrorCode(), this.lbc.getErrorString(), new Object[0]);
                }
                if (bool.booleanValue()) {
                    if (MarkModel.this.lbj != null) {
                        MarkModel.this.lbj.d(true, this.idP, null);
                    }
                } else if (MarkModel.this.lbj != null) {
                    if (this.bZh == null || this.bZh.bqa().bqI().isRequestSuccess()) {
                        MarkModel.this.lbj.d(false, this.idP, this.lbc.getErrorString());
                    } else {
                        MarkModel.this.lbj.d(false, this.idP, this.bZh.getErrorString());
                    }
                }
                MarkModel.this.lbi = null;
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
        if (this.lbi != null) {
            this.lbi.cancel();
            return false;
        }
        return false;
    }
}
