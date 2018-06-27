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
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes.dex */
public class b {
    private static b gSK;
    private ClientConfigModel gSI;
    private a gSJ;
    private boolean gSL = false;
    private final com.baidu.tbadk.clientConfig.a abY = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void B(Object obj) {
            b.this.gSL = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.um("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.um("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.um("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.mV(true);
                        TbadkSettings.getInst().saveLong(b.this.um("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.gSL = false;
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jD() && b.this.bzM()) {
                b.this.bzL();
            }
        }
    };
    private CustomMessageListener bwT = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.bzM()) {
                b.this.mV(true);
                b.this.bzL();
            }
        }
    };

    public static b bzK() {
        if (gSK == null) {
            synchronized (b.class) {
                if (gSK == null) {
                    gSK = new b();
                }
            }
        }
        return gSK;
    }

    private b() {
    }

    public void e(BaseFragmentActivity baseFragmentActivity) {
        this.gSJ = new a();
        baseFragmentActivity.registerListener(this.gSJ);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.bwT);
        this.gSI = new ClientConfigModel(baseFragmentActivity, this.abY);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bzM()) {
            mV(true);
            bzL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzL() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.S(TbadkSettings.getInst().loadLong(um("remind_recommend_data_time"), 0L))) {
            bzN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzM() {
        if (!TbadkCoreApplication.isLogin()) {
            mV(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bzJ()) {
            mV(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bqf()) {
            mV(false);
            return false;
        } else {
            return true;
        }
    }

    public String um(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void bzN() {
        if (this.gSI != null && !this.gSL) {
            this.gSL = true;
            this.gSI.cZ("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mV(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.bzI() + 86400000, 86400000L, broadcast);
        } else {
            alarmManager.cancel(broadcast);
        }
    }

    /* loaded from: classes.dex */
    private class a extends CustomMessageListener {
        public a() {
            super(2001011);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null && !data.booleanValue()) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.bzM()) {
                    b.this.mV(true);
                    b.this.bzL();
                }
            }
        }
    }
}
