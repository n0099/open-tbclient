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
    private a jZV;
    private b jZW;
    private boolean jZb;
    private ForumListModel.RequestParams jZx;

    /* loaded from: classes8.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.jZb = false;
        this.cRe = tbPageContext;
        this.jZx = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.jZx = requestParams;
    }

    public void a(a aVar) {
        this.jZV = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.jZW = new b();
        this.jZW.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jZW == null) {
            return false;
        }
        this.jZW.cancel();
        return true;
    }

    /* loaded from: classes8.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel jZX;

        private b() {
            this.jZX = new ForumListModel(ForumListDetailModel.this.cRe);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.jZX != null) {
                ForumListDetailModel.this.jZV.a(true, this.jZX.getErrorCode(), this.jZX, this.jZX.getErrorString(), ForumListDetailModel.this.jZb);
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
                    String str = sA != null ? sA.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.jZx.menu_name + "_list") : null;
                    if (str != null) {
                        this.jZX = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.jZX != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.jZb = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.jZx);
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
                ForumListDetailModel.this.jZV.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.jZb);
            } else {
                ForumListDetailModel.this.jZV.a(false, 0, forumListModel, ForumListDetailModel.this.cRe.getString(R.string.neterror), ForumListDetailModel.this.jZb);
            }
        }
    }
}
