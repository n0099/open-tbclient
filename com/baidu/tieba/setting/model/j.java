package com.baidu.tieba.setting.model;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.n;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.more.SystemHelpSettingActivity;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.e {
    private a dlQ;
    private b dlR;
    private BaseActivity.LoadDataCallBack dlS;
    private Context mContext;

    public j(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.dlQ = null;
        this.dlR = null;
        this.mContext = null;
        this.dlS = null;
        this.mContext = systemHelpSettingActivity.getPageContext().getPageActivity();
    }

    public void axr() {
        if (this.dlQ == null) {
            this.dlQ = new a(this, null);
            this.dlQ.execute(new String[0]);
        }
    }

    public void axs() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, currentAccount));
        }
    }

    public void axt() {
        if (this.dlR == null) {
            this.dlR = new b(this, null);
            this.dlR.execute(new String[0]);
        }
    }

    public void setHeadsetModeOn(boolean z) {
        TbadkCoreApplication.m411getInst().setHeadsetModeOn(z);
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* synthetic */ a(j jVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            j.this.dlQ = null;
            if (j.this.dlS == null) {
                return;
            }
            j.this.dlS.callback(MoreModel.TaskType.DO_CACHE_CLEAR);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().dN();
            com.baidu.tbadk.core.voice.a.b.wB();
            try {
                aw.vk().vl();
                aw.vk().vm();
                MessageManager.getInstance().sendMessageFromBackground(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_CLEARIMAGE, ""));
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, String, String> {
        private b() {
        }

        /* synthetic */ b(j jVar, b bVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String ui = n.ui();
            long l = n.l(TbConfig.IMAGE_CACHE_DIR_NAME, false) + n.l(String.valueOf(ui) + TbConfig.TMP_PIC_DIR_NAME, false) + n.l(String.valueOf(ui) + "voice", false) + n.da(String.valueOf(ui) + TbConfig.TMP_DATABASE_NAME);
            float f = 0.0f + ((float) l);
            if (l < 10485.76d) {
                return "";
            }
            return String.valueOf(String.format("%.2f", Float.valueOf(f / 1048576.0f))) + j.this.mContext.getString(n.i.mebibyte);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((b) str);
            j.this.dlR = null;
            if (j.this.dlS == null) {
                return;
            }
            j.this.dlS.callback(MoreModel.TaskType.GET_SIZE, str);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(BaseActivity.LoadDataCallBack loadDataCallBack) {
        this.dlS = loadDataCallBack;
    }
}
