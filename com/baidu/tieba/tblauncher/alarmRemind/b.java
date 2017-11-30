package com.baidu.tieba.tblauncher.alarmRemind;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.clientConfig.ClientConfigModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes.dex */
public class b {
    private static b gEf;
    private ClientConfigModel gEd;
    private a gEe;
    private boolean gEg = false;
    private final com.baidu.tbadk.clientConfig.a SK = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void y(Object obj) {
            b.this.gEg = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.tv("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.tv("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.tv("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.no(true);
                        TbadkSettings.getInst().saveLong(b.this.tv("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.gEg = false;
        }
    };
    private final CustomMessageListener gEh = new CustomMessageListener(CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001356 && b.this.byp()) {
                b.this.no(true);
                b.this.byo();
            }
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.hh() && b.this.byp()) {
                b.this.byo();
            }
        }
    };
    private CustomMessageListener cWV = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.byp()) {
                b.this.no(true);
                b.this.byo();
            }
        }
    };

    public static b byn() {
        if (gEf == null) {
            synchronized (b.class) {
                if (gEf == null) {
                    gEf = new b();
                }
            }
        }
        return gEf;
    }

    private b() {
    }

    public void g(BaseFragmentActivity baseFragmentActivity) {
        this.gEe = new a();
        baseFragmentActivity.registerListener(this.gEe);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.gEh);
        baseFragmentActivity.registerListener(this.cWV);
        this.gEd = new ClientConfigModel(baseFragmentActivity, this.SK);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (byp()) {
            no(true);
            byo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byo() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.O(TbadkSettings.getInst().loadLong(tv("remind_recommend_data_time"), 0L))) {
            byq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean byp() {
        if (!TbadkCoreApplication.isLogin()) {
            no(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bym()) {
            no(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.b.zj().zC()) {
            no(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bmv()) {
            no(false);
            return false;
        } else {
            return true;
        }
    }

    public String tv(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void byq() {
        if (this.gEd != null && !this.gEg) {
            this.gEg = true;
            this.gEd.co("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void no(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.byl() + 86400000, 86400000L, broadcast);
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
                if (b.this.byp()) {
                    b.this.no(true);
                    b.this.byo();
                }
            }
        }
    }
}
