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
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StorageFile;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.more.SystemHelpSettingActivity;
/* loaded from: classes5.dex */
public class SystemHelpSettingModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f20485e;

    /* renamed from: f  reason: collision with root package name */
    public c f20486f;

    /* renamed from: g  reason: collision with root package name */
    public Context f20487g;

    /* renamed from: h  reason: collision with root package name */
    public BaseActivity.LoadDataCallBack f20488h;

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().b();
            d.a.m0.r.g0.b.b.a();
            try {
                FileHelper.clearCacheDir("image");
                FileHelper.clearCacheDir("images");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921549));
                StorageFile.getInstance().clearBubbleCache();
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((b) str);
            SystemHelpSettingModel.this.f20485e = null;
            if (SystemHelpSettingModel.this.f20488h != null) {
                SystemHelpSettingModel.this.f20488h.callback(MoreModel.TaskType.DO_CACHE_CLEAR);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<String, String, String> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            d.a.c.e.a.b bVar = new d.a.c.e.a.b();
            String a2 = bVar.a("image", true, false, true);
            String cacheDir = FileHelper.getCacheDir();
            String a3 = bVar.a("images", true, false, true);
            long directorySize = FileHelper.getDirectorySize(a2, false);
            long directorySize2 = directorySize + FileHelper.getDirectorySize(cacheDir + "voice", false) + FileHelper.getFileSize(cacheDir + TbConfig.TMP_DATABASE_NAME) + FileHelper.getDirectorySize(a3, false) + ((Long) MessageManager.getInstance().runTask(2921548, Long.class).getData()).longValue();
            float f2 = ((float) directorySize2) + 0.0f;
            if (directorySize2 >= 10485.76d) {
                return String.format("%.2f", Float.valueOf(f2 / 1048576.0f)) + SystemHelpSettingModel.this.f20487g.getString(R.string.mebibyte);
            }
            return "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            SystemHelpSettingModel.this.f20486f = null;
            if (SystemHelpSettingModel.this.f20488h != null) {
                SystemHelpSettingModel.this.f20488h.callback(MoreModel.TaskType.GET_SIZE, str);
            }
        }
    }

    public SystemHelpSettingModel(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.f20485e = null;
        this.f20486f = null;
        this.f20487g = null;
        this.f20488h = null;
        this.f20487g = systemHelpSettingActivity.getPageContext().getPageActivity();
    }

    public void A() {
        if (this.f20485e == null) {
            b bVar = new b();
            this.f20485e = bVar;
            bVar.execute(new String[0]);
        }
    }

    public void B() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, currentAccount));
    }

    public void C() {
        if (this.f20486f == null) {
            c cVar = new c();
            this.f20486f = cVar;
            cVar.execute(new String[0]);
        }
    }

    public void D(boolean z) {
        TbadkCoreApplication.getInst().setHeadsetModeOn(z);
    }

    public void E(BaseActivity.LoadDataCallBack loadDataCallBack) {
        this.f20488h = loadDataCallBack;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
