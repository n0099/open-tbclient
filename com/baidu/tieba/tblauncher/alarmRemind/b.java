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
    private static b iMW;
    private ClientConfigModel iMU;
    private a iMV;
    private boolean iMX = false;
    private final com.baidu.tbadk.clientConfig.a buD = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void aa(Object obj) {
            b.this.iMX = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.Dd("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.Dd("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.Dd("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.qo(true);
                        TbadkSettings.getInst().saveLong(b.this.Dd("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.iMX = false;
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kY() && b.this.cgQ()) {
                b.this.cgP();
            }
        }
    };
    private CustomMessageListener dgB = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.cgQ()) {
                b.this.qo(true);
                b.this.cgP();
            }
        }
    };

    public static b cgO() {
        if (iMW == null) {
            synchronized (b.class) {
                if (iMW == null) {
                    iMW = new b();
                }
            }
        }
        return iMW;
    }

    private b() {
    }

    public void e(BaseFragmentActivity baseFragmentActivity) {
        this.iMV = new a();
        baseFragmentActivity.registerListener(this.iMV);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.dgB);
        this.iMU = new ClientConfigModel(baseFragmentActivity, this.buD);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (cgQ()) {
            qo(true);
            cgP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgP() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.aM(TbadkSettings.getInst().loadLong(Dd("remind_recommend_data_time"), 0L))) {
            cgR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cgQ() {
        if (!TbadkCoreApplication.isLogin()) {
            qo(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.cgN()) {
            qo(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bYh()) {
            qo(false);
            return false;
        } else {
            return true;
        }
    }

    public String Dd(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void cgR() {
        if (this.iMU != null && !this.iMX) {
            this.iMX = true;
            this.iMU.kQ("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qo(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.cgM() + 86400000, 86400000L, broadcast);
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
                if (b.this.cgQ()) {
                    b.this.qo(true);
                    b.this.cgP();
                }
            }
        }
    }
}
