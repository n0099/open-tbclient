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
/* loaded from: classes6.dex */
public class b extends com.bytedance.sdk.openadsdk.core.video.d.a {

    /* renamed from: a  reason: collision with root package name */
    public final MediaPlayer f28594a;

    /* renamed from: b  reason: collision with root package name */
    public final a f28595b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.video.a.a f28596c;

    /* renamed from: d  reason: collision with root package name */
    public Surface f28597d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f28598e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28599f;

    /* loaded from: classes6.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<b> f28601b;

        public a(b bVar) {
            this.f28601b = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            try {
                if (this.f28601b.get() != null) {
                    b.this.a(i2);
                }
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onBufferingUpdate error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                if (this.f28601b.get() != null) {
                    b.this.c();
                }
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onCompletion error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            try {
                if (this.f28601b.get() != null) {
                    return b.this.a(i2, i3);
                }
                return false;
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onError error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            try {
                if (this.f28601b.get() != null) {
                    return b.this.b(i2, i3);
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
                if (this.f28601b.get() != null) {
                    b.this.b();
                }
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onPrepared error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                if (this.f28601b.get() != null) {
                    b.this.d();
                }
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onSeekComplete error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            try {
                if (this.f28601b.get() != null) {
                    b.this.a(i2, i3, 1, 1);
                }
            } catch (Throwable th) {
                u.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onVideoSizeChanged error: ", th);
            }
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.f28598e = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.f28594a = mediaPlayer;
        }
        a(mediaPlayer);
        try {
            this.f28594a.setAudioStreamType(3);
        } catch (Throwable th) {
            u.c("AndroidMediaPlayer", "setAudioStreamType error: ", th);
        }
        this.f28595b = new a(this);
        n();
    }

    private void a(MediaPlayer mediaPlayer) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19 || i2 >= 28) {
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
        if (Build.VERSION.SDK_INT < 23 || (aVar = this.f28596c) == null) {
            return;
        }
        try {
            aVar.close();
        } catch (Throwable th) {
            u.c("AndroidMediaPlayer", "releaseMediaDataSource error: ", th);
        }
        this.f28596c = null;
    }

    private void n() {
        this.f28594a.setOnPreparedListener(this.f28595b);
        this.f28594a.setOnBufferingUpdateListener(this.f28595b);
        this.f28594a.setOnCompletionListener(this.f28595b);
        this.f28594a.setOnSeekCompleteListener(this.f28595b);
        this.f28594a.setOnVideoSizeChangedListener(this.f28595b);
        this.f28594a.setOnErrorListener(this.f28595b);
        this.f28594a.setOnInfoListener(this.f28595b);
    }

    private void o() {
        try {
            if (this.f28597d != null) {
                this.f28597d.release();
                this.f28597d = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void b(boolean z) throws Throwable {
        this.f28594a.setLooping(z);
    }

    public MediaPlayer e() {
        return this.f28594a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void f() throws Throwable {
        this.f28594a.start();
    }

    public void finalize() throws Throwable {
        super.finalize();
        o();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void g() throws Throwable {
        this.f28594a.stop();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void h() throws Throwable {
        this.f28594a.pause();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public long i() {
        try {
            return this.f28594a.getCurrentPosition();
        } catch (Throwable th) {
            u.c("AndroidMediaPlayer", "getCurrentPosition error: ", th);
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public long j() {
        try {
            return this.f28594a.getDuration();
        } catch (Throwable th) {
            u.c("AndroidMediaPlayer", "getDuration error: ", th);
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void k() throws Throwable {
        this.f28599f = true;
        this.f28594a.release();
        o();
        m();
        a();
        n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void l() throws Throwable {
        try {
            this.f28594a.reset();
        } catch (Throwable th) {
            u.c("AndroidMediaPlayer", "reset error: ", th);
        }
        m();
        a();
        n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.f28598e) {
            if (!this.f28599f) {
                this.f28594a.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    @TargetApi(14)
    public void a(Surface surface) {
        o();
        this.f28597d = surface;
        this.f28594a.setSurface(surface);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(String str) throws Throwable {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase("file")) {
            this.f28594a.setDataSource(parse.getPath());
        } else {
            this.f28594a.setDataSource(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(FileDescriptor fileDescriptor) throws Throwable {
        this.f28594a.setDataSource(fileDescriptor);
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
        this.f28596c = com.bytedance.sdk.openadsdk.video.a.a.a(p.a(), aVar);
        com.bytedance.sdk.openadsdk.video.a.b.a.b(p.a(), aVar);
        this.f28594a.setDataSource(this.f28596c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(boolean z) throws Throwable {
        this.f28594a.setScreenOnWhilePlaying(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(long j) throws Throwable {
        this.f28594a.seekTo((int) j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(float f2, float f3) throws Throwable {
        this.f28594a.setVolume(f2, f3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public void a(Context context, int i2) throws Throwable {
        this.f28594a.setWakeMode(context, i2);
    }
}
