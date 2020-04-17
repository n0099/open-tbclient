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
    private TbPageContext<ForumListActivity> duG;
    private boolean isFirst;
    private boolean kLM;
    private a kMG;
    private b kMH;
    private ForumListModel.RequestParams kMi;

    /* loaded from: classes10.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.kLM = false;
        this.duG = tbPageContext;
        this.kMi = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.kMi = requestParams;
    }

    public void a(a aVar) {
        this.kMG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.kMH = new b();
        this.kMH.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kMH == null) {
            return false;
        }
        this.kMH.cancel();
        return true;
    }

    /* loaded from: classes10.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel kMI;

        private b() {
            this.kMI = new ForumListModel(ForumListDetailModel.this.duG);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.kMI != null) {
                ForumListDetailModel.this.kMG.a(true, this.kMI.getErrorCode(), this.kMI, this.kMI.getErrorString(), ForumListDetailModel.this.kLM);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> ud = com.baidu.tbadk.core.c.a.aMT().ud("tb.my_posts");
                    String str = ud != null ? ud.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.kMi.menu_name + "_list") : null;
                    if (str != null) {
                        this.kMI = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.kMI != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.kLM = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.kMi);
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
                ForumListDetailModel.this.kMG.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.kLM);
            } else {
                ForumListDetailModel.this.kMG.a(false, 0, forumListModel, ForumListDetailModel.this.duG.getString(R.string.neterror), ForumListDetailModel.this.kLM);
            }
        }
    }
}
