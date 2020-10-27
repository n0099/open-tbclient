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
/* loaded from: classes23.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {
    private TbPageContext<ForumListActivity> eCn;
    private boolean isFirst;
    private ForumListModel.RequestParams mKK;
    private boolean mKp;
    private a mLi;
    private b mLj;

    /* loaded from: classes23.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.mKp = false;
        this.eCn = tbPageContext;
        this.mKK = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.mKK = requestParams;
    }

    public void a(a aVar) {
        this.mLi = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.mLj = new b();
        this.mLj.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mLj == null) {
            return false;
        }
        this.mLj.cancel();
        return true;
    }

    /* loaded from: classes23.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel mLk;

        private b() {
            this.mLk = new ForumListModel(ForumListDetailModel.this.eCn);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.mLk != null) {
                ForumListDetailModel.this.mLi.a(true, this.mLk.getErrorCode(), this.mLk, this.mLk.getErrorString(), ForumListDetailModel.this.mKp);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> AY = com.baidu.tbadk.core.c.a.bmx().AY("tb.my_posts");
                    String str = AY != null ? AY.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.mKK.menu_name + "_list") : null;
                    if (str != null) {
                        this.mLk = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.mLk != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.mKp = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.mKK);
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
                ForumListDetailModel.this.mLi.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.mKp);
            } else {
                ForumListDetailModel.this.mLi.a(false, 0, forumListModel, ForumListDetailModel.this.eCn.getString(R.string.neterror), ForumListDetailModel.this.mKp);
            }
        }
    }
}
