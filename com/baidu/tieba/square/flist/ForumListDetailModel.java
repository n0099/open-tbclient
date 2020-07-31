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
    private TbPageContext<ForumListActivity> dVN;
    private boolean isFirst;
    private boolean lGD;
    private ForumListModel.RequestParams lGY;
    private a lHw;
    private b lHx;

    /* loaded from: classes17.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.lGD = false;
        this.dVN = tbPageContext;
        this.lGY = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.lGY = requestParams;
    }

    public void a(a aVar) {
        this.lHw = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.lHx = new b();
        this.lHx.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lHx == null) {
            return false;
        }
        this.lHx.cancel();
        return true;
    }

    /* loaded from: classes17.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel lHy;

        private b() {
            this.lHy = new ForumListModel(ForumListDetailModel.this.dVN);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.lHy != null) {
                ForumListDetailModel.this.lHw.a(true, this.lHy.getErrorCode(), this.lHy, this.lHy.getErrorString(), ForumListDetailModel.this.lGD);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> xj = com.baidu.tbadk.core.c.a.aYG().xj("tb.my_posts");
                    String str = xj != null ? xj.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.lGY.menu_name + "_list") : null;
                    if (str != null) {
                        this.lHy = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.lHy != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.lGD = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.lGY);
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
                ForumListDetailModel.this.lHw.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.lGD);
            } else {
                ForumListDetailModel.this.lHw.a(false, 0, forumListModel, ForumListDetailModel.this.dVN.getString(R.string.neterror), ForumListDetailModel.this.lGD);
            }
        }
    }
}
