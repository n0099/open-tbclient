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
    private TbPageContext<ForumListActivity> etO;
    private boolean isFirst;
    private boolean mxF;
    private ForumListModel.RequestParams mya;
    private a myy;
    private b myz;

    /* loaded from: classes23.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.mxF = false;
        this.etO = tbPageContext;
        this.mya = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.mya = requestParams;
    }

    public void a(a aVar) {
        this.myy = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.myz = new b();
        this.myz.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.myz == null) {
            return false;
        }
        this.myz.cancel();
        return true;
    }

    /* loaded from: classes23.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel myA;

        private b() {
            this.myA = new ForumListModel(ForumListDetailModel.this.etO);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.myA != null) {
                ForumListDetailModel.this.myy.a(true, this.myA.getErrorCode(), this.myA, this.myA.getErrorString(), ForumListDetailModel.this.mxF);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> AF = com.baidu.tbadk.core.c.a.bkE().AF("tb.my_posts");
                    String str = AF != null ? AF.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.mya.menu_name + "_list") : null;
                    if (str != null) {
                        this.myA = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.myA != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.mxF = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.mya);
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
                ForumListDetailModel.this.myy.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.mxF);
            } else {
                ForumListDetailModel.this.myy.a(false, 0, forumListModel, ForumListDetailModel.this.etO.getString(R.string.neterror), ForumListDetailModel.this.mxF);
            }
        }
    }
}
