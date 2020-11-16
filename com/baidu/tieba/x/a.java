package com.baidu.tieba.x;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.coreExtra.data.ai;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener evz = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.x.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.aip();
            }
        }
    };
    private long mEndTime;
    private long mInterval;
    private long mStartTime;
    private long nzj;
    private ai nzk;

    public a() {
        init();
    }

    private void init() {
        aip();
        this.nzj = com.baidu.tbadk.core.sharedPref.b.bpu().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.evz);
    }

    public boolean dSp() {
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
        return date != null && date.getTime() - this.nzj >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aip() {
        if (this.nzk == null) {
            this.nzk = new ai();
        }
        this.nzk.parseJson(com.baidu.tbadk.core.sharedPref.b.bpu().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.nzk.buo();
        this.mEndTime = this.nzk.bup();
        this.mInterval = this.nzk.buq();
    }

    public void hg(long j) {
        this.nzj = j;
        com.baidu.tbadk.core.sharedPref.b.bpu().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
