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
/* loaded from: classes8.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {
    private TbPageContext<ForumListActivity> eUY;
    private boolean isFirst;
    private boolean npV;
    private a nqO;
    private b nqP;
    private ForumListModel.RequestParams nqq;

    /* loaded from: classes8.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.npV = false;
        this.eUY = tbPageContext;
        this.nqq = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.nqq = requestParams;
    }

    public void a(a aVar) {
        this.nqO = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.nqP = new b();
        this.nqP.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nqP == null) {
            return false;
        }
        this.nqP.cancel();
        return true;
    }

    /* loaded from: classes8.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel nqQ;

        private b() {
            this.nqQ = new ForumListModel(ForumListDetailModel.this.eUY);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.nqQ != null) {
                ForumListDetailModel.this.nqO.a(true, this.nqQ.getErrorCode(), this.nqQ, this.nqQ.getErrorString(), ForumListDetailModel.this.npV);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> As = com.baidu.tbadk.core.c.a.bqr().As("tb.my_posts");
                    String str = As != null ? As.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.nqq.menu_name + "_list") : null;
                    if (str != null) {
                        this.nqQ = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.nqQ != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.npV = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.nqq);
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
                ForumListDetailModel.this.nqO.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.npV);
            } else {
                ForumListDetailModel.this.nqO.a(false, 0, forumListModel, ForumListDetailModel.this.eUY.getString(R.string.neterror), ForumListDetailModel.this.npV);
            }
        }
    }
}
