package com.baidu.tieba.v;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.y;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener aoH = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.v.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.bNn();
            }
        }
    };
    private long hQw;
    private y hQx;
    private long mEndTime;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        bNn();
        this.hQw = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.aoH);
    }

    public boolean bNm() {
        if (this.mStartTime == 0 || this.mEndTime == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return l(date) && m(date);
    }

    private boolean l(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.mEndTime;
    }

    private boolean m(Date date) {
        return date != null && date.getTime() - this.hQw >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNn() {
        if (this.hQx == null) {
            this.hQx = new y();
        }
        this.hQx.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", ""));
        this.mStartTime = this.hQx.Ho();
        this.mEndTime = this.hQx.Hp();
        this.mInterval = this.hQx.Hq();
    }

    public void dr(long j) {
        this.hQw = j;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", j);
    }
}
