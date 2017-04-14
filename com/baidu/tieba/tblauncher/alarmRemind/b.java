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
    private static b fAs;
    private ClientConfigModel fAq;
    private a fAr;
    private boolean fAt = false;
    private final com.baidu.tbadk.clientConfig.b RU = new c(this);
    private final CustomMessageListener fAu = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener mNetworkChangedListener = new e(this, 2000994);
    private CustomMessageListener dkH = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b bkf() {
        if (fAs == null) {
            synchronized (b.class) {
                if (fAs == null) {
                    fAs = new b();
                }
            }
        }
        return fAs;
    }

    private b() {
    }

    public void g(BaseFragmentActivity baseFragmentActivity) {
        this.fAr = new a();
        baseFragmentActivity.registerListener(this.fAr);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.fAu);
        baseFragmentActivity.registerListener(this.dkH);
        this.fAq = new ClientConfigModel(baseFragmentActivity, this.RU);
        com.baidu.tbadk.core.sharedPref.b.uL().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bkh()) {
            ls(true);
            bkg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkg() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.cD(TbadkSettings.getInst().loadLong(qy("remind_recommend_data_time"), 0L))) {
            bki();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bkh() {
        if (!TbadkCoreApplication.isLogin()) {
            ls(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bke()) {
            ls(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.zG().zZ()) {
            ls(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.baW()) {
            ls(false);
            return false;
        } else {
            return true;
        }
    }

    public String qy(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void bki() {
        if (this.fAq != null && !this.fAt) {
            this.fAt = true;
            this.fAq.bZ("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ls(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m9getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst().getApp(), 0, new Intent(TbadkCoreApplication.m9getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.bkd() + 86400000, 86400000L, broadcast);
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
                if (b.this.bkh()) {
                    b.this.ls(true);
                    b.this.bkg();
                }
            }
        }
    }
}
