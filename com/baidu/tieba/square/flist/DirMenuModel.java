package com.baidu.tieba.square.flist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.square.square.d;
/* loaded from: classes5.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    private boolean eDG;
    private a izn;
    private b izo;
    private String izp;
    private String izq;
    private String izr;
    private boolean izs;

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, int i, d dVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.eDG = false;
        this.izs = false;
        this.izp = str;
        this.izq = str2;
        this.izr = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.izn = new a();
        this.izn.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.izn != null) {
            this.izn.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.izo = bVar;
    }

    /* loaded from: classes5.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.c> {
        com.baidu.tieba.square.square.c izt;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.izt = new com.baidu.tieba.square.square.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (this.izt != null) {
                DirMenuModel.this.izo.a(true, this.izt.getErrorCode(), this.izt.cda(), this.izt.getErrorMsg(), DirMenuModel.this.izs);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.square.square.c doInBackground(Object... objArr) {
            String acg;
            String str = null;
            l<String> lw = com.baidu.tbadk.core.c.a.aaT().lw("tb.my_posts");
            if (lw != null) {
                str = lw.get(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.izp + "_dir");
            }
            if (str != null) {
                this.izt.parserJson(str);
                DirMenuModel.this.izs = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/f/forum/seconddir");
                this.mNetwork.x("menu_name", DirMenuModel.this.izp);
                this.mNetwork.x(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.izq);
                this.mNetwork.x("menu_id", DirMenuModel.this.izr);
                acg = this.mNetwork.acg();
            } catch (Exception e) {
                this.izt.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (acg == null) {
                return this.izt;
            }
            if (this.mNetwork.acE().adD().isRequestSuccess()) {
                this.izt.parserJson(acg);
                DirMenuModel.this.eDG = true;
                if (lw != null) {
                    lw.a(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.izp + "_dir", acg, 86400000L);
                }
            } else {
                this.izt.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.eDG = false;
            }
            return this.izt;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.c cVar) {
            if (!DirMenuModel.this.eDG) {
                DirMenuModel.this.izo.a(false, -1, null, cVar.getErrorMsg(), DirMenuModel.this.izs);
            } else if (cVar.cda() != null) {
                DirMenuModel.this.izo.a(true, cVar.getErrorCode(), cVar.cda(), cVar.getErrorMsg(), DirMenuModel.this.izs);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.ji();
                this.mNetwork = null;
            }
        }
    }
}
