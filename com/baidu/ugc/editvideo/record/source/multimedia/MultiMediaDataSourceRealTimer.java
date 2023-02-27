package com.baidu.ugc.editvideo.record.source.multimedia;

import android.animation.Animator;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.j1a;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class MultiMediaDataSourceRealTimer {
    public static final String TAG = "com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer";
    public static final AtomicInteger nextSerialNumber = new AtomicInteger(0);
    public volatile boolean isStart;
    public volatile Animator.AnimatorListener mAnimatorAdapter;
    public long mBeginTime;
    public long mCurrentPlayTime;
    public long mDuration;
    public Timer mTimer;
    public TimerTask mTimerTask;
    public volatile AnimatorUpdateListener mUpdateListener;
    public int mFrameRate = 30;
    public Runnable animatorStartRunnable = new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer.3
        @Override // java.lang.Runnable
        public void run() {
            if (MultiMediaDataSourceRealTimer.this.mAnimatorAdapter != null) {
                MultiMediaDataSourceRealTimer.this.mAnimatorAdapter.onAnimationStart(null);
            }
        }
    };
    public Runnable animatorCancelRunnable = new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer.4
        @Override // java.lang.Runnable
        public void run() {
            MultiMediaDataSourceRealTimer.this.innerStop();
        }
    };
    public Runnable animatorEndRunnable = new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer.5
        @Override // java.lang.Runnable
        public void run() {
            if (MultiMediaDataSourceRealTimer.this.mAnimatorAdapter != null) {
                MultiMediaDataSourceRealTimer.this.mAnimatorAdapter.onAnimationEnd(null);
            }
        }
    };
    public Runnable stopRunnable = new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer.6
        @Override // java.lang.Runnable
        public void run() {
            MultiMediaDataSourceRealTimer.this.innerStop();
        }
    };
    public Runnable resetRunnable = new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer.7
        @Override // java.lang.Runnable
        public void run() {
            MultiMediaDataSourceRealTimer.this.innerReset();
        }
    };
    public Runnable startRunnable = new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer.8
        @Override // java.lang.Runnable
        public void run() {
            MultiMediaDataSourceRealTimer.this.innerStart();
        }
    };
    public Handler mJobHandler = new Handler(MultiMediaDataSourceTimerManager.getInstance().getTimerLooper()) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                Object obj = message.obj;
                if (MultiMediaDataSourceRealTimer.this.mUpdateListener == null || !(obj instanceof Long)) {
                    return;
                }
                MultiMediaDataSourceRealTimer.this.mUpdateListener.onAnimationUpdate(((Long) obj).longValue());
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface AnimatorUpdateListener {
        void onAnimationUpdate(long j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerReset() {
        if (this.isStart) {
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer = null;
            }
            TimerTask timerTask = this.mTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
                this.mTimerTask = null;
            }
            this.mAnimatorAdapter = null;
            this.mUpdateListener = null;
            this.isStart = false;
            this.mCurrentPlayTime = 0L;
            this.mBeginTime = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerStart() {
        if (this.isStart) {
            return;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer(TAG + "-" + serialNumber());
        }
        this.mTimerTask = new TimerTask() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                if (MultiMediaDataSourceRealTimer.this.mBeginTime == 0) {
                    String str = MultiMediaDataSourceRealTimer.TAG;
                    j1a.a(str, "TimerTask thread : " + Thread.currentThread().getName());
                    MultiMediaDataSourceRealTimer.this.mBeginTime = currentTimeMillis;
                }
                long j = currentTimeMillis + MultiMediaDataSourceRealTimer.this.mCurrentPlayTime;
                if (j == MultiMediaDataSourceRealTimer.this.mBeginTime + MultiMediaDataSourceRealTimer.this.mCurrentPlayTime) {
                    MultiMediaDataSourceRealTimer.this.mJobHandler.post(MultiMediaDataSourceRealTimer.this.animatorStartRunnable);
                }
                if (j - MultiMediaDataSourceRealTimer.this.mBeginTime < MultiMediaDataSourceRealTimer.this.mDuration) {
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = Long.valueOf(j - MultiMediaDataSourceRealTimer.this.mBeginTime);
                    MultiMediaDataSourceRealTimer.this.mJobHandler.sendMessage(obtain);
                    return;
                }
                Message obtain2 = Message.obtain();
                obtain2.what = 0;
                obtain2.obj = Long.valueOf(MultiMediaDataSourceRealTimer.this.mDuration);
                MultiMediaDataSourceRealTimer.this.mJobHandler.sendMessage(obtain2);
                MultiMediaDataSourceRealTimer.this.mJobHandler.post(MultiMediaDataSourceRealTimer.this.animatorEndRunnable);
                MultiMediaDataSourceRealTimer.this.mJobHandler.post(MultiMediaDataSourceRealTimer.this.animatorCancelRunnable);
            }
        };
        this.mBeginTime = 0L;
        this.mTimer.purge();
        this.mTimer.schedule(this.mTimerTask, 0L, 1000.0f / this.mFrameRate);
        this.isStart = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerStop() {
        if (this.isStart) {
            TimerTask timerTask = this.mTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
            }
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.purge();
            }
            this.isStart = false;
        }
    }

    public static int serialNumber() {
        return nextSerialNumber.getAndIncrement();
    }

    public boolean isPlaying() {
        return (this.mTimer == null || this.mTimerTask == null || !this.isStart) ? false : true;
    }

    public void lockTimer() {
    }

    public void reset() {
        this.mJobHandler.post(this.resetRunnable);
    }

    public void setAnimatorListenerAdapter(Animator.AnimatorListener animatorListener) {
        this.mAnimatorAdapter = animatorListener;
    }

    public void setCurrentPlayTime(long j) {
        this.mCurrentPlayTime = j;
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }

    public void setFrameRate(int i) {
        this.mFrameRate = i;
    }

    public void setUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        this.mUpdateListener = animatorUpdateListener;
    }

    public void start() {
        this.mJobHandler.post(this.startRunnable);
    }

    public void stop() {
        this.mJobHandler.post(this.stopRunnable);
    }

    public void unLockTimer() {
    }
}
