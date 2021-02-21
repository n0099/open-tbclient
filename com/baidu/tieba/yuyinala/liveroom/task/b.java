package com.baidu.tieba.yuyinala.liveroom.task;

import android.os.Handler;
import android.util.Log;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes11.dex */
public class b {
    private static int hOJ = 0;
    private static volatile b ozP = null;
    private long currLiveId;
    private long duration;
    private long now;
    private Handler handler = new Handler();
    Runnable hOL = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.task.b.1
        @Override // java.lang.Runnable
        public void run() {
            Log.i("TaskHelper", "@@ reportRunnable haokan=" + b.hOJ + ", currLiveId=" + b.this.currLiveId + ", duration=" + b.this.duration);
            b.this.auo();
            b.this.stopRecord();
        }
    };

    public static b ebU() {
        if (ozP == null) {
            synchronized (b.class) {
                if (ozP == null) {
                    ozP = new b();
                }
            }
        }
        return ozP;
    }

    public void fK(long j) {
        Log.i("TaskHelper", "@@ startRecord watchCount=" + hOJ + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (ckI()) {
            this.currLiveId = j;
            this.duration = 0L;
            this.now = System.currentTimeMillis();
            this.handler.removeCallbacks(this.hOL);
            this.handler.postDelayed(this.hOL, AppStatusRules.DEFAULT_GRANULARITY - this.duration);
        }
    }

    public void pauseRecord() {
        Log.i("TaskHelper", "@@ pauseRecord watchCount=" + hOJ + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.handler.removeCallbacks(this.hOL);
        this.duration = System.currentTimeMillis() - this.now;
        if (this.duration < 0) {
            this.duration = 0L;
        }
    }

    public void fL(long j) {
        Log.i("TaskHelper", "@@ resumeRecord watchCount=" + hOJ + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (this.currLiveId == 0 || this.currLiveId != j) {
            stopRecord();
            return;
        }
        this.now = System.currentTimeMillis();
        this.handler.removeCallbacks(this.hOL);
        this.handler.postDelayed(this.hOL, AppStatusRules.DEFAULT_GRANULARITY - this.duration);
    }

    public void stopRecord() {
        Log.i("TaskHelper", "@@ stopRecord watchCount=" + hOJ + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.duration = 0L;
        this.currLiveId = 0L;
        this.handler.removeCallbacks(this.hOL);
    }

    private boolean ckI() {
        return hOJ < 30;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auo() {
    }
}
