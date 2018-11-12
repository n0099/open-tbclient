package com.baidu.tieba.u;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.x;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener akD = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.u.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.bJL();
            }
        }
    };
    private long hET;
    private x hEU;
    private long mEndTime;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        bJL();
        this.hET = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.akD);
    }

    public boolean bJK() {
        if (this.mStartTime == 0 || this.mEndTime == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return k(date) && l(date);
    }

    private boolean k(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.mEndTime;
    }

    private boolean l(Date date) {
        return date != null && date.getTime() - this.hET >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJL() {
        if (this.hEU == null) {
            this.hEU = new x();
        }
        this.hEU.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", ""));
        this.mStartTime = this.hEU.FV();
        this.mEndTime = this.hEU.FW();
        this.mInterval = this.hEU.FX();
    }

    public void df(long j) {
        this.hET = j;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", j);
    }
}
