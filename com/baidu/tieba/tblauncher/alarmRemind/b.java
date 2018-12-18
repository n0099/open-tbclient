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
    private static b hrL;
    private ClientConfigModel hrJ;
    private a hrK;
    private boolean hrM = false;
    private final com.baidu.tbadk.clientConfig.a anr = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void G(Object obj) {
            b.this.hrM = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.wh("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.wh("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.wh("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.nK(true);
                        TbadkSettings.getInst().saveLong(b.this.wh("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.hrM = false;
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kV() && b.this.bFP()) {
                b.this.bFO();
            }
        }
    };
    private CustomMessageListener bQv = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.bFP()) {
                b.this.nK(true);
                b.this.bFO();
            }
        }
    };

    public static b bFN() {
        if (hrL == null) {
            synchronized (b.class) {
                if (hrL == null) {
                    hrL = new b();
                }
            }
        }
        return hrL;
    }

    private b() {
    }

    public void e(BaseFragmentActivity baseFragmentActivity) {
        this.hrK = new a();
        baseFragmentActivity.registerListener(this.hrK);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.bQv);
        this.hrJ = new ClientConfigModel(baseFragmentActivity, this.anr);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bFP()) {
            nK(true);
            bFO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFO() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.aj(TbadkSettings.getInst().loadLong(wh("remind_recommend_data_time"), 0L))) {
            bFQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bFP() {
        if (!TbadkCoreApplication.isLogin()) {
            nK(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bFM()) {
            nK(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bvV()) {
            nK(false);
            return false;
        } else {
            return true;
        }
    }

    public String wh(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void bFQ() {
        if (this.hrJ != null && !this.hrM) {
            this.hrM = true;
            this.hrJ.dX("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nK(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.bFL() + 86400000, 86400000L, broadcast);
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
                if (b.this.bFP()) {
                    b.this.nK(true);
                    b.this.bFO();
                }
            }
        }
    }
}
