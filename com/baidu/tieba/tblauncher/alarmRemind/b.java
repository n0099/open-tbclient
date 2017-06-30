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
    private static b fQV;
    private ClientConfigModel fQT;
    private a fQU;
    private boolean fQW = false;
    private final com.baidu.tbadk.clientConfig.b QU = new c(this);
    private final CustomMessageListener fQX = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener mNetworkChangedListener = new e(this, 2000994);
    private CustomMessageListener duu = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b bot() {
        if (fQV == null) {
            synchronized (b.class) {
                if (fQV == null) {
                    fQV = new b();
                }
            }
        }
        return fQV;
    }

    private b() {
    }

    public void g(BaseFragmentActivity baseFragmentActivity) {
        this.fQU = new a();
        baseFragmentActivity.registerListener(this.fQU);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.fQX);
        baseFragmentActivity.registerListener(this.duu);
        this.fQT = new ClientConfigModel(baseFragmentActivity, this.QU);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bov()) {
            md(true);
            bou();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bou() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.cI(TbadkSettings.getInst().loadLong(rF("remind_recommend_data_time"), 0L))) {
            bow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bov() {
        if (!TbadkCoreApplication.isLogin()) {
            md(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bos()) {
            md(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.zd().zw()) {
            md(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bff()) {
            md(false);
            return false;
        } else {
            return true;
        }
    }

    public String rF(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void bow() {
        if (this.fQT != null && !this.fQW) {
            this.fQW = true;
            this.fQT.cf("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void md(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m9getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst().getApp(), 0, new Intent(TbadkCoreApplication.m9getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.bor() + 86400000, 86400000L, broadcast);
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
                if (b.this.bov()) {
                    b.this.md(true);
                    b.this.bou();
                }
            }
        }
    }
}
