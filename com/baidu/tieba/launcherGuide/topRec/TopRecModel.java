package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes.dex */
public class TopRecModel extends BdBaseModel<TopRecActivity> {
    private boolean bys;
    a dqr;
    b dqs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(Boolean bool, TRForumListData tRForumListData, int i, String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TopRecModel(TopRecActivity topRecActivity) {
        super(topRecActivity.getPageContext());
        this.bys = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.dqr = new a(this, null);
        this.dqr.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.dqr != null) {
            this.dqr.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.dqs = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, TRForumListData> {
        TRForumListData dpN;
        private y mNetwork;

        private a() {
            this.mNetwork = null;
            this.dpN = new TRForumListData();
        }

        /* synthetic */ a(TopRecModel topRecModel, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public TRForumListData doInBackground(Object... objArr) {
            String ud;
            try {
                this.mNetwork = new y(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/random_recommend_forum");
                this.mNetwork.n(LegoListActivityConfig.RN, "100");
                ud = this.mNetwork.ud();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            if (ud == null) {
                return null;
            }
            if (!this.mNetwork.uC().vw().isRequestSuccess()) {
                TopRecModel.this.bys = false;
            } else {
                this.dpN = (TRForumListData) OrmObject.objectWithJsonStr(ud, TRForumListData.class);
                TopRecModel.this.bys = true;
            }
            return this.dpN;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(TRForumListData tRForumListData) {
            super.onPostExecute(tRForumListData);
            if (tRForumListData != null) {
                if (tRForumListData.error_code == 0 && tRForumListData.error != null) {
                    TopRecModel.this.dqs.a(Boolean.valueOf(TopRecModel.this.bys), tRForumListData, tRForumListData.error.errno, tRForumListData.error.usermsg);
                } else {
                    TopRecModel.this.dqs.a(Boolean.valueOf(TopRecModel.this.bys), tRForumListData, tRForumListData.error_code, tRForumListData.error_msg);
                }
            }
        }
    }
}
