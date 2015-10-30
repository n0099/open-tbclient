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
    private static b ddD;
    private com.baidu.tbadk.clientConfig.a ddB;
    private a ddC;
    private boolean ddE = false;
    com.baidu.tbadk.clientConfig.c Sz = new c(this);
    private final CustomMessageListener ddF = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener xl = new e(this, 2000994);
    private CustomMessageListener cKz = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b ayK() {
        if (ddD == null) {
            synchronized (b.class) {
                if (ddD == null) {
                    ddD = new b();
                }
            }
        }
        return ddD;
    }

    private b() {
    }

    public void b(BaseFragmentActivity baseFragmentActivity) {
        this.ddC = new a();
        baseFragmentActivity.registerListener(this.ddC);
        baseFragmentActivity.registerListener(this.xl);
        baseFragmentActivity.registerListener(this.ddF);
        baseFragmentActivity.registerListener(this.cKz);
        this.ddB = new com.baidu.tbadk.clientConfig.a(baseFragmentActivity, this.Sz);
        ayL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayL() {
        if (!TbadkCoreApplication.isLogin()) {
            gF(false);
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.xe().xy()) {
            gF(false);
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.aqE()) {
            gF(false);
        } else {
            gF(true);
            String lP = lP("remind_recommend_data_time");
            long currentTimeMillis = System.currentTimeMillis();
            long loadLong = currentTimeMillis - TbadkSettings.getInst().loadLong(lP, currentTimeMillis);
            if (loadLong == 0 || loadLong > 86400000) {
                ayM();
            }
        }
    }

    public String lP(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void ayM() {
        if (this.ddB != null && !this.ddE) {
            this.ddE = true;
            this.ddB.bY("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gF(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m411getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m411getInst().getApp(), 0, new Intent(TbadkCoreApplication.m411getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            long ayJ = com.baidu.tieba.tblauncher.alarmRemind.a.ayJ();
            if (ayJ > System.currentTimeMillis()) {
                alarmManager.setRepeating(0, ayJ, 86400000L, broadcast);
                return;
            } else {
                alarmManager.setRepeating(0, ayJ + 86400000, 86400000L, broadcast);
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
                b.this.ayL();
            }
        }
    }
}
