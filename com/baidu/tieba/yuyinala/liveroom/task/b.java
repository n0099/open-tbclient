package com.baidu.tieba.yuyinala.liveroom.task;

import android.os.Handler;
import android.util.Log;
/* loaded from: classes4.dex */
public class b {
    private static int hCE = 0;
    private static volatile b oqL = null;
    private long currLiveId;
    private long duration;
    private long now;
    private Handler handler = new Handler();
    Runnable hCG = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.task.b.1
        @Override // java.lang.Runnable
        public void run() {
            Log.i("TaskHelper", "@@ reportRunnable haokan=" + b.hCE + ", currLiveId=" + b.this.currLiveId + ", duration=" + b.this.duration);
            b.this.awr();
            b.this.stopRecord();
        }
    };

    public static b edY() {
        if (oqL == null) {
            synchronized (b.class) {
                if (oqL == null) {
                    oqL = new b();
                }
            }
        }
        return oqL;
    }

    public void fF(long j) {
        Log.i("TaskHelper", "@@ startRecord watchCount=" + hCE + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (ckF()) {
            this.currLiveId = j;
            this.duration = 0L;
            this.now = System.currentTimeMillis();
            this.handler.removeCallbacks(this.hCG);
            this.handler.postDelayed(this.hCG, 60000 - this.duration);
        }
    }

    public void pauseRecord() {
        Log.i("TaskHelper", "@@ pauseRecord watchCount=" + hCE + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.handler.removeCallbacks(this.hCG);
        this.duration = System.currentTimeMillis() - this.now;
        if (this.duration < 0) {
            this.duration = 0L;
        }
    }

    public void fG(long j) {
        Log.i("TaskHelper", "@@ resumeRecord watchCount=" + hCE + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (this.currLiveId == 0 || this.currLiveId != j) {
            stopRecord();
            return;
        }
        this.now = System.currentTimeMillis();
        this.handler.removeCallbacks(this.hCG);
        this.handler.postDelayed(this.hCG, 60000 - this.duration);
    }

    public void stopRecord() {
        Log.i("TaskHelper", "@@ stopRecord watchCount=" + hCE + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.duration = 0L;
        this.currLiveId = 0L;
        this.handler.removeCallbacks(this.hCG);
    }

    private boolean ckF() {
        return hCE < 30;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awr() {
    }
}
