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
    private boolean eDV;
    private a izD;
    private b izE;
    private String izF;
    private String izG;
    private String izH;
    private boolean izI;

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, int i, d dVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.eDV = false;
        this.izI = false;
        this.izF = str;
        this.izG = str2;
        this.izH = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.izD = new a();
        this.izD.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.izD != null) {
            this.izD.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.izE = bVar;
    }

    /* loaded from: classes5.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.c> {
        com.baidu.tieba.square.square.c izJ;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.izJ = new com.baidu.tieba.square.square.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (this.izJ != null) {
                DirMenuModel.this.izE.a(true, this.izJ.getErrorCode(), this.izJ.cde(), this.izJ.getErrorMsg(), DirMenuModel.this.izI);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.square.square.c doInBackground(Object... objArr) {
            String acj;
            String str = null;
            l<String> lv = com.baidu.tbadk.core.c.a.aaW().lv("tb.my_posts");
            if (lv != null) {
                str = lv.get(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.izF + "_dir");
            }
            if (str != null) {
                this.izJ.parserJson(str);
                DirMenuModel.this.izI = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/f/forum/seconddir");
                this.mNetwork.x("menu_name", DirMenuModel.this.izF);
                this.mNetwork.x(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.izG);
                this.mNetwork.x("menu_id", DirMenuModel.this.izH);
                acj = this.mNetwork.acj();
            } catch (Exception e) {
                this.izJ.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (acj == null) {
                return this.izJ;
            }
            if (this.mNetwork.acH().adG().isRequestSuccess()) {
                this.izJ.parserJson(acj);
                DirMenuModel.this.eDV = true;
                if (lv != null) {
                    lv.a(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.izF + "_dir", acj, 86400000L);
                }
            } else {
                this.izJ.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.eDV = false;
            }
            return this.izJ;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.c cVar) {
            if (!DirMenuModel.this.eDV) {
                DirMenuModel.this.izE.a(false, -1, null, cVar.getErrorMsg(), DirMenuModel.this.izI);
            } else if (cVar.cde() != null) {
                DirMenuModel.this.izE.a(true, cVar.getErrorCode(), cVar.cde(), cVar.getErrorMsg(), DirMenuModel.this.izI);
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
