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
/* loaded from: classes17.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {
    private TbPageContext<ForumListActivity> efn;
    private boolean isFirst;
    private ForumListModel.RequestParams lYG;
    private boolean lYl;
    private a lZe;
    private b lZf;

    /* loaded from: classes17.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.lYl = false;
        this.efn = tbPageContext;
        this.lYG = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.lYG = requestParams;
    }

    public void a(a aVar) {
        this.lZe = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.lZf = new b();
        this.lZf.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lZf == null) {
            return false;
        }
        this.lZf.cancel();
        return true;
    }

    /* loaded from: classes17.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel lZg;

        private b() {
            this.lZg = new ForumListModel(ForumListDetailModel.this.efn);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.lZg != null) {
                ForumListDetailModel.this.lZe.a(true, this.lZg.getErrorCode(), this.lZg, this.lZg.getErrorString(), ForumListDetailModel.this.lYl);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> zx = com.baidu.tbadk.core.c.a.bhb().zx("tb.my_posts");
                    String str = zx != null ? zx.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.lYG.menu_name + "_list") : null;
                    if (str != null) {
                        this.lZg = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.lZg != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.lYl = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.lYG);
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
                ForumListDetailModel.this.lZe.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.lYl);
            } else {
                ForumListDetailModel.this.lZe.a(false, 0, forumListModel, ForumListDetailModel.this.efn.getString(R.string.neterror), ForumListDetailModel.this.lYl);
            }
        }
    }
}
