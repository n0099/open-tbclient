package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes.dex */
public interface v {

    /* loaded from: classes.dex */
    public interface a {
        void onCompletion(v vVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean onError(v vVar, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(v vVar, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface d {
        void onPrepared(v vVar);
    }

    boolean Jw();

    void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture);

    void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, int i);

    void a(c cVar);

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isLooping();

    boolean isPlaying();

    void pause();

    void release();

    void seekTo(int i);

    void setLooping(boolean z);

    void setOnCompletionListener(a aVar);

    void setOnErrorListener(b bVar);

    void setOnPreparedListener(d dVar);

    void setVolume(float f, float f2);

    void start();
}
