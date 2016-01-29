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
    private static b ebh;
    private com.baidu.tbadk.clientConfig.a ebf;
    private a ebg;
    private boolean aXB = false;
    private final com.baidu.tbadk.clientConfig.c SL = new c(this);
    private final CustomMessageListener ebi = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener xC = new e(this, 2000994);
    private CustomMessageListener cnP = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b aOr() {
        if (ebh == null) {
            synchronized (b.class) {
                if (ebh == null) {
                    ebh = new b();
                }
            }
        }
        return ebh;
    }

    private b() {
    }

    public void g(BaseFragmentActivity baseFragmentActivity) {
        this.ebg = new a();
        baseFragmentActivity.registerListener(this.ebg);
        baseFragmentActivity.registerListener(this.xC);
        baseFragmentActivity.registerListener(this.ebi);
        baseFragmentActivity.registerListener(this.cnP);
        this.ebf = new com.baidu.tbadk.clientConfig.a(baseFragmentActivity, this.SL);
        com.baidu.tbadk.core.sharedPref.b.uO().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (aOt()) {
            ih(true);
            aOs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOs() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.bS(TbadkSettings.getInst().loadLong(na("remind_recommend_data_time"), 0L))) {
            aOu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aOt() {
        if (!TbadkCoreApplication.isLogin()) {
            ih(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.aOq()) {
            ih(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.zk().zE()) {
            ih(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.aFW()) {
            ih(false);
            return false;
        } else {
            return true;
        }
    }

    public String na(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void aOu() {
        if (this.ebf != null && !this.aXB) {
            this.aXB = true;
            this.ebf.cd("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ih(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m411getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m411getInst().getApp(), 0, new Intent(TbadkCoreApplication.m411getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.aOp() + 86400000, 86400000L, broadcast);
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
                com.baidu.tbadk.core.sharedPref.b.uO().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.aOt()) {
                    b.this.ih(true);
                    b.this.aOs();
                }
            }
        }
    }
}
