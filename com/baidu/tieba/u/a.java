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
                a.this.cmO();
            }
        }
    };
    private long jhe;
    private y jhf;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        cmO();
        this.jhe = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.bvr);
    }

    public boolean cmN() {
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
        return date != null && date.getTime() - this.jhe >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmO() {
        if (this.jhf == null) {
            this.jhf = new y();
        }
        this.jhf.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", ""));
        this.mStartTime = this.jhf.agH();
        this.aEo = this.jhf.agI();
        this.mInterval = this.jhf.agJ();
    }

    public void dX(long j) {
        this.jhe = j;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", j);
    }
}
