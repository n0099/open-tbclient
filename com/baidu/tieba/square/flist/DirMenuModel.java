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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.square.square.e;
/* loaded from: classes23.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    private boolean isOk;
    private a mxA;
    private b mxB;
    private String mxC;
    private String mxD;
    private String mxE;
    private boolean mxF;

    /* loaded from: classes23.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.mxF = false;
        this.mxC = str;
        this.mxD = str2;
        this.mxE = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.mxA = new a();
        this.mxA.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mxA != null) {
            this.mxA.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.mxB = bVar;
    }

    /* loaded from: classes23.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        private aa mNetwork;
        com.baidu.tieba.square.square.d mxG;

        private a() {
            this.mNetwork = null;
            this.mxG = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.mxG != null) {
                DirMenuModel.this.mxB.a(true, this.mxG.getErrorCode(), this.mxG.dCX(), this.mxG.getErrorMsg(), DirMenuModel.this.mxF);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> AF = com.baidu.tbadk.core.c.a.bkE().AF("tb.my_posts");
            if (AF != null) {
                str = AF.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.mxC + "_dir");
            }
            if (str != null) {
                this.mxG.parserJson(str);
                DirMenuModel.this.mxF = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.mxC);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.mxD);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.mxE);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.mxG.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.mxG;
            }
            if (this.mNetwork.bmu().bnb().isRequestSuccess()) {
                this.mxG.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (AF != null) {
                    AF.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.mxC + "_dir", postNetData, 86400000L);
                }
            } else {
                this.mxG.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.mxG;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.mxB.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.mxF);
            } else if (dVar.dCX() != null) {
                DirMenuModel.this.mxB.a(true, dVar.getErrorCode(), dVar.dCX(), dVar.getErrorMsg(), DirMenuModel.this.mxF);
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
