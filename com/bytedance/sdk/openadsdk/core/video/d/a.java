package com.bytedance.sdk.openadsdk.core.video.d;

import com.bytedance.sdk.openadsdk.core.video.d.c;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes6.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public c.e f28402a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f28403b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f28404c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f28405d;

    /* renamed from: e  reason: collision with root package name */
    public c.g f28406e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0296c f28407f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f28408g;

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.e eVar) {
        this.f28402a = eVar;
    }

    public final void b() {
        try {
            if (this.f28402a != null) {
                this.f28402a.b(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    public final void c() {
        try {
            if (this.f28403b != null) {
                this.f28403b.a(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    public final void d() {
        try {
            if (this.f28405d != null) {
                this.f28405d.c(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.b bVar) {
        this.f28403b = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.a aVar) {
        this.f28404c = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.f fVar) {
        this.f28405d = fVar;
    }

    public final boolean b(int i2, int i3) {
        try {
            if (this.f28408g != null) {
                return this.f28408g.b(this, i2, i3);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.InterfaceC0296c interfaceC0296c) {
        this.f28407f = interfaceC0296c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.d dVar) {
        this.f28408g = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.g gVar) {
        this.f28406e = gVar;
    }

    public void a() {
        this.f28402a = null;
        this.f28404c = null;
        this.f28403b = null;
        this.f28405d = null;
        this.f28406e = null;
        this.f28407f = null;
        this.f28408g = null;
    }

    public final void a(int i2) {
        try {
            if (this.f28404c != null) {
                this.f28404c.a(this, i2);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        try {
            if (this.f28406e != null) {
                this.f28406e.a(this, i2, i3, i4, i5);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    public final boolean a(int i2, int i3) {
        try {
            if (this.f28407f != null) {
                return this.f28407f.a(this, i2, i3);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }
}
