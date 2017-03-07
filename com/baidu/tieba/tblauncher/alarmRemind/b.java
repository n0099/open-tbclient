package com.baidu.tieba.tblauncher.alarmRemind;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.clientConfig.ClientConfigModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
/* loaded from: classes.dex */
public class b {
    private static b fyJ;
    private ClientConfigModel fyH;
    private a fyI;
    private boolean fyK = false;
    private final com.baidu.tbadk.clientConfig.b RB = new c(this);
    private final CustomMessageListener fyL = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener mNetworkChangedListener = new e(this, 2000994);
    private CustomMessageListener dmi = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b bju() {
        if (fyJ == null) {
            synchronized (b.class) {
                if (fyJ == null) {
                    fyJ = new b();
                }
            }
        }
        return fyJ;
    }

    private b() {
    }

    public void g(BaseFragmentActivity baseFragmentActivity) {
        this.fyI = new a();
        baseFragmentActivity.registerListener(this.fyI);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.fyL);
        baseFragmentActivity.registerListener(this.dmi);
        this.fyH = new ClientConfigModel(baseFragmentActivity, this.RB);
        com.baidu.tbadk.core.sharedPref.b.uo().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bjw()) {
            lp(true);
            bjv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjv() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.cD(TbadkSettings.getInst().loadLong(qh("remind_recommend_data_time"), 0L))) {
            bjx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bjw() {
        if (!TbadkCoreApplication.isLogin()) {
            lp(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bjt()) {
            lp(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zA()) {
            lp(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.ban()) {
            lp(false);
            return false;
        } else {
            return true;
        }
    }

    public String qh(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void bjx() {
        if (this.fyH != null && !this.fyK) {
            this.fyK = true;
            this.fyH.bS("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lp(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m9getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst().getApp(), 0, new Intent(TbadkCoreApplication.m9getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.bjs() + 86400000, 86400000L, broadcast);
        } else {
            alarmManager.cancel(broadcast);
        }
    }

    /* loaded from: classes.dex */
    private class a extends CustomMessageListener {
        public a() {
            super(CmdConfigCustom.CMD_BACKGROUND_SWTICH);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null && !data.booleanValue()) {
                com.baidu.tbadk.core.sharedPref.b.uo().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.bjw()) {
                    b.this.lp(true);
                    b.this.bjv();
                }
            }
        }
    }
}
