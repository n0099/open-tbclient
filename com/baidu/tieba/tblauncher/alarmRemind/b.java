package com.baidu.tieba.tblauncher.alarmRemind;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.clientConfig.ClientConfigModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes.dex */
public class b {
    private static b gmD;
    private ClientConfigModel gmB;
    private a gmC;
    private boolean gmE = false;
    private final com.baidu.tbadk.clientConfig.a SF = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void z(Object obj) {
            b.this.gmE = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.sw("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.sw("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.sw("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.mJ(true);
                        TbadkSettings.getInst().saveLong(b.this.sw("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.gmE = false;
        }
    };
    private final CustomMessageListener gmF = new CustomMessageListener(CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001356 && b.this.buy()) {
                b.this.mJ(true);
                b.this.bux();
            }
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && i.hr() && b.this.buy()) {
                b.this.bux();
            }
        }
    };
    private CustomMessageListener dEn = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.buy()) {
                b.this.mJ(true);
                b.this.bux();
            }
        }
    };

    public static b buw() {
        if (gmD == null) {
            synchronized (b.class) {
                if (gmD == null) {
                    gmD = new b();
                }
            }
        }
        return gmD;
    }

    private b() {
    }

    public void g(BaseFragmentActivity baseFragmentActivity) {
        this.gmC = new a();
        baseFragmentActivity.registerListener(this.gmC);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.gmF);
        baseFragmentActivity.registerListener(this.dEn);
        this.gmB = new ClientConfigModel(baseFragmentActivity, this.SF);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (buy()) {
            mJ(true);
            bux();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bux() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.cV(TbadkSettings.getInst().loadLong(sw("remind_recommend_data_time"), 0L))) {
            buz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buy() {
        if (!TbadkCoreApplication.isLogin()) {
            mJ(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.buv()) {
            mJ(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.b.zw().zP()) {
            mJ(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.biQ()) {
            mJ(false);
            return false;
        } else {
            return true;
        }
    }

    public String sw(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void buz() {
        if (this.gmB != null && !this.gmE) {
            this.gmE = true;
            this.gmB.cq("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mJ(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.buu() + 86400000, 86400000L, broadcast);
        } else {
            alarmManager.cancel(broadcast);
        }
    }

    /* loaded from: classes.dex */
    private class a extends CustomMessageListener {
        public a() {
            super(CmdConfigCustom.CMD_BACKGROUND_SWTICH);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null && !data.booleanValue()) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.buy()) {
                    b.this.mJ(true);
                    b.this.bux();
                }
            }
        }
    }
}
