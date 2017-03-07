package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes.dex */
public class TopRecModel extends BdBaseModel<TopRecActivity> {
    private boolean bFy;
    a dsK;
    b dsL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(Boolean bool, TRForumListData tRForumListData, int i, String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TopRecModel(TopRecActivity topRecActivity) {
        super(topRecActivity.getPageContext());
        this.bFy = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.dsK = new a(this, null);
        this.dsK.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.dsK != null) {
            this.dsK.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.dsL = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, TRForumListData> {
        TRForumListData dsg;
        private z mNetwork;

        private a() {
            this.mNetwork = null;
            this.dsg = new TRForumListData();
        }

        /* synthetic */ a(TopRecModel topRecModel, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public TRForumListData doInBackground(Object... objArr) {
            String uB;
            try {
                this.mNetwork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/random_recommend_forum");
                this.mNetwork.n(LegoListActivityConfig.RN, "100");
                uB = this.mNetwork.uB();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            if (uB == null) {
                return null;
            }
            if (!this.mNetwork.uZ().vT().isRequestSuccess()) {
                TopRecModel.this.bFy = false;
            } else {
                this.dsg = (TRForumListData) OrmObject.objectWithJsonStr(uB, TRForumListData.class);
                TopRecModel.this.bFy = true;
            }
            return this.dsg;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(TRForumListData tRForumListData) {
            super.onPostExecute(tRForumListData);
            if (tRForumListData != null) {
                if (tRForumListData.error_code == 0 && tRForumListData.error != null) {
                    TopRecModel.this.dsL.a(Boolean.valueOf(TopRecModel.this.bFy), tRForumListData, tRForumListData.error.errno, tRForumListData.error.usermsg);
                } else {
                    TopRecModel.this.dsL.a(Boolean.valueOf(TopRecModel.this.bFy), tRForumListData, tRForumListData.error_code, tRForumListData.error_msg);
                }
            }
        }
    }
}
