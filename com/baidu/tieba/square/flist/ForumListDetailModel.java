package com.baidu.tieba.square.flist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.square.flist.ForumListModel;
/* loaded from: classes10.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {
    private TbPageContext<ForumListActivity> dPv;
    private boolean isFirst;
    private a lAh;
    private b lAi;
    private ForumListModel.RequestParams lzJ;
    private boolean lzn;

    /* loaded from: classes10.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.lzn = false;
        this.dPv = tbPageContext;
        this.lzJ = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.lzJ = requestParams;
    }

    public void a(a aVar) {
        this.lAh = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.lAi = new b();
        this.lAi.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lAi == null) {
            return false;
        }
        this.lAi.cancel();
        return true;
    }

    /* loaded from: classes10.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel lAj;

        private b() {
            this.lAj = new ForumListModel(ForumListDetailModel.this.dPv);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.lAj != null) {
                ForumListDetailModel.this.lAh.a(true, this.lAj.getErrorCode(), this.lAj, this.lAj.getErrorString(), ForumListDetailModel.this.lzn);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> wc = com.baidu.tbadk.core.c.a.aUM().wc("tb.my_posts");
                    String str = wc != null ? wc.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.lzJ.menu_name + "_list") : null;
                    if (str != null) {
                        this.lAj = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.lAj != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.lzn = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.lzJ);
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ForumListModel forumListModel) {
            if (forumListModel != null && forumListModel.isOk()) {
                ForumListDetailModel.this.lAh.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.lzn);
            } else {
                ForumListDetailModel.this.lAh.a(false, 0, forumListModel, ForumListDetailModel.this.dPv.getString(R.string.neterror), ForumListDetailModel.this.lzn);
            }
        }
    }
}
