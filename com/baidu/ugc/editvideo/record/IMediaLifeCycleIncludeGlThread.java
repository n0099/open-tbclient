package com.baidu.ugc.editvideo.record;
/* loaded from: classes11.dex */
public interface IMediaLifeCycleIncludeGlThread extends IMediaLifeCycle {
    void onDestroyInGlThread();

    void onPauseInGlThread();

    void onResumeInGlThread();
}
