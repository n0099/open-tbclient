package com.baidu.tieba.tblauncher.alarmRemind;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
/* loaded from: classes.dex */
public class b {
    private static b dDv;
    private com.baidu.tbadk.clientConfig.a dDt;
    private a dDu;
    private boolean aRy = false;
    private final com.baidu.tbadk.clientConfig.c SP = new c(this);
    private final CustomMessageListener dDw = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener xr = new e(this, 2000994);
    private CustomMessageListener cfl = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b aEX() {
        if (dDv == null) {
            synchronized (b.class) {
                if (dDv == null) {
                    dDv = new b();
                }
            }
        }
        return dDv;
    }

    private b() {
    }

    public void c(BaseFragmentActivity baseFragmentActivity) {
        this.dDu = new a();
        baseFragmentActivity.registerListener(this.dDu);
        baseFragmentActivity.registerListener(this.xr);
        baseFragmentActivity.registerListener(this.dDw);
        baseFragmentActivity.registerListener(this.cfl);
        this.dDt = new com.baidu.tbadk.clientConfig.a(baseFragmentActivity, this.SP);
        com.baidu.tbadk.core.sharedPref.b.tZ().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (aEZ()) {
            ht(true);
            aEY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEY() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.bE(TbadkSettings.getInst().loadLong(mM("remind_recommend_data_time"), 0L))) {
            aFa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEZ() {
        if (!TbadkCoreApplication.isLogin()) {
            ht(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.aEW()) {
            ht(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.yg().yA()) {
            ht(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.awI()) {
            ht(false);
            return false;
        } else {
            return true;
        }
    }

    public String mM(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void aFa() {
        if (this.dDt != null && !this.aRy) {
            this.aRy = true;
            this.dDt.cc("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ht(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m411getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m411getInst().getApp(), 0, new Intent(TbadkCoreApplication.m411getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.aEV() + 86400000, 86400000L, broadcast);
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
                com.baidu.tbadk.core.sharedPref.b.tZ().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.aEZ()) {
                    b.this.ht(true);
                    b.this.aEY();
                }
            }
        }
    }
}
