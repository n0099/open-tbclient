package com.bytedance.sdk.openadsdk.core.video.d;

import com.bytedance.sdk.openadsdk.core.video.d.c;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes6.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public c.e f28665a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f28666b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f28667c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f28668d;

    /* renamed from: e  reason: collision with root package name */
    public c.g f28669e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0311c f28670f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f28671g;

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.e eVar) {
        this.f28665a = eVar;
    }

    public final void b() {
        try {
            if (this.f28665a != null) {
                this.f28665a.b(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    public final void c() {
        try {
            if (this.f28666b != null) {
                this.f28666b.a(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    public final void d() {
        try {
            if (this.f28668d != null) {
                this.f28668d.c(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.b bVar) {
        this.f28666b = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.a aVar) {
        this.f28667c = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.f fVar) {
        this.f28668d = fVar;
    }

    public final boolean b(int i, int i2) {
        try {
            if (this.f28671g != null) {
                return this.f28671g.b(this, i, i2);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.InterfaceC0311c interfaceC0311c) {
        this.f28670f = interfaceC0311c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.d dVar) {
        this.f28671g = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.g gVar) {
        this.f28669e = gVar;
    }

    public void a() {
        this.f28665a = null;
        this.f28667c = null;
        this.f28666b = null;
        this.f28668d = null;
        this.f28669e = null;
        this.f28670f = null;
        this.f28671g = null;
    }

    public final void a(int i) {
        try {
            if (this.f28667c != null) {
                this.f28667c.a(this, i);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        try {
            if (this.f28669e != null) {
                this.f28669e.a(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    public final boolean a(int i, int i2) {
        try {
            if (this.f28670f != null) {
                return this.f28670f.a(this, i, i2);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }
}
