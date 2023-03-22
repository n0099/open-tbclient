package com.baidu.tieba;

import com.baidu.swan.videoplayer.SwanVideoView;
/* loaded from: classes6.dex */
public interface to4 {
    void a();

    void b(boolean z);

    void c(SwanVideoView swanVideoView);

    void d(boolean z);

    void onBufferingUpdate(int i);

    void onError(int i, int i2, String str);

    void onPause();

    void onPrepared();

    void onResume();

    void onSeekEnd();

    void onStart();

    void onVideoSizeChanged(int i, int i2);
}
