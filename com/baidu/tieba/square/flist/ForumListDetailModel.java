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
    private boolean nkS;
    private a nlL;
    private b nlM;
    private ForumListModel.RequestParams nln;

    /* loaded from: classes8.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.nkS = false;
        this.eXu = tbPageContext;
        this.nln = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.nln = requestParams;
    }

    public void a(a aVar) {
        this.nlL = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.nlM = new b();
        this.nlM.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nlM == null) {
            return false;
        }
        this.nlM.cancel();
        return true;
    }

    /* loaded from: classes8.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel nlN;

        private b() {
            this.nlN = new ForumListModel(ForumListDetailModel.this.eXu);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.nlN != null) {
                ForumListDetailModel.this.nlL.a(true, this.nlN.getErrorCode(), this.nlN, this.nlN.getErrorString(), ForumListDetailModel.this.nkS);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> Bn = com.baidu.tbadk.core.c.a.btS().Bn("tb.my_posts");
                    String str = Bn != null ? Bn.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.nln.menu_name + "_list") : null;
                    if (str != null) {
                        this.nlN = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.nlN != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.nkS = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.nln);
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
                ForumListDetailModel.this.nlL.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.nkS);
            } else {
                ForumListDetailModel.this.nlL.a(false, 0, forumListModel, ForumListDetailModel.this.eXu.getString(R.string.neterror), ForumListDetailModel.this.nkS);
            }
        }
    }
}
