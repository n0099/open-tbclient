package com.baidu.tieba.w;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.coreExtra.data.ae;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener dFw = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.Uz();
            }
        }
    };
    private long mEndTime;
    private long mInterval;
    private long mStartTime;
    private long mgS;
    private ae mgT;

    public a() {
        init();
    }

    private void init() {
        Uz();
        this.mgS = com.baidu.tbadk.core.sharedPref.b.aVP().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.dFw);
    }

    public boolean dqm() {
        if (this.mStartTime == 0 || this.mEndTime == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return p(date) && q(date);
    }

    private boolean p(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.mEndTime;
    }

    private boolean q(Date date) {
        return date != null && date.getTime() - this.mgS >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uz() {
        if (this.mgT == null) {
            this.mgT = new ae();
        }
        this.mgT.parseJson(com.baidu.tbadk.core.sharedPref.b.aVP().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.mgT.bau();
        this.mEndTime = this.mgT.bav();
        this.mInterval = this.mgT.baw();
    }

    public void fz(long j) {
        this.mgS = j;
        com.baidu.tbadk.core.sharedPref.b.aVP().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
