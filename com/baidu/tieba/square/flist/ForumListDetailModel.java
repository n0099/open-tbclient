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
    private a iAm;
    private b iAn;
    private boolean isFirst;
    private ForumListModel.RequestParams izO;
    private boolean izt;
    private TbPageContext<ForumListActivity> mContext;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.izt = false;
        this.mContext = tbPageContext;
        this.izO = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.izO = requestParams;
    }

    public void a(a aVar) {
        this.iAm = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.iAn = new b();
        this.iAn.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iAn == null) {
            return false;
        }
        this.iAn.cancel();
        return true;
    }

    /* loaded from: classes5.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel iAo;

        private b() {
            this.iAo = new ForumListModel(ForumListDetailModel.this.mContext);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.iAo != null) {
                ForumListDetailModel.this.iAm.a(true, this.iAo.getErrorCode(), this.iAo, this.iAo.getErrorString(), ForumListDetailModel.this.izt);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> lw = com.baidu.tbadk.core.c.a.aaT().lw("tb.my_posts");
                    String str = lw != null ? lw.get(TbadkCoreApplication.getCurrentAccount() + "_" + ForumListDetailModel.this.izO.menu_name + "_list") : null;
                    if (str != null) {
                        this.iAo = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.iAo != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.izt = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.izO);
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
                ForumListDetailModel.this.iAm.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.izt);
            } else {
                ForumListDetailModel.this.iAm.a(false, 0, forumListModel, ForumListDetailModel.this.mContext.getString(d.j.neterror), ForumListDetailModel.this.izt);
            }
        }
    }
}
