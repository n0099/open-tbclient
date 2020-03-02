package com.baidu.tieba.w;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.coreExtra.data.ab;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener cLG = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.Ja();
            }
        }
    };
    private long kHi;
    private ab kHj;
    private long mEndTime;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        Ja();
        this.kHi = com.baidu.tbadk.core.sharedPref.b.aFD().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.cLG);
    }

    public boolean cTn() {
        if (this.mStartTime == 0 || this.mEndTime == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return o(date) && p(date);
    }

    private boolean o(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.mEndTime;
    }

    private boolean p(Date date) {
        return date != null && date.getTime() - this.kHi >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ja() {
        if (this.kHj == null) {
            this.kHj = new ab();
        }
        this.kHj.parseJson(com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.kHj.aJI();
        this.mEndTime = this.kHj.aJJ();
        this.mInterval = this.kHj.aJK();
    }

    public void eI(long j) {
        this.kHi = j;
        com.baidu.tbadk.core.sharedPref.b.aFD().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
