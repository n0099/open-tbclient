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
    private boolean eTB;
    private a iSb;
    private b iSc;
    private String iSd;
    private String iSe;
    private String iSf;
    private boolean iSg;

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, int i, d dVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.eTB = false;
        this.iSg = false;
        this.iSd = str;
        this.iSe = str2;
        this.iSf = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.iSb = new a();
        this.iSb.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iSb != null) {
            this.iSb.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.iSc = bVar;
    }

    /* loaded from: classes5.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.c> {
        com.baidu.tieba.square.square.c iSh;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.iSh = new com.baidu.tieba.square.square.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (this.iSh != null) {
                DirMenuModel.this.iSc.a(true, this.iSh.getErrorCode(), this.iSh.cle(), this.iSh.getErrorMsg(), DirMenuModel.this.iSg);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.square.square.c doInBackground(Object... objArr) {
            String ahe;
            String str = null;
            l<String> mB = com.baidu.tbadk.core.c.a.afD().mB("tb.my_posts");
            if (mB != null) {
                str = mB.get(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.iSd + "_dir");
            }
            if (str != null) {
                this.iSh.parserJson(str);
                DirMenuModel.this.iSg = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/f/forum/seconddir");
                this.mNetwork.o("menu_name", DirMenuModel.this.iSd);
                this.mNetwork.o(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.iSe);
                this.mNetwork.o("menu_id", DirMenuModel.this.iSf);
                ahe = this.mNetwork.ahe();
            } catch (Exception e) {
                this.iSh.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (ahe == null) {
                return this.iSh;
            }
            if (this.mNetwork.ahC().aiC().isRequestSuccess()) {
                this.iSh.parserJson(ahe);
                DirMenuModel.this.eTB = true;
                if (mB != null) {
                    mB.a(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.iSd + "_dir", ahe, 86400000L);
                }
            } else {
                this.iSh.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.eTB = false;
            }
            return this.iSh;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.c cVar) {
            if (!DirMenuModel.this.eTB) {
                DirMenuModel.this.iSc.a(false, -1, null, cVar.getErrorMsg(), DirMenuModel.this.iSg);
            } else if (cVar.cle() != null) {
                DirMenuModel.this.iSc.a(true, cVar.getErrorCode(), cVar.cle(), cVar.getErrorMsg(), DirMenuModel.this.iSg);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.ia();
                this.mNetwork = null;
            }
        }
    }
}
