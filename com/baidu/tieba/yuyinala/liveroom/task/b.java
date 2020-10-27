package com.baidu.tieba.yuyinala.liveroom.task;

import android.os.Handler;
import android.util.Log;
/* loaded from: classes4.dex */
public class b {
    private static int hnt = 0;
    private static volatile b nSS = null;
    private long currLiveId;
    private long duration;
    private Handler handler = new Handler();
    Runnable hnv = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.task.b.1
        @Override // java.lang.Runnable
        public void run() {
            Log.i("TaskHelper", "@@ reportRunnable haokan=" + b.hnt + ", currLiveId=" + b.this.currLiveId + ", duration=" + b.this.duration);
            b.this.arq();
            b.this.stopRecord();
        }
    };
    private long now;

    public static b dVF() {
        if (nSS == null) {
            synchronized (b.class) {
                if (nSS == null) {
                    nSS = new b();
                }
            }
        }
        return nSS;
    }

    public void eF(long j) {
        Log.i("TaskHelper", "@@ startRecord watchCount=" + hnt + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (ceO()) {
            this.currLiveId = j;
            this.duration = 0L;
            this.now = System.currentTimeMillis();
            this.handler.removeCallbacks(this.hnv);
            this.handler.postDelayed(this.hnv, 60000 - this.duration);
        }
    }

    public void pauseRecord() {
        Log.i("TaskHelper", "@@ pauseRecord watchCount=" + hnt + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.handler.removeCallbacks(this.hnv);
        this.duration = System.currentTimeMillis() - this.now;
        if (this.duration < 0) {
            this.duration = 0L;
        }
    }

    public void eG(long j) {
        Log.i("TaskHelper", "@@ resumeRecord watchCount=" + hnt + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (this.currLiveId == 0 || this.currLiveId != j) {
            stopRecord();
            return;
        }
        this.now = System.currentTimeMillis();
        this.handler.removeCallbacks(this.hnv);
        this.handler.postDelayed(this.hnv, 60000 - this.duration);
    }

    public void stopRecord() {
        Log.i("TaskHelper", "@@ stopRecord watchCount=" + hnt + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.duration = 0L;
        this.currLiveId = 0L;
        this.handler.removeCallbacks(this.hnv);
    }

    private boolean ceO() {
        return hnt < 30;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arq() {
    }
}
