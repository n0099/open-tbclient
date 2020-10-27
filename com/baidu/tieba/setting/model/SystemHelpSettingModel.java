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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.more.SystemHelpSettingActivity;
/* loaded from: classes26.dex */
public class SystemHelpSettingModel extends BdBaseModel {
    private Context mContext;
    private a mzP;
    private b mzQ;
    private BaseActivity.LoadDataCallBack mzR;

    public SystemHelpSettingModel(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.mzP = null;
        this.mzQ = null;
        this.mContext = null;
        this.mzR = null;
        this.mContext = systemHelpSettingActivity.getPageContext().getPageActivity();
    }

    public void cli() {
        if (this.mzP == null) {
            this.mzP = new a();
            this.mzP.execute(new String[0]);
        }
    }

    public void dAT() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, currentAccount));
        }
    }

    public void dAU() {
        if (this.mzQ == null) {
            this.mzQ = new b();
            this.mzQ.execute(new String[0]);
        }
    }

    public void setHeadsetModeOn(boolean z) {
        TbadkCoreApplication.getInst().setHeadsetModeOn(z);
    }

    /* loaded from: classes26.dex */
    private class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            SystemHelpSettingModel.this.mzP = null;
            if (SystemHelpSettingModel.this.mzR != null) {
                SystemHelpSettingModel.this.mzR.callback(MoreModel.TaskType.DO_CACHE_CLEAR);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().deleteDatabase();
            com.baidu.tbadk.core.voice.a.b.brv();
            try {
                n.Bv("image");
                n.Bv(TbConfig.IMAGE_CACHE_DIR_NAME);
                as.boL().boM();
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
    }

    /* loaded from: classes26.dex */
    private class b extends BdAsyncTask<String, String, String> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            com.baidu.adp.lib.Disk.b bVar = new com.baidu.adp.lib.Disk.b();
            String checkDir = bVar.checkDir("image", true, false, true);
            String cacheDir = n.getCacheDir();
            String str = cacheDir + "voice";
            long fileSize = n.getFileSize(cacheDir + "tieba_database.db") + n.getDirectorySize(checkDir, false) + n.getDirectorySize(str, false) + n.getDirectorySize(bVar.checkDir(TbConfig.IMAGE_CACHE_DIR_NAME, true, false, true), false);
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
            SystemHelpSettingModel.this.mzQ = null;
            if (SystemHelpSettingModel.this.mzR != null) {
                SystemHelpSettingModel.this.mzR.callback(MoreModel.TaskType.GET_SIZE, str);
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
        this.mzR = loadDataCallBack;
    }
}
