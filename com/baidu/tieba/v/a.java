package com.baidu.tieba.v;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.coreExtra.data.aa;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private long bDL;
    private CustomMessageListener cHC = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.v.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.GJ();
            }
        }
    };
    private long kGl;
    private aa kGm;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        GJ();
        this.kGl = com.baidu.tbadk.core.sharedPref.b.aDr().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.cHC);
    }

    public boolean cRQ() {
        if (this.mStartTime == 0 || this.bDL == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return o(date) && p(date);
    }

    private boolean o(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.bDL;
    }

    private boolean p(Date date) {
        return date != null && date.getTime() - this.kGl >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GJ() {
        if (this.kGm == null) {
            this.kGm = new aa();
        }
        this.kGm.parseJson(com.baidu.tbadk.core.sharedPref.b.aDr().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.kGm.aHn();
        this.bDL = this.kGm.aHo();
        this.mInterval = this.kGm.aHp();
    }

    public void eK(long j) {
        this.kGl = j;
        com.baidu.tbadk.core.sharedPref.b.aDr().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
