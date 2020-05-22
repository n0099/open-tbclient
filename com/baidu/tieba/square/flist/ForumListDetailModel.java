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
    private TbPageContext<ForumListActivity> dIF;
    private boolean isFirst;
    private ForumListModel.RequestParams leD;
    private boolean leg;
    private a lfb;
    private b lfc;

    /* loaded from: classes10.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.leg = false;
        this.dIF = tbPageContext;
        this.leD = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.leD = requestParams;
    }

    public void a(a aVar) {
        this.lfb = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.lfc = new b();
        this.lfc.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lfc == null) {
            return false;
        }
        this.lfc.cancel();
        return true;
    }

    /* loaded from: classes10.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel lfd;

        private b() {
            this.lfd = new ForumListModel(ForumListDetailModel.this.dIF);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.lfd != null) {
                ForumListDetailModel.this.lfb.a(true, this.lfd.getErrorCode(), this.lfd, this.lfd.getErrorString(), ForumListDetailModel.this.leg);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> vM = com.baidu.tbadk.core.c.a.aSS().vM("tb.my_posts");
                    String str = vM != null ? vM.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.leD.menu_name + "_list") : null;
                    if (str != null) {
                        this.lfd = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.lfd != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.leg = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.leD);
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
                ForumListDetailModel.this.lfb.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.leg);
            } else {
                ForumListDetailModel.this.lfb.a(false, 0, forumListModel, ForumListDetailModel.this.dIF.getString(R.string.neterror), ForumListDetailModel.this.leg);
            }
        }
    }
}
