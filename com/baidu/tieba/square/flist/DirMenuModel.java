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
    private boolean eYD;
    private String iYA;
    private String iYB;
    private String iYC;
    private boolean iYD;
    private a iYy;
    private b iYz;

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, int i, d dVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.eYD = false;
        this.iYD = false;
        this.iYA = str;
        this.iYB = str2;
        this.iYC = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.iYy = new a();
        this.iYy.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iYy != null) {
            this.iYy.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.iYz = bVar;
    }

    /* loaded from: classes5.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.c> {
        com.baidu.tieba.square.square.c iYE;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.iYE = new com.baidu.tieba.square.square.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (this.iYE != null) {
                DirMenuModel.this.iYz.a(true, this.iYE.getErrorCode(), this.iYE.cnZ(), this.iYE.getErrorMsg(), DirMenuModel.this.iYD);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.square.square.c doInBackground(Object... objArr) {
            String aig;
            String str = null;
            l<String> mL = com.baidu.tbadk.core.d.a.agF().mL("tb.my_posts");
            if (mL != null) {
                str = mL.get(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.iYA + "_dir");
            }
            if (str != null) {
                this.iYE.parserJson(str);
                DirMenuModel.this.iYD = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/f/forum/seconddir");
                this.mNetwork.o("menu_name", DirMenuModel.this.iYA);
                this.mNetwork.o(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.iYB);
                this.mNetwork.o("menu_id", DirMenuModel.this.iYC);
                aig = this.mNetwork.aig();
            } catch (Exception e) {
                this.iYE.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (aig == null) {
                return this.iYE;
            }
            if (this.mNetwork.aiE().ajF().isRequestSuccess()) {
                this.iYE.parserJson(aig);
                DirMenuModel.this.eYD = true;
                if (mL != null) {
                    mL.a(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.iYA + "_dir", aig, 86400000L);
                }
            } else {
                this.iYE.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.eYD = false;
            }
            return this.iYE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.c cVar) {
            if (!DirMenuModel.this.eYD) {
                DirMenuModel.this.iYz.a(false, -1, null, cVar.getErrorMsg(), DirMenuModel.this.iYD);
            } else if (cVar.cnZ() != null) {
                DirMenuModel.this.iYz.a(true, cVar.getErrorCode(), cVar.cnZ(), cVar.getErrorMsg(), DirMenuModel.this.iYD);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.ik();
                this.mNetwork = null;
            }
        }
    }
}
