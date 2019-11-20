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
    private TbPageContext<ForumListActivity> ceu;
    private boolean isFirst;
    private a jbW;
    private b jbX;
    private boolean jbc;
    private ForumListModel.RequestParams jby;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.jbc = false;
        this.ceu = tbPageContext;
        this.jby = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.jby = requestParams;
    }

    public void a(a aVar) {
        this.jbW = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.jbX = new b();
        this.jbX.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jbX == null) {
            return false;
        }
        this.jbX.cancel();
        return true;
    }

    /* loaded from: classes5.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel jbY;

        private b() {
            this.jbY = new ForumListModel(ForumListDetailModel.this.ceu);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.jbY != null) {
                ForumListDetailModel.this.jbW.a(true, this.jbY.getErrorCode(), this.jbY, this.jbY.getErrorString(), ForumListDetailModel.this.jbc);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> nl = com.baidu.tbadk.core.d.a.akL().nl("tb.my_posts");
                    String str = nl != null ? nl.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.jby.menu_name + "_list") : null;
                    if (str != null) {
                        this.jbY = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.jbY != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.jbc = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.jby);
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
                ForumListDetailModel.this.jbW.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.jbc);
            } else {
                ForumListDetailModel.this.jbW.a(false, 0, forumListModel, ForumListDetailModel.this.ceu.getString(R.string.neterror), ForumListDetailModel.this.jbc);
            }
        }
    }
}
