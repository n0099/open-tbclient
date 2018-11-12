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
/* loaded from: classes5.dex */
public class b {
    private static b hkz;
    private ClientConfigModel hkx;
    private a hky;
    private boolean hkA = false;
    private final com.baidu.tbadk.clientConfig.a ajP = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void G(Object obj) {
            b.this.hkA = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.vE("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.vE("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.vE("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.nI(true);
                        TbadkSettings.getInst().saveLong(b.this.vE("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.hkA = false;
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kV() && b.this.bDM()) {
                b.this.bDL();
            }
        }
    };
    private CustomMessageListener bMF = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.bDM()) {
                b.this.nI(true);
                b.this.bDL();
            }
        }
    };

    public static b bDK() {
        if (hkz == null) {
            synchronized (b.class) {
                if (hkz == null) {
                    hkz = new b();
                }
            }
        }
        return hkz;
    }

    private b() {
    }

    public void e(BaseFragmentActivity baseFragmentActivity) {
        this.hky = new a();
        baseFragmentActivity.registerListener(this.hky);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.bMF);
        this.hkx = new ClientConfigModel(baseFragmentActivity, this.ajP);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bDM()) {
            nI(true);
            bDL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDL() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.ac(TbadkSettings.getInst().loadLong(vE("remind_recommend_data_time"), 0L))) {
            bDN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bDM() {
        if (!TbadkCoreApplication.isLogin()) {
            nI(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bDJ()) {
            nI(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bud()) {
            nI(false);
            return false;
        } else {
            return true;
        }
    }

    public String vE(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void bDN() {
        if (this.hkx != null && !this.hkA) {
            this.hkA = true;
            this.hkx.dF("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nI(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.bDI() + 86400000, 86400000L, broadcast);
        } else {
            alarmManager.cancel(broadcast);
        }
    }

    /* loaded from: classes5.dex */
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
                if (b.this.bDM()) {
                    b.this.nI(true);
                    b.this.bDL();
                }
            }
        }
    }
}
