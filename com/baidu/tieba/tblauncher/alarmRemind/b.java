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
    private static b gCH;
    private ClientConfigModel gCF;
    private a gCG;
    private boolean gCI = false;
    private final com.baidu.tbadk.clientConfig.a TL = new com.baidu.tbadk.clientConfig.a() { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.1
        @Override // com.baidu.tbadk.clientConfig.a
        public void y(Object obj) {
            b.this.gCI = false;
            if (obj != null && (obj instanceof DataRes)) {
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String c = com.baidu.tieba.tblauncher.alarmRemind.a.c(dataRes);
                    if (!TextUtils.isEmpty(c)) {
                        TbadkSettings.getInst().saveString(b.this.ts("remind_recommend_info"), c);
                        TbadkSettings.getInst().saveInt(b.this.ts("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(b.this.ts("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        b.this.mE(true);
                        TbadkSettings.getInst().saveLong(b.this.ts("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.clientConfig.a
        public void onError(String str) {
            b.this.gCI = false;
        }
    };
    CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.gP() && b.this.bub()) {
                b.this.bua();
            }
        }
    };
    private CustomMessageListener bns = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.alarmRemind.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.bub()) {
                b.this.mE(true);
                b.this.bua();
            }
        }
    };

    public static b btZ() {
        if (gCH == null) {
            synchronized (b.class) {
                if (gCH == null) {
                    gCH = new b();
                }
            }
        }
        return gCH;
    }

    private b() {
    }

    public void m(BaseFragmentActivity baseFragmentActivity) {
        this.gCG = new a();
        baseFragmentActivity.registerListener(this.gCG);
        baseFragmentActivity.registerListener(this.mNetworkChangedListener);
        baseFragmentActivity.registerListener(this.bns);
        this.gCF = new ClientConfigModel(baseFragmentActivity, this.TL);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("tieba_last_active_time", System.currentTimeMillis());
        if (bub()) {
            mE(true);
            bua();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bua() {
        if (!com.baidu.tieba.tblauncher.alarmRemind.a.O(TbadkSettings.getInst().loadLong(ts("remind_recommend_data_time"), 0L))) {
            buc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bub() {
        if (!TbadkCoreApplication.isLogin()) {
            mE(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.btY()) {
            mE(false);
            return false;
        } else if (!com.baidu.tieba.tblauncher.alarmRemind.a.bkG()) {
            mE(false);
            return false;
        } else {
            return true;
        }
    }

    public String ts(String str) {
        return TbadkCoreApplication.getCurrentAccount() + str;
    }

    private void buc() {
        if (this.gCF != null && !this.gCI) {
            this.gCI = true;
            this.gCF.cy("local_dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE(boolean z) {
        AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
        if (z) {
            alarmManager.setRepeating(0, com.baidu.tieba.tblauncher.alarmRemind.a.btX() + 86400000, 86400000L, broadcast);
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
                if (b.this.bub()) {
                    b.this.mE(true);
                    b.this.bua();
                }
            }
        }
    }
}
