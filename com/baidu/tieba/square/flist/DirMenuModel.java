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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.square.square.e;
/* loaded from: classes10.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    private boolean isOk;
    private a kLL;
    private b kLM;
    private String kLN;
    private String kLO;
    private String kLP;
    private boolean kLQ;

    /* loaded from: classes10.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.kLQ = false;
        this.kLN = str;
        this.kLO = str2;
        this.kLP = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.kLL = new a();
        this.kLL.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kLL != null) {
            this.kLL.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.kLM = bVar;
    }

    /* loaded from: classes10.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        com.baidu.tieba.square.square.d kLR;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.kLR = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.kLR != null) {
                DirMenuModel.this.kLM.a(true, this.kLR.getErrorCode(), this.kLR.cUY(), this.kLR.getErrorMsg(), DirMenuModel.this.kLQ);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> ug = com.baidu.tbadk.core.c.a.aMR().ug("tb.my_posts");
            if (ug != null) {
                str = ug.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.kLN + "_dir");
            }
            if (str != null) {
                this.kLR.parserJson(str);
                DirMenuModel.this.kLQ = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.kLN);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.kLO);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.kLP);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.kLR.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.kLR;
            }
            if (this.mNetwork.aOw().aOX().isRequestSuccess()) {
                this.kLR.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (ug != null) {
                    ug.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.kLN + "_dir", postNetData, 86400000L);
                }
            } else {
                this.kLR.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.kLR;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.kLM.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.kLQ);
            } else if (dVar.cUY() != null) {
                DirMenuModel.this.kLM.a(true, dVar.getErrorCode(), dVar.cUY(), dVar.getErrorMsg(), DirMenuModel.this.kLQ);
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
