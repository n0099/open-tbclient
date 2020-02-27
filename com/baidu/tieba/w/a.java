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
    private CustomMessageListener cLF = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.IY();
            }
        }
    };
    private long kHg;
    private ab kHh;
    private long mEndTime;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        IY();
        this.kHg = com.baidu.tbadk.core.sharedPref.b.aFB().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.cLF);
    }

    public boolean cTl() {
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
        return date != null && date.getTime() - this.kHg >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IY() {
        if (this.kHh == null) {
            this.kHh = new ab();
        }
        this.kHh.parseJson(com.baidu.tbadk.core.sharedPref.b.aFB().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.kHh.aJG();
        this.mEndTime = this.kHh.aJH();
        this.mInterval = this.kHh.aJI();
    }

    public void eI(long j) {
        this.kHg = j;
        com.baidu.tbadk.core.sharedPref.b.aFB().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
