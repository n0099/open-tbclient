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
    private CustomMessageListener bVR = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.u.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.cwH();
            }
        }
    };
    private long baF;
    private long jJm;
    private z jJn;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        cwH();
        this.jJm = com.baidu.tbadk.core.sharedPref.b.alR().getLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        MessageManager.getInstance().registerListener(this.bVR);
    }

    public boolean cwG() {
        if (this.mStartTime == 0 || this.baF == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return l(date) && m(date);
    }

    private boolean l(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.baF;
    }

    private boolean m(Date date) {
        return date != null && date.getTime() - this.jJm >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwH() {
        if (this.jJn == null) {
            this.jJn = new z();
        }
        this.jJn.parseJson(com.baidu.tbadk.core.sharedPref.b.alR().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, ""));
        this.mStartTime = this.jJn.apx();
        this.baF = this.jJn.apy();
        this.mInterval = this.jJn.apz();
    }

    public void eb(long j) {
        this.jJm = j;
        com.baidu.tbadk.core.sharedPref.b.alR().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, j);
    }
}
