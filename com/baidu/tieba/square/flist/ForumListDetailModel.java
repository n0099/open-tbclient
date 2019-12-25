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
/* loaded from: classes7.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {
    private TbPageContext<ForumListActivity> cQU;
    private boolean isFirst;
    private ForumListModel.RequestParams jVV;
    private boolean jVz;
    private a jWt;
    private b jWu;

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.jVz = false;
        this.cQU = tbPageContext;
        this.jVV = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.jVV = requestParams;
    }

    public void a(a aVar) {
        this.jWt = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.jWu = new b();
        this.jWu.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jWu == null) {
            return false;
        }
        this.jWu.cancel();
        return true;
    }

    /* loaded from: classes7.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel jWv;

        private b() {
            this.jWv = new ForumListModel(ForumListDetailModel.this.cQU);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.jWv != null) {
                ForumListDetailModel.this.jWt.a(true, this.jWv.getErrorCode(), this.jWv, this.jWv.getErrorString(), ForumListDetailModel.this.jVz);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> sx = com.baidu.tbadk.core.c.a.aBV().sx("tb.my_posts");
                    String str = sx != null ? sx.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.jVV.menu_name + "_list") : null;
                    if (str != null) {
                        this.jWv = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.jWv != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.jVz = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.jVV);
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
                ForumListDetailModel.this.jWt.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.jVz);
            } else {
                ForumListDetailModel.this.jWt.a(false, 0, forumListModel, ForumListDetailModel.this.cQU.getString(R.string.neterror), ForumListDetailModel.this.jVz);
            }
        }
    }
}
