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
        void onHandleOppoError(String str);
    }

    /* loaded from: classes.dex */
    public interface e {
        boolean a(g gVar, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface f {
        void onReleaseFinished();
    }

    /* renamed from: com.baidu.tieba.play.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0121g {
        void onPrepared(g gVar);
    }

    /* loaded from: classes.dex */
    public interface h {
        void a(g gVar);
    }

    /* loaded from: classes.dex */
    public interface i {
        void onSubError(int i, int i2);
    }

    void GX();

    void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, int i2);

    void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str);

    void a(c cVar);

    void a(d dVar);

    void a(e eVar);

    void a(f fVar);

    void a(i iVar);

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

    void seekTo(int i2);

    void setLooping(boolean z);

    void setOnCompletionListener(a aVar);

    void setOnPreparedListener(InterfaceC0121g interfaceC0121g);

    void setOnSeekCompleteListener(h hVar);

    void setVolume(float f2, float f3);

    void start();
}
