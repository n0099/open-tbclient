package com.baidu.tieba.v;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.coreExtra.data.z;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private long bDa;
    private CustomMessageListener cHq = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.v.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.Gn();
            }
        }
    };
    private long kCE;
    private z kCF;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        Gn();
        this.kCE = com.baidu.tbadk.core.sharedPref.b.aCY().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.cHq);
    }

    public boolean cQL() {
        if (this.mStartTime == 0 || this.bDa == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return o(date) && p(date);
    }

    private boolean o(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.bDa;
    }

    private boolean p(Date date) {
        return date != null && date.getTime() - this.kCE >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gn() {
        if (this.kCF == null) {
            this.kCF = new z();
        }
        this.kCF.parseJson(com.baidu.tbadk.core.sharedPref.b.aCY().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.kCF.aGT();
        this.bDa = this.kCF.aGU();
        this.mInterval = this.kCF.aGV();
    }

    public void eF(long j) {
        this.kCE = j;
        com.baidu.tbadk.core.sharedPref.b.aCY().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
