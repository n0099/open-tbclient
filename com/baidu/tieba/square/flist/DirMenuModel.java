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
    private a mRa;
    private b mRb;
    private String mRd;
    private String mRe;
    private String mRf;
    private boolean mRg;

    /* loaded from: classes22.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.mRg = false;
        this.mRd = str;
        this.mRe = str2;
        this.mRf = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.mRa = new a();
        this.mRa.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mRa != null) {
            this.mRa.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.mRb = bVar;
    }

    /* loaded from: classes22.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        private aa mNetwork;
        com.baidu.tieba.square.square.d mRh;

        private a() {
            this.mNetwork = null;
            this.mRh = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.mRh != null) {
                DirMenuModel.this.mRb.a(true, this.mRh.getErrorCode(), this.mRh.dIy(), this.mRh.getErrorMsg(), DirMenuModel.this.mRg);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> AH = com.baidu.tbadk.core.c.a.bob().AH("tb.my_posts");
            if (AH != null) {
                str = AH.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.mRd + "_dir");
            }
            if (str != null) {
                this.mRh.parserJson(str);
                DirMenuModel.this.mRg = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.mRd);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.mRe);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.mRf);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.mRh.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.mRh;
            }
            if (this.mNetwork.bqa().bqI().isRequestSuccess()) {
                this.mRh.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (AH != null) {
                    AH.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.mRd + "_dir", postNetData, 86400000L);
                }
            } else {
                this.mRh.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.mRh;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.mRb.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.mRg);
            } else if (dVar.dIy() != null) {
                DirMenuModel.this.mRb.a(true, dVar.getErrorCode(), dVar.dIy(), dVar.getErrorMsg(), DirMenuModel.this.mRg);
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
