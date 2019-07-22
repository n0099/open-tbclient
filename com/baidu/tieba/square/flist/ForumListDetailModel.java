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
    private boolean iYD;
    private ForumListModel.RequestParams iYZ;
    private a iZx;
    private b iZy;
    private boolean isFirst;
    private TbPageContext<ForumListActivity> mContext;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.iYD = false;
        this.mContext = tbPageContext;
        this.iYZ = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.iYZ = requestParams;
    }

    public void a(a aVar) {
        this.iZx = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.iZy = new b();
        this.iZy.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iZy == null) {
            return false;
        }
        this.iZy.cancel();
        return true;
    }

    /* loaded from: classes5.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel iZz;

        private b() {
            this.iZz = new ForumListModel(ForumListDetailModel.this.mContext);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.iZz != null) {
                ForumListDetailModel.this.iZx.a(true, this.iZz.getErrorCode(), this.iZz, this.iZz.getErrorString(), ForumListDetailModel.this.iYD);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> mL = com.baidu.tbadk.core.d.a.agF().mL("tb.my_posts");
                    String str = mL != null ? mL.get(TbadkCoreApplication.getCurrentAccount() + "_" + ForumListDetailModel.this.iYZ.menu_name + "_list") : null;
                    if (str != null) {
                        this.iZz = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.iZz != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.iYD = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.iYZ);
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
                ForumListDetailModel.this.iZx.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.iYD);
            } else {
                ForumListDetailModel.this.iZx.a(false, 0, forumListModel, ForumListDetailModel.this.mContext.getString(R.string.neterror), ForumListDetailModel.this.iYD);
            }
        }
    }
}
