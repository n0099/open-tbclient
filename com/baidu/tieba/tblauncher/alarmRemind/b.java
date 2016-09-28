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
    private static b fzy;
    private com.baidu.tbadk.clientConfig.a fzw;
    private a fzx;
    private boolean fzz = false;
    private final com.baidu.tbadk.clientConfig.c Nm = new c(this);
    private final CustomMessageListener fzA = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener qQ = new e(this, 2000994);
    private CustomMessageListener duN = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b blL() {
        if (fzy == null) {
            synchronized (b.class) {
                if (fzy == null) {
                    fzy = new b();
                }
            }
        }
        return fzy;
    }

    private b() {
    }

    public void h(BaseFragmentActivity baseFragmentActivity) {
        this.fzx = new a();
        baseFragmentActivity.registerListener(this.fzx);
        baseFragmentActivity.registerListener(this.qQ);
        baseFragmentActivity.registerListener(this.fzA);
        baseFragmentActivity.registerListener(this.duN);
        this.fzw = new com.baidu.tbadk.clientConfig.a(baseFragmentActivity, this.Nm);
        com.baidu.tbadk.core.sharedPref.b.uh().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (blN()) {
            kU(true);
            blM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blM() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.cU(TbadkSettings.getInst().loadLong(rB("remind_recommend_data_time"), 0L))) {
            blO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blN() {
        if (!TbadkCoreApplication.isLogin()) {
            kU(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.blK()) {
            kU(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.za().zu()) {
            kU(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bcx()) {
            kU(false);
            return false;
        } else {
            return true;
        }
    }

    public String rB(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void blO() {
        if (this.fzw != null && !this.fzz) {
            this.fzz = true;
            this.fzw.bZ("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kU(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m9getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst().getApp(), 0, new Intent(TbadkCoreApplication.m9getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.blJ() + 86400000, 86400000L, broadcast);
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
                com.baidu.tbadk.core.sharedPref.b.uh().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.blN()) {
                    b.this.kU(true);
                    b.this.blM();
                }
            }
        }
    }
}
