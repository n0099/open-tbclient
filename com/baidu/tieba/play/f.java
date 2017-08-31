package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes.dex */
public interface f {

    /* loaded from: classes.dex */
    public interface a {
        void onCompletion(f fVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean onError(f fVar, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(f fVar, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface d {
        void onReleaseFinished();
    }

    /* loaded from: classes.dex */
    public interface e {
        void onPrepared(f fVar);
    }

    void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, int i);

    void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str);

    void a(c cVar);

    void a(d dVar);

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isExistInRemote();

    boolean isLooping();

    boolean isPlaying();

    void pause();

    void release();

    void seekTo(int i);

    void setLooping(boolean z);

    void setOnCompletionListener(a aVar);

    void setOnErrorListener(b bVar);

    void setOnPreparedListener(e eVar);

    void setVolume(float f, float f2);

    void start();
}
