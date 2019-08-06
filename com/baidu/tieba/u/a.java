package com.baidu.tieba.u;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.y;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private long aGT;
    private CustomMessageListener bDy = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.u.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.cye();
            }
        }
    };
    private long jGZ;
    private y jHa;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        cye();
        this.jGZ = com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.bDy);
    }

    public boolean cyd() {
        if (this.mStartTime == 0 || this.aGT == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return q(date) && r(date);
    }

    private boolean q(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.aGT;
    }

    private boolean r(Date date) {
        return date != null && date.getTime() - this.jGZ >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cye() {
        if (this.jHa == null) {
            this.jHa = new y();
        }
        this.jHa.parseJson(com.baidu.tbadk.core.sharedPref.b.ahQ().getString("key_video_splash_config", ""));
        this.mStartTime = this.jHa.amK();
        this.aGT = this.jHa.amL();
        this.mInterval = this.jHa.amM();
    }

    public void eE(long j) {
        this.jGZ = j;
        com.baidu.tbadk.core.sharedPref.b.ahQ().putLong("key_video_splash_last_show_time", j);
    }
}
