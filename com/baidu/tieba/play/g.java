package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import java.util.Map;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        void onCompletion(g gVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean onError(g gVar, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(g gVar, int i, int i2, int i3);
    }

    /* loaded from: classes.dex */
    public interface d {
        boolean a(g gVar, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface e {
        void onReleaseFinished();
    }

    /* loaded from: classes.dex */
    public interface f {
        void onPrepared(g gVar);
    }

    /* renamed from: com.baidu.tieba.play.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0121g {
        void a(g gVar);
    }

    void GR();

    void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, int i);

    void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str);

    void a(c cVar);

    void a(d dVar);

    void a(e eVar);

    void forceUseSystemMediaPlayer(boolean z);

    int getCurrentPosition();

    int getDuration();

    int getPlayerType();

    int getVideoHeight();

    int getVideoWidth();

    boolean isExistInRemote();

    boolean isPlaying();

    void pause();

    void release();

    void seekTo(int i);

    void setLooping(boolean z);

    void setOnCompletionListener(a aVar);

    void setOnPreparedListener(f fVar);

    void setOnSeekCompleteListener(InterfaceC0121g interfaceC0121g);

    void setVolume(float f2, float f3);

    void start();
}
