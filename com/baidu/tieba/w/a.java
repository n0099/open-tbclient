package com.baidu.tieba.w;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.coreExtra.data.ab;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener dld = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.QO();
            }
        }
    };
    private long ltm;
    private ab ltn;
    private long mEndTime;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        QO();
        this.ltm = com.baidu.tbadk.core.sharedPref.b.aNT().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.dld);
    }

    public boolean des() {
        if (this.mStartTime == 0 || this.mEndTime == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return o(date) && p(date);
    }

    private boolean o(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.mEndTime;
    }

    private boolean p(Date date) {
        return date != null && date.getTime() - this.ltm >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QO() {
        if (this.ltn == null) {
            this.ltn = new ab();
        }
        this.ltn.parseJson(com.baidu.tbadk.core.sharedPref.b.aNT().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.ltn.aSh();
        this.mEndTime = this.ltn.aSi();
        this.mInterval = this.ltn.aSj();
    }

    public void fv(long j) {
        this.ltm = j;
        com.baidu.tbadk.core.sharedPref.b.aNT().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
