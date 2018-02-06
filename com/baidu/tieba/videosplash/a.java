package com.baidu.tieba.videosplash;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.u;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener aJC = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.videosplash.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.bEC();
            }
        }
    };
    private long frT;
    private long hzE;
    private u hzF;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        bEC();
        this.hzE = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.aJC);
    }

    public boolean bEB() {
        if (this.mStartTime == 0 || this.frT == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return h(date) && i(date);
    }

    private boolean h(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.frT;
    }

    private boolean i(Date date) {
        return date != null && date.getTime() - this.hzE >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEC() {
        if (this.hzF == null) {
            this.hzF = new u();
        }
        this.hzF.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", ""));
        this.mStartTime = this.hzF.Gb();
        this.frT = this.hzF.Gc();
        this.mInterval = this.hzF.Gd();
    }

    public void cV(long j) {
        this.hzE = j;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", j);
    }
}
