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
/* loaded from: classes22.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    private boolean isOk;
    private a mhX;
    private b mhY;
    private String mhZ;
    private String mia;
    private String mib;
    private boolean mic;

    /* loaded from: classes22.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.mic = false;
        this.mhZ = str;
        this.mia = str2;
        this.mib = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.mhX = new a();
        this.mhX.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mhX != null) {
            this.mhX.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.mhY = bVar;
    }

    /* loaded from: classes22.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        private aa mNetwork;
        com.baidu.tieba.square.square.d mie;

        private a() {
            this.mNetwork = null;
            this.mie = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.mie != null) {
                DirMenuModel.this.mhY.a(true, this.mie.getErrorCode(), this.mie.dzm(), this.mie.getErrorMsg(), DirMenuModel.this.mic);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> zT = com.baidu.tbadk.core.c.a.bhV().zT("tb.my_posts");
            if (zT != null) {
                str = zT.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.mhZ + "_dir");
            }
            if (str != null) {
                this.mie.parserJson(str);
                DirMenuModel.this.mic = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.mhZ);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.mia);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.mib);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.mie.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.mie;
            }
            if (this.mNetwork.bjL().bkr().isRequestSuccess()) {
                this.mie.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (zT != null) {
                    zT.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.mhZ + "_dir", postNetData, 86400000L);
                }
            } else {
                this.mie.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.mie;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.mhY.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.mic);
            } else if (dVar.dzm() != null) {
                DirMenuModel.this.mhY.a(true, dVar.getErrorCode(), dVar.dzm(), dVar.getErrorMsg(), DirMenuModel.this.mic);
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
