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
    private static b fle;
    private com.baidu.tbadk.clientConfig.a flc;
    private a fld;
    private boolean flf = false;
    private final com.baidu.tbadk.clientConfig.c Nl = new c(this);
    private final CustomMessageListener flg = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener qR = new e(this, 2000994);
    private CustomMessageListener dcD = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b bhX() {
        if (fle == null) {
            synchronized (b.class) {
                if (fle == null) {
                    fle = new b();
                }
            }
        }
        return fle;
    }

    private b() {
    }

    public void g(BaseFragmentActivity baseFragmentActivity) {
        this.fld = new a();
        baseFragmentActivity.registerListener(this.fld);
        baseFragmentActivity.registerListener(this.qR);
        baseFragmentActivity.registerListener(this.flg);
        baseFragmentActivity.registerListener(this.dcD);
        this.flc = new com.baidu.tbadk.clientConfig.a(baseFragmentActivity, this.Nl);
        com.baidu.tbadk.core.sharedPref.b.tW().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bhZ()) {
            le(true);
            bhY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhY() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.cH(TbadkSettings.getInst().loadLong(qF("remind_recommend_data_time"), 0L))) {
            bia();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhZ() {
        if (!TbadkCoreApplication.isLogin()) {
            le(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bhW()) {
            le(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.yV().zo()) {
            le(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.aYN()) {
            le(false);
            return false;
        } else {
            return true;
        }
    }

    public String qF(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void bia() {
        if (this.flc != null && !this.flf) {
            this.flf = true;
            this.flc.cb("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void le(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m9getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst().getApp(), 0, new Intent(TbadkCoreApplication.m9getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.bhV() + 86400000, 86400000L, broadcast);
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
                com.baidu.tbadk.core.sharedPref.b.tW().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.bhZ()) {
                    b.this.le(true);
                    b.this.bhY();
                }
            }
        }
    }
}
