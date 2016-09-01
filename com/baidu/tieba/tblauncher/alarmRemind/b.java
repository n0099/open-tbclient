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
    private static b fwV;
    private com.baidu.tbadk.clientConfig.a fwT;
    private a fwU;
    private boolean fwW = false;
    private final com.baidu.tbadk.clientConfig.c Nl = new c(this);
    private final CustomMessageListener fwX = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener qQ = new e(this, 2000994);
    private CustomMessageListener dtq = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b bld() {
        if (fwV == null) {
            synchronized (b.class) {
                if (fwV == null) {
                    fwV = new b();
                }
            }
        }
        return fwV;
    }

    private b() {
    }

    public void h(BaseFragmentActivity baseFragmentActivity) {
        this.fwU = new a();
        baseFragmentActivity.registerListener(this.fwU);
        baseFragmentActivity.registerListener(this.qQ);
        baseFragmentActivity.registerListener(this.fwX);
        baseFragmentActivity.registerListener(this.dtq);
        this.fwT = new com.baidu.tbadk.clientConfig.a(baseFragmentActivity, this.Nl);
        com.baidu.tbadk.core.sharedPref.b.tS().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (blf()) {
            kR(true);
            ble();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ble() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.cU(TbadkSettings.getInst().loadLong(rm("remind_recommend_data_time"), 0L))) {
            blg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blf() {
        if (!TbadkCoreApplication.isLogin()) {
            kR(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.blc()) {
            kR(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.yX().zr()) {
            kR(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bbN()) {
            kR(false);
            return false;
        } else {
            return true;
        }
    }

    public String rm(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void blg() {
        if (this.fwT != null && !this.fwW) {
            this.fwW = true;
            this.fwT.bZ("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kR(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m9getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst().getApp(), 0, new Intent(TbadkCoreApplication.m9getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.blb() + 86400000, 86400000L, broadcast);
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
                com.baidu.tbadk.core.sharedPref.b.tS().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.blf()) {
                    b.this.kR(true);
                    b.this.ble();
                }
            }
        }
    }
}
