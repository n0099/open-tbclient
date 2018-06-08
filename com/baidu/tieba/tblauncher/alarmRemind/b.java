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
    private static b gOj;
    private ClientConfigModel gOh;
    private a gOi;
    private boolean gOk = false;
    private final com.baidu.tbadk.clientConfig.a abT = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void B(Object obj) {
            b.this.gOk = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.um("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.um("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.um("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.mK(true);
                        TbadkSettings.getInst().saveLong(b.this.um("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.gOk = false;
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jD() && b.this.bze()) {
                b.this.bzd();
            }
        }
    };
    private CustomMessageListener bvy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.bze()) {
                b.this.mK(true);
                b.this.bzd();
            }
        }
    };

    public static b bzc() {
        if (gOj == null) {
            synchronized (b.class) {
                if (gOj == null) {
                    gOj = new b();
                }
            }
        }
        return gOj;
    }

    private b() {
    }

    public void m(BaseFragmentActivity baseFragmentActivity) {
        this.gOi = new a();
        baseFragmentActivity.registerListener(this.gOi);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.bvy);
        this.gOh = new ClientConfigModel(baseFragmentActivity, this.abT);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bze()) {
            mK(true);
            bzd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzd() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.R(TbadkSettings.getInst().loadLong(um("remind_recommend_data_time"), 0L))) {
            bzf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bze() {
        if (!TbadkCoreApplication.isLogin()) {
            mK(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bzb()) {
            mK(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bpE()) {
            mK(false);
            return false;
        } else {
            return true;
        }
    }

    public String um(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void bzf() {
        if (this.gOh != null && !this.gOk) {
            this.gOk = true;
            this.gOh.cX("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mK(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.bza() + 86400000, 86400000L, broadcast);
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
                if (b.this.bze()) {
                    b.this.mK(true);
                    b.this.bzd();
                }
            }
        }
    }
}
