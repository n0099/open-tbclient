package com.bytedance.sdk.openadsdk.core.video.d;

import com.bytedance.sdk.openadsdk.core.video.d.c;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes5.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public c.e f28350a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f28351b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f28352c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f28353d;

    /* renamed from: e  reason: collision with root package name */
    public c.g f28354e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0313c f28355f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f28356g;

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.e eVar) {
        this.f28350a = eVar;
    }

    public final void b() {
        try {
            if (this.f28350a != null) {
                this.f28350a.b(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    public final void c() {
        try {
            if (this.f28351b != null) {
                this.f28351b.a(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    public final void d() {
        try {
            if (this.f28353d != null) {
                this.f28353d.c(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.b bVar) {
        this.f28351b = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.a aVar) {
        this.f28352c = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.f fVar) {
        this.f28353d = fVar;
    }

    public final boolean b(int i, int i2) {
        try {
            if (this.f28356g != null) {
                return this.f28356g.b(this, i, i2);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.InterfaceC0313c interfaceC0313c) {
        this.f28355f = interfaceC0313c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.d dVar) {
        this.f28356g = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.g gVar) {
        this.f28354e = gVar;
    }

    public void a() {
        this.f28350a = null;
        this.f28352c = null;
        this.f28351b = null;
        this.f28353d = null;
        this.f28354e = null;
        this.f28355f = null;
        this.f28356g = null;
    }

    public final void a(int i) {
        try {
            if (this.f28352c != null) {
                this.f28352c.a(this, i);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        try {
            if (this.f28354e != null) {
                this.f28354e.a(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    public final boolean a(int i, int i2) {
        try {
            if (this.f28355f != null) {
                return this.f28355f.a(this, i, i2);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }
}
