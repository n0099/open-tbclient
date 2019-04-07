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
/* loaded from: classes4.dex */
public class b {
    private static b iMC;
    private ClientConfigModel iMA;
    private a iMB;
    private boolean iMD = false;
    private final com.baidu.tbadk.clientConfig.a buI = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void Y(Object obj) {
            b.this.iMD = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.Da("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.Da("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.Da("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.qo(true);
                        TbadkSettings.getInst().saveLong(b.this.Da("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.iMD = false;
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kY() && b.this.cgR()) {
                b.this.cgQ();
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.cgR()) {
                b.this.qo(true);
                b.this.cgQ();
            }
        }
    };

    public static b cgP() {
        if (iMC == null) {
            synchronized (b.class) {
                if (iMC == null) {
                    iMC = new b();
                }
            }
        }
        return iMC;
    }

    private b() {
    }

    public void e(BaseFragmentActivity baseFragmentActivity) {
        this.iMB = new a();
        baseFragmentActivity.registerListener(this.iMB);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.mAccountChangedListener);
        this.iMA = new ClientConfigModel(baseFragmentActivity, this.buI);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (cgR()) {
            qo(true);
            cgQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgQ() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.aM(TbadkSettings.getInst().loadLong(Da("remind_recommend_data_time"), 0L))) {
            cgS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cgR() {
        if (!TbadkCoreApplication.isLogin()) {
            qo(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.cgO()) {
            qo(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bYf()) {
            qo(false);
            return false;
        } else {
            return true;
        }
    }

    public String Da(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void cgS() {
        if (this.iMA != null && !this.iMD) {
            this.iMD = true;
            this.iMA.kR("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qo(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.cgN() + 86400000, 86400000L, broadcast);
        } else {
            alarmManager.cancel(broadcast);
        }
    }

    /* loaded from: classes4.dex */
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
                if (b.this.cgR()) {
                    b.this.qo(true);
                    b.this.cgQ();
                }
            }
        }
    }
}
