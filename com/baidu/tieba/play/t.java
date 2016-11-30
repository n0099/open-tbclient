package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes.dex */
public interface t {

    /* loaded from: classes.dex */
    public interface a {
        void onCompletion(t tVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean onError(t tVar, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(t tVar, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface d {
        void onPrepared(t tVar);
    }

    void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture);

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

    void setOnCompletionListener(a aVar);

    void setOnErrorListener(b bVar);

    void setOnPreparedListener(d dVar);

    void setVolume(float f, float f2);

    void start();
}
