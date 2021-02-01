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
    private CustomMessageListener eJz = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.ajm();
            }
        }
    };
    private long mEndTime;
    private long mInterval;
    private long mStartTime;
    private long nVT;
    private ai nVU;

    public a() {
        init();
    }

    private void init() {
        ajm();
        this.nVT = com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.eJz);
    }

    public boolean dVI() {
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
        return date != null && date.getTime() - this.nVT >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajm() {
        if (this.nVU == null) {
            this.nVU = new ai();
        }
        this.nVU.parseJson(com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.nVU.bwH();
        this.mEndTime = this.nVU.bwI();
        this.mInterval = this.nVU.bwJ();
    }

    public void hK(long j) {
        this.nVT = j;
        com.baidu.tbadk.core.sharedPref.b.brQ().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
