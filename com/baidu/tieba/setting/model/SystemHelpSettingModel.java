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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.more.SystemHelpSettingActivity;
/* loaded from: classes3.dex */
public class SystemHelpSettingModel extends BdBaseModel {
    private a gLX;
    private b gLY;
    private BaseActivity.LoadDataCallBack gLZ;
    private Context mContext;

    public SystemHelpSettingModel(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.gLX = null;
        this.gLY = null;
        this.mContext = null;
        this.gLZ = null;
        this.mContext = systemHelpSettingActivity.getPageContext().getPageActivity();
    }

    public void bqe() {
        if (this.gLX == null) {
            this.gLX = new a();
            this.gLX.execute(new String[0]);
        }
    }

    public void bqf() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, currentAccount));
        }
    }

    public void bqg() {
        if (this.gLY == null) {
            this.gLY = new b();
            this.gLY.execute(new String[0]);
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
            SystemHelpSettingModel.this.gLX = null;
            if (SystemHelpSettingModel.this.gLZ != null) {
                SystemHelpSettingModel.this.gLZ.callback(MoreModel.TaskType.DO_CACHE_CLEAR);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().jO();
            com.baidu.tbadk.core.voice.a.b.EO();
            try {
                al.CY().CZ();
                al.CY().Da();
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
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            String BV = k.BV();
            String str = BV + "voice";
            long dV = k.dV(BV + TbConfig.TMP_DATABASE_NAME) + k.h(str, false) + k.h(BV + "image", false) + k.h(TbConfig.IMAGE_CACHE_DIR_NAME, false);
            float f = 0.0f + ((float) dV);
            if (dV >= 10485.76d) {
                return String.format("%.2f", Float.valueOf(f / 1048576.0f)) + SystemHelpSettingModel.this.mContext.getString(d.j.mebibyte);
            }
            return "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((b) str);
            SystemHelpSettingModel.this.gLY = null;
            if (SystemHelpSettingModel.this.gLZ != null) {
                SystemHelpSettingModel.this.gLZ.callback(MoreModel.TaskType.GET_SIZE, str);
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
        this.gLZ = loadDataCallBack;
    }
}
