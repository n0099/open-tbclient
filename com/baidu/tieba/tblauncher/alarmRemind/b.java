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
    private static b euc;
    private com.baidu.tbadk.clientConfig.a eua;
    private a eub;
    private boolean bck = false;
    private final com.baidu.tbadk.clientConfig.c Qi = new c(this);
    private final CustomMessageListener eud = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener xT = new e(this, 2000994);
    private CustomMessageListener cyr = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b aVt() {
        if (euc == null) {
            synchronized (b.class) {
                if (euc == null) {
                    euc = new b();
                }
            }
        }
        return euc;
    }

    private b() {
    }

    public void g(BaseFragmentActivity baseFragmentActivity) {
        this.eub = new a();
        baseFragmentActivity.registerListener(this.eub);
        baseFragmentActivity.registerListener(this.xT);
        baseFragmentActivity.registerListener(this.eud);
        baseFragmentActivity.registerListener(this.cyr);
        this.eua = new com.baidu.tbadk.clientConfig.a(baseFragmentActivity, this.Qi);
        com.baidu.tbadk.core.sharedPref.b.vk().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (aVv()) {
            iW(true);
            aVu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVu() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.cc(TbadkSettings.getInst().loadLong(on("remind_recommend_data_time"), 0L))) {
            aVw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVv() {
        if (!TbadkCoreApplication.isLogin()) {
            iW(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.aVs()) {
            iW(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ag()) {
            iW(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.aMG()) {
            iW(false);
            return false;
        } else {
            return true;
        }
    }

    public String on(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void aVw() {
        if (this.eua != null && !this.bck) {
            this.bck = true;
            this.eua.ca("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iW(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m411getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m411getInst().getApp(), 0, new Intent(TbadkCoreApplication.m411getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.aVr() + 86400000, 86400000L, broadcast);
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
                com.baidu.tbadk.core.sharedPref.b.vk().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.aVv()) {
                    b.this.iW(true);
                    b.this.aVu();
                }
            }
        }
    }
}
