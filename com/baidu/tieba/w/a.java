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
    private CustomMessageListener exi = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.aiX();
            }
        }
    };
    private long mEndTime;
    private long mInterval;
    private long mStartTime;
    private long nyc;
    private ai nyd;

    public a() {
        init();
    }

    private void init() {
        aiX();
        this.nyc = com.baidu.tbadk.core.sharedPref.b.bqh().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.exi);
    }

    public boolean dSq() {
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
        return date != null && date.getTime() - this.nyc >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiX() {
        if (this.nyd == null) {
            this.nyd = new ai();
        }
        this.nyd.parseJson(com.baidu.tbadk.core.sharedPref.b.bqh().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.nyd.buY();
        this.mEndTime = this.nyd.buZ();
        this.mInterval = this.nyd.bva();
    }

    public void hd(long j) {
        this.nyc = j;
        com.baidu.tbadk.core.sharedPref.b.bqh().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
