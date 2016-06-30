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
    private static b fbX;
    private com.baidu.tbadk.clientConfig.a fbV;
    private a fbW;
    private boolean fbY = false;
    private final com.baidu.tbadk.clientConfig.c KZ = new c(this);
    private final CustomMessageListener fbZ = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener nT = new e(this, 2000994);
    private CustomMessageListener deN = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b beh() {
        if (fbX == null) {
            synchronized (b.class) {
                if (fbX == null) {
                    fbX = new b();
                }
            }
        }
        return fbX;
    }

    private b() {
    }

    public void i(BaseFragmentActivity baseFragmentActivity) {
        this.fbW = new a();
        baseFragmentActivity.registerListener(this.fbW);
        baseFragmentActivity.registerListener(this.nT);
        baseFragmentActivity.registerListener(this.fbZ);
        baseFragmentActivity.registerListener(this.deN);
        this.fbV = new com.baidu.tbadk.clientConfig.a(baseFragmentActivity, this.KZ);
        com.baidu.tbadk.core.sharedPref.b.sO().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bej()) {
            kr(true);
            bei();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bei() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.cC(TbadkSettings.getInst().loadLong(pS("remind_recommend_data_time"), 0L))) {
            bek();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bej() {
        if (!TbadkCoreApplication.isLogin()) {
            kr(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.beg()) {
            kr(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().ye()) {
            kr(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.aUY()) {
            kr(false);
            return false;
        } else {
            return true;
        }
    }

    public String pS(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void bek() {
        if (this.fbV != null && !this.fbY) {
            this.fbY = true;
            this.fbV.bX("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kr(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m9getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst().getApp(), 0, new Intent(TbadkCoreApplication.m9getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.bef() + 86400000, 86400000L, broadcast);
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
                com.baidu.tbadk.core.sharedPref.b.sO().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.bej()) {
                    b.this.kr(true);
                    b.this.bei();
                }
            }
        }
    }
}
