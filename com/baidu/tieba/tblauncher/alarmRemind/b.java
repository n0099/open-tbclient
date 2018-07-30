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
    private static b gTI;
    private ClientConfigModel gTG;
    private a gTH;
    private boolean gTJ = false;
    private final com.baidu.tbadk.clientConfig.a abC = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void B(Object obj) {
            b.this.gTJ = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.uk("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.uk("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.uk("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.mG(true);
                        TbadkSettings.getInst().saveLong(b.this.uk("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.gTJ = false;
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jE() && b.this.byp()) {
                b.this.byo();
            }
        }
    };
    private CustomMessageListener bxy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.byp()) {
                b.this.mG(true);
                b.this.byo();
            }
        }
    };

    public static b byn() {
        if (gTI == null) {
            synchronized (b.class) {
                if (gTI == null) {
                    gTI = new b();
                }
            }
        }
        return gTI;
    }

    private b() {
    }

    public void e(BaseFragmentActivity baseFragmentActivity) {
        this.gTH = new a();
        baseFragmentActivity.registerListener(this.gTH);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.bxy);
        this.gTG = new ClientConfigModel(baseFragmentActivity, this.abC);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (byp()) {
            mG(true);
            byo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byo() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.U(TbadkSettings.getInst().loadLong(uk("remind_recommend_data_time"), 0L))) {
            byq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean byp() {
        if (!TbadkCoreApplication.isLogin()) {
            mG(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bym()) {
            mG(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.boK()) {
            mG(false);
            return false;
        } else {
            return true;
        }
    }

    public String uk(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void byq() {
        if (this.gTG != null && !this.gTJ) {
            this.gTJ = true;
            this.gTG.cW("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mG(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.byl() + 86400000, 86400000L, broadcast);
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
                if (b.this.byp()) {
                    b.this.mG(true);
                    b.this.byo();
                }
            }
        }
    }
}
