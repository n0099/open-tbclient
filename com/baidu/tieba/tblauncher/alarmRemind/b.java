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
    private static b fHa;
    private com.baidu.tbadk.clientConfig.a fGY;
    private a fGZ;
    private boolean fHb = false;
    private final com.baidu.tbadk.clientConfig.c No = new c(this);
    private final CustomMessageListener fHc = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener qR = new e(this, 2000994);
    private CustomMessageListener dAs = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b bod() {
        if (fHa == null) {
            synchronized (b.class) {
                if (fHa == null) {
                    fHa = new b();
                }
            }
        }
        return fHa;
    }

    private b() {
    }

    public void h(BaseFragmentActivity baseFragmentActivity) {
        this.fGZ = new a();
        baseFragmentActivity.registerListener(this.fGZ);
        baseFragmentActivity.registerListener(this.qR);
        baseFragmentActivity.registerListener(this.fHc);
        baseFragmentActivity.registerListener(this.dAs);
        this.fGY = new com.baidu.tbadk.clientConfig.a(baseFragmentActivity, this.No);
        com.baidu.tbadk.core.sharedPref.b.um().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bof()) {
            lt(true);
            boe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boe() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.cX(TbadkSettings.getInst().loadLong(rX("remind_recommend_data_time"), 0L))) {
            bog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bof() {
        if (!TbadkCoreApplication.isLogin()) {
            lt(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.boc()) {
            lt(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zB()) {
            lt(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.beY()) {
            lt(false);
            return false;
        } else {
            return true;
        }
    }

    public String rX(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void bog() {
        if (this.fGY != null && !this.fHb) {
            this.fHb = true;
            this.fGY.ca("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m9getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst().getApp(), 0, new Intent(TbadkCoreApplication.m9getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.bob() + 86400000, 86400000L, broadcast);
        } else {
            alarmManager.cancel(broadcast);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends CustomMessageListener {
        public a() {
            super(CmdConfigCustom.CMD_BACKGROUND_SWTICH);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null && !data.booleanValue()) {
                com.baidu.tbadk.core.sharedPref.b.um().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.bof()) {
                    b.this.lt(true);
                    b.this.boe();
                }
            }
        }
    }
}
