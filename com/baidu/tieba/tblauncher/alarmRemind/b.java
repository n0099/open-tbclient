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
    private static b fpb;
    private com.baidu.tbadk.clientConfig.a foZ;
    private a fpa;
    private boolean fpc = false;
    private final com.baidu.tbadk.clientConfig.c KY = new c(this);
    private final CustomMessageListener fpd = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener oz = new e(this, 2000994);
    private CustomMessageListener dhL = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b bhz() {
        if (fpb == null) {
            synchronized (b.class) {
                if (fpb == null) {
                    fpb = new b();
                }
            }
        }
        return fpb;
    }

    private b() {
    }

    public void i(BaseFragmentActivity baseFragmentActivity) {
        this.fpa = new a();
        baseFragmentActivity.registerListener(this.fpa);
        baseFragmentActivity.registerListener(this.oz);
        baseFragmentActivity.registerListener(this.fpd);
        baseFragmentActivity.registerListener(this.dhL);
        this.foZ = new com.baidu.tbadk.clientConfig.a(baseFragmentActivity, this.KY);
        com.baidu.tbadk.core.sharedPref.b.sN().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bhB()) {
            kF(true);
            bhA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhA() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.cB(TbadkSettings.getInst().loadLong(qC("remind_recommend_data_time"), 0L))) {
            bhC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhB() {
        if (!TbadkCoreApplication.isLogin()) {
            kF(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bhy()) {
            kF(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().ye()) {
            kF(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.aYl()) {
            kF(false);
            return false;
        } else {
            return true;
        }
    }

    public String qC(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void bhC() {
        if (this.foZ != null && !this.fpc) {
            this.fpc = true;
            this.foZ.bY("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kF(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m10getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m10getInst().getApp(), 0, new Intent(TbadkCoreApplication.m10getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.bhx() + 86400000, 86400000L, broadcast);
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
                com.baidu.tbadk.core.sharedPref.b.sN().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.bhB()) {
                    b.this.kF(true);
                    b.this.bhA();
                }
            }
        }
    }
}
