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
    private TbPageContext<ForumListActivity> cVi;
    private boolean isFirst;
    private ForumListModel.RequestParams kaQ;
    private boolean kat;
    private a kbo;
    private b kbp;

    /* loaded from: classes10.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.kat = false;
        this.cVi = tbPageContext;
        this.kaQ = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.kaQ = requestParams;
    }

    public void a(a aVar) {
        this.kbo = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.kbp = new b();
        this.kbp.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kbp == null) {
            return false;
        }
        this.kbp.cancel();
        return true;
    }

    /* loaded from: classes10.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel kbq;

        private b() {
            this.kbq = new ForumListModel(ForumListDetailModel.this.cVi);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.kbq != null) {
                ForumListDetailModel.this.kbo.a(true, this.kbq.getErrorCode(), this.kbq, this.kbq.getErrorString(), ForumListDetailModel.this.kat);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> sQ = com.baidu.tbadk.core.c.a.aEB().sQ("tb.my_posts");
                    String str = sQ != null ? sQ.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.kaQ.menu_name + "_list") : null;
                    if (str != null) {
                        this.kbq = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.kbq != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.kat = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.kaQ);
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
                ForumListDetailModel.this.kbo.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.kat);
            } else {
                ForumListDetailModel.this.kbo.a(false, 0, forumListModel, ForumListDetailModel.this.cVi.getString(R.string.neterror), ForumListDetailModel.this.kat);
            }
        }
    }
}
