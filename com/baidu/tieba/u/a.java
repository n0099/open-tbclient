package com.baidu.tieba.u;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.v;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private long ZJ;
    private CustomMessageListener acr = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.u.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.this.bEj();
            }
        }
    };
    private long hoe;
    private v hof;
    private long mInterval;
    private long mStartTime;

    public a() {
        init();
    }

    private void init() {
        bEj();
        this.hoe = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_video_splash_last_show_time", 0L);
        MessageManager.getInstance().registerListener(this.acr);
    }

    public boolean bEi() {
        if (this.mStartTime == 0 || this.ZJ == 0 || this.mInterval == 0) {
            return false;
        }
        Date date = new Date();
        return j(date) && k(date);
    }

    private boolean j(Date date) {
        return date != null && date.getTime() >= this.mStartTime && date.getTime() <= this.ZJ;
    }

    private boolean k(Date date) {
        return date != null && date.getTime() - this.hoe >= this.mInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEj() {
        if (this.hof == null) {
            this.hof = new v();
        }
        this.hof.parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", ""));
        this.mStartTime = this.hof.Cv();
        this.ZJ = this.hof.Cw();
        this.mInterval = this.hof.Cx();
    }

    public void db(long j) {
        this.hoe = j;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", j);
    }
}
