package com.baidu.tieba.yuyinala.liveroom.task;

import android.os.Handler;
import android.util.Log;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes11.dex */
public class b {
    private static int hOv = 0;
    private static volatile b ozp = null;
    private long currLiveId;
    private long duration;
    private long now;
    private Handler handler = new Handler();
    Runnable hOx = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.task.b.1
        @Override // java.lang.Runnable
        public void run() {
            Log.i("TaskHelper", "@@ reportRunnable haokan=" + b.hOv + ", currLiveId=" + b.this.currLiveId + ", duration=" + b.this.duration);
            b.this.auo();
            b.this.stopRecord();
        }
    };

    public static b ebM() {
        if (ozp == null) {
            synchronized (b.class) {
                if (ozp == null) {
                    ozp = new b();
                }
            }
        }
        return ozp;
    }

    public void fK(long j) {
        Log.i("TaskHelper", "@@ startRecord watchCount=" + hOv + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (ckB()) {
            this.currLiveId = j;
            this.duration = 0L;
            this.now = System.currentTimeMillis();
            this.handler.removeCallbacks(this.hOx);
            this.handler.postDelayed(this.hOx, AppStatusRules.DEFAULT_GRANULARITY - this.duration);
        }
    }

    public void pauseRecord() {
        Log.i("TaskHelper", "@@ pauseRecord watchCount=" + hOv + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.handler.removeCallbacks(this.hOx);
        this.duration = System.currentTimeMillis() - this.now;
        if (this.duration < 0) {
            this.duration = 0L;
        }
    }

    public void fL(long j) {
        Log.i("TaskHelper", "@@ resumeRecord watchCount=" + hOv + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (this.currLiveId == 0 || this.currLiveId != j) {
            stopRecord();
            return;
        }
        this.now = System.currentTimeMillis();
        this.handler.removeCallbacks(this.hOx);
        this.handler.postDelayed(this.hOx, AppStatusRules.DEFAULT_GRANULARITY - this.duration);
    }

    public void stopRecord() {
        Log.i("TaskHelper", "@@ stopRecord watchCount=" + hOv + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.duration = 0L;
        this.currLiveId = 0L;
        this.handler.removeCallbacks(this.hOx);
    }

    private boolean ckB() {
        return hOv < 30;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auo() {
    }
}
