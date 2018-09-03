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
    private static b gTK;
    private ClientConfigModel gTI;
    private a gTJ;
    private boolean gTL = false;
    private final com.baidu.tbadk.clientConfig.a abD = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void B(Object obj) {
            b.this.gTL = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.uo("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.uo("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.uo("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.mG(true);
                        TbadkSettings.getInst().saveLong(b.this.uo("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.gTL = false;
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jE() && b.this.byr()) {
                b.this.byq();
            }
        }
    };
    private CustomMessageListener bxA = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.byr()) {
                b.this.mG(true);
                b.this.byq();
            }
        }
    };

    public static b byp() {
        if (gTK == null) {
            synchronized (b.class) {
                if (gTK == null) {
                    gTK = new b();
                }
            }
        }
        return gTK;
    }

    private b() {
    }

    public void e(BaseFragmentActivity baseFragmentActivity) {
        this.gTJ = new a();
        baseFragmentActivity.registerListener(this.gTJ);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.bxA);
        this.gTI = new ClientConfigModel(baseFragmentActivity, this.abD);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (byr()) {
            mG(true);
            byq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byq() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.U(TbadkSettings.getInst().loadLong(uo("remind_recommend_data_time"), 0L))) {
            bys();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean byr() {
        if (!TbadkCoreApplication.isLogin()) {
            mG(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.byo()) {
            mG(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.boL()) {
            mG(false);
            return false;
        } else {
            return true;
        }
    }

    public String uo(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void bys() {
        if (this.gTI != null && !this.gTL) {
            this.gTL = true;
            this.gTI.cX("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mG(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.byn() + 86400000, 86400000L, broadcast);
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
                if (b.this.byr()) {
                    b.this.mG(true);
                    b.this.byq();
                }
            }
        }
    }
}
