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
/* loaded from: classes17.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    private boolean isOk;
    private a lGA;
    private b lGB;
    private String lGC;
    private String lGD;
    private String lGE;
    private boolean lGF;

    /* loaded from: classes17.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.lGF = false;
        this.lGC = str;
        this.lGD = str2;
        this.lGE = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.lGA = new a();
        this.lGA.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lGA != null) {
            this.lGA.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.lGB = bVar;
    }

    /* loaded from: classes17.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        com.baidu.tieba.square.square.d lGG;
        private z mNetwork;

        private a() {
            this.mNetwork = null;
            this.lGG = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.lGG != null) {
                DirMenuModel.this.lGB.a(true, this.lGG.getErrorCode(), this.lGG.djR(), this.lGG.getErrorMsg(), DirMenuModel.this.lGF);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> xj = com.baidu.tbadk.core.c.a.aYG().xj("tb.my_posts");
            if (xj != null) {
                str = xj.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.lGC + "_dir");
            }
            if (str != null) {
                this.lGG.parserJson(str);
                DirMenuModel.this.lGF = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new z(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.lGC);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.lGD);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.lGE);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.lGG.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.lGG;
            }
            if (this.mNetwork.bav().baX().isRequestSuccess()) {
                this.lGG.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (xj != null) {
                    xj.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.lGC + "_dir", postNetData, 86400000L);
                }
            } else {
                this.lGG.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.lGG;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.lGB.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.lGF);
            } else if (dVar.djR() != null) {
                DirMenuModel.this.lGB.a(true, dVar.getErrorCode(), dVar.djR(), dVar.getErrorMsg(), DirMenuModel.this.lGF);
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
