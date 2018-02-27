package com.baidu.tieba.videosplash;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.u;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener aJr = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.videosplash.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.bEB();
            }
        }
    };
    private long frH;
    private long hzr;
    private u hzs;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        bEB();
        this.hzr = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.aJr);
    }

    public boolean bEA() {
        if (this.mStartTime == 0 || this.frH == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return h(date) && i(date);
    }

    private boolean h(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.frH;
    }

    private boolean i(Date date) {
        return date != null && date.getTime() - this.hzr >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEB() {
        if (this.hzs == null) {
            this.hzs = new u();
        }
        this.hzs.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", ""));
        this.mStartTime = this.hzs.Ga();
        this.frH = this.hzs.Gb();
        this.mInterval = this.hzs.Gc();
    }

    public void cV(long j) {
        this.hzr = j;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", j);
    }
}
