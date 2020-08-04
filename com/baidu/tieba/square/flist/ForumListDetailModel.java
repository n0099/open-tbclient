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
    private boolean lGF;
    private ForumListModel.RequestParams lHa;
    private a lHy;
    private b lHz;

    /* loaded from: classes17.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.lGF = false;
        this.dVN = tbPageContext;
        this.lHa = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.lHa = requestParams;
    }

    public void a(a aVar) {
        this.lHy = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.lHz = new b();
        this.lHz.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lHz == null) {
            return false;
        }
        this.lHz.cancel();
        return true;
    }

    /* loaded from: classes17.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel lHA;

        private b() {
            this.lHA = new ForumListModel(ForumListDetailModel.this.dVN);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.lHA != null) {
                ForumListDetailModel.this.lHy.a(true, this.lHA.getErrorCode(), this.lHA, this.lHA.getErrorString(), ForumListDetailModel.this.lGF);
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
                    String str = xj != null ? xj.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.lHa.menu_name + "_list") : null;
                    if (str != null) {
                        this.lHA = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.lHA != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.lGF = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.lHa);
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
                ForumListDetailModel.this.lHy.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.lGF);
            } else {
                ForumListDetailModel.this.lHy.a(false, 0, forumListModel, ForumListDetailModel.this.dVN.getString(R.string.neterror), ForumListDetailModel.this.lGF);
            }
        }
    }
}
