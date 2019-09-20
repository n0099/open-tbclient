package com.baidu.tieba.square.flist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.square.flist.ForumListModel;
/* loaded from: classes5.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {
    private boolean isFirst;
    private a jcW;
    private b jcX;
    private boolean jcc;
    private ForumListModel.RequestParams jcy;
    private TbPageContext<ForumListActivity> mContext;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.jcc = false;
        this.mContext = tbPageContext;
        this.jcy = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.jcy = requestParams;
    }

    public void a(a aVar) {
        this.jcW = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.jcX = new b();
        this.jcX.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jcX == null) {
            return false;
        }
        this.jcX.cancel();
        return true;
    }

    /* loaded from: classes5.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel jcY;

        private b() {
            this.jcY = new ForumListModel(ForumListDetailModel.this.mContext);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.jcY != null) {
                ForumListDetailModel.this.jcW.a(true, this.jcY.getErrorCode(), this.jcY, this.jcY.getErrorString(), ForumListDetailModel.this.jcc);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> mN = com.baidu.tbadk.core.d.a.agL().mN("tb.my_posts");
                    String str = mN != null ? mN.get(TbadkCoreApplication.getCurrentAccount() + "_" + ForumListDetailModel.this.jcy.menu_name + "_list") : null;
                    if (str != null) {
                        this.jcY = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.jcY != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.jcc = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.jcy);
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
                ForumListDetailModel.this.jcW.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.jcc);
            } else {
                ForumListDetailModel.this.jcW.a(false, 0, forumListModel, ForumListDetailModel.this.mContext.getString(R.string.neterror), ForumListDetailModel.this.jcc);
            }
        }
    }
}
