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
    private static b dfM;
    private com.baidu.tbadk.clientConfig.a dfK;
    private a dfL;
    private boolean dfN = false;
    com.baidu.tbadk.clientConfig.c SA = new c(this);
    private final CustomMessageListener dfO = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener xl = new e(this, 2000994);
    private CustomMessageListener cLV = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b azR() {
        if (dfM == null) {
            synchronized (b.class) {
                if (dfM == null) {
                    dfM = new b();
                }
            }
        }
        return dfM;
    }

    private b() {
    }

    public void b(BaseFragmentActivity baseFragmentActivity) {
        this.dfL = new a();
        baseFragmentActivity.registerListener(this.dfL);
        baseFragmentActivity.registerListener(this.xl);
        baseFragmentActivity.registerListener(this.dfO);
        baseFragmentActivity.registerListener(this.cLV);
        this.dfK = new com.baidu.tbadk.clientConfig.a(baseFragmentActivity, this.SA);
        azS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azS() {
        if (!TbadkCoreApplication.isLogin()) {
            gL(false);
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.xj().xD()) {
            gL(false);
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.ark()) {
            gL(false);
        } else {
            gL(true);
            String lV = lV("remind_recommend_data_time");
            long currentTimeMillis = System.currentTimeMillis();
            long loadLong = currentTimeMillis - TbadkSettings.getInst().loadLong(lV, currentTimeMillis);
            if (loadLong == 0 || loadLong > 86400000) {
                azT();
            }
        }
    }

    public String lV(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void azT() {
        if (this.dfK != null && !this.dfN) {
            this.dfN = true;
            this.dfK.bW("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gL(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m411getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m411getInst().getApp(), 0, new Intent(TbadkCoreApplication.m411getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            long azQ = com.baidu.tieba.tblauncher.alarmRemind.a.azQ();
            if (azQ > System.currentTimeMillis()) {
                alarmManager.setRepeating(0, azQ, 86400000L, broadcast);
                return;
            } else {
                alarmManager.setRepeating(0, azQ + 86400000, 86400000L, broadcast);
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
                b.this.azS();
            }
        }
    }
}
