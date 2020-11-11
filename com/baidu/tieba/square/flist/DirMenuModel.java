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
    private a mQh;
    private b mQi;
    private String mQj;
    private String mQk;
    private String mQl;
    private boolean mQm;

    /* loaded from: classes23.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.mQm = false;
        this.mQj = str;
        this.mQk = str2;
        this.mQl = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.mQh = new a();
        this.mQh.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mQh != null) {
            this.mQh.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.mQi = bVar;
    }

    /* loaded from: classes23.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        private aa mNetwork;
        com.baidu.tieba.square.square.d mQn;

        private a() {
            this.mNetwork = null;
            this.mQn = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.mQn != null) {
                DirMenuModel.this.mQi.a(true, this.mQn.getErrorCode(), this.mQn.dIH(), this.mQn.getErrorMsg(), DirMenuModel.this.mQm);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> Bm = com.baidu.tbadk.core.c.a.boX().Bm("tb.my_posts");
            if (Bm != null) {
                str = Bm.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.mQj + "_dir");
            }
            if (str != null) {
                this.mQn.parserJson(str);
                DirMenuModel.this.mQm = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.mQj);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.mQk);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.mQl);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.mQn.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.mQn;
            }
            if (this.mNetwork.bqN().bru().isRequestSuccess()) {
                this.mQn.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (Bm != null) {
                    Bm.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.mQj + "_dir", postNetData, 86400000L);
                }
            } else {
                this.mQn.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.mQn;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.mQi.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.mQm);
            } else if (dVar.dIH() != null) {
                DirMenuModel.this.mQi.a(true, dVar.getErrorCode(), dVar.dIH(), dVar.getErrorMsg(), DirMenuModel.this.mQm);
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
