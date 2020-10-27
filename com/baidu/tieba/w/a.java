package com.baidu.tieba.w;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.coreExtra.data.ai;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener erp = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.agx();
            }
        }
    };
    private long mEndTime;
    private long mInterval;
    private long mStartTime;
    private long nsh;
    private ai nsi;

    public a() {
        init();
    }

    private void init() {
        agx();
        this.nsh = com.baidu.tbadk.core.sharedPref.b.bnH().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.erp);
    }

    public boolean dPO() {
        if (this.mStartTime == 0 || this.mEndTime == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return s(date) && t(date);
    }

    private boolean s(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.mEndTime;
    }

    private boolean t(Date date) {
        return date != null && date.getTime() - this.nsh >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agx() {
        if (this.nsi == null) {
            this.nsi = new ai();
        }
        this.nsi.parseJson(com.baidu.tbadk.core.sharedPref.b.bnH().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.nsi.bsy();
        this.mEndTime = this.nsi.bsz();
        this.mInterval = this.nsi.bsA();
    }

    public void gH(long j) {
        this.nsh = j;
        com.baidu.tbadk.core.sharedPref.b.bnH().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
