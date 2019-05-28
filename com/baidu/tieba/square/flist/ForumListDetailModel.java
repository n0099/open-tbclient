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
    private ForumListModel.RequestParams iSE;
    private boolean iSi;
    private a iTc;
    private b iTd;
    private boolean isFirst;
    private TbPageContext<ForumListActivity> mContext;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.iSi = false;
        this.mContext = tbPageContext;
        this.iSE = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.iSE = requestParams;
    }

    public void a(a aVar) {
        this.iTc = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.iTd = new b();
        this.iTd.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iTd == null) {
            return false;
        }
        this.iTd.cancel();
        return true;
    }

    /* loaded from: classes5.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel iTe;

        private b() {
            this.iTe = new ForumListModel(ForumListDetailModel.this.mContext);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.iTe != null) {
                ForumListDetailModel.this.iTc.a(true, this.iTe.getErrorCode(), this.iTe, this.iTe.getErrorString(), ForumListDetailModel.this.iSi);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> mB = com.baidu.tbadk.core.c.a.afD().mB("tb.my_posts");
                    String str = mB != null ? mB.get(TbadkCoreApplication.getCurrentAccount() + "_" + ForumListDetailModel.this.iSE.menu_name + "_list") : null;
                    if (str != null) {
                        this.iTe = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.iTe != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.iSi = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.iSE);
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
                ForumListDetailModel.this.iTc.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.iSi);
            } else {
                ForumListDetailModel.this.iTc.a(false, 0, forumListModel, ForumListDetailModel.this.mContext.getString(R.string.neterror), ForumListDetailModel.this.iSi);
            }
        }
    }
}
