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
    private a mKk;
    private b mKl;
    private String mKm;
    private String mKn;
    private String mKo;
    private boolean mKp;

    /* loaded from: classes23.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.mKp = false;
        this.mKm = str;
        this.mKn = str2;
        this.mKo = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.mKk = new a();
        this.mKk.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mKk != null) {
            this.mKk.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.mKl = bVar;
    }

    /* loaded from: classes23.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        com.baidu.tieba.square.square.d mKq;
        private aa mNetwork;

        private a() {
            this.mNetwork = null;
            this.mKq = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.mKq != null) {
                DirMenuModel.this.mKl.a(true, this.mKq.getErrorCode(), this.mKq.dGf(), this.mKq.getErrorMsg(), DirMenuModel.this.mKp);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> AY = com.baidu.tbadk.core.c.a.bmx().AY("tb.my_posts");
            if (AY != null) {
                str = AY.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.mKm + "_dir");
            }
            if (str != null) {
                this.mKq.parserJson(str);
                DirMenuModel.this.mKp = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.mKm);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.mKn);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.mKo);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.mKq.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.mKq;
            }
            if (this.mNetwork.bon().boU().isRequestSuccess()) {
                this.mKq.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (AY != null) {
                    AY.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.mKm + "_dir", postNetData, 86400000L);
                }
            } else {
                this.mKq.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.mKq;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.mKl.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.mKp);
            } else if (dVar.dGf() != null) {
                DirMenuModel.this.mKl.a(true, dVar.getErrorCode(), dVar.dGf(), dVar.getErrorMsg(), DirMenuModel.this.mKp);
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
