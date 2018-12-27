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
    private static b huX;
    private ClientConfigModel huV;
    private a huW;
    private boolean huY = false;
    private final com.baidu.tbadk.clientConfig.a anr = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void G(Object obj) {
            b.this.huY = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.wk("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.wk("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.wk("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.nN(true);
                        TbadkSettings.getInst().saveLong(b.this.wk("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.huY = false;
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kV() && b.this.bGF()) {
                b.this.bGE();
            }
        }
    };
    private CustomMessageListener bQy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.bGF()) {
                b.this.nN(true);
                b.this.bGE();
            }
        }
    };

    public static b bGD() {
        if (huX == null) {
            synchronized (b.class) {
                if (huX == null) {
                    huX = new b();
                }
            }
        }
        return huX;
    }

    private b() {
    }

    public void e(BaseFragmentActivity baseFragmentActivity) {
        this.huW = new a();
        baseFragmentActivity.registerListener(this.huW);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.bQy);
        this.huV = new ClientConfigModel(baseFragmentActivity, this.anr);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bGF()) {
            nN(true);
            bGE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGE() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.ak(TbadkSettings.getInst().loadLong(wk("remind_recommend_data_time"), 0L))) {
            bGG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bGF() {
        if (!TbadkCoreApplication.isLogin()) {
            nN(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bGC()) {
            nN(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bwJ()) {
            nN(false);
            return false;
        } else {
            return true;
        }
    }

    public String wk(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void bGG() {
        if (this.huV != null && !this.huY) {
            this.huY = true;
            this.huV.dX("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nN(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.bGB() + 86400000, 86400000L, broadcast);
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
                if (b.this.bGF()) {
                    b.this.nN(true);
                    b.this.bGE();
                }
            }
        }
    }
}
