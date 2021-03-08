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
/* loaded from: classes7.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    private boolean isOk;
    private a nsu;
    private b nsv;
    private String nsw;
    private String nsx;
    private String nsy;
    private boolean nsz;

    /* loaded from: classes7.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.nsz = false;
        this.nsw = str;
        this.nsx = str2;
        this.nsy = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.nsu = new a();
        this.nsu.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nsu != null) {
            this.nsu.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.nsv = bVar;
    }

    /* loaded from: classes7.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        private aa mNetwork;
        com.baidu.tieba.square.square.d nsA;

        private a() {
            this.mNetwork = null;
            this.nsA = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.nsA != null) {
                DirMenuModel.this.nsv.a(true, this.nsA.getErrorCode(), this.nsA.dMr(), this.nsA.getErrorMsg(), DirMenuModel.this.nsz);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> Az = com.baidu.tbadk.core.c.a.bqt().Az("tb.my_posts");
            if (Az != null) {
                str = Az.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.nsw + "_dir");
            }
            if (str != null) {
                this.nsA.parserJson(str);
                DirMenuModel.this.nsz = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.nsw);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.nsx);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.nsy);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.nsA.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.nsA;
            }
            if (this.mNetwork.bsu().bte().isRequestSuccess()) {
                this.nsA.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (Az != null) {
                    Az.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.nsw + "_dir", postNetData, 86400000L);
                }
            } else {
                this.nsA.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.nsA;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.nsv.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.nsz);
            } else if (dVar.dMr() != null) {
                DirMenuModel.this.nsv.a(true, dVar.getErrorCode(), dVar.dMr(), dVar.getErrorMsg(), DirMenuModel.this.nsz);
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
