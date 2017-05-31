package com.baidu.tieba.tblauncher.alarmRemind;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.clientConfig.ClientConfigModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
/* loaded from: classes.dex */
public class b {
    private static b fHf;
    private ClientConfigModel fHd;
    private a fHe;
    private boolean fHg = false;
    private final com.baidu.tbadk.clientConfig.b Ra = new c(this);
    private final CustomMessageListener fHh = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener mNetworkChangedListener = new e(this, 2000994);
    private CustomMessageListener dmy = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b bkj() {
        if (fHf == null) {
            synchronized (b.class) {
                if (fHf == null) {
                    fHf = new b();
                }
            }
        }
        return fHf;
    }

    private b() {
    }

    public void g(BaseFragmentActivity baseFragmentActivity) {
        this.fHe = new a();
        baseFragmentActivity.registerListener(this.fHe);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.fHh);
        baseFragmentActivity.registerListener(this.dmy);
        this.fHd = new ClientConfigModel(baseFragmentActivity, this.Ra);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bkl()) {
            lE(true);
            bkk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkk() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.ct(TbadkSettings.getInst().loadLong(qI("remind_recommend_data_time"), 0L))) {
            bkm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bkl() {
        if (!TbadkCoreApplication.isLogin()) {
            lE(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bki()) {
            lE(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.yK().zd()) {
            lE(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.baQ()) {
            lE(false);
            return false;
        } else {
            return true;
        }
    }

    public String qI(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void bkm() {
        if (this.fHd != null && !this.fHg) {
            this.fHg = true;
            this.fHd.bZ("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lE(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m9getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst().getApp(), 0, new Intent(TbadkCoreApplication.m9getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.bkh() + 86400000, 86400000L, broadcast);
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
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.bkl()) {
                    b.this.lE(true);
                    b.this.bkk();
                }
            }
        }
    }
}
