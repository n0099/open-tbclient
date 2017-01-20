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
    private static b fuk;
    private ClientConfigModel fui;
    private a fuj;
    private boolean ful = false;
    private final com.baidu.tbadk.clientConfig.b My = new c(this);
    private final CustomMessageListener fum = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener mNetworkChangedListener = new e(this, 2000994);
    private CustomMessageListener djO = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b bjF() {
        if (fuk == null) {
            synchronized (b.class) {
                if (fuk == null) {
                    fuk = new b();
                }
            }
        }
        return fuk;
    }

    private b() {
    }

    public void g(BaseFragmentActivity baseFragmentActivity) {
        this.fuj = new a();
        baseFragmentActivity.registerListener(this.fuj);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.fum);
        baseFragmentActivity.registerListener(this.djO);
        this.fui = new ClientConfigModel(baseFragmentActivity, this.My);
        com.baidu.tbadk.core.sharedPref.b.tQ().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bjH()) {
            lq(true);
            bjG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjG() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.cA(TbadkSettings.getInst().loadLong(qZ("remind_recommend_data_time"), 0L))) {
            bjI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bjH() {
        if (!TbadkCoreApplication.isLogin()) {
            lq(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bjE()) {
            lq(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.yQ().zj()) {
            lq(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.baC()) {
            lq(false);
            return false;
        } else {
            return true;
        }
    }

    public String qZ(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void bjI() {
        if (this.fui != null && !this.ful) {
            this.ful = true;
            this.fui.bZ("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lq(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m9getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst().getApp(), 0, new Intent(TbadkCoreApplication.m9getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.bjD() + 86400000, 86400000L, broadcast);
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
                com.baidu.tbadk.core.sharedPref.b.tQ().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.bjH()) {
                    b.this.lq(true);
                    b.this.bjG();
                }
            }
        }
    }
}
