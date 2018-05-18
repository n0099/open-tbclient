package com.baidu.tieba.s;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.u;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener UJ = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.s.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.bzR();
            }
        }
    };
    private long eNK;
    private long gXo;
    private u gXp;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        bzR();
        this.gXo = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.UJ);
    }

    public boolean bzQ() {
        if (this.mStartTime == 0 || this.eNK == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return i(date) && j(date);
    }

    private boolean i(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.eNK;
    }

    private boolean j(Date date) {
        return date != null && date.getTime() - this.gXo >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzR() {
        if (this.gXp == null) {
            this.gXp = new u();
        }
        this.gXp.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", ""));
        this.mStartTime = this.gXp.yN();
        this.eNK = this.gXp.yO();
        this.mInterval = this.gXp.yP();
    }

    public void cZ(long j) {
        this.gXo = j;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", j);
    }
}
