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
/* loaded from: classes10.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    private boolean isOk;
    private a kac;
    private b kad;
    private String kae;
    private String kaf;
    private String kag;
    private boolean kah;

    /* loaded from: classes10.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.kah = false;
        this.kae = str;
        this.kaf = str2;
        this.kag = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.kac = new a();
        this.kac.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kac != null) {
            this.kac.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.kad = bVar;
    }

    /* loaded from: classes10.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        com.baidu.tieba.square.square.d kai;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.kai = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.kai != null) {
                DirMenuModel.this.kad.a(true, this.kai.getErrorCode(), this.kai.cJK(), this.kai.getErrorMsg(), DirMenuModel.this.kah);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> sQ = com.baidu.tbadk.core.c.a.aEB().sQ("tb.my_posts");
            if (sQ != null) {
                str = sQ.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.kae + "_dir");
            }
            if (str != null) {
                this.kai.parserJson(str);
                DirMenuModel.this.kah = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.kae);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.kaf);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.kag);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.kai.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.kai;
            }
            if (this.mNetwork.aGg().aGI().isRequestSuccess()) {
                this.kai.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (sQ != null) {
                    sQ.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.kae + "_dir", postNetData, 86400000L);
                }
            } else {
                this.kai.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.kai;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.kad.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.kah);
            } else if (dVar.cJK() != null) {
                DirMenuModel.this.kad.a(true, dVar.getErrorCode(), dVar.cJK(), dVar.getErrorMsg(), DirMenuModel.this.kah);
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
