package com.baidu.tieba.u;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.w;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private long ack;
    private CustomMessageListener aeT = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.u.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.bHa();
            }
        }
    };
    private long hvW;
    private w hvX;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        bHa();
        this.hvW = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.aeT);
    }

    public boolean bGZ() {
        if (this.mStartTime == 0 || this.ack == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return k(date) && l(date);
    }

    private boolean k(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.ack;
    }

    private boolean l(Date date) {
        return date != null && date.getTime() - this.hvW >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHa() {
        if (this.hvX == null) {
            this.hvX = new w();
        }
        this.hvX.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", ""));
        this.mStartTime = this.hvX.DI();
        this.ack = this.hvX.DJ();
        this.mInterval = this.hvX.DK();
    }

    public void dd(long j) {
        this.hvW = j;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", j);
    }
}
