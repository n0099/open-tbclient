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
    private static b cVv;
    private com.baidu.tbadk.clientConfig.a cVt;
    private a cVu;
    private boolean cVw = false;
    com.baidu.tbadk.clientConfig.c SM = new c(this);
    private final CustomMessageListener cVx = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener xk = new e(this, 2000994);
    private CustomMessageListener cCZ = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b awp() {
        if (cVv == null) {
            synchronized (b.class) {
                if (cVv == null) {
                    cVv = new b();
                }
            }
        }
        return cVv;
    }

    private b() {
    }

    public void b(BaseFragmentActivity baseFragmentActivity) {
        this.cVu = new a();
        baseFragmentActivity.registerListener(this.cVu);
        baseFragmentActivity.registerListener(this.xk);
        baseFragmentActivity.registerListener(this.cVx);
        baseFragmentActivity.registerListener(this.cCZ);
        this.cVt = new com.baidu.tbadk.clientConfig.a(baseFragmentActivity, this.SM);
        awq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awq() {
        if (!TbadkCoreApplication.isLogin()) {
            gv(false);
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.xw().xQ()) {
            gv(false);
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.aok()) {
            gv(false);
        } else {
            gv(true);
            String lm = lm("remind_recommend_data_time");
            long currentTimeMillis = System.currentTimeMillis();
            long loadLong = currentTimeMillis - TbadkSettings.getInst().loadLong(lm, currentTimeMillis);
            if (loadLong == 0 || loadLong > 86400000) {
                awr();
            }
        }
    }

    public String lm(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void awr() {
        if (this.cVt != null && !this.cVw) {
            this.cVw = true;
            this.cVt.bX("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gv(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m411getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m411getInst().getApp(), 0, new Intent(TbadkCoreApplication.m411getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            long awo = com.baidu.tieba.tblauncher.alarmRemind.a.awo();
            if (awo > System.currentTimeMillis()) {
                alarmManager.setRepeating(0, awo, 86400000L, broadcast);
                return;
            } else {
                alarmManager.setRepeating(0, awo + 86400000, 86400000L, broadcast);
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
                b.this.awq();
            }
        }
    }
}
