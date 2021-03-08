package com.baidu.tieba.yuyinala.liveroom.task;

import android.os.Handler;
import android.util.Log;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes10.dex */
public class b {
    private static int hQs = 0;
    private static volatile b oBU = null;
    private long currLiveId;
    private long duration;
    private long now;
    private Handler handler = new Handler();
    Runnable hQu = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.task.b.1
        @Override // java.lang.Runnable
        public void run() {
            Log.i("TaskHelper", "@@ reportRunnable haokan=" + b.hQs + ", currLiveId=" + b.this.currLiveId + ", duration=" + b.this.duration);
            b.this.aur();
            b.this.stopRecord();
        }
    };

    public static b ecc() {
        if (oBU == null) {
            synchronized (b.class) {
                if (oBU == null) {
                    oBU = new b();
                }
            }
        }
        return oBU;
    }

    public void fK(long j) {
        Log.i("TaskHelper", "@@ startRecord watchCount=" + hQs + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (ckO()) {
            this.currLiveId = j;
            this.duration = 0L;
            this.now = System.currentTimeMillis();
            this.handler.removeCallbacks(this.hQu);
            this.handler.postDelayed(this.hQu, AppStatusRules.DEFAULT_GRANULARITY - this.duration);
        }
    }

    public void pauseRecord() {
        Log.i("TaskHelper", "@@ pauseRecord watchCount=" + hQs + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.handler.removeCallbacks(this.hQu);
        this.duration = System.currentTimeMillis() - this.now;
        if (this.duration < 0) {
            this.duration = 0L;
        }
    }

    public void fL(long j) {
        Log.i("TaskHelper", "@@ resumeRecord watchCount=" + hQs + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (this.currLiveId == 0 || this.currLiveId != j) {
            stopRecord();
            return;
        }
        this.now = System.currentTimeMillis();
        this.handler.removeCallbacks(this.hQu);
        this.handler.postDelayed(this.hQu, AppStatusRules.DEFAULT_GRANULARITY - this.duration);
    }

    public void stopRecord() {
        Log.i("TaskHelper", "@@ stopRecord watchCount=" + hQs + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.duration = 0L;
        this.currLiveId = 0L;
        this.handler.removeCallbacks(this.hQu);
    }

    private boolean ckO() {
        return hQs < 30;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aur() {
    }
}
