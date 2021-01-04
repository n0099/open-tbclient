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
    private a nkN;
    private b nkO;
    private String nkP;
    private String nkQ;
    private String nkR;
    private boolean nkS;

    /* loaded from: classes8.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.nkS = false;
        this.nkP = str;
        this.nkQ = str2;
        this.nkR = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.nkN = new a();
        this.nkN.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nkN != null) {
            this.nkN.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.nkO = bVar;
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        private z mNetwork;
        com.baidu.tieba.square.square.d nkT;

        private a() {
            this.mNetwork = null;
            this.nkT = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.nkT != null) {
                DirMenuModel.this.nkO.a(true, this.nkT.getErrorCode(), this.nkT.dNH(), this.nkT.getErrorMsg(), DirMenuModel.this.nkS);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> Bn = com.baidu.tbadk.core.c.a.btS().Bn("tb.my_posts");
            if (Bn != null) {
                str = Bn.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.nkP + "_dir");
            }
            if (str != null) {
                this.nkT.parserJson(str);
                DirMenuModel.this.nkS = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new z(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.nkP);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.nkQ);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.nkR);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.nkT.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.nkT;
            }
            if (this.mNetwork.bvQ().bwA().isRequestSuccess()) {
                this.nkT.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (Bn != null) {
                    Bn.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.nkP + "_dir", postNetData, 86400000L);
                }
            } else {
                this.nkT.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.nkT;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.nkO.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.nkS);
            } else if (dVar.dNH() != null) {
                DirMenuModel.this.nkO.a(true, dVar.getErrorCode(), dVar.dNH(), dVar.getErrorMsg(), DirMenuModel.this.nkS);
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
