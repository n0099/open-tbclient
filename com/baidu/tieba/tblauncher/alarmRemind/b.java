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
    private static b iMO;
    private ClientConfigModel iMM;
    private a iMN;
    private boolean iMP = false;
    private final com.baidu.tbadk.clientConfig.a buF = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void aa(Object obj) {
            b.this.iMP = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.Db("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.Db("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.Db("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.qo(true);
                        TbadkSettings.getInst().saveLong(b.this.Db("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.iMP = false;
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kY() && b.this.cgT()) {
                b.this.cgS();
            }
        }
    };
    private CustomMessageListener dgx = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.cgT()) {
                b.this.qo(true);
                b.this.cgS();
            }
        }
    };

    public static b cgR() {
        if (iMO == null) {
            synchronized (b.class) {
                if (iMO == null) {
                    iMO = new b();
                }
            }
        }
        return iMO;
    }

    private b() {
    }

    public void e(BaseFragmentActivity baseFragmentActivity) {
        this.iMN = new a();
        baseFragmentActivity.registerListener(this.iMN);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.dgx);
        this.iMM = new ClientConfigModel(baseFragmentActivity, this.buF);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (cgT()) {
            qo(true);
            cgS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgS() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.aM(TbadkSettings.getInst().loadLong(Db("remind_recommend_data_time"), 0L))) {
            cgU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cgT() {
        if (!TbadkCoreApplication.isLogin()) {
            qo(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.cgQ()) {
            qo(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bYj()) {
            qo(false);
            return false;
        } else {
            return true;
        }
    }

    public String Db(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void cgU() {
        if (this.iMM != null && !this.iMP) {
            this.iMP = true;
            this.iMM.kQ("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qo(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.cgP() + 86400000, 86400000L, broadcast);
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
                if (b.this.cgT()) {
                    b.this.qo(true);
                    b.this.cgS();
                }
            }
        }
    }
}
