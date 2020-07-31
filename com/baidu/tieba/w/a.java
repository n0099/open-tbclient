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
    private CustomMessageListener dLt = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.w.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.Vd();
            }
        }
    };
    private long mEndTime;
    private long mInterval;
    private long mStartTime;
    private long moh;
    private ae moi;

    public a() {
        init();
    }

    private void init() {
        Vd();
        this.moh = com.baidu.tbadk.core.sharedPref.b.aZP().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.dLt);
    }

    public boolean dtv() {
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
        return date != null && date.getTime() - this.moh >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vd() {
        if (this.moi == null) {
            this.moi = new ae();
        }
        this.moi.parseJson(com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.moi.ber();
        this.mEndTime = this.moi.bes();
        this.mInterval = this.moi.bet();
    }

    public void fM(long j) {
        this.moh = j;
        com.baidu.tbadk.core.sharedPref.b.aZP().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
