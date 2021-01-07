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
/* loaded from: classes8.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    private boolean isOk;
    private a nkM;
    private b nkN;
    private String nkO;
    private String nkP;
    private String nkQ;
    private boolean nkR;

    /* loaded from: classes8.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.nkR = false;
        this.nkO = str;
        this.nkP = str2;
        this.nkQ = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.nkM = new a();
        this.nkM.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nkM != null) {
            this.nkM.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.nkN = bVar;
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        private z mNetwork;
        com.baidu.tieba.square.square.d nkS;

        private a() {
            this.mNetwork = null;
            this.nkS = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.nkS != null) {
                DirMenuModel.this.nkN.a(true, this.nkS.getErrorCode(), this.nkS.dNI(), this.nkS.getErrorMsg(), DirMenuModel.this.nkR);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> Bm = com.baidu.tbadk.core.c.a.btT().Bm("tb.my_posts");
            if (Bm != null) {
                str = Bm.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.nkO + "_dir");
            }
            if (str != null) {
                this.nkS.parserJson(str);
                DirMenuModel.this.nkR = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new z(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.nkO);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.nkP);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.nkQ);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.nkS.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.nkS;
            }
            if (this.mNetwork.bvR().bwB().isRequestSuccess()) {
                this.nkS.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (Bm != null) {
                    Bm.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.nkO + "_dir", postNetData, 86400000L);
                }
            } else {
                this.nkS.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.nkS;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.nkN.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.nkR);
            } else if (dVar.dNI() != null) {
                DirMenuModel.this.nkN.a(true, dVar.getErrorCode(), dVar.dNI(), dVar.getErrorMsg(), DirMenuModel.this.nkR);
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
