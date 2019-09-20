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
    private static b jpo;
    private ClientConfigModel jpm;
    private a jpn;
    private boolean jpp = false;
    private final com.baidu.tbadk.clientConfig.a bDi = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void aa(Object obj) {
            b.this.jpp = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.FN("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.FN("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.FN("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.rv(true);
                        TbadkSettings.getInst().saveLong(b.this.FN("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.jpp = false;
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kc() && b.this.csR()) {
                b.this.csQ();
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.csR()) {
                b.this.rv(true);
                b.this.csQ();
            }
        }
    };

    public static b csP() {
        if (jpo == null) {
            synchronized (b.class) {
                if (jpo == null) {
                    jpo = new b();
                }
            }
        }
        return jpo;
    }

    private b() {
    }

    public void e(BaseFragmentActivity baseFragmentActivity) {
        this.jpn = new a();
        baseFragmentActivity.registerListener(this.jpn);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.mAccountChangedListener);
        this.jpm = new ClientConfigModel(baseFragmentActivity, this.bDi);
        com.baidu.tbadk.core.sharedPref.b.ahU().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (csR()) {
            rv(true);
            csQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csQ() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.bc(TbadkSettings.getInst().loadLong(FN("remind_recommend_data_time"), 0L)) && !TbadkCoreApplication.getInst().checkInterrupt()) {
            csS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean csR() {
        if (!TbadkCoreApplication.isLogin()) {
            rv(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.csO()) {
            rv(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.cki()) {
            rv(false);
            return false;
        } else {
            return true;
        }
    }

    public String FN(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void csS() {
        if (this.jpm != null && !this.jpp) {
            this.jpp = true;
            this.jpm.mh("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.csN() + 86400000, 86400000L, broadcast);
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
                com.baidu.tbadk.core.sharedPref.b.ahU().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.csR()) {
                    b.this.rv(true);
                    b.this.csQ();
                }
            }
        }
    }
}
