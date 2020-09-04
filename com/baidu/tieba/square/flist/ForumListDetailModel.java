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
    private TbPageContext<ForumListActivity> efr;
    private boolean isFirst;
    private boolean lYA;
    private ForumListModel.RequestParams lYV;
    private a lZt;
    private b lZu;

    /* loaded from: classes17.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.lYA = false;
        this.efr = tbPageContext;
        this.lYV = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.lYV = requestParams;
    }

    public void a(a aVar) {
        this.lZt = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.lZu = new b();
        this.lZu.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lZu == null) {
            return false;
        }
        this.lZu.cancel();
        return true;
    }

    /* loaded from: classes17.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel lZv;

        private b() {
            this.lZv = new ForumListModel(ForumListDetailModel.this.efr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.lZv != null) {
                ForumListDetailModel.this.lZt.a(true, this.lZv.getErrorCode(), this.lZv, this.lZv.getErrorString(), ForumListDetailModel.this.lYA);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> zy = com.baidu.tbadk.core.c.a.bhb().zy("tb.my_posts");
                    String str = zy != null ? zy.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.lYV.menu_name + "_list") : null;
                    if (str != null) {
                        this.lZv = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.lZv != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.lYA = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.lYV);
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
                ForumListDetailModel.this.lZt.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.lYA);
            } else {
                ForumListDetailModel.this.lZt.a(false, 0, forumListModel, ForumListDetailModel.this.efr.getString(R.string.neterror), ForumListDetailModel.this.lYA);
            }
        }
    }
}
