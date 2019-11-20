package com.baidu.tieba.u;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.coreExtra.data.z;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener bVa = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.u.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.cwF();
            }
        }
    };
    private long ban;
    private long jIv;
    private z jIw;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        cwF();
        this.jIv = com.baidu.tbadk.core.sharedPref.b.alP().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.bVa);
    }

    public boolean cwE() {
        if (this.mStartTime == 0 || this.ban == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return l(date) && m(date);
    }

    private boolean l(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.ban;
    }

    private boolean m(Date date) {
        return date != null && date.getTime() - this.jIv >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwF() {
        if (this.jIw == null) {
            this.jIw = new z();
        }
        this.jIw.parseJson(com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.jIw.apv();
        this.ban = this.jIw.apw();
        this.mInterval = this.jIw.apx();
    }

    public void ea(long j) {
        this.jIv = j;
        com.baidu.tbadk.core.sharedPref.b.alP().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
