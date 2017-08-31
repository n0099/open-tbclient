package com.baidu.tieba.tblauncher.alarmRemind;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.clientConfig.ClientConfigModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes.dex */
public class b {
    private static b gmV;
    private ClientConfigModel gmT;
    private a gmU;
    private boolean gmW = false;
    private final com.baidu.tbadk.clientConfig.a RJ = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void y(Object obj) {
            b.this.gmW = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.sy("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.sy("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.sy("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.mS(true);
                        TbadkSettings.getInst().saveLong(b.this.sy("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.gmW = false;
        }
    };
    private final CustomMessageListener gmX = new CustomMessageListener(CmdConfigCustom.CMD_REMIND_RECOMMEND_SWITCH) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001356 && b.this.bun()) {
                b.this.mS(true);
                b.this.bum();
            }
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && i.hi() && b.this.bun()) {
                b.this.bum();
            }
        }
    };
    private CustomMessageListener dMO = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.bun()) {
                b.this.mS(true);
                b.this.bum();
            }
        }
    };

    public static b bul() {
        if (gmV == null) {
            synchronized (b.class) {
                if (gmV == null) {
                    gmV = new b();
                }
            }
        }
        return gmV;
    }

    private b() {
    }

    public void g(BaseFragmentActivity baseFragmentActivity) {
        this.gmU = new a();
        baseFragmentActivity.registerListener(this.gmU);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.gmX);
        baseFragmentActivity.registerListener(this.dMO);
        this.gmT = new ClientConfigModel(baseFragmentActivity, this.RJ);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bun()) {
            mS(true);
            bum();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bum() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.cQ(TbadkSettings.getInst().loadLong(sy("remind_recommend_data_time"), 0L))) {
            buo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bun() {
        if (!TbadkCoreApplication.isLogin()) {
            mS(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.buk()) {
            mS(false);
            return false;
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.b.zA().zT()) {
            mS(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.biq()) {
            mS(false);
            return false;
        } else {
            return true;
        }
    }

    public String sy(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void buo() {
        if (this.gmT != null && !this.gmW) {
            this.gmW = true;
            this.gmT.cj("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mS(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.buj() + 86400000, 86400000L, broadcast);
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
                if (b.this.bun()) {
                    b.this.mS(true);
                    b.this.bum();
                }
            }
        }
    }
}
