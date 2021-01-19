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
    private CustomMessageListener eHt = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.aiO();
            }
        }
    };
    private long mEndTime;
    private long mInterval;
    private long mStartTime;
    private long nMc;
    private ai nMd;

    public a() {
        init();
    }

    private void init() {
        aiO();
        this.nMc = com.baidu.tbadk.core.sharedPref.b.brx().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.eHt);
    }

    public boolean dTw() {
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
        return date != null && date.getTime() - this.nMc >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiO() {
        if (this.nMd == null) {
            this.nMd = new ai();
        }
        this.nMd.parseJson(com.baidu.tbadk.core.sharedPref.b.brx().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.nMd.bwp();
        this.mEndTime = this.nMd.bwq();
        this.mInterval = this.nMd.bwr();
    }

    public void hF(long j) {
        this.nMc = j;
        com.baidu.tbadk.core.sharedPref.b.brx().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
