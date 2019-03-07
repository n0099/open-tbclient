package com.baidu.tieba.u;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.y;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private long aEo;
    private CustomMessageListener bvr = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.u.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.cmE();
            }
        }
    };
    private long jgK;
    private y jgL;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        cmE();
        this.jgK = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.bvr);
    }

    public boolean cmD() {
        if (this.mStartTime == 0 || this.aEo == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return q(date) && r(date);
    }

    private boolean q(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.aEo;
    }

    private boolean r(Date date) {
        return date != null && date.getTime() - this.jgK >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmE() {
        if (this.jgL == null) {
            this.jgL = new y();
        }
        this.jgL.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", ""));
        this.mStartTime = this.jgL.agH();
        this.aEo = this.jgL.agI();
        this.mInterval = this.jgL.agJ();
    }

    public void dX(long j) {
        this.jgK = j;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", j);
    }
}
