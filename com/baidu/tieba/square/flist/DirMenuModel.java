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
    private boolean fax;
    private a jbX;
    private b jbY;
    private String jbZ;
    private String jca;
    private String jcb;
    private boolean jcc;

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, int i, d dVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.fax = false;
        this.jcc = false;
        this.jbZ = str;
        this.jca = str2;
        this.jcb = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.jbX = new a();
        this.jbX.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jbX != null) {
            this.jbX.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.jbY = bVar;
    }

    /* loaded from: classes5.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.c> {
        com.baidu.tieba.square.square.c jcd;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.jcd = new com.baidu.tieba.square.square.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (this.jcd != null) {
                DirMenuModel.this.jbY.a(true, this.jcd.getErrorCode(), this.jcd.cpe(), this.jcd.getErrorMsg(), DirMenuModel.this.jcc);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.square.square.c doInBackground(Object... objArr) {
            String aim;
            String str = null;
            l<String> mN = com.baidu.tbadk.core.d.a.agL().mN("tb.my_posts");
            if (mN != null) {
                str = mN.get(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.jbZ + "_dir");
            }
            if (str != null) {
                this.jcd.parserJson(str);
                DirMenuModel.this.jcc = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/f/forum/seconddir");
                this.mNetwork.o("menu_name", DirMenuModel.this.jbZ);
                this.mNetwork.o(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.jca);
                this.mNetwork.o("menu_id", DirMenuModel.this.jcb);
                aim = this.mNetwork.aim();
            } catch (Exception e) {
                this.jcd.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (aim == null) {
                return this.jcd;
            }
            if (this.mNetwork.aiK().ajN().isRequestSuccess()) {
                this.jcd.parserJson(aim);
                DirMenuModel.this.fax = true;
                if (mN != null) {
                    mN.a(TbadkCoreApplication.getCurrentAccount() + "_" + DirMenuModel.this.jbZ + "_dir", aim, 86400000L);
                }
            } else {
                this.jcd.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.fax = false;
            }
            return this.jcd;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.c cVar) {
            if (!DirMenuModel.this.fax) {
                DirMenuModel.this.jbY.a(false, -1, null, cVar.getErrorMsg(), DirMenuModel.this.jcc);
            } else if (cVar.cpe() != null) {
                DirMenuModel.this.jbY.a(true, cVar.getErrorCode(), cVar.cpe(), cVar.getErrorMsg(), DirMenuModel.this.jcc);
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
