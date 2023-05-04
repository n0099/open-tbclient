package com.baidu.tieba;

import com.baidu.swan.videoplayer.SwanVideoView;
/* loaded from: classes7.dex */
public interface xo4 {
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
