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
    private boolean eYR;
    private a iZC;
    private b iZD;
    private String iZE;
    private String iZF;
    private String iZG;
    private boolean iZH;

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, int i, d dVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.eYR = false;
        this.iZH = false;
        this.iZE = str;
        this.iZF = str2;
        this.iZG = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.iZC = new a();
        this.iZC.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iZC != null) {
            this.iZC.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.iZD = bVar;
    }

    /* loaded from: classes5.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.c> {
        com.baidu.tieba.square.square.c iZI;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.iZI = new com.baidu.tieba.square.square.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (this.iZI != null) {
                DirMenuModel.this.iZD.a(true, this.iZI.getErrorCode(), this.iZI.cor(), this.iZI.getErrorMsg(), DirMenuModel.this.iZH);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.square.square.c doInBackground(Object... objArr) {
            String aii;
            String str = null;
            l<String> mL = com.baidu.tbadk.core.d.a.agH().mL("tb.my_posts");
            if (mL != null) {
                str = mL.get(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.iZE + "_dir");
            }
            if (str != null) {
                this.iZI.parserJson(str);
                DirMenuModel.this.iZH = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/f/forum/seconddir");
                this.mNetwork.o("menu_name", DirMenuModel.this.iZE);
                this.mNetwork.o(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.iZF);
                this.mNetwork.o("menu_id", DirMenuModel.this.iZG);
                aii = this.mNetwork.aii();
            } catch (Exception e) {
                this.iZI.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (aii == null) {
                return this.iZI;
            }
            if (this.mNetwork.aiG().ajH().isRequestSuccess()) {
                this.iZI.parserJson(aii);
                DirMenuModel.this.eYR = true;
                if (mL != null) {
                    mL.a(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.iZE + "_dir", aii, 86400000L);
                }
            } else {
                this.iZI.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.eYR = false;
            }
            return this.iZI;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.c cVar) {
            if (!DirMenuModel.this.eYR) {
                DirMenuModel.this.iZD.a(false, -1, null, cVar.getErrorMsg(), DirMenuModel.this.iZH);
            } else if (cVar.cor() != null) {
                DirMenuModel.this.iZD.a(true, cVar.getErrorCode(), cVar.cor(), cVar.getErrorMsg(), DirMenuModel.this.iZH);
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
