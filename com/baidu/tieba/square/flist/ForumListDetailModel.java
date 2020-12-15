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
    private TbPageContext<ForumListActivity> eNx;
    private boolean isFirst;
    private ForumListModel.RequestParams nfH;
    private boolean nfm;
    private a ngf;
    private b ngg;

    /* loaded from: classes23.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.nfm = false;
        this.eNx = tbPageContext;
        this.nfH = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.nfH = requestParams;
    }

    public void a(a aVar) {
        this.ngf = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.ngg = new b();
        this.ngg.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.ngg == null) {
            return false;
        }
        this.ngg.cancel();
        return true;
    }

    /* loaded from: classes23.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel ngh;

        private b() {
            this.ngh = new ForumListModel(ForumListDetailModel.this.eNx);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.ngh != null) {
                ForumListDetailModel.this.ngf.a(true, this.ngh.getErrorCode(), this.ngh, this.ngh.getErrorString(), ForumListDetailModel.this.nfm);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> Bo = com.baidu.tbadk.core.c.a.brq().Bo("tb.my_posts");
                    String str = Bo != null ? Bo.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.nfH.menu_name + "_list") : null;
                    if (str != null) {
                        this.ngh = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.ngh != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.nfm = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.nfH);
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
                ForumListDetailModel.this.ngf.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.nfm);
            } else {
                ForumListDetailModel.this.ngf.a(false, 0, forumListModel, ForumListDetailModel.this.eNx.getString(R.string.neterror), ForumListDetailModel.this.nfm);
            }
        }
    }
}
