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
/* loaded from: classes5.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {
    private TbPageContext<ForumListActivity> cfl;
    private boolean isFirst;
    private boolean jbT;
    private a jcN;
    private b jcO;
    private ForumListModel.RequestParams jcp;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.jbT = false;
        this.cfl = tbPageContext;
        this.jcp = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.jcp = requestParams;
    }

    public void a(a aVar) {
        this.jcN = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.jcO = new b();
        this.jcO.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jcO == null) {
            return false;
        }
        this.jcO.cancel();
        return true;
    }

    /* loaded from: classes5.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel jcP;

        private b() {
            this.jcP = new ForumListModel(ForumListDetailModel.this.cfl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.jcP != null) {
                ForumListDetailModel.this.jcN.a(true, this.jcP.getErrorCode(), this.jcP, this.jcP.getErrorString(), ForumListDetailModel.this.jbT);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> nl = com.baidu.tbadk.core.d.a.akN().nl("tb.my_posts");
                    String str = nl != null ? nl.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.jcp.menu_name + "_list") : null;
                    if (str != null) {
                        this.jcP = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.jcP != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.jbT = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.jcp);
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
                ForumListDetailModel.this.jcN.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.jbT);
            } else {
                ForumListDetailModel.this.jcN.a(false, 0, forumListModel, ForumListDetailModel.this.cfl.getString(R.string.neterror), ForumListDetailModel.this.jbT);
            }
        }
    }
}
