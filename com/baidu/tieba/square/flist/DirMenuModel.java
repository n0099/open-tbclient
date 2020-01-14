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
/* loaded from: classes8.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    private boolean isOk;
    private a jZb;
    private b jZc;
    private String jZd;
    private String jZe;
    private String jZf;
    private boolean jZg;

    /* loaded from: classes8.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.jZg = false;
        this.jZd = str;
        this.jZe = str2;
        this.jZf = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.jZb = new a();
        this.jZb.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jZb != null) {
            this.jZb.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.jZc = bVar;
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        com.baidu.tieba.square.square.d jZh;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.jZh = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.jZh != null) {
                DirMenuModel.this.jZc.a(true, this.jZh.getErrorCode(), this.jZh.cIe(), this.jZh.getErrorMsg(), DirMenuModel.this.jZg);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> sA = com.baidu.tbadk.core.c.a.aCo().sA("tb.my_posts");
            if (sA != null) {
                str = sA.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.jZd + "_dir");
            }
            if (str != null) {
                this.jZh.parserJson(str);
                DirMenuModel.this.jZg = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.jZd);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.jZe);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.jZf);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.jZh.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.jZh;
            }
            if (this.mNetwork.aDU().aEv().isRequestSuccess()) {
                this.jZh.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (sA != null) {
                    sA.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.jZd + "_dir", postNetData, 86400000L);
                }
            } else {
                this.jZh.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.jZh;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.jZc.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.jZg);
            } else if (dVar.cIe() != null) {
                DirMenuModel.this.jZc.a(true, dVar.getErrorCode(), dVar.cIe(), dVar.getErrorMsg(), DirMenuModel.this.jZg);
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
