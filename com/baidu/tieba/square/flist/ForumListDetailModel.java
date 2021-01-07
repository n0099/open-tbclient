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
    private TbPageContext<ForumListActivity> eXu;
    private boolean isFirst;
    private boolean nkR;
    private a nlK;
    private b nlL;
    private ForumListModel.RequestParams nlm;

    /* loaded from: classes8.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.nkR = false;
        this.eXu = tbPageContext;
        this.nlm = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.nlm = requestParams;
    }

    public void a(a aVar) {
        this.nlK = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.nlL = new b();
        this.nlL.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nlL == null) {
            return false;
        }
        this.nlL.cancel();
        return true;
    }

    /* loaded from: classes8.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel nlM;

        private b() {
            this.nlM = new ForumListModel(ForumListDetailModel.this.eXu);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.nlM != null) {
                ForumListDetailModel.this.nlK.a(true, this.nlM.getErrorCode(), this.nlM, this.nlM.getErrorString(), ForumListDetailModel.this.nkR);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> Bm = com.baidu.tbadk.core.c.a.btT().Bm("tb.my_posts");
                    String str = Bm != null ? Bm.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.nlm.menu_name + "_list") : null;
                    if (str != null) {
                        this.nlM = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.nlM != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.nkR = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.nlm);
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
                ForumListDetailModel.this.nlK.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.nkR);
            } else {
                ForumListDetailModel.this.nlK.a(false, 0, forumListModel, ForumListDetailModel.this.eXu.getString(R.string.neterror), ForumListDetailModel.this.nkR);
            }
        }
    }
}
