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
    private a nfh;
    private b nfi;
    private String nfj;
    private String nfk;
    private String nfl;
    private boolean nfm;

    /* loaded from: classes23.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.nfm = false;
        this.nfj = str;
        this.nfk = str2;
        this.nfl = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.nfh = new a();
        this.nfh.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nfh != null) {
            this.nfh.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.nfi = bVar;
    }

    /* loaded from: classes23.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        private aa mNetwork;
        com.baidu.tieba.square.square.d nfn;

        private a() {
            this.mNetwork = null;
            this.nfn = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.nfn != null) {
                DirMenuModel.this.nfi.a(true, this.nfn.getErrorCode(), this.nfn.dNP(), this.nfn.getErrorMsg(), DirMenuModel.this.nfm);
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
                str = Bo.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.nfj + "_dir");
            }
            if (str != null) {
                this.nfn.parserJson(str);
                DirMenuModel.this.nfm = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.nfj);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.nfk);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.nfl);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.nfn.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.nfn;
            }
            if (this.mNetwork.btv().buf().isRequestSuccess()) {
                this.nfn.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (Bo != null) {
                    Bo.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.nfj + "_dir", postNetData, 86400000L);
                }
            } else {
                this.nfn.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.nfn;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.nfi.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.nfm);
            } else if (dVar.dNP() != null) {
                DirMenuModel.this.nfi.a(true, dVar.getErrorCode(), dVar.dNP(), dVar.getErrorMsg(), DirMenuModel.this.nfm);
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
