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
    private static b dKZ;
    private com.baidu.tbadk.clientConfig.a dKX;
    private a dKY;
    private boolean aVo = false;
    private final com.baidu.tbadk.clientConfig.c Tp = new c(this);
    private final CustomMessageListener dLa = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener xt = new e(this, 2000994);
    private CustomMessageListener cjp = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b aHm() {
        if (dKZ == null) {
            synchronized (b.class) {
                if (dKZ == null) {
                    dKZ = new b();
                }
            }
        }
        return dKZ;
    }

    private b() {
    }

    public void d(BaseFragmentActivity baseFragmentActivity) {
        this.dKY = new a();
        baseFragmentActivity.registerListener(this.dKY);
        baseFragmentActivity.registerListener(this.xt);
        baseFragmentActivity.registerListener(this.dLa);
        baseFragmentActivity.registerListener(this.cjp);
        this.dKX = new com.baidu.tbadk.clientConfig.a(baseFragmentActivity, this.Tp);
        com.baidu.tbadk.core.sharedPref.b.tJ().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (aHo()) {
            hC(true);
            aHn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHn() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.bN(TbadkSettings.getInst().loadLong(mJ("remind_recommend_data_time"), 0L))) {
            aHp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aHo() {
        if (!TbadkCoreApplication.isLogin()) {
            hC(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.aHl()) {
            hC(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.xS().ym()) {
            hC(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.ayP()) {
            hC(false);
            return false;
        } else {
            return true;
        }
    }

    public String mJ(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void aHp() {
        if (this.dKX != null && !this.aVo) {
            this.aVo = true;
            this.dKX.ce("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hC(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m411getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m411getInst().getApp(), 0, new Intent(TbadkCoreApplication.m411getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.aHk() + 86400000, 86400000L, broadcast);
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
                com.baidu.tbadk.core.sharedPref.b.tJ().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.aHo()) {
                    b.this.hC(true);
                    b.this.aHn();
                }
            }
        }
    }
}
