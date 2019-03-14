package com.baidu.tieba.square.flist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.square.flist.ForumListModel;
/* loaded from: classes5.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {
    private a iAB;
    private b iAC;
    private ForumListModel.RequestParams iAd;
    private boolean isFirst;
    private boolean izI;
    private TbPageContext<ForumListActivity> mContext;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.izI = false;
        this.mContext = tbPageContext;
        this.iAd = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.iAd = requestParams;
    }

    public void a(a aVar) {
        this.iAB = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.iAC = new b();
        this.iAC.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iAC == null) {
            return false;
        }
        this.iAC.cancel();
        return true;
    }

    /* loaded from: classes5.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel iAD;

        private b() {
            this.iAD = new ForumListModel(ForumListDetailModel.this.mContext);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.iAD != null) {
                ForumListDetailModel.this.iAB.a(true, this.iAD.getErrorCode(), this.iAD, this.iAD.getErrorString(), ForumListDetailModel.this.izI);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> lv = com.baidu.tbadk.core.c.a.aaW().lv("tb.my_posts");
                    String str = lv != null ? lv.get(TbadkCoreApplication.getCurrentAccount() + "_" + ForumListDetailModel.this.iAd.menu_name + "_list") : null;
                    if (str != null) {
                        this.iAD = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.iAD != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.izI = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.iAd);
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
                ForumListDetailModel.this.iAB.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.izI);
            } else {
                ForumListDetailModel.this.iAB.a(false, 0, forumListModel, ForumListDetailModel.this.mContext.getString(d.j.neterror), ForumListDetailModel.this.izI);
            }
        }
    }
}
