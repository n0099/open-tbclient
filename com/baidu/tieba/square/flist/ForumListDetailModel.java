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
/* loaded from: classes8.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {
    private TbPageContext<ForumListActivity> cRe;
    private boolean isFirst;
    private ForumListModel.RequestParams jZC;
    private boolean jZg;
    private a kaa;
    private b kab;

    /* loaded from: classes8.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.jZg = false;
        this.cRe = tbPageContext;
        this.jZC = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.jZC = requestParams;
    }

    public void a(a aVar) {
        this.kaa = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.kab = new b();
        this.kab.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kab == null) {
            return false;
        }
        this.kab.cancel();
        return true;
    }

    /* loaded from: classes8.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel kac;

        private b() {
            this.kac = new ForumListModel(ForumListDetailModel.this.cRe);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.kac != null) {
                ForumListDetailModel.this.kaa.a(true, this.kac.getErrorCode(), this.kac, this.kac.getErrorString(), ForumListDetailModel.this.jZg);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> sA = com.baidu.tbadk.core.c.a.aCo().sA("tb.my_posts");
                    String str = sA != null ? sA.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.jZC.menu_name + "_list") : null;
                    if (str != null) {
                        this.kac = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.kac != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.jZg = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.jZC);
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
                ForumListDetailModel.this.kaa.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.jZg);
            } else {
                ForumListDetailModel.this.kaa.a(false, 0, forumListModel, ForumListDetailModel.this.cRe.getString(R.string.neterror), ForumListDetailModel.this.jZg);
            }
        }
    }
}
