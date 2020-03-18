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
/* loaded from: classes10.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {
    private TbPageContext<ForumListActivity> cVv;
    private boolean isFirst;
    private boolean kbW;
    private a kcQ;
    private b kcR;
    private ForumListModel.RequestParams kcs;

    /* loaded from: classes10.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.kbW = false;
        this.cVv = tbPageContext;
        this.kcs = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.kcs = requestParams;
    }

    public void a(a aVar) {
        this.kcQ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.kcR = new b();
        this.kcR.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kcR == null) {
            return false;
        }
        this.kcR.cancel();
        return true;
    }

    /* loaded from: classes10.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel kcS;

        private b() {
            this.kcS = new ForumListModel(ForumListDetailModel.this.cVv);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.kcS != null) {
                ForumListDetailModel.this.kcQ.a(true, this.kcS.getErrorCode(), this.kcS, this.kcS.getErrorString(), ForumListDetailModel.this.kbW);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> sP = com.baidu.tbadk.core.c.a.aEF().sP("tb.my_posts");
                    String str = sP != null ? sP.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.kcs.menu_name + "_list") : null;
                    if (str != null) {
                        this.kcS = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.kcS != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.kbW = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.kcs);
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
                ForumListDetailModel.this.kcQ.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.kbW);
            } else {
                ForumListDetailModel.this.kcQ.a(false, 0, forumListModel, ForumListDetailModel.this.cVv.getString(R.string.neterror), ForumListDetailModel.this.kbW);
            }
        }
    }
}
