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
/* loaded from: classes17.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    private boolean isOk;
    private a lYg;
    private b lYh;
    private String lYi;
    private String lYj;
    private String lYk;
    private boolean lYl;

    /* loaded from: classes17.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.lYl = false;
        this.lYi = str;
        this.lYj = str2;
        this.lYk = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.lYg = new a();
        this.lYg.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lYg != null) {
            this.lYg.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.lYh = bVar;
    }

    /* loaded from: classes17.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        com.baidu.tieba.square.square.d lYm;
        private aa mNetwork;

        private a() {
            this.mNetwork = null;
            this.lYm = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.lYm != null) {
                DirMenuModel.this.lYh.a(true, this.lYm.getErrorCode(), this.lYm.dvo(), this.lYm.getErrorMsg(), DirMenuModel.this.lYl);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> zx = com.baidu.tbadk.core.c.a.bhb().zx("tb.my_posts");
            if (zx != null) {
                str = zx.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.lYi + "_dir");
            }
            if (str != null) {
                this.lYm.parserJson(str);
                DirMenuModel.this.lYl = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.lYi);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.lYj);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.lYk);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.lYm.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.lYm;
            }
            if (this.mNetwork.biQ().bjw().isRequestSuccess()) {
                this.lYm.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (zx != null) {
                    zx.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.lYi + "_dir", postNetData, 86400000L);
                }
            } else {
                this.lYm.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.lYm;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.lYh.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.lYl);
            } else if (dVar.dvo() != null) {
                DirMenuModel.this.lYh.a(true, dVar.getErrorCode(), dVar.dvo(), dVar.getErrorMsg(), DirMenuModel.this.lYl);
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
