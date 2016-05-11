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
    private static b exl;
    private com.baidu.tbadk.clientConfig.a exj;
    private a exk;
    private boolean exm = false;
    private final com.baidu.tbadk.clientConfig.c KZ = new c(this);
    private final CustomMessageListener exn = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener nT = new e(this, 2000994);
    private CustomMessageListener czq = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b aVP() {
        if (exl == null) {
            synchronized (b.class) {
                if (exl == null) {
                    exl = new b();
                }
            }
        }
        return exl;
    }

    private b() {
    }

    public void g(BaseFragmentActivity baseFragmentActivity) {
        this.exk = new a();
        baseFragmentActivity.registerListener(this.exk);
        baseFragmentActivity.registerListener(this.nT);
        baseFragmentActivity.registerListener(this.exn);
        baseFragmentActivity.registerListener(this.czq);
        this.exj = new com.baidu.tbadk.clientConfig.a(baseFragmentActivity, this.KZ);
        com.baidu.tbadk.core.sharedPref.b.sQ().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (aVR()) {
            jH(true);
            aVQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVQ() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.cb(TbadkSettings.getInst().loadLong(ol("remind_recommend_data_time"), 0L))) {
            aVS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVR() {
        if (!TbadkCoreApplication.isLogin()) {
            jH(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.aVO()) {
            jH(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.xF().xZ()) {
            jH(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.aMQ()) {
            jH(false);
            return false;
        } else {
            return true;
        }
    }

    public String ol(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void aVS() {
        if (this.exj != null && !this.exm) {
            this.exm = true;
            this.exj.bY("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jH(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m11getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m11getInst().getApp(), 0, new Intent(TbadkCoreApplication.m11getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.aVN() + 86400000, 86400000L, broadcast);
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
                com.baidu.tbadk.core.sharedPref.b.sQ().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.aVR()) {
                    b.this.jH(true);
                    b.this.aVQ();
                }
            }
        }
    }
}
