package com.baidu.tieba.yuyinala.liveroom.task;

import android.os.Handler;
import android.util.Log;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes11.dex */
public class b {
    private static int hOD = 0;
    private static volatile b ouf = null;
    private long currLiveId;
    private long duration;
    private long now;
    private Handler handler = new Handler();
    Runnable hOF = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.task.b.1
        @Override // java.lang.Runnable
        public void run() {
            Log.i("TaskHelper", "@@ reportRunnable haokan=" + b.hOD + ", currLiveId=" + b.this.currLiveId + ", duration=" + b.this.duration);
            b.this.axJ();
            b.this.stopRecord();
        }
    };

    public static b edq() {
        if (ouf == null) {
            synchronized (b.class) {
                if (ouf == null) {
                    ouf = new b();
                }
            }
        }
        return ouf;
    }

    public void fF(long j) {
        Log.i("TaskHelper", "@@ startRecord watchCount=" + hOD + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (cnt()) {
            this.currLiveId = j;
            this.duration = 0L;
            this.now = System.currentTimeMillis();
            this.handler.removeCallbacks(this.hOF);
            this.handler.postDelayed(this.hOF, AppStatusRules.DEFAULT_GRANULARITY - this.duration);
        }
    }

    public void pauseRecord() {
        Log.i("TaskHelper", "@@ pauseRecord watchCount=" + hOD + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.handler.removeCallbacks(this.hOF);
        this.duration = System.currentTimeMillis() - this.now;
        if (this.duration < 0) {
            this.duration = 0L;
        }
    }

    public void fG(long j) {
        Log.i("TaskHelper", "@@ resumeRecord watchCount=" + hOD + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (this.currLiveId == 0 || this.currLiveId != j) {
            stopRecord();
            return;
        }
        this.now = System.currentTimeMillis();
        this.handler.removeCallbacks(this.hOF);
        this.handler.postDelayed(this.hOF, AppStatusRules.DEFAULT_GRANULARITY - this.duration);
    }

    public void stopRecord() {
        Log.i("TaskHelper", "@@ stopRecord watchCount=" + hOD + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.duration = 0L;
        this.currLiveId = 0L;
        this.handler.removeCallbacks(this.hOF);
    }

    private boolean cnt() {
        return hOD < 30;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axJ() {
    }
}
