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
    private boolean eTC;
    private a iSd;
    private b iSe;
    private String iSf;
    private String iSg;
    private String iSh;
    private boolean iSi;

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, int i, d dVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.eTC = false;
        this.iSi = false;
        this.iSf = str;
        this.iSg = str2;
        this.iSh = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.iSd = new a();
        this.iSd.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iSd != null) {
            this.iSd.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.iSe = bVar;
    }

    /* loaded from: classes5.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.c> {
        com.baidu.tieba.square.square.c iSj;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.iSj = new com.baidu.tieba.square.square.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (this.iSj != null) {
                DirMenuModel.this.iSe.a(true, this.iSj.getErrorCode(), this.iSj.clg(), this.iSj.getErrorMsg(), DirMenuModel.this.iSi);
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
                str = mB.get(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.iSf + "_dir");
            }
            if (str != null) {
                this.iSj.parserJson(str);
                DirMenuModel.this.iSi = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/f/forum/seconddir");
                this.mNetwork.o("menu_name", DirMenuModel.this.iSf);
                this.mNetwork.o(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.iSg);
                this.mNetwork.o("menu_id", DirMenuModel.this.iSh);
                ahe = this.mNetwork.ahe();
            } catch (Exception e) {
                this.iSj.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (ahe == null) {
                return this.iSj;
            }
            if (this.mNetwork.ahC().aiC().isRequestSuccess()) {
                this.iSj.parserJson(ahe);
                DirMenuModel.this.eTC = true;
                if (mB != null) {
                    mB.a(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.iSf + "_dir", ahe, 86400000L);
                }
            } else {
                this.iSj.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.eTC = false;
            }
            return this.iSj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.c cVar) {
            if (!DirMenuModel.this.eTC) {
                DirMenuModel.this.iSe.a(false, -1, null, cVar.getErrorMsg(), DirMenuModel.this.iSi);
            } else if (cVar.clg() != null) {
                DirMenuModel.this.iSe.a(true, cVar.getErrorCode(), cVar.clg(), cVar.getErrorMsg(), DirMenuModel.this.iSi);
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
