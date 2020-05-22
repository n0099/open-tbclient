package com.baidu.tieba.square.flist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.square.square.e;
/* loaded from: classes10.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    private boolean isOk;
    private a leb;
    private b lec;
    private String led;
    private String lee;
    private String lef;
    private boolean leg;

    /* loaded from: classes10.dex */
    public interface b {
        void a(boolean z, int i, e eVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.isOk = false;
        this.leg = false;
        this.led = str;
        this.lee = str2;
        this.lef = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.leb = new a();
        this.leb.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.leb != null) {
            this.leb.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.lec = bVar;
    }

    /* loaded from: classes10.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.d> {
        com.baidu.tieba.square.square.d leh;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.leh = new com.baidu.tieba.square.square.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.leh != null) {
                DirMenuModel.this.lec.a(true, this.leh.getErrorCode(), this.leh.dcd(), this.leh.getErrorMsg(), DirMenuModel.this.leg);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public com.baidu.tieba.square.square.d doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> vM = com.baidu.tbadk.core.c.a.aSS().vM("tb.my_posts");
            if (vM != null) {
                str = vM.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.led + "_dir");
            }
            if (str != null) {
                this.leh.parserJson(str);
                DirMenuModel.this.leg = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.led);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.lee);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.lef);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.leh.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.leh;
            }
            if (this.mNetwork.aUA().aVb().isRequestSuccess()) {
                this.leh.parserJson(postNetData);
                DirMenuModel.this.isOk = true;
                if (vM != null) {
                    vM.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.led + "_dir", postNetData, 86400000L);
                }
            } else {
                this.leh.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.isOk = false;
            }
            return this.leh;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.d dVar) {
            if (!DirMenuModel.this.isOk) {
                DirMenuModel.this.lec.a(false, -1, null, dVar.getErrorMsg(), DirMenuModel.this.leg);
            } else if (dVar.dcd() != null) {
                DirMenuModel.this.lec.a(true, dVar.getErrorCode(), dVar.dcd(), dVar.getErrorMsg(), DirMenuModel.this.leg);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
        }
    }
}
