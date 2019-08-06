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
    private boolean iZH;
    private boolean isFirst;
    private a jaB;
    private b jaC;
    private ForumListModel.RequestParams jad;
    private TbPageContext<ForumListActivity> mContext;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.iZH = false;
        this.mContext = tbPageContext;
        this.jad = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.jad = requestParams;
    }

    public void a(a aVar) {
        this.jaB = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.jaC = new b();
        this.jaC.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jaC == null) {
            return false;
        }
        this.jaC.cancel();
        return true;
    }

    /* loaded from: classes5.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel jaD;

        private b() {
            this.jaD = new ForumListModel(ForumListDetailModel.this.mContext);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.jaD != null) {
                ForumListDetailModel.this.jaB.a(true, this.jaD.getErrorCode(), this.jaD, this.jaD.getErrorString(), ForumListDetailModel.this.iZH);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> mL = com.baidu.tbadk.core.d.a.agH().mL("tb.my_posts");
                    String str = mL != null ? mL.get(TbadkCoreApplication.getCurrentAccount() + "_" + ForumListDetailModel.this.jad.menu_name + "_list") : null;
                    if (str != null) {
                        this.jaD = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.jaD != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.iZH = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.jad);
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
                ForumListDetailModel.this.jaB.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.iZH);
            } else {
                ForumListDetailModel.this.jaB.a(false, 0, forumListModel, ForumListDetailModel.this.mContext.getString(R.string.neterror), ForumListDetailModel.this.iZH);
            }
        }
    }
}
