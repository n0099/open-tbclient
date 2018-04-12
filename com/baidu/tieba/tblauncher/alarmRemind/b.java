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
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes.dex */
public class b {
    private static b gBH;
    private ClientConfigModel gBF;
    private a gBG;
    private boolean gBI = false;
    private final com.baidu.tbadk.clientConfig.a TQ = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void y(Object obj) {
            b.this.gBI = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.tp("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.tp("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.tp("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.mD(true);
                        TbadkSettings.getInst().saveLong(b.this.tp("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.gBI = false;
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.gP() && b.this.bud()) {
                b.this.buc();
            }
        }
    };
    private CustomMessageListener bnd = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.bud()) {
                b.this.mD(true);
                b.this.buc();
            }
        }
    };

    public static b bub() {
        if (gBH == null) {
            synchronized (b.class) {
                if (gBH == null) {
                    gBH = new b();
                }
            }
        }
        return gBH;
    }

    private b() {
    }

    public void m(BaseFragmentActivity baseFragmentActivity) {
        this.gBG = new a();
        baseFragmentActivity.registerListener(this.gBG);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.bnd);
        this.gBF = new ClientConfigModel(baseFragmentActivity, this.TQ);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bud()) {
            mD(true);
            buc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buc() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.O(TbadkSettings.getInst().loadLong(tp("remind_recommend_data_time"), 0L))) {
            bue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bud() {
        if (!TbadkCoreApplication.isLogin()) {
            mD(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bua()) {
            mD(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bkH()) {
            mD(false);
            return false;
        } else {
            return true;
        }
    }

    public String tp(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void bue() {
        if (this.gBF != null && !this.gBI) {
            this.gBI = true;
            this.gBF.cy("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.btZ() + 86400000, 86400000L, broadcast);
        } else {
            alarmManager.cancel(broadcast);
        }
    }

    /* loaded from: classes.dex */
    private class a extends CustomMessageListener {
        public a() {
            super(2001011);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null && !data.booleanValue()) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
                if (b.this.bud()) {
                    b.this.mD(true);
                    b.this.buc();
                }
            }
        }
    }
}
