package com.baidu.tieba.square.flist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.square.square.e;
/* loaded from: classes7.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    private boolean isOk;
    private a ngh;
    private b ngi;
    private String ngj;
    private String ngk;
    private String ngl;
    private boolean ngm;

    /* loaded from: classes7.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.ngm = false;
        this.ngj = str;
        this.ngk = str2;
        this.ngl = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.ngh = new a();
        this.ngh.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.ngh != null) {
            this.ngh.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.ngi = bVar;
    }

    /* loaded from: classes7.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        private z mNetwork;
        com.baidu.tieba.square.square.d ngn;

        private a() {
            this.mNetwork = null;
            this.ngn = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.ngn != null) {
                DirMenuModel.this.ngi.a(true, this.ngn.getErrorCode(), this.ngn.dJQ(), this.ngn.getErrorMsg(), DirMenuModel.this.ngm);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> Ab = com.baidu.tbadk.core.c.a.bpZ().Ab("tb.my_posts");
            if (Ab != null) {
                str = Ab.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.ngj + "_dir");
            }
            if (str != null) {
                this.ngn.parserJson(str);
                DirMenuModel.this.ngm = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new z(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.ngj);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.ngk);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.ngl);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.ngn.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.ngn;
            }
            if (this.mNetwork.brX().bsH().isRequestSuccess()) {
                this.ngn.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (Ab != null) {
                    Ab.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.ngj + "_dir", postNetData, 86400000L);
                }
            } else {
                this.ngn.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.ngn;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.ngi.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.ngm);
            } else if (dVar.dJQ() != null) {
                DirMenuModel.this.ngi.a(true, dVar.getErrorCode(), dVar.dJQ(), dVar.getErrorMsg(), DirMenuModel.this.ngm);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
        }
    }
}
