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
    private TbPageContext<ForumListActivity> eGu;
    private boolean isFirst;
    private ForumListModel.RequestParams mRB;
    private a mRZ;
    private boolean mRg;
    private b mSa;

    /* loaded from: classes22.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.mRg = false;
        this.eGu = tbPageContext;
        this.mRB = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.mRB = requestParams;
    }

    public void a(a aVar) {
        this.mRZ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.mSa = new b();
        this.mSa.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mSa == null) {
            return false;
        }
        this.mSa.cancel();
        return true;
    }

    /* loaded from: classes22.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel mSb;

        private b() {
            this.mSb = new ForumListModel(ForumListDetailModel.this.eGu);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.mSb != null) {
                ForumListDetailModel.this.mRZ.a(true, this.mSb.getErrorCode(), this.mSb, this.mSb.getErrorString(), ForumListDetailModel.this.mRg);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> AH = com.baidu.tbadk.core.c.a.bob().AH("tb.my_posts");
                    String str = AH != null ? AH.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.mRB.menu_name + "_list") : null;
                    if (str != null) {
                        this.mSb = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.mSb != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.mRg = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.mRB);
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
                ForumListDetailModel.this.mRZ.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.mRg);
            } else {
                ForumListDetailModel.this.mRZ.a(false, 0, forumListModel, ForumListDetailModel.this.eGu.getString(R.string.neterror), ForumListDetailModel.this.mRg);
            }
        }
    }
}
