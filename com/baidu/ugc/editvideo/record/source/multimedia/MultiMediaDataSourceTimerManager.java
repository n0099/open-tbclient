package com.baidu.ugc.editvideo.record.source.multimedia;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes7.dex */
public class MultiMediaDataSourceTimerManager {
    public static MultiMediaDataSourceTimerManager sInstance;
    public HandlerThread mHandlerThread;
    public HandlerThread mPlayerHandlerThread;
    public HandlerThread mReadPhotoHandlerThread;

    public MultiMediaDataSourceTimerManager() {
        HandlerThread handlerThread = new HandlerThread("MultiMediaDataSourceTimer");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        HandlerThread handlerThread2 = new HandlerThread("playerThread");
        this.mPlayerHandlerThread = handlerThread2;
        handlerThread2.start();
        HandlerThread handlerThread3 = new HandlerThread("readPhotoThread");
        this.mReadPhotoHandlerThread = handlerThread3;
        handlerThread3.start();
    }

    public static MultiMediaDataSourceTimerManager getInstance() {
        if (sInstance == null) {
            synchronized (MultiMediaDataSourceTimerManager.class) {
                if (sInstance == null) {
                    sInstance = new MultiMediaDataSourceTimerManager();
                }
            }
        }
        return sInstance;
    }

    public void destroy() {
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        HandlerThread handlerThread2 = this.mPlayerHandlerThread;
        if (handlerThread2 != null) {
            handlerThread2.quit();
        }
        HandlerThread handlerThread3 = this.mReadPhotoHandlerThread;
        if (handlerThread3 != null) {
            handlerThread3.quit();
        }
        sInstance = null;
    }

    public Looper getPlayerLooper() {
        return this.mPlayerHandlerThread.getLooper();
    }

    public Looper getReadPhotoLooper() {
        return this.mReadPhotoHandlerThread.getLooper();
    }

    public Looper getTimerLooper() {
        return this.mHandlerThread.getLooper();
    }
}
