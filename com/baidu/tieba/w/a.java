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
    private CustomMessageListener eMe = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.amH();
            }
        }
    };
    private long mEndTime;
    private long mInterval;
    private long mStartTime;
    private long nQH;
    private ai nQI;

    public a() {
        init();
    }

    private void init() {
        amH();
        this.nQH = com.baidu.tbadk.core.sharedPref.b.bvq().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.eMe);
    }

    public boolean dXn() {
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
        return date != null && date.getTime() - this.nQH >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amH() {
        if (this.nQI == null) {
            this.nQI = new ai();
        }
        this.nQI.parseJson(com.baidu.tbadk.core.sharedPref.b.bvq().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.nQI.bAi();
        this.mEndTime = this.nQI.bAj();
        this.mInterval = this.nQI.bAk();
    }

    public void hF(long j) {
        this.nQH = j;
        com.baidu.tbadk.core.sharedPref.b.bvq().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
