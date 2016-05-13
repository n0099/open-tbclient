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
    private static b exk;
    private com.baidu.tbadk.clientConfig.a exi;
    private a exj;
    private boolean exl = false;
    private final com.baidu.tbadk.clientConfig.c KZ = new c(this);
    private final CustomMessageListener exm = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener nT = new e(this, 2000994);
    private CustomMessageListener czq = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b aVV() {
        if (exk == null) {
            synchronized (b.class) {
                if (exk == null) {
                    exk = new b();
                }
            }
        }
        return exk;
    }

    private b() {
    }

    public void g(BaseFragmentActivity baseFragmentActivity) {
        this.exj = new a();
        baseFragmentActivity.registerListener(this.exj);
        baseFragmentActivity.registerListener(this.nT);
        baseFragmentActivity.registerListener(this.exm);
        baseFragmentActivity.registerListener(this.czq);
        this.exi = new com.baidu.tbadk.clientConfig.a(baseFragmentActivity, this.KZ);
        com.baidu.tbadk.core.sharedPref.b.sR().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (aVX()) {
            jH(true);
            aVW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVW() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.cb(TbadkSettings.getInst().loadLong(ol("remind_recommend_data_time"), 0L))) {
            aVY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVX() {
        if (!TbadkCoreApplication.isLogin()) {
            jH(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.aVU()) {
            jH(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.xG().ya()) {
            jH(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.aMT()) {
            jH(false);
            return false;
        } else {
            return true;
        }
    }

    public String ol(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void aVY() {
        if (this.exi != null && !this.exl) {
            this.exl = true;
            this.exi.bY("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jH(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m11getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m11getInst().getApp(), 0, new Intent(TbadkCoreApplication.m11getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.aVT() + 86400000, 86400000L, broadcast);
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
                com.baidu.tbadk.core.sharedPref.b.sR().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.aVX()) {
                    b.this.jH(true);
                    b.this.aVW();
                }
            }
        }
    }
}
