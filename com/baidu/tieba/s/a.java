package com.baidu.tieba.s;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.u;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener UN = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.s.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.bzT();
            }
        }
    };
    private long eMG;
    private long gWn;
    private u gWo;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        bzT();
        this.gWn = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.UN);
    }

    public boolean bzS() {
        if (this.mStartTime == 0 || this.eMG == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return i(date) && j(date);
    }

    private boolean i(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.eMG;
    }

    private boolean j(Date date) {
        return date != null && date.getTime() - this.gWn >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzT() {
        if (this.gWo == null) {
            this.gWo = new u();
        }
        this.gWo.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", ""));
        this.mStartTime = this.gWo.yO();
        this.eMG = this.gWo.yP();
        this.mInterval = this.gWo.yQ();
    }

    public void cZ(long j) {
        this.gWn = j;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", j);
    }
}
