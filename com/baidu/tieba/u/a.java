package com.baidu.tieba.u;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.y;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private long aEs;
    private CustomMessageListener bvw = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.u.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.cmP();
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
        cmP();
        this.jgK = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.bvw);
    }

    public boolean cmO() {
        if (this.mStartTime == 0 || this.aEs == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return q(date) && r(date);
    }

    private boolean q(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.aEs;
    }

    private boolean r(Date date) {
        return date != null && date.getTime() - this.jgK >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmP() {
        if (this.jgL == null) {
            this.jgL = new y();
        }
        this.jgL.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", ""));
        this.mStartTime = this.jgL.agE();
        this.aEs = this.jgL.agF();
        this.mInterval = this.jgL.agG();
    }

    public void dY(long j) {
        this.jgK = j;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", j);
    }
}
