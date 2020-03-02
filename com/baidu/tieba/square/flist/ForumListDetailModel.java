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
    private TbPageContext<ForumListActivity> cVh;
    private boolean isFirst;
    private ForumListModel.RequestParams kaE;
    private boolean kah;
    private a kbc;
    private b kbd;

    /* loaded from: classes10.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.kah = false;
        this.cVh = tbPageContext;
        this.kaE = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.kaE = requestParams;
    }

    public void a(a aVar) {
        this.kbc = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.kbd = new b();
        this.kbd.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kbd == null) {
            return false;
        }
        this.kbd.cancel();
        return true;
    }

    /* loaded from: classes10.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel kbe;

        private b() {
            this.kbe = new ForumListModel(ForumListDetailModel.this.cVh);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.kbe != null) {
                ForumListDetailModel.this.kbc.a(true, this.kbe.getErrorCode(), this.kbe, this.kbe.getErrorString(), ForumListDetailModel.this.kah);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> sQ = com.baidu.tbadk.core.c.a.aEB().sQ("tb.my_posts");
                    String str = sQ != null ? sQ.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.kaE.menu_name + "_list") : null;
                    if (str != null) {
                        this.kbe = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.kbe != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.kah = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.kaE);
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
                ForumListDetailModel.this.kbc.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.kah);
            } else {
                ForumListDetailModel.this.kbc.a(false, 0, forumListModel, ForumListDetailModel.this.cVh.getString(R.string.neterror), ForumListDetailModel.this.kah);
            }
        }
    }
}
