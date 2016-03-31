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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.more.SystemHelpSettingActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.e {
    private a ebv;
    private b ebw;
    private BaseActivity.LoadDataCallBack ebx;
    private Context mContext;

    public k(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.ebv = null;
        this.ebw = null;
        this.mContext = null;
        this.ebx = null;
        this.mContext = systemHelpSettingActivity.getPageContext().getPageActivity();
    }

    public void aNo() {
        if (this.ebv == null) {
            this.ebv = new a(this, null);
            this.ebv.execute(new String[0]);
        }
    }

    public void aNp() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, currentAccount));
        }
    }

    public void aNq() {
        if (this.ebw == null) {
            this.ebw = new b(this, null);
            this.ebw.execute(new String[0]);
        }
    }

    public void setHeadsetModeOn(boolean z) {
        TbadkCoreApplication.m411getInst().setHeadsetModeOn(z);
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* synthetic */ a(k kVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: er */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            k.this.ebv = null;
            if (k.this.ebx == null) {
                return;
            }
            k.this.ebx.callback(MoreModel.TaskType.DO_CACHE_CLEAR);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public String doInBackground(String... strArr) {
            TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().dQ();
            com.baidu.tbadk.core.voice.a.b.xZ();
            try {
                ax.ws().wt();
                ax.ws().wu();
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

        /* synthetic */ b(k kVar, b bVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public String doInBackground(String... strArr) {
            String vs = m.vs();
            long k = m.k(TbConfig.IMAGE_CACHE_DIR_NAME, false) + m.k(String.valueOf(vs) + TbConfig.TMP_PIC_DIR_NAME, false) + m.k(String.valueOf(vs) + "voice", false) + m.de(String.valueOf(vs) + TbConfig.TMP_DATABASE_NAME);
            float f = 0.0f + ((float) k);
            if (k < 10485.76d) {
                return "";
            }
            return String.valueOf(String.format("%.2f", Float.valueOf(f / 1048576.0f))) + k.this.mContext.getString(t.j.mebibyte);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: er */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            k.this.ebw = null;
            if (k.this.ebx == null) {
                return;
            }
            k.this.ebx.callback(MoreModel.TaskType.GET_SIZE, str);
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
        this.ebx = loadDataCallBack;
    }
}
