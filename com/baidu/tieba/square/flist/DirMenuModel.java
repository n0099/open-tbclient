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
import com.baidu.tieba.square.square.d;
/* loaded from: classes5.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    private boolean fdi;
    private a jbO;
    private b jbP;
    private String jbQ;
    private String jbR;
    private String jbS;
    private boolean jbT;

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, int i, d dVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.fdi = false;
        this.jbT = false;
        this.jbQ = str;
        this.jbR = str2;
        this.jbS = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.jbO = new a();
        this.jbO.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jbO != null) {
            this.jbO.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.jbP = bVar;
    }

    /* loaded from: classes5.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.c> {
        com.baidu.tieba.square.square.c jbU;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.jbU = new com.baidu.tieba.square.square.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.jbU != null) {
                DirMenuModel.this.jbP.a(true, this.jbU.getErrorCode(), this.jbU.cmU(), this.jbU.getErrorMsg(), DirMenuModel.this.jbT);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public com.baidu.tieba.square.square.c doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> nl = com.baidu.tbadk.core.d.a.akN().nl("tb.my_posts");
            if (nl != null) {
                str = nl.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.jbQ + "_dir");
            }
            if (str != null) {
                this.jbU.parserJson(str);
                DirMenuModel.this.jbT = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.jbQ);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.jbR);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.jbS);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.jbU.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.jbU;
            }
            if (this.mNetwork.amr().amS().isRequestSuccess()) {
                this.jbU.parserJson(postNetData);
                DirMenuModel.this.fdi = true;
                if (nl != null) {
                    nl.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.jbQ + "_dir", postNetData, 86400000L);
                }
            } else {
                this.jbU.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.fdi = false;
            }
            return this.jbU;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.c cVar) {
            if (!DirMenuModel.this.fdi) {
                DirMenuModel.this.jbP.a(false, -1, null, cVar.getErrorMsg(), DirMenuModel.this.jbT);
            } else if (cVar.cmU() != null) {
                DirMenuModel.this.jbP.a(true, cVar.getErrorCode(), cVar.cmU(), cVar.getErrorMsg(), DirMenuModel.this.jbT);
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
