package com.baidu.tieba.yuyinala.liveroom.task;

import android.os.Handler;
import android.util.Log;
/* loaded from: classes4.dex */
public class b {
    private static int hsY = 0;
    private static volatile b obJ = null;
    private long currLiveId;
    private long duration;
    private Handler handler = new Handler();
    Runnable hta = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.task.b.1
        @Override // java.lang.Runnable
        public void run() {
            Log.i("TaskHelper", "@@ reportRunnable haokan=" + b.hsY + ", currLiveId=" + b.this.currLiveId + ", duration=" + b.this.duration);
            b.this.atj();
            b.this.stopRecord();
        }
    };
    private long now;

    public static b dYt() {
        if (obJ == null) {
            synchronized (b.class) {
                if (obJ == null) {
                    obJ = new b();
                }
            }
        }
        return obJ;
    }

    public void fb(long j) {
        Log.i("TaskHelper", "@@ startRecord watchCount=" + hsY + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (cgK()) {
            this.currLiveId = j;
            this.duration = 0L;
            this.now = System.currentTimeMillis();
            this.handler.removeCallbacks(this.hta);
            this.handler.postDelayed(this.hta, 60000 - this.duration);
        }
    }

    public void pauseRecord() {
        Log.i("TaskHelper", "@@ pauseRecord watchCount=" + hsY + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.handler.removeCallbacks(this.hta);
        this.duration = System.currentTimeMillis() - this.now;
        if (this.duration < 0) {
            this.duration = 0L;
        }
    }

    public void fc(long j) {
        Log.i("TaskHelper", "@@ resumeRecord watchCount=" + hsY + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (this.currLiveId == 0 || this.currLiveId != j) {
            stopRecord();
            return;
        }
        this.now = System.currentTimeMillis();
        this.handler.removeCallbacks(this.hta);
        this.handler.postDelayed(this.hta, 60000 - this.duration);
    }

    public void stopRecord() {
        Log.i("TaskHelper", "@@ stopRecord watchCount=" + hsY + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.duration = 0L;
        this.currLiveId = 0L;
        this.handler.removeCallbacks(this.hta);
    }

    private boolean cgK() {
        return hsY < 30;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atj() {
    }
}
