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
/* loaded from: classes7.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {
    private TbPageContext<ForumListActivity> eSJ;
    private boolean isFirst;
    private ForumListModel.RequestParams ngH;
    private boolean ngm;
    private a nhf;
    private b nhg;

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.ngm = false;
        this.eSJ = tbPageContext;
        this.ngH = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.ngH = requestParams;
    }

    public void a(a aVar) {
        this.nhf = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.nhg = new b();
        this.nhg.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nhg == null) {
            return false;
        }
        this.nhg.cancel();
        return true;
    }

    /* loaded from: classes7.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel nhh;

        private b() {
            this.nhh = new ForumListModel(ForumListDetailModel.this.eSJ);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.nhh != null) {
                ForumListDetailModel.this.nhf.a(true, this.nhh.getErrorCode(), this.nhh, this.nhh.getErrorString(), ForumListDetailModel.this.ngm);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> Ab = com.baidu.tbadk.core.c.a.bpZ().Ab("tb.my_posts");
                    String str = Ab != null ? Ab.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.ngH.menu_name + "_list") : null;
                    if (str != null) {
                        this.nhh = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.nhh != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.ngm = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.ngH);
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
                ForumListDetailModel.this.nhf.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.ngm);
            } else {
                ForumListDetailModel.this.nhf.a(false, 0, forumListModel, ForumListDetailModel.this.eSJ.getString(R.string.neterror), ForumListDetailModel.this.ngm);
            }
        }
    }
}
