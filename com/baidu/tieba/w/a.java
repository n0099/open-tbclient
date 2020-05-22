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
    private CustomMessageListener dzd = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.Tt();
            }
        }
    };
    private long lLQ;
    private ab lLR;
    private long mEndTime;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        Tt();
        this.lLQ = com.baidu.tbadk.core.sharedPref.b.aTX().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.dzd);
    }

    public boolean dlI() {
        if (this.mStartTime == 0 || this.mEndTime == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return p(date) && q(date);
    }

    private boolean p(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.mEndTime;
    }

    private boolean q(Date date) {
        return date != null && date.getTime() - this.lLQ >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tt() {
        if (this.lLR == null) {
            this.lLR = new ab();
        }
        this.lLR.parseJson(com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.lLR.aYo();
        this.mEndTime = this.lLR.aYp();
        this.mInterval = this.lLR.aYq();
    }

    public void fv(long j) {
        this.lLQ = j;
        com.baidu.tbadk.core.sharedPref.b.aTX().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
