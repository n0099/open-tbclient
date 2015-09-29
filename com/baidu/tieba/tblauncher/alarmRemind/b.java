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
    private static b ddd;
    private com.baidu.tbadk.clientConfig.a ddb;
    private a ddc;
    private boolean dde = false;
    com.baidu.tbadk.clientConfig.c Sy = new c(this);
    private final CustomMessageListener ddf = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener xl = new e(this, 2000994);
    private CustomMessageListener cKa = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b ayE() {
        if (ddd == null) {
            synchronized (b.class) {
                if (ddd == null) {
                    ddd = new b();
                }
            }
        }
        return ddd;
    }

    private b() {
    }

    public void b(BaseFragmentActivity baseFragmentActivity) {
        this.ddc = new a();
        baseFragmentActivity.registerListener(this.ddc);
        baseFragmentActivity.registerListener(this.xl);
        baseFragmentActivity.registerListener(this.ddf);
        baseFragmentActivity.registerListener(this.cKa);
        this.ddb = new com.baidu.tbadk.clientConfig.a(baseFragmentActivity, this.Sy);
        ayF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayF() {
        if (!TbadkCoreApplication.isLogin()) {
            gF(false);
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.xh().xB()) {
            gF(false);
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.aqC()) {
            gF(false);
        } else {
            gF(true);
            String lM = lM("remind_recommend_data_time");
            long currentTimeMillis = System.currentTimeMillis();
            long loadLong = currentTimeMillis - TbadkSettings.getInst().loadLong(lM, currentTimeMillis);
            if (loadLong == 0 || loadLong > 86400000) {
                ayG();
            }
        }
    }

    public String lM(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void ayG() {
        if (this.ddb != null && !this.dde) {
            this.dde = true;
            this.ddb.bX("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gF(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m411getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m411getInst().getApp(), 0, new Intent(TbadkCoreApplication.m411getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            long ayD = com.baidu.tieba.tblauncher.alarmRemind.a.ayD();
            if (ayD > System.currentTimeMillis()) {
                alarmManager.setRepeating(0, ayD, 86400000L, broadcast);
                return;
            } else {
                alarmManager.setRepeating(0, ayD + 86400000, 86400000L, broadcast);
                return;
            }
        }
        alarmManager.cancel(broadcast);
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
                b.this.ayF();
            }
        }
    }
}
