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
                a.this.amI();
            }
        }
    };
    private long mEndTime;
    private long mInterval;
    private long mStartTime;
    private long nQG;
    private ai nQH;

    public a() {
        init();
    }

    private void init() {
        amI();
        this.nQG = com.baidu.tbadk.core.sharedPref.b.bvr().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.eMe);
    }

    public boolean dXo() {
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
        return date != null && date.getTime() - this.nQG >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amI() {
        if (this.nQH == null) {
            this.nQH = new ai();
        }
        this.nQH.parseJson(com.baidu.tbadk.core.sharedPref.b.bvr().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.nQH.bAj();
        this.mEndTime = this.nQH.bAk();
        this.mInterval = this.nQH.bAl();
    }

    public void hF(long j) {
        this.nQG = j;
        com.baidu.tbadk.core.sharedPref.b.bvr().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
