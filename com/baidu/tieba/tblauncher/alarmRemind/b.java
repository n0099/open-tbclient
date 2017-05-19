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
    private static b fzk;
    private ClientConfigModel fzi;
    private a fzj;
    private boolean fzl = false;
    private final com.baidu.tbadk.clientConfig.b Rn = new c(this);
    private final CustomMessageListener fzm = new d(this, CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH);
    CustomMessageListener mNetworkChangedListener = new e(this, 2000994);
    private CustomMessageListener dhc = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    public static b biL() {
        if (fzk == null) {
            synchronized (b.class) {
                if (fzk == null) {
                    fzk = new b();
                }
            }
        }
        return fzk;
    }

    private b() {
    }

    public void g(BaseFragmentActivity baseFragmentActivity) {
        this.fzj = new a();
        baseFragmentActivity.registerListener(this.fzj);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.fzm);
        baseFragmentActivity.registerListener(this.dhc);
        this.fzi = new ClientConfigModel(baseFragmentActivity, this.Rn);
        com.baidu.tbadk.core.sharedPref.b.tX().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (biN()) {
            lj(true);
            biM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biM() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.co(TbadkSettings.getInst().loadLong(qt("remind_recommend_data_time"), 0L))) {
            biO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean biN() {
        if (!TbadkCoreApplication.isLogin()) {
            lj(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.biK()) {
            lj(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.yR().zk()) {
            lj(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.aZw()) {
            lj(false);
            return false;
        } else {
            return true;
        }
    }

    public String qt(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + str;
    }

    private void biO() {
        if (this.fzi != null && !this.fzl) {
            this.fzl = true;
            this.fzi.bZ("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.m9getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst().getApp(), 0, new Intent(TbadkCoreApplication.m9getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.biJ() + 86400000, 86400000L, broadcast);
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
                com.baidu.tbadk.core.sharedPref.b.tX().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.biN()) {
                    b.this.lj(true);
                    b.this.biM();
                }
            }
        }
    }
}
