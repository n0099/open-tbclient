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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.square.square.e;
/* loaded from: classes10.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    private boolean isOk;
    private a lzi;
    private b lzj;
    private String lzk;
    private String lzl;
    private String lzm;
    private boolean lzn;

    /* loaded from: classes10.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.lzn = false;
        this.lzk = str;
        this.lzl = str2;
        this.lzm = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.lzi = new a();
        this.lzi.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lzi != null) {
            this.lzi.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.lzj = bVar;
    }

    /* loaded from: classes10.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        com.baidu.tieba.square.square.d lzo;
        private y mNetwork;

        private a() {
            this.mNetwork = null;
            this.lzo = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.lzo != null) {
                DirMenuModel.this.lzj.a(true, this.lzo.getErrorCode(), this.lzo.dgH(), this.lzo.getErrorMsg(), DirMenuModel.this.lzn);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> wc = com.baidu.tbadk.core.c.a.aUM().wc("tb.my_posts");
            if (wc != null) {
                str = wc.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.lzk + "_dir");
            }
            if (str != null) {
                this.lzo.parserJson(str);
                DirMenuModel.this.lzn = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.lzk);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.lzl);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.lzm);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.lzo.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.lzo;
            }
            if (this.mNetwork.aWu().aWW().isRequestSuccess()) {
                this.lzo.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (wc != null) {
                    wc.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.lzk + "_dir", postNetData, 86400000L);
                }
            } else {
                this.lzo.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.lzo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.lzj.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.lzn);
            } else if (dVar.dgH() != null) {
                DirMenuModel.this.lzj.a(true, dVar.getErrorCode(), dVar.dgH(), dVar.getErrorMsg(), DirMenuModel.this.lzn);
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
