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
    private ForumListModel.RequestParams nfF;
    private boolean nfk;
    private a ngd;
    private b nge;

    /* loaded from: classes23.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.nfk = false;
        this.eNx = tbPageContext;
        this.nfF = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.nfF = requestParams;
    }

    public void a(a aVar) {
        this.ngd = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.nge = new b();
        this.nge.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nge == null) {
            return false;
        }
        this.nge.cancel();
        return true;
    }

    /* loaded from: classes23.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel ngf;

        private b() {
            this.ngf = new ForumListModel(ForumListDetailModel.this.eNx);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.ngf != null) {
                ForumListDetailModel.this.ngd.a(true, this.ngf.getErrorCode(), this.ngf, this.ngf.getErrorString(), ForumListDetailModel.this.nfk);
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
                    String str = Bo != null ? Bo.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.nfF.menu_name + "_list") : null;
                    if (str != null) {
                        this.ngf = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.ngf != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.nfk = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.nfF);
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
                ForumListDetailModel.this.ngd.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.nfk);
            } else {
                ForumListDetailModel.this.ngd.a(false, 0, forumListModel, ForumListDetailModel.this.eNx.getString(R.string.neterror), ForumListDetailModel.this.nfk);
            }
        }
    }
}
