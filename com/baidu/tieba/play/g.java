package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.support.annotation.Nullable;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        void onCompletion(@Nullable g gVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean onError(@Nullable g gVar, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(@Nullable g gVar, int i, int i2, int i3);
    }

    /* loaded from: classes.dex */
    public interface d {
        void onHandleOppoError(String str);
    }

    /* loaded from: classes.dex */
    public interface e {
        boolean onInfo(@Nullable g gVar, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface f {
        void onPrepared(@Nullable g gVar);
    }

    /* renamed from: com.baidu.tieba.play.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0651g {
        void b(@Nullable g gVar);
    }

    /* loaded from: classes.dex */
    public interface h {
        void onSpeed(long j);
    }

    /* loaded from: classes.dex */
    public interface i {
        void onSubError(int i, int i2, String str);
    }

    void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, int i2);

    void a(Context context, Uri uri, Map<String, String> map, SurfaceTexture surfaceTexture, String str);

    void a(c cVar);

    void a(d dVar);

    void a(e eVar);

    void a(h hVar);

    void a(i iVar);

    int beP();

    boolean beQ();

    void beR();

    void forceUseSystemMediaPlayer(boolean z);

    int getBitRate();

    int getCachedSize();

    int getCurrentPosition();

    int getDuration();

    String getId();

    List<String> getMediaIDs();

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

    void setOnErrorListener(b bVar);

    void setOnPreparedListener(f fVar);

    void setOnSeekCompleteListener(InterfaceC0651g interfaceC0651g);

    void setSurface(SurfaceTexture surfaceTexture);

    void setVolume(float f2, float f3);

    void start();
}
