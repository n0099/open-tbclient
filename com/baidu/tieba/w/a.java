package com.baidu.tieba.w;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.coreExtra.data.ah;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener dUB = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.abi();
            }
        }
    };
    private long mEndTime;
    private long mFX;
    private ah mFY;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        abi();
        this.mFX = com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.dUB);
    }

    public boolean dER() {
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
        return date != null && date.getTime() - this.mFX >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abi() {
        if (this.mFY == null) {
            this.mFY = new ah();
        }
        this.mFY.parseJson(com.baidu.tbadk.core.sharedPref.b.bik().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.mFY.bnb();
        this.mEndTime = this.mFY.bnc();
        this.mInterval = this.mFY.bnd();
    }

    public void fY(long j) {
        this.mFX = j;
        com.baidu.tbadk.core.sharedPref.b.bik().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
