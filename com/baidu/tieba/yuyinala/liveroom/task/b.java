package com.baidu.tieba.yuyinala.liveroom.task;

import android.os.Handler;
import android.util.Log;
/* loaded from: classes4.dex */
public class b {
    private static int htr = 0;
    private static volatile b oaf = null;
    private long currLiveId;
    private long duration;
    private Handler handler = new Handler();
    Runnable htt = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.task.b.1
        @Override // java.lang.Runnable
        public void run() {
            Log.i("TaskHelper", "@@ reportRunnable haokan=" + b.htr + ", currLiveId=" + b.this.currLiveId + ", duration=" + b.this.duration);
            b.this.atR();
            b.this.stopRecord();
        }
    };
    private long now;

    public static b dYu() {
        if (oaf == null) {
            synchronized (b.class) {
                if (oaf == null) {
                    oaf = new b();
                }
            }
        }
        return oaf;
    }

    public void fb(long j) {
        Log.i("TaskHelper", "@@ startRecord watchCount=" + htr + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (chr()) {
            this.currLiveId = j;
            this.duration = 0L;
            this.now = System.currentTimeMillis();
            this.handler.removeCallbacks(this.htt);
            this.handler.postDelayed(this.htt, 60000 - this.duration);
        }
    }

    public void pauseRecord() {
        Log.i("TaskHelper", "@@ pauseRecord watchCount=" + htr + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.handler.removeCallbacks(this.htt);
        this.duration = System.currentTimeMillis() - this.now;
        if (this.duration < 0) {
            this.duration = 0L;
        }
    }

    public void fc(long j) {
        Log.i("TaskHelper", "@@ resumeRecord watchCount=" + htr + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (this.currLiveId == 0 || this.currLiveId != j) {
            stopRecord();
            return;
        }
        this.now = System.currentTimeMillis();
        this.handler.removeCallbacks(this.htt);
        this.handler.postDelayed(this.htt, 60000 - this.duration);
    }

    public void stopRecord() {
        Log.i("TaskHelper", "@@ stopRecord watchCount=" + htr + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.duration = 0L;
        this.currLiveId = 0L;
        this.handler.removeCallbacks(this.htt);
    }

    private boolean chr() {
        return htr < 30;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atR() {
    }
}
