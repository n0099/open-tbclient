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
    private CustomMessageListener eCA = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.x.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.alx();
            }
        }
    };
    private long mEndTime;
    private long mInterval;
    private long mStartTime;
    private long nNm;
    private ai nNn;

    public a() {
        init();
    }

    private void init() {
        alx();
        this.nNm = com.baidu.tbadk.core.sharedPref.b.bsO().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.eCA);
    }

    public boolean dXK() {
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
        return date != null && date.getTime() - this.nNm >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alx() {
        if (this.nNn == null) {
            this.nNn = new ai();
        }
        this.nNn.parseJson(com.baidu.tbadk.core.sharedPref.b.bsO().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.nNn.bxO();
        this.mEndTime = this.nNn.bxP();
        this.mInterval = this.nNn.bxQ();
    }

    public void hL(long j) {
        this.nNm = j;
        com.baidu.tbadk.core.sharedPref.b.bsO().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
