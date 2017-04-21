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
    private static b fCI;
    private ClientConfigModel fCG;
    private a fCH;
    private boolean fCJ = false;
    private final com.baidu.tbadk.clientConfig.b RW = new c(this);
    private final CustomMessageListener fCK = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener mNetworkChangedListener = new e(this, 2000994);
    private CustomMessageListener dmY = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b blg() {
        if (fCI == null) {
            synchronized (b.class) {
                if (fCI == null) {
                    fCI = new b();
                }
            }
        }
        return fCI;
    }

    private b() {
    }

    public void g(BaseFragmentActivity baseFragmentActivity) {
        this.fCH = new a();
        baseFragmentActivity.registerListener(this.fCH);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.fCK);
        baseFragmentActivity.registerListener(this.dmY);
        this.fCG = new ClientConfigModel(baseFragmentActivity, this.RW);
        com.baidu.tbadk.core.sharedPref.b.uL().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bli()) {
            lC(true);
            blh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blh() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.cD(TbadkSettings.getInst().loadLong(qz("remind_recommend_data_time"), 0L))) {
            blj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bli() {
        if (!TbadkCoreApplication.isLogin()) {
            lC(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.blf()) {
            lC(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.zG().zZ()) {
            lC(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bbX()) {
            lC(false);
            return false;
        } else {
            return true;
        }
    }

    public String qz(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void blj() {
        if (this.fCG != null && !this.fCJ) {
            this.fCJ = true;
            this.fCG.bZ("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lC(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m9getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst().getApp(), 0, new Intent(TbadkCoreApplication.m9getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.ble() + 86400000, 86400000L, broadcast);
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
                com.baidu.tbadk.core.sharedPref.b.uL().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.bli()) {
                    b.this.lC(true);
                    b.this.blh();
                }
            }
        }
    }
}
