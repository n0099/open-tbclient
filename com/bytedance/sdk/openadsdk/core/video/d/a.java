package com.bytedance.sdk.openadsdk.core.video.d;

import com.bytedance.sdk.openadsdk.core.video.d.c;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes6.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public c.e f28664a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f28665b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f28666c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f28667d;

    /* renamed from: e  reason: collision with root package name */
    public c.g f28668e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0310c f28669f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f28670g;

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.e eVar) {
        this.f28664a = eVar;
    }

    public final void b() {
        try {
            if (this.f28664a != null) {
                this.f28664a.b(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    public final void c() {
        try {
            if (this.f28665b != null) {
                this.f28665b.a(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    public final void d() {
        try {
            if (this.f28667d != null) {
                this.f28667d.c(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.b bVar) {
        this.f28665b = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.a aVar) {
        this.f28666c = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.f fVar) {
        this.f28667d = fVar;
    }

    public final boolean b(int i, int i2) {
        try {
            if (this.f28670g != null) {
                return this.f28670g.b(this, i, i2);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.InterfaceC0310c interfaceC0310c) {
        this.f28669f = interfaceC0310c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.d dVar) {
        this.f28670g = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.g gVar) {
        this.f28668e = gVar;
    }

    public void a() {
        this.f28664a = null;
        this.f28666c = null;
        this.f28665b = null;
        this.f28667d = null;
        this.f28668e = null;
        this.f28669f = null;
        this.f28670g = null;
    }

    public final void a(int i) {
        try {
            if (this.f28666c != null) {
                this.f28666c.a(this, i);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        try {
            if (this.f28668e != null) {
                this.f28668e.a(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    public final boolean a(int i, int i2) {
        try {
            if (this.f28669f != null) {
                return this.f28669f.a(this, i, i2);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }
}
