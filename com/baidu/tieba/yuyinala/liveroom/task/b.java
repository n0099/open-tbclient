package com.baidu.tieba.yuyinala.liveroom.task;

import android.os.Handler;
import android.util.Log;
/* loaded from: classes4.dex */
public class b {
    private static int hCC = 0;
    private static volatile b oqJ = null;
    private long currLiveId;
    private long duration;
    private long now;
    private Handler handler = new Handler();
    Runnable hCE = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.task.b.1
        @Override // java.lang.Runnable
        public void run() {
            Log.i("TaskHelper", "@@ reportRunnable haokan=" + b.hCC + ", currLiveId=" + b.this.currLiveId + ", duration=" + b.this.duration);
            b.this.awr();
            b.this.stopRecord();
        }
    };

    public static b edX() {
        if (oqJ == null) {
            synchronized (b.class) {
                if (oqJ == null) {
                    oqJ = new b();
                }
            }
        }
        return oqJ;
    }

    public void fF(long j) {
        Log.i("TaskHelper", "@@ startRecord watchCount=" + hCC + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (ckE()) {
            this.currLiveId = j;
            this.duration = 0L;
            this.now = System.currentTimeMillis();
            this.handler.removeCallbacks(this.hCE);
            this.handler.postDelayed(this.hCE, 60000 - this.duration);
        }
    }

    public void pauseRecord() {
        Log.i("TaskHelper", "@@ pauseRecord watchCount=" + hCC + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.handler.removeCallbacks(this.hCE);
        this.duration = System.currentTimeMillis() - this.now;
        if (this.duration < 0) {
            this.duration = 0L;
        }
    }

    public void fG(long j) {
        Log.i("TaskHelper", "@@ resumeRecord watchCount=" + hCC + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (this.currLiveId == 0 || this.currLiveId != j) {
            stopRecord();
            return;
        }
        this.now = System.currentTimeMillis();
        this.handler.removeCallbacks(this.hCE);
        this.handler.postDelayed(this.hCE, 60000 - this.duration);
    }

    public void stopRecord() {
        Log.i("TaskHelper", "@@ stopRecord watchCount=" + hCC + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.duration = 0L;
        this.currLiveId = 0L;
        this.handler.removeCallbacks(this.hCE);
    }

    private boolean ckE() {
        return hCC < 30;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awr() {
    }
}
