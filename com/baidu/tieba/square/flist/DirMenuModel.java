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
    private a kbR;
    private b kbS;
    private String kbT;
    private String kbU;
    private String kbV;
    private boolean kbW;

    /* loaded from: classes10.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.kbW = false;
        this.kbT = str;
        this.kbU = str2;
        this.kbV = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.kbR = new a();
        this.kbR.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kbR != null) {
            this.kbR.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.kbS = bVar;
    }

    /* loaded from: classes10.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        com.baidu.tieba.square.square.d kbX;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.kbX = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.kbX != null) {
                DirMenuModel.this.kbS.a(true, this.kbX.getErrorCode(), this.kbX.cKf(), this.kbX.getErrorMsg(), DirMenuModel.this.kbW);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> sQ = com.baidu.tbadk.core.c.a.aEF().sQ("tb.my_posts");
            if (sQ != null) {
                str = sQ.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.kbT + "_dir");
            }
            if (str != null) {
                this.kbX.parserJson(str);
                DirMenuModel.this.kbW = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.kbT);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.kbU);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.kbV);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.kbX.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.kbX;
            }
            if (this.mNetwork.aGk().aGM().isRequestSuccess()) {
                this.kbX.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (sQ != null) {
                    sQ.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.kbT + "_dir", postNetData, 86400000L);
                }
            } else {
                this.kbX.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.kbX;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.kbS.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.kbW);
            } else if (dVar.cKf() != null) {
                DirMenuModel.this.kbS.a(true, dVar.getErrorCode(), dVar.cKf(), dVar.getErrorMsg(), DirMenuModel.this.kbW);
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
