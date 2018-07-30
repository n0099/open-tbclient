package com.baidu.tieba.u;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.u;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private long ZI;
    private CustomMessageListener acq = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.u.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.bEh();
            }
        }
    };
    private long hod;
    private u hoe;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        bEh();
        this.hod = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.acq);
    }

    public boolean bEg() {
        if (this.mStartTime == 0 || this.ZI == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return j(date) && k(date);
    }

    private boolean j(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.ZI;
    }

    private boolean k(Date date) {
        return date != null && date.getTime() - this.hod >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEh() {
        if (this.hoe == null) {
            this.hoe = new u();
        }
        this.hoe.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", ""));
        this.mStartTime = this.hoe.Cx();
        this.ZI = this.hoe.Cy();
        this.mInterval = this.hoe.Cz();
    }

    public void db(long j) {
        this.hod = j;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", j);
    }
}
