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
    private a nff;
    private b nfg;
    private String nfh;
    private String nfi;
    private String nfj;
    private boolean nfk;

    /* loaded from: classes23.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.nfk = false;
        this.nfh = str;
        this.nfi = str2;
        this.nfj = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.nff = new a();
        this.nff.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nff != null) {
            this.nff.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.nfg = bVar;
    }

    /* loaded from: classes23.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        private aa mNetwork;
        com.baidu.tieba.square.square.d nfl;

        private a() {
            this.mNetwork = null;
            this.nfl = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.nfl != null) {
                DirMenuModel.this.nfg.a(true, this.nfl.getErrorCode(), this.nfl.dNO(), this.nfl.getErrorMsg(), DirMenuModel.this.nfk);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> Bo = com.baidu.tbadk.core.c.a.brq().Bo("tb.my_posts");
            if (Bo != null) {
                str = Bo.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.nfh + "_dir");
            }
            if (str != null) {
                this.nfl.parserJson(str);
                DirMenuModel.this.nfk = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.nfh);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.nfi);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.nfj);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.nfl.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.nfl;
            }
            if (this.mNetwork.btv().buf().isRequestSuccess()) {
                this.nfl.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (Bo != null) {
                    Bo.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.nfh + "_dir", postNetData, 86400000L);
                }
            } else {
                this.nfl.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.nfl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.nfg.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.nfk);
            } else if (dVar.dNO() != null) {
                DirMenuModel.this.nfg.a(true, dVar.getErrorCode(), dVar.dNO(), dVar.getErrorMsg(), DirMenuModel.this.nfk);
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
