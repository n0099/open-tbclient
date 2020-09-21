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
/* loaded from: classes22.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {
    private TbPageContext<ForumListActivity> ehG;
    private boolean isFirst;
    private a miX;
    private b miY;
    private boolean mic;
    private ForumListModel.RequestParams miz;

    /* loaded from: classes22.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.mic = false;
        this.ehG = tbPageContext;
        this.miz = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.miz = requestParams;
    }

    public void a(a aVar) {
        this.miX = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.miY = new b();
        this.miY.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.miY == null) {
            return false;
        }
        this.miY.cancel();
        return true;
    }

    /* loaded from: classes22.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel miZ;

        private b() {
            this.miZ = new ForumListModel(ForumListDetailModel.this.ehG);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.miZ != null) {
                ForumListDetailModel.this.miX.a(true, this.miZ.getErrorCode(), this.miZ, this.miZ.getErrorString(), ForumListDetailModel.this.mic);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> zT = com.baidu.tbadk.core.c.a.bhV().zT("tb.my_posts");
                    String str = zT != null ? zT.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.miz.menu_name + "_list") : null;
                    if (str != null) {
                        this.miZ = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.miZ != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.mic = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.miz);
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
                ForumListDetailModel.this.miX.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.mic);
            } else {
                ForumListDetailModel.this.miX.a(false, 0, forumListModel, ForumListDetailModel.this.ehG.getString(R.string.neterror), ForumListDetailModel.this.mic);
            }
        }
    }
}
