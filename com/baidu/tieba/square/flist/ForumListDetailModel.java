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
    private TbPageContext<ForumListActivity> eIc;
    private boolean isFirst;
    private ForumListModel.RequestParams mQH;
    private boolean mQm;
    private a mRg;
    private b mRh;

    /* loaded from: classes23.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.mQm = false;
        this.eIc = tbPageContext;
        this.mQH = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.mQH = requestParams;
    }

    public void a(a aVar) {
        this.mRg = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.mRh = new b();
        this.mRh.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mRh == null) {
            return false;
        }
        this.mRh.cancel();
        return true;
    }

    /* loaded from: classes23.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel mRi;

        private b() {
            this.mRi = new ForumListModel(ForumListDetailModel.this.eIc);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.mRi != null) {
                ForumListDetailModel.this.mRg.a(true, this.mRi.getErrorCode(), this.mRi, this.mRi.getErrorString(), ForumListDetailModel.this.mQm);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> Bm = com.baidu.tbadk.core.c.a.boX().Bm("tb.my_posts");
                    String str = Bm != null ? Bm.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.mQH.menu_name + "_list") : null;
                    if (str != null) {
                        this.mRi = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.mRi != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.mQm = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.mQH);
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
                ForumListDetailModel.this.mRg.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.mQm);
            } else {
                ForumListDetailModel.this.mRg.a(false, 0, forumListModel, ForumListDetailModel.this.eIc.getString(R.string.neterror), ForumListDetailModel.this.mQm);
            }
        }
    }
}
