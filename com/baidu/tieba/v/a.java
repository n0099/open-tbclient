package com.baidu.tieba.v;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.u;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private long aab;
    private CustomMessageListener acJ = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.v.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.bEW();
            }
        }
    };
    private long hiQ;
    private u hiR;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        bEW();
        this.hiQ = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.acJ);
    }

    public boolean bEV() {
        if (this.mStartTime == 0 || this.aab == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return k(date) && l(date);
    }

    private boolean k(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.aab;
    }

    private boolean l(Date date) {
        return date != null && date.getTime() - this.hiQ >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEW() {
        if (this.hiR == null) {
            this.hiR = new u();
        }
        this.hiR.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", ""));
        this.mStartTime = this.hiR.Cn();
        this.aab = this.hiR.Co();
        this.mInterval = this.hiR.Cp();
    }

    public void dg(long j) {
        this.hiQ = j;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", j);
    }
}
