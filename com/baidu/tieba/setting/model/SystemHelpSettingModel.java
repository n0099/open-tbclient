package com.baidu.tieba.setting.model;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.more.SystemHelpSettingActivity;
/* loaded from: classes13.dex */
public class SystemHelpSettingModel extends BdBaseModel {
    private a kUC;
    private b kUD;
    private BaseActivity.LoadDataCallBack kUE;
    private Context mContext;

    public SystemHelpSettingModel(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.kUC = null;
        this.kUD = null;
        this.mContext = null;
        this.kUE = null;
        this.mContext = systemHelpSettingActivity.getPageContext().getPageActivity();
    }

    public void bKK() {
        if (this.kUC == null) {
            this.kUC = new a();
            this.kUC.execute(new String[0]);
        }
    }

    public void cXd() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, currentAccount));
        }
    }

    public void cXe() {
        if (this.kUD == null) {
            this.kUD = new b();
            this.kUD.execute(new String[0]);
        }
    }

    public void setHeadsetModeOn(boolean z) {
        TbadkCoreApplication.getInst().setHeadsetModeOn(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            SystemHelpSettingModel.this.kUC = null;
            if (SystemHelpSettingModel.this.kUE != null) {
                SystemHelpSettingModel.this.kUE.callback(MoreModel.TaskType.DO_CACHE_CLEAR);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().deleteDatabase();
            com.baidu.tbadk.core.voice.a.b.aXo();
            try {
                m.wi("image");
                m.wi(TbConfig.IMAGE_CACHE_DIR_NAME);
                ap.aUT().aUU();
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class b extends BdAsyncTask<String, String, String> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            com.baidu.adp.lib.Disk.b bVar = new com.baidu.adp.lib.Disk.b();
            String checkDir = bVar.checkDir("image", true, false, true);
            String cacheDir = m.getCacheDir();
            String str = cacheDir + "voice";
            long fileSize = m.getFileSize(cacheDir + "tieba_database.db") + m.getDirectorySize(checkDir, false) + m.getDirectorySize(str, false) + m.getDirectorySize(bVar.checkDir(TbConfig.IMAGE_CACHE_DIR_NAME, true, false, true), false);
            float f = 0.0f + ((float) fileSize);
            if (fileSize >= 10485.76d) {
                return String.format("%.2f", Float.valueOf(f / 1048576.0f)) + SystemHelpSettingModel.this.mContext.getString(R.string.mebibyte);
            }
            return "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((b) str);
            SystemHelpSettingModel.this.kUD = null;
            if (SystemHelpSettingModel.this.kUE != null) {
                SystemHelpSettingModel.this.kUE.callback(MoreModel.TaskType.GET_SIZE, str);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(BaseActivity.LoadDataCallBack loadDataCallBack) {
        this.kUE = loadDataCallBack;
    }
}
