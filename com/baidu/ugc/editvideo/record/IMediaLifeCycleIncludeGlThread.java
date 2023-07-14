package com.baidu.ugc.editvideo.record;
/* loaded from: classes9.dex */
public interface IMediaLifeCycleIncludeGlThread extends IMediaLifeCycle {
    void onDestroyInGlThread();

    void onPauseInGlThread();

    void onResumeInGlThread();
}
