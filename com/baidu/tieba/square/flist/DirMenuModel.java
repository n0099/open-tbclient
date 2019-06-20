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
    private a iSh;
    private b iSi;
    private String iSj;
    private String iSk;
    private String iSl;
    private boolean iSm;

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, int i, d dVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.eTC = false;
        this.iSm = false;
        this.iSj = str;
        this.iSk = str2;
        this.iSl = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.iSh = new a();
        this.iSh.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iSh != null) {
            this.iSh.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.iSi = bVar;
    }

    /* loaded from: classes5.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.c> {
        com.baidu.tieba.square.square.c iSn;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.iSn = new com.baidu.tieba.square.square.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (this.iSn != null) {
                DirMenuModel.this.iSi.a(true, this.iSn.getErrorCode(), this.iSn.clh(), this.iSn.getErrorMsg(), DirMenuModel.this.iSm);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.square.square.c doInBackground(Object... objArr) {
            String ahe;
            String str = null;
            l<String> mA = com.baidu.tbadk.core.c.a.afD().mA("tb.my_posts");
            if (mA != null) {
                str = mA.get(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.iSj + "_dir");
            }
            if (str != null) {
                this.iSn.parserJson(str);
                DirMenuModel.this.iSm = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/f/forum/seconddir");
                this.mNetwork.o("menu_name", DirMenuModel.this.iSj);
                this.mNetwork.o(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.iSk);
                this.mNetwork.o("menu_id", DirMenuModel.this.iSl);
                ahe = this.mNetwork.ahe();
            } catch (Exception e) {
                this.iSn.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (ahe == null) {
                return this.iSn;
            }
            if (this.mNetwork.ahC().aiC().isRequestSuccess()) {
                this.iSn.parserJson(ahe);
                DirMenuModel.this.eTC = true;
                if (mA != null) {
                    mA.a(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.iSj + "_dir", ahe, 86400000L);
                }
            } else {
                this.iSn.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.eTC = false;
            }
            return this.iSn;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.c cVar) {
            if (!DirMenuModel.this.eTC) {
                DirMenuModel.this.iSi.a(false, -1, null, cVar.getErrorMsg(), DirMenuModel.this.iSm);
            } else if (cVar.clh() != null) {
                DirMenuModel.this.iSi.a(true, cVar.getErrorCode(), cVar.clh(), cVar.getErrorMsg(), DirMenuModel.this.iSm);
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
