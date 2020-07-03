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
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.clientConfig.ClientConfigModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes9.dex */
public class b {
    private static b lML;
    private ClientConfigModel lMJ;
    private a lMK;
    private boolean lMM = false;
    private final com.baidu.tbadk.clientConfig.a dFl = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void al(Object obj) {
            b.this.lMM = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.ND(SharedPrefConfig.REMIND_RECOMMEND_INFO), c);
                        TbadkSettings.getInst().saveInt(b.this.ND(SharedPrefConfig.REMIND_RECOMMEND_SERVER_SWITCH), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.ND(SharedPrefConfig.REMIND_RECOMMEND_DLALOG_TIME), dataRes.local_dialog.time);
                        b.this.uW(true);
                        TbadkSettings.getInst().saveLong(b.this.ND(SharedPrefConfig.REMIND_RECOMMEND_DATA_TIME), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.lMM = false;
        }
    };
    CustomMessageListener Ny = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable() && b.this.dkp()) {
                b.this.dko();
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.dkp()) {
                b.this.uW(true);
                b.this.dko();
            }
        }
    };

    public static b dkn() {
        if (lML == null) {
            synchronized (b.class) {
                if (lML == null) {
                    lML = new b();
                }
            }
        }
        return lML;
    }

    private b() {
    }

    public void f(BaseFragmentActivity baseFragmentActivity) {
        this.lMK = new a();
        baseFragmentActivity.registerListener(this.lMK);
        baseFragmentActivity.registerListener(this.Ny);
        baseFragmentActivity.registerListener(this.mAccountChangedListener);
        this.lMJ = new ClientConfigModel(baseFragmentActivity, this.dFl);
        com.baidu.tbadk.core.sharedPref.b.aVP().putLong(SharedPrefConfig.TIEBA_LAST_ACTIVE_TIME, System.currentTimeMillis());
        if (dkp()) {
            uW(true);
            dko();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dko() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.isTaday(TbadkSettings.getInst().loadLong(ND(SharedPrefConfig.REMIND_RECOMMEND_DATA_TIME), 0L)) && !TbadkCoreApplication.getInst().checkInterrupt()) {
            dkq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dkp() {
        if (!TbadkCoreApplication.isLogin()) {
            uW(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.dkm()) {
            uW(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.daD()) {
            uW(false);
            return false;
        } else {
            return true;
        }
    }

    public String ND(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void dkq() {
        if (this.lMJ != null && !this.lMM) {
            this.lMM = true;
            this.lMJ.vy("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uW(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.dkl() + 86400000, 86400000L, broadcast);
        } else {
            alarmManager.cancel(broadcast);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public a() {
            super(CmdConfigCustom.CMD_BACKGROUND_SWTICH);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null && !data.booleanValue()) {
                com.baidu.tbadk.core.sharedPref.b.aVP().putLong(SharedPrefConfig.TIEBA_LAST_ACTIVE_TIME, System.currentTimeMillis());
                if (b.this.dkp()) {
                    b.this.uW(true);
                    b.this.dko();
                }
            }
        }
    }
}
