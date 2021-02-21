package com.baidu.tieba.tblauncher.alarmRemind;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
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
/* loaded from: classes.dex */
public class b {
    private static b nEH;
    private ClientConfigModel nEF;
    private a nEG;
    private boolean nEI = false;
    private final com.baidu.tbadk.clientConfig.a eJp = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void at(Object obj) {
            b.this.nEI = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.Uc(SharedPrefConfig.REMIND_RECOMMEND_INFO), c);
                        TbadkSettings.getInst().saveInt(b.this.Uc(SharedPrefConfig.REMIND_RECOMMEND_SERVER_SWITCH), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.Uc(SharedPrefConfig.REMIND_RECOMMEND_DLALOG_TIME), dataRes.local_dialog.time);
                        b.this.yN(true);
                        TbadkSettings.getInst().saveLong(b.this.Uc(SharedPrefConfig.REMIND_RECOMMEND_DATA_TIME), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.nEI = false;
        }
    };
    CustomMessageListener PM = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable() && b.this.dQC()) {
                b.this.dQB();
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.dQC()) {
                b.this.yN(true);
                b.this.dQB();
            }
        }
    };

    public static b dQA() {
        if (nEH == null) {
            synchronized (b.class) {
                if (nEH == null) {
                    nEH = new b();
                }
            }
        }
        return nEH;
    }

    private b() {
    }

    public void f(BaseFragmentActivity baseFragmentActivity) {
        this.nEG = new a();
        baseFragmentActivity.registerListener(this.nEG);
        baseFragmentActivity.registerListener(this.PM);
        baseFragmentActivity.registerListener(this.mAccountChangedListener);
        this.nEF = new ClientConfigModel(baseFragmentActivity, this.eJp);
        com.baidu.tbadk.core.sharedPref.b.brQ().putLong(SharedPrefConfig.TIEBA_LAST_ACTIVE_TIME, System.currentTimeMillis());
        if (dQC()) {
            yN(true);
            dQB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQB() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.isTaday(TbadkSettings.getInst().loadLong(Uc(SharedPrefConfig.REMIND_RECOMMEND_DATA_TIME), 0L)) && !TbadkCoreApplication.getInst().checkInterrupt()) {
            dQD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dQC() {
        if (!TbadkCoreApplication.isLogin()) {
            yN(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.dQz()) {
            yN(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.dFq()) {
            yN(false);
            return false;
        } else {
            return true;
        }
    }

    public String Uc(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void dQD() {
        if (this.nEF != null && !this.nEI) {
            this.nEI = true;
            this.nEF.zG("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yN(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.dQy() + 86400000, 86400000L, broadcast);
        } else {
            alarmManager.cancel(broadcast);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends CustomMessageListener {
        public a() {
            super(CmdConfigCustom.CMD_BACKGROUND_SWTICH);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null && !data.booleanValue()) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putLong(SharedPrefConfig.TIEBA_LAST_ACTIVE_TIME, System.currentTimeMillis());
                if (b.this.dQC()) {
                    b.this.yN(true);
                    b.this.dQB();
                }
            }
        }
    }
}
