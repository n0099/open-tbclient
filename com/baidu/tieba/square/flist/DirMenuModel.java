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
/* loaded from: classes7.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    private boolean isOk;
    private a jVu;
    private b jVv;
    private String jVw;
    private String jVx;
    private String jVy;
    private boolean jVz;

    /* loaded from: classes7.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.jVz = false;
        this.jVw = str;
        this.jVx = str2;
        this.jVy = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.jVu = new a();
        this.jVu.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jVu != null) {
            this.jVu.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.jVv = bVar;
    }

    /* loaded from: classes7.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        com.baidu.tieba.square.square.d jVA;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.jVA = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.jVA != null) {
                DirMenuModel.this.jVv.a(true, this.jVA.getErrorCode(), this.jVA.cGY(), this.jVA.getErrorMsg(), DirMenuModel.this.jVz);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> sx = com.baidu.tbadk.core.c.a.aBV().sx("tb.my_posts");
            if (sx != null) {
                str = sx.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.jVw + "_dir");
            }
            if (str != null) {
                this.jVA.parserJson(str);
                DirMenuModel.this.jVz = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.jVw);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.jVx);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.jVy);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.jVA.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.jVA;
            }
            if (this.mNetwork.aDB().aEc().isRequestSuccess()) {
                this.jVA.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (sx != null) {
                    sx.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.jVw + "_dir", postNetData, 86400000L);
                }
            } else {
                this.jVA.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.jVA;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.jVv.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.jVz);
            } else if (dVar.cGY() != null) {
                DirMenuModel.this.jVv.a(true, dVar.getErrorCode(), dVar.cGY(), dVar.getErrorMsg(), DirMenuModel.this.jVz);
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
