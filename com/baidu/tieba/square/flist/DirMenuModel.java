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
/* loaded from: classes8.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    private boolean isOk;
    private a nqq;
    private b nqr;
    private String nqs;
    private String nqt;
    private String nqu;
    private boolean nqv;

    /* loaded from: classes8.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.nqv = false;
        this.nqs = str;
        this.nqt = str2;
        this.nqu = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.nqq = new a();
        this.nqq.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nqq != null) {
            this.nqq.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.nqr = bVar;
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        private aa mNetwork;
        com.baidu.tieba.square.square.d nqw;

        private a() {
            this.mNetwork = null;
            this.nqw = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.nqw != null) {
                DirMenuModel.this.nqr.a(true, this.nqw.getErrorCode(), this.nqw.dMj(), this.nqw.getErrorMsg(), DirMenuModel.this.nqv);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> As = com.baidu.tbadk.core.c.a.bqr().As("tb.my_posts");
            if (As != null) {
                str = As.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.nqs + "_dir");
            }
            if (str != null) {
                this.nqw.parserJson(str);
                DirMenuModel.this.nqv = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.nqs);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.nqt);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.nqu);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.nqw.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.nqw;
            }
            if (this.mNetwork.bsr().btb().isRequestSuccess()) {
                this.nqw.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (As != null) {
                    As.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.nqs + "_dir", postNetData, 86400000L);
                }
            } else {
                this.nqw.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.nqw;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.nqr.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.nqv);
            } else if (dVar.dMj() != null) {
                DirMenuModel.this.nqr.a(true, dVar.getErrorCode(), dVar.dMj(), dVar.getErrorMsg(), DirMenuModel.this.nqv);
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
