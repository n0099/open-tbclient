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
    private CustomMessageListener dWP = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.abR();
            }
        }
    };
    private long mEndTime;
    private long mInterval;
    private long mQb;
    private ai mQc;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        abR();
        this.mQb = com.baidu.tbadk.core.sharedPref.b.bjf().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.dWP);
    }

    public boolean dIU() {
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
        return date != null && date.getTime() - this.mQb >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abR() {
        if (this.mQc == null) {
            this.mQc = new ai();
        }
        this.mQc.parseJson(com.baidu.tbadk.core.sharedPref.b.bjf().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.mQc.bnV();
        this.mEndTime = this.mQc.bnW();
        this.mInterval = this.mQc.bnX();
    }

    public void go(long j) {
        this.mQb = j;
        com.baidu.tbadk.core.sharedPref.b.bjf().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
