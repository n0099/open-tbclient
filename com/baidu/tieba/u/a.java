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
                a.this.cxI();
            }
        }
    };
    private long jFS;
    private y jFT;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        cxI();
        this.jFS = com.baidu.tbadk.core.sharedPref.b.ahO().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.bDy);
    }

    public boolean cxH() {
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
        return date != null && date.getTime() - this.jFS >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxI() {
        if (this.jFT == null) {
            this.jFT = new y();
        }
        this.jFT.parseJson(com.baidu.tbadk.core.sharedPref.b.ahO().getString("key_video_splash_config", ""));
        this.mStartTime = this.jFT.amI();
        this.aGT = this.jFT.amJ();
        this.mInterval = this.jFT.amK();
    }

    public void eE(long j) {
        this.jFS = j;
        com.baidu.tbadk.core.sharedPref.b.ahO().putLong("key_video_splash_last_show_time", j);
    }
}
