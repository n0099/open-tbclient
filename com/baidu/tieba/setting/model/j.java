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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.more.SystemHelpSettingActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.e {
    private a dJb;
    private b dJc;
    private BaseActivity.LoadDataCallBack dJd;
    private Context mContext;

    public j(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.dJb = null;
        this.dJc = null;
        this.mContext = null;
        this.dJd = null;
        this.mContext = systemHelpSettingActivity.getPageContext().getPageActivity();
    }

    public void aGE() {
        if (this.dJb == null) {
            this.dJb = new a(this, null);
            this.dJb.execute(new String[0]);
        }
    }

    public void aGF() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, currentAccount));
        }
    }

    public void aGG() {
        if (this.dJc == null) {
            this.dJc = new b(this, null);
            this.dJc.execute(new String[0]);
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
        /* renamed from: ek */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            j.this.dJb = null;
            if (j.this.dJd == null) {
                return;
            }
            j.this.dJd.callback(MoreModel.TaskType.DO_CACHE_CLEAR);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public String doInBackground(String... strArr) {
            TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().dQ();
            com.baidu.tbadk.core.voice.a.b.xy();
            try {
                av.vZ().wa();
                av.vZ().wb();
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
        /* renamed from: h */
        public String doInBackground(String... strArr) {
            String uW = m.uW();
            long l = m.l(TbConfig.IMAGE_CACHE_DIR_NAME, false) + m.l(String.valueOf(uW) + TbConfig.TMP_PIC_DIR_NAME, false) + m.l(String.valueOf(uW) + "voice", false) + m.da(String.valueOf(uW) + TbConfig.TMP_DATABASE_NAME);
            float f = 0.0f + ((float) l);
            if (l < 10485.76d) {
                return "";
            }
            return String.valueOf(String.format("%.2f", Float.valueOf(f / 1048576.0f))) + j.this.mContext.getString(t.j.mebibyte);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ek */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            j.this.dJc = null;
            if (j.this.dJd == null) {
                return;
            }
            j.this.dJd.callback(MoreModel.TaskType.GET_SIZE, str);
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
        this.dJd = loadDataCallBack;
    }
}
