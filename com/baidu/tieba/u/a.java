package com.baidu.tieba.u;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.z;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private long aHr;
    private CustomMessageListener bDW = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.u.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.cyS();
            }
        }
    };
    private long jJu;
    private z jJv;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        cyS();
        this.jJu = com.baidu.tbadk.core.sharedPref.b.ahU().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.bDW);
    }

    public boolean cyR() {
        if (this.mStartTime == 0 || this.aHr == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return q(date) && r(date);
    }

    private boolean q(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.aHr;
    }

    private boolean r(Date date) {
        return date != null && date.getTime() - this.jJu >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyS() {
        if (this.jJv == null) {
            this.jJv = new z();
        }
        this.jJv.parseJson(com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_video_splash_config", ""));
        this.mStartTime = this.jJv.amW();
        this.aHr = this.jJv.amX();
        this.mInterval = this.jJv.amY();
    }

    public void eH(long j) {
        this.jJu = j;
        com.baidu.tbadk.core.sharedPref.b.ahU().putLong("key_video_splash_last_show_time", j);
    }
}
