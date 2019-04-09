package com.baidu.tieba.u;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.y;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private long aEt;
    private CustomMessageListener bvx = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.u.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.cmP();
            }
        }
    };
    private long jgL;
    private y jgM;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        cmP();
        this.jgL = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.bvx);
    }

    public boolean cmO() {
        if (this.mStartTime == 0 || this.aEt == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return q(date) && r(date);
    }

    private boolean q(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.aEt;
    }

    private boolean r(Date date) {
        return date != null && date.getTime() - this.jgL >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmP() {
        if (this.jgM == null) {
            this.jgM = new y();
        }
        this.jgM.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", ""));
        this.mStartTime = this.jgM.agE();
        this.aEt = this.jgM.agF();
        this.mInterval = this.jgM.agG();
    }

    public void dY(long j) {
        this.jgL = j;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", j);
    }
}
