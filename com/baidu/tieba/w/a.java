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
    private CustomMessageListener dUF = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.abi();
            }
        }
    };
    private long mEndTime;
    private long mGq;
    private ah mGr;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        abi();
        this.mGq = com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.dUF);
    }

    public boolean dFa() {
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
        return date != null && date.getTime() - this.mGq >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abi() {
        if (this.mGr == null) {
            this.mGr = new ah();
        }
        this.mGr.parseJson(com.baidu.tbadk.core.sharedPref.b.bik().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.mGr.bnb();
        this.mEndTime = this.mGr.bnc();
        this.mInterval = this.mGr.bnd();
    }

    public void ga(long j) {
        this.mGq = j;
        com.baidu.tbadk.core.sharedPref.b.bik().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
