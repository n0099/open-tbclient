package com.baidu.tieba.videosplash;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.u;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener aJs = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.videosplash.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.bEG();
            }
        }
    };
    private long frX;
    private long hzP;
    private u hzQ;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        bEG();
        this.hzP = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.aJs);
    }

    public boolean bEF() {
        if (this.mStartTime == 0 || this.frX == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return h(date) && i(date);
    }

    private boolean h(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.frX;
    }

    private boolean i(Date date) {
        return date != null && date.getTime() - this.hzP >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEG() {
        if (this.hzQ == null) {
            this.hzQ = new u();
        }
        this.hzQ.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", ""));
        this.mStartTime = this.hzQ.Gb();
        this.frX = this.hzQ.Gc();
        this.mInterval = this.hzQ.Gd();
    }

    public void cV(long j) {
        this.hzP = j;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", j);
    }
}
