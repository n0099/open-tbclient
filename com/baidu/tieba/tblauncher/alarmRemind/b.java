package com.baidu.tieba.tblauncher.alarmRemind;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.clientConfig.ClientConfigModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes.dex */
public class b {
    private static b hdC;
    private ClientConfigModel hdA;
    private a hdB;
    private boolean hdD = false;
    private final com.baidu.tbadk.clientConfig.a aHm = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void aD(Object obj) {
            b.this.hdD = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.ta("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.ta("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.ta("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.mO(true);
                        TbadkSettings.getInst().saveLong(b.this.ta("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.hdD = false;
        }
    };
    private final CustomMessageListener hdE = new CustomMessageListener(CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001356 && b.this.bxN()) {
                b.this.mO(true);
                b.this.bxM();
            }
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.oJ() && b.this.bxN()) {
                b.this.bxM();
            }
        }
    };
    private CustomMessageListener dOv = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.bxN()) {
                b.this.mO(true);
                b.this.bxM();
            }
        }
    };

    public static b bxL() {
        if (hdC == null) {
            synchronized (b.class) {
                if (hdC == null) {
                    hdC = new b();
                }
            }
        }
        return hdC;
    }

    private b() {
    }

    public void i(BaseFragmentActivity baseFragmentActivity) {
        this.hdB = new a();
        baseFragmentActivity.registerListener(this.hdB);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.hdE);
        baseFragmentActivity.registerListener(this.dOv);
        this.hdA = new ClientConfigModel(baseFragmentActivity, this.aHm);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bxN()) {
            mO(true);
            bxM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxM() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.W(TbadkSettings.getInst().loadLong(ta("remind_recommend_data_time"), 0L))) {
            bxO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bxN() {
        if (!TbadkCoreApplication.isLogin()) {
            mO(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bxK()) {
            mO(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.b.GE().GX()) {
            mO(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bod()) {
            mO(false);
            return false;
        } else {
            return true;
        }
    }

    public String ta(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void bxO() {
        if (this.hdA != null && !this.hdD) {
            this.hdD = true;
            this.hdA.cv("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mO(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.bxJ() + 86400000, 86400000L, broadcast);
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
                if (b.this.bxN()) {
                    b.this.mO(true);
                    b.this.bxM();
                }
            }
        }
    }
}
