package com.baidu.tieba.setting.model;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.f;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.more.SystemHelpSettingActivity;
/* loaded from: classes3.dex */
public class SystemHelpSettingModel extends BdBaseModel {
    private a gyB;
    private b gyC;
    private BaseActivity.LoadDataCallBack gyD;
    private Context mContext;

    public SystemHelpSettingModel(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.gyB = null;
        this.gyC = null;
        this.mContext = null;
        this.gyD = null;
        this.mContext = systemHelpSettingActivity.getPageContext().getPageActivity();
    }

    public void bpp() {
        if (this.gyB == null) {
            this.gyB = new a();
            this.gyB.execute(new String[0]);
        }
    }

    public void bpq() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, currentAccount));
        }
    }

    public void bpr() {
        if (this.gyC == null) {
            this.gyC = new b();
            this.gyC.execute(new String[0]);
        }
    }

    public void setHeadsetModeOn(boolean z) {
        TbadkCoreApplication.getInst().setHeadsetModeOn(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            SystemHelpSettingModel.this.gyB = null;
            if (SystemHelpSettingModel.this.gyD != null) {
                SystemHelpSettingModel.this.gyD.callback(MoreModel.TaskType.DO_CACHE_CLEAR);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().eF();
            com.baidu.tbadk.core.voice.a.b.Bi();
            try {
                ao.zo().zp();
                ao.zo().zq();
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, String, String> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String yj = l.yj();
            String str = yj + "voice";
            long en = l.en(yj + TbConfig.TMP_DATABASE_NAME) + l.h(str, false) + l.h(yj + TbConfig.TMP_PIC_DIR_NAME, false) + l.h(TbConfig.IMAGE_CACHE_DIR_NAME, false);
            float f = 0.0f + ((float) en);
            if (en >= 10485.76d) {
                return String.format("%.2f", Float.valueOf(f / 1048576.0f)) + SystemHelpSettingModel.this.mContext.getString(f.j.mebibyte);
            }
            return "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((b) str);
            SystemHelpSettingModel.this.gyC = null;
            if (SystemHelpSettingModel.this.gyD != null) {
                SystemHelpSettingModel.this.gyD.callback(MoreModel.TaskType.GET_SIZE, str);
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
        this.gyD = loadDataCallBack;
    }
}
