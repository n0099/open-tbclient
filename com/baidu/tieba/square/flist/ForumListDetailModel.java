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
    private TbPageContext<ForumListActivity> eWx;
    private boolean isFirst;
    private ForumListModel.RequestParams nsU;
    private boolean nsz;
    private a nts;
    private b ntt;

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        this.isFirst = true;
        this.nsz = false;
        this.eWx = tbPageContext;
        this.nsU = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.nsU = requestParams;
    }

    public void a(a aVar) {
        this.nts = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.ntt = new b();
        this.ntt.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.ntt == null) {
            return false;
        }
        this.ntt.cancel();
        return true;
    }

    /* loaded from: classes7.dex */
    private class b extends BdAsyncTask<Void, Void, ForumListModel> {
        ForumListModel ntu;

        private b() {
            this.ntu = new ForumListModel(ForumListDetailModel.this.eWx);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
            if (this.ntu != null) {
                ForumListDetailModel.this.nts.a(true, this.ntu.getErrorCode(), this.ntu, this.ntu.getErrorString(), ForumListDetailModel.this.nsz);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                if (ForumListDetailModel.this.isFirst) {
                    l<String> Az = com.baidu.tbadk.core.c.a.bqt().Az("tb.my_posts");
                    String str = Az != null ? Az.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ForumListDetailModel.this.nsU.menu_name + "_list") : null;
                    if (str != null) {
                        this.ntu = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                        if (this.ntu != null) {
                            publishProgress(new Void[0]);
                        }
                        ForumListDetailModel.this.nsz = true;
                    }
                }
                ForumListDetailModel.this.isFirst = false;
                return ForumListModel.new_fetch(ForumListDetailModel.this.nsU);
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
                ForumListDetailModel.this.nts.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), ForumListDetailModel.this.nsz);
            } else {
                ForumListDetailModel.this.nts.a(false, 0, forumListModel, ForumListDetailModel.this.eWx.getString(R.string.neterror), ForumListDetailModel.this.nsz);
            }
        }
    }
}
