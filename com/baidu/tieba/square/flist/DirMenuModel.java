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
    private boolean eDH;
    private a izo;
    private b izp;
    private String izq;
    private String izr;
    private String izs;
    private boolean izt;

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, int i, d dVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.eDH = false;
        this.izt = false;
        this.izq = str;
        this.izr = str2;
        this.izs = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.izo = new a();
        this.izo.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.izo != null) {
            this.izo.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.izp = bVar;
    }

    /* loaded from: classes5.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.c> {
        com.baidu.tieba.square.square.c izu;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.izu = new com.baidu.tieba.square.square.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (this.izu != null) {
                DirMenuModel.this.izp.a(true, this.izu.getErrorCode(), this.izu.cda(), this.izu.getErrorMsg(), DirMenuModel.this.izt);
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
                str = lw.get(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.izq + "_dir");
            }
            if (str != null) {
                this.izu.parserJson(str);
                DirMenuModel.this.izt = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/f/forum/seconddir");
                this.mNetwork.x("menu_name", DirMenuModel.this.izq);
                this.mNetwork.x(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.izr);
                this.mNetwork.x("menu_id", DirMenuModel.this.izs);
                acg = this.mNetwork.acg();
            } catch (Exception e) {
                this.izu.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (acg == null) {
                return this.izu;
            }
            if (this.mNetwork.acE().adD().isRequestSuccess()) {
                this.izu.parserJson(acg);
                DirMenuModel.this.eDH = true;
                if (lw != null) {
                    lw.a(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.izq + "_dir", acg, 86400000L);
                }
            } else {
                this.izu.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.eDH = false;
            }
            return this.izu;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.c cVar) {
            if (!DirMenuModel.this.eDH) {
                DirMenuModel.this.izp.a(false, -1, null, cVar.getErrorMsg(), DirMenuModel.this.izt);
            } else if (cVar.cda() != null) {
                DirMenuModel.this.izp.a(true, cVar.getErrorCode(), cVar.cda(), cVar.getErrorMsg(), DirMenuModel.this.izt);
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
