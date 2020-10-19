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
    private CustomMessageListener eiR = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.aeD();
            }
        }
    };
    private long mEndTime;
    private long mInterval;
    private long mStartTime;
    private long nfG;
    private ai nfH;

    public a() {
        init();
    }

    private void init() {
        aeD();
        this.nfG = com.baidu.tbadk.core.sharedPref.b.blO().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.eiR);
    }

    public boolean dMG() {
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
        return date != null && date.getTime() - this.nfG >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeD() {
        if (this.nfH == null) {
            this.nfH = new ai();
        }
        this.nfH.parseJson(com.baidu.tbadk.core.sharedPref.b.blO().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.nfH.bqF();
        this.mEndTime = this.nfH.bqG();
        this.mInterval = this.nfH.bqH();
    }

    public void gG(long j) {
        this.nfG = j;
        com.baidu.tbadk.core.sharedPref.b.blO().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
