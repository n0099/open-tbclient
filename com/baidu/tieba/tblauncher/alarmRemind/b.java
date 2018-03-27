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
    private static b hgc;
    private ClientConfigModel hga;
    private a hgb;
    private boolean hgd = false;
    private final com.baidu.tbadk.clientConfig.a aIw = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void aD(Object obj) {
            b.this.hgd = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.ti("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.ti("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.ti("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.nb(true);
                        TbadkSettings.getInst().saveLong(b.this.ti("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.hgd = false;
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.oJ() && b.this.bzb()) {
                b.this.bza();
            }
        }
    };
    private CustomMessageListener cde = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.bzb()) {
                b.this.nb(true);
                b.this.bza();
            }
        }
    };

    public static b byZ() {
        if (hgc == null) {
            synchronized (b.class) {
                if (hgc == null) {
                    hgc = new b();
                }
            }
        }
        return hgc;
    }

    private b() {
    }

    public void i(BaseFragmentActivity baseFragmentActivity) {
        this.hgb = new a();
        baseFragmentActivity.registerListener(this.hgb);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.cde);
        this.hga = new ClientConfigModel(baseFragmentActivity, this.aIw);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bzb()) {
            nb(true);
            bza();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bza() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.W(TbadkSettings.getInst().loadLong(ti("remind_recommend_data_time"), 0L))) {
            bzc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzb() {
        if (!TbadkCoreApplication.isLogin()) {
            nb(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.byY()) {
            nb(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bpA()) {
            nb(false);
            return false;
        } else {
            return true;
        }
    }

    public String ti(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void bzc() {
        if (this.hga != null && !this.hgd) {
            this.hgd = true;
            this.hga.cG("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nb(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.byX() + 86400000, 86400000L, broadcast);
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
                if (b.this.bzb()) {
                    b.this.nb(true);
                    b.this.bza();
                }
            }
        }
    }
}
