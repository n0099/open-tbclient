package com.baidu.tieba.u;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.y;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private long aEp;
    private CustomMessageListener bvt = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.u.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.cmR();
            }
        }
    };
    private long jgW;
    private y jgX;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        cmR();
        this.jgW = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.bvt);
    }

    public boolean cmQ() {
        if (this.mStartTime == 0 || this.aEp == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return q(date) && r(date);
    }

    private boolean q(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.aEp;
    }

    private boolean r(Date date) {
        return date != null && date.getTime() - this.jgW >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmR() {
        if (this.jgX == null) {
            this.jgX = new y();
        }
        this.jgX.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", ""));
        this.mStartTime = this.jgX.agH();
        this.aEp = this.jgX.agI();
        this.mInterval = this.jgX.agJ();
    }

    public void dX(long j) {
        this.jgW = j;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", j);
    }
}
