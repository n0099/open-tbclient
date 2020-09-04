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
    private boolean lYA;
    private a lYv;
    private b lYw;
    private String lYx;
    private String lYy;
    private String lYz;

    /* loaded from: classes17.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.lYA = false;
        this.lYx = str;
        this.lYy = str2;
        this.lYz = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.lYv = new a();
        this.lYv.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lYv != null) {
            this.lYv.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.lYw = bVar;
    }

    /* loaded from: classes17.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        com.baidu.tieba.square.square.d lYB;
        private aa mNetwork;

        private a() {
            this.mNetwork = null;
            this.lYB = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.lYB != null) {
                DirMenuModel.this.lYw.a(true, this.lYB.getErrorCode(), this.lYB.dvt(), this.lYB.getErrorMsg(), DirMenuModel.this.lYA);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> zy = com.baidu.tbadk.core.c.a.bhb().zy("tb.my_posts");
            if (zy != null) {
                str = zy.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.lYx + "_dir");
            }
            if (str != null) {
                this.lYB.parserJson(str);
                DirMenuModel.this.lYA = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.lYx);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.lYy);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.lYz);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.lYB.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.lYB;
            }
            if (this.mNetwork.biQ().bjw().isRequestSuccess()) {
                this.lYB.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (zy != null) {
                    zy.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.lYx + "_dir", postNetData, 86400000L);
                }
            } else {
                this.lYB.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.lYB;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.lYw.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.lYA);
            } else if (dVar.dvt() != null) {
                DirMenuModel.this.lYw.a(true, dVar.getErrorCode(), dVar.dvt(), dVar.getErrorMsg(), DirMenuModel.this.lYA);
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
