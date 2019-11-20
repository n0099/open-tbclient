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
import com.baidu.tieba.square.square.d;
/* loaded from: classes5.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    private boolean fcr;
    private a jaX;
    private b jaY;
    private String jaZ;
    private String jba;
    private String jbb;
    private boolean jbc;

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, int i, d dVar, String str, boolean z2);
    }

    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        this.fcr = false;
        this.jbc = false;
        this.jaZ = str;
        this.jba = str2;
        this.jbb = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        this.jaX = new a();
        this.jaX.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jaX != null) {
            this.jaX.cancel();
            return false;
        }
        return false;
    }

    public void a(b bVar) {
        this.jaY = bVar;
    }

    /* loaded from: classes5.dex */
    private class a extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.square.c> {
        com.baidu.tieba.square.square.c jbd;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.jbd = new com.baidu.tieba.square.square.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            if (this.jbd != null) {
                DirMenuModel.this.jaY.a(true, this.jbd.getErrorCode(), this.jbd.cmS(), this.jbd.getErrorMsg(), DirMenuModel.this.jbc);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public com.baidu.tieba.square.square.c doInBackground(Object... objArr) {
            String postNetData;
            String str = null;
            l<String> nl = com.baidu.tbadk.core.d.a.akL().nl("tb.my_posts");
            if (nl != null) {
                str = nl.get(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.jaZ + "_dir");
            }
            if (str != null) {
                this.jbd.parserJson(str);
                DirMenuModel.this.jbc = true;
                publishProgress(new Integer[0]);
            }
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.FORUM_SECOND_DIR);
                this.mNetwork.addPostData("menu_name", DirMenuModel.this.jaZ);
                this.mNetwork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, DirMenuModel.this.jba);
                this.mNetwork.addPostData("menu_id", DirMenuModel.this.jbb);
                postNetData = this.mNetwork.postNetData();
            } catch (Exception e) {
                this.jbd.setErrorMsg(e.getMessage());
                BdLog.detailException(e);
            }
            if (postNetData == null) {
                return this.jbd;
            }
            if (this.mNetwork.amp().amQ().isRequestSuccess()) {
                this.jbd.parserJson(postNetData);
                DirMenuModel.this.fcr = true;
                if (nl != null) {
                    nl.set(TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DirMenuModel.this.jaZ + "_dir", postNetData, 86400000L);
                }
            } else {
                this.jbd.setErrorMsg(this.mNetwork.getErrorString());
                DirMenuModel.this.fcr = false;
            }
            return this.jbd;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.square.square.c cVar) {
            if (!DirMenuModel.this.fcr) {
                DirMenuModel.this.jaY.a(false, -1, null, cVar.getErrorMsg(), DirMenuModel.this.jbc);
            } else if (cVar.cmS() != null) {
                DirMenuModel.this.jaY.a(true, cVar.getErrorCode(), cVar.cmS(), cVar.getErrorMsg(), DirMenuModel.this.jbc);
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
