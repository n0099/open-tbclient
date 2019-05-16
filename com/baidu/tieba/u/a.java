package com.baidu.tieba.u;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.y;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private long aGl;
    private CustomMessageListener bCA = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.u.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.cuS();
            }
        }
    };
    private long jzF;
    private y jzG;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        cuS();
        this.jzF = com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.bCA);
    }

    public boolean cuR() {
        if (this.mStartTime == 0 || this.aGl == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return q(date) && r(date);
    }

    private boolean q(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.aGl;
    }

    private boolean r(Date date) {
        return date != null && date.getTime() - this.jzF >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuS() {
        if (this.jzG == null) {
            this.jzG = new y();
        }
        this.jzG.parseJson(com.baidu.tbadk.core.sharedPref.b.agM().getString("key_video_splash_config", ""));
        this.mStartTime = this.jzG.alD();
        this.aGl = this.jzG.alE();
        this.mInterval = this.jzG.alF();
    }

    public void ew(long j) {
        this.jzF = j;
        com.baidu.tbadk.core.sharedPref.b.agM().putLong("key_video_splash_last_show_time", j);
    }
}
