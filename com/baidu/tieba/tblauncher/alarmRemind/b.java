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
    private static b jfy;
    private ClientConfigModel jfw;
    private a jfx;
    private boolean jfz = false;
    private final com.baidu.tbadk.clientConfig.a bBM = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void aa(Object obj) {
            b.this.jfz = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.Ew("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.Ew("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.Ew("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.rd(true);
                        TbadkSettings.getInst().saveLong(b.this.Ew("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.jfz = false;
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jS() && b.this.coX()) {
                b.this.coW();
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.coX()) {
                b.this.rd(true);
                b.this.coW();
            }
        }
    };

    public static b coV() {
        if (jfy == null) {
            synchronized (b.class) {
                if (jfy == null) {
                    jfy = new b();
                }
            }
        }
        return jfy;
    }

    private b() {
    }

    public void e(BaseFragmentActivity baseFragmentActivity) {
        this.jfx = new a();
        baseFragmentActivity.registerListener(this.jfx);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.mAccountChangedListener);
        this.jfw = new ClientConfigModel(baseFragmentActivity, this.bBM);
        com.baidu.tbadk.core.sharedPref.b.agM().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (coX()) {
            rd(true);
            coW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coW() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.bb(TbadkSettings.getInst().loadLong(Ew("remind_recommend_data_time"), 0L)) && !TbadkCoreApplication.getInst().checkInterrupt()) {
            coY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean coX() {
        if (!TbadkCoreApplication.isLogin()) {
            rd(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.coU()) {
            rd(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.cgm()) {
            rd(false);
            return false;
        } else {
            return true;
        }
    }

    public String Ew(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void coY() {
        if (this.jfw != null && !this.jfz) {
            this.jfz = true;
            this.jfw.lW("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rd(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.coT() + 86400000, 86400000L, broadcast);
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
                com.baidu.tbadk.core.sharedPref.b.agM().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.coX()) {
                    b.this.rd(true);
                    b.this.coW();
                }
            }
        }
    }
}
