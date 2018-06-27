package com.baidu.tieba.v;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.u;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private long aae;
    private CustomMessageListener acM = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.v.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.bFw();
            }
        }
    };
    private long hmV;
    private u hmW;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        bFw();
        this.hmV = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.acM);
    }

    public boolean bFv() {
        if (this.mStartTime == 0 || this.aae == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return k(date) && l(date);
    }

    private boolean k(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.aae;
    }

    private boolean l(Date date) {
        return date != null && date.getTime() - this.hmV >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFw() {
        if (this.hmW == null) {
            this.hmW = new u();
        }
        this.hmW.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", ""));
        this.mStartTime = this.hmW.CF();
        this.aae = this.hmW.CG();
        this.mInterval = this.hmW.CH();
    }

    public void de(long j) {
        this.hmV = j;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", j);
    }
}
