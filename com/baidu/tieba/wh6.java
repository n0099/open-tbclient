package com.baidu.tieba;
/* loaded from: classes8.dex */
public interface wh6 {

    /* loaded from: classes8.dex */
    public interface a {
        boolean a(float f);
    }

    /* loaded from: classes8.dex */
    public interface b {
        float getSpeed();
    }

    /* loaded from: classes8.dex */
    public interface c {
        boolean onFinished();
    }

    boolean a();

    boolean b();

    int getMaxDuration();

    float getProgress();

    int getSlideNum();

    boolean pause();

    boolean reset();

    boolean setMaxDuration(int i);

    boolean setMinDuration(int i);

    boolean setProgress(long j);

    boolean setShowDeleteLastTip(boolean z);

    boolean start();
}
