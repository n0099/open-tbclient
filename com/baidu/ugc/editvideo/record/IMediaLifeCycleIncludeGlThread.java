package com.baidu.ugc.editvideo.record;
/* loaded from: classes6.dex */
public interface IMediaLifeCycleIncludeGlThread extends IMediaLifeCycle {
    void onDestroyInGlThread();

    void onPauseInGlThread();

    void onResumeInGlThread();
}
