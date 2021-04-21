package com.bytedance.sdk.openadsdk.core.video.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public class b extends com.bytedance.sdk.openadsdk.core.video.d.a {

    /* renamed from: a  reason: collision with root package name */
    public final MediaPlayer f28365a;

    /* renamed from: b  reason: collision with root package name */
    public final a f28366b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.video.a.a f28367c;

    /* renamed from: d  reason: collision with root package name */
    public Surface f28368d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f28369e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28370f;

    /* loaded from: classes5.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<b> f28372b;

        public a(b bVar) {
            this.f28372b = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                if (this.f28372b.get() != null) {
                    b.this.a(i);
                }
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onBufferingUpdate error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                if (this.f28372b.get() != null) {
                    b.this.c();
                }
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onCompletion error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                if (this.f28372b.get() != null) {
                    return b.this.a(i, i2);
                }
                return false;
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onError error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                if (this.f28372b.get() != null) {
                    return b.this.b(i, i2);
                }
                return false;
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onInfo error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                if (this.f28372b.get() != null) {
                    b.this.b();
                }
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onPrepared error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                if (this.f28372b.get() != null) {
                    b.this.d();
                }
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onSeekComplete error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                if (this.f28372b.get() != null) {
                    b.this.a(i, i2, 1, 1);
                }
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onVideoSizeChanged error: ", th);
            }
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.f28369e = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.f28365a = mediaPlayer;
        }
        a(mediaPlayer);
        try {
            this.f28365a.setAudioStreamType(3);
        } catch (Throwable th) {
            u.c("AndroidMediaPlayer", "setAudioStreamType error: ", th);
        }
        this.f28366b = new a(this);
        n();
    }

    private void a(MediaPlayer mediaPlayer) {
        int i = Build.VERSION.SDK_INT;
        if (i < 19 || i >= 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object newInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(p.a(), null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, new Handler());
            declaredField.setAccessible(false);
            mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, newInstance, null);
        } catch (Throwable th) {
            u.c("AndroidMediaPlayer", "setSubtitleController error: ", th);
        }
    }

    private void m() {
        com.bytedance.sdk.openadsdk.video.a.a aVar;
        if (Build.VERSION.SDK_INT < 23 || (aVar = this.f28367c) == null) {
            return;
        }
        try {
            aVar.close();
        } catch (Throwable th) {
            u.c("AndroidMediaPlayer", "releaseMediaDataSource error: ", th);
        }
        this.f28367c = null;
    }

    private void n() {
        this.f28365a.setOnPreparedListener(this.f28366b);
        this.f28365a.setOnBufferingUpdateListener(this.f28366b);
        this.f28365a.setOnCompletionListener(this.f28366b);
        this.f28365a.setOnSeekCompleteListener(this.f28366b);
        this.f28365a.setOnVideoSizeChangedListener(this.f28366b);
        this.f28365a.setOnErrorListener(this.f28366b);
        this.f28365a.setOnInfoListener(this.f28366b);
    }

    private void o() {
        try {
            if (this.f28368d != null) {
                this.f28368d.release();
                this.f28368d = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void b(boolean z) throws Throwable {
        this.f28365a.setLooping(z);
    }

    public MediaPlayer e() {
        return this.f28365a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void f() throws Throwable {
        this.f28365a.start();
    }

    public void finalize() throws Throwable {
        super.finalize();
        o();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void g() throws Throwable {
        this.f28365a.stop();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void h() throws Throwable {
        this.f28365a.pause();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public long i() {
        try {
            return this.f28365a.getCurrentPosition();
        } catch (Throwable th) {
            u.c("AndroidMediaPlayer", "getCurrentPosition error: ", th);
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public long j() {
        try {
            return this.f28365a.getDuration();
        } catch (Throwable th) {
            u.c("AndroidMediaPlayer", "getDuration error: ", th);
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void k() throws Throwable {
        this.f28370f = true;
        this.f28365a.release();
        o();
        m();
        a();
        n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void l() throws Throwable {
        try {
            this.f28365a.reset();
        } catch (Throwable th) {
            u.c("AndroidMediaPlayer", "reset error: ", th);
        }
        m();
        a();
        n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.f28369e) {
            if (!this.f28370f) {
                this.f28365a.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    @TargetApi(14)
    public void a(Surface surface) {
        o();
        this.f28368d = surface;
        this.f28365a.setSurface(surface);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(String str) throws Throwable {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase("file")) {
            this.f28365a.setDataSource(parse.getPath());
        } else {
            this.f28365a.setDataSource(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(FileDescriptor fileDescriptor) throws Throwable {
        this.f28365a.setDataSource(fileDescriptor);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    @RequiresApi(api = 23)
    public synchronized void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = com.bytedance.sdk.openadsdk.k.g.b.a(str);
        }
        u.b("AndroidMediaPlayer", "setDataSource: ", str2);
        com.bytedance.sdk.openadsdk.video.b.a aVar = new com.bytedance.sdk.openadsdk.video.b.a();
        aVar.a(str);
        aVar.b(str2);
        this.f28367c = com.bytedance.sdk.openadsdk.video.a.a.a(p.a(), aVar);
        com.bytedance.sdk.openadsdk.video.a.b.a.b(p.a(), aVar);
        this.f28365a.setDataSource(this.f28367c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(boolean z) throws Throwable {
        this.f28365a.setScreenOnWhilePlaying(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(long j) throws Throwable {
        this.f28365a.seekTo((int) j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(float f2, float f3) throws Throwable {
        this.f28365a.setVolume(f2, f3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(Context context, int i) throws Throwable {
        this.f28365a.setWakeMode(context, i);
    }
}
