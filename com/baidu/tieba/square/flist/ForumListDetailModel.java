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
    private ForumListModel.RequestParams iSC;
    private boolean iSg;
    private a iTa;
    private b iTb;
    private boolean isFirst;
    private TbPageContext<ForumListActivity> mContext;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.iSg = false;
        this.mContext = tbPageContext;
        this.iSC = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.iSC = requestParams;
    }

    public void a(a aVar) {
        this.iTa = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.iTb = new b();
        this.iTb.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iTb == null) {
            return false;
        }
        this.iTb.cancel();
        return true;
    }

    /* loaded from: classes5.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel iTc;

        private b() {
            this.iTc = new ForumListModel(ForumListDetailModel.this.mContext);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.iTc != null) {
                ForumListDetailModel.this.iTa.a(true, this.iTc.getErrorCode(), this.iTc, this.iTc.getErrorString(), ForumListDetailModel.this.iSg);
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
                    String str = mB != null ? mB.get(TbadkCoreApplication.getCurrentAccount() + "_" + ForumListDetailModel.this.iSC.menu_name + "_list") : null;
                    if (str != null) {
                        this.iTc = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.iTc != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.iSg = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.iSC);
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
                ForumListDetailModel.this.iTa.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.iSg);
            } else {
                ForumListDetailModel.this.iTa.a(false, 0, forumListModel, ForumListDetailModel.this.mContext.getString(R.string.neterror), ForumListDetailModel.this.iSg);
            }
        }
    }
}
