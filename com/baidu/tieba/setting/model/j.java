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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.more.SystemHelpSettingActivity;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.e {
    private a cMd;
    private b cMe;
    private BaseActivity.LoadDataCallBack cMf;
    private Context mContext;

    public j(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.cMd = null;
        this.cMe = null;
        this.mContext = null;
        this.cMf = null;
        this.mContext = systemHelpSettingActivity.getPageContext().getPageActivity();
    }

    public void arn() {
        if (this.cMd == null) {
            this.cMd = new a(this, null);
            this.cMd.execute(new String[0]);
        }
    }

    public void aro() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, currentAccount));
        }
    }

    public void arp() {
        if (this.cMe == null) {
            this.cMe = new b(this, null);
            this.cMe.execute(new String[0]);
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
            j.this.cMd = null;
            if (j.this.cMf == null) {
                return;
            }
            j.this.cMf.callback(MoreModel.TaskType.DO_CACHE_CLEAR);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().dN();
            com.baidu.tbadk.core.voice.a.b.vG();
            try {
                ar.uA().uB();
                ar.uA().uC();
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
            String tA = n.tA();
            long k = n.k(TbConfig.IMAGE_CACHE_DIR_NAME, false) + n.k(String.valueOf(tA) + TbConfig.TMP_PIC_DIR_NAME, false) + n.k(String.valueOf(tA) + "voice", false) + n.cS(String.valueOf(tA) + TbConfig.TMP_DATABASE_NAME);
            float f = 0.0f + ((float) k);
            if (k < 10485.76d) {
                return "";
            }
            return String.valueOf(String.format("%.2f", Float.valueOf(f / 1048576.0f))) + j.this.mContext.getString(i.h.mebibyte);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((b) str);
            j.this.cMe = null;
            if (j.this.cMf == null) {
                return;
            }
            j.this.cMf.callback(MoreModel.TaskType.GET_SIZE, str);
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
        this.cMf = loadDataCallBack;
    }
}
