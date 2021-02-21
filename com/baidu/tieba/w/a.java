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
    private long nWt;
    private ai nWu;

    public a() {
        init();
    }

    private void init() {
        ajm();
        this.nWt = com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.eJz);
    }

    public boolean dVQ() {
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
        return date != null && date.getTime() - this.nWt >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajm() {
        if (this.nWu == null) {
            this.nWu = new ai();
        }
        this.nWu.parseJson(com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.nWu.bwH();
        this.mEndTime = this.nWu.bwI();
        this.mInterval = this.nWu.bwJ();
    }

    public void hK(long j) {
        this.nWt = j;
        com.baidu.tbadk.core.sharedPref.b.brQ().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
