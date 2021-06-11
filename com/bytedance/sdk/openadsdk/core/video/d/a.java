package com.bytedance.sdk.openadsdk.core.video.d;

import com.bytedance.sdk.openadsdk.core.video.d.c;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes6.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public c.e f28505a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f28506b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f28507c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f28508d;

    /* renamed from: e  reason: collision with root package name */
    public c.g f28509e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0298c f28510f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f28511g;

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.e eVar) {
        this.f28505a = eVar;
    }

    public final void b() {
        try {
            if (this.f28505a != null) {
                this.f28505a.b(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    public final void c() {
        try {
            if (this.f28506b != null) {
                this.f28506b.a(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    public final void d() {
        try {
            if (this.f28508d != null) {
                this.f28508d.c(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.b bVar) {
        this.f28506b = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.a aVar) {
        this.f28507c = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.f fVar) {
        this.f28508d = fVar;
    }

    public final boolean b(int i2, int i3) {
        try {
            if (this.f28511g != null) {
                return this.f28511g.b(this, i2, i3);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.InterfaceC0298c interfaceC0298c) {
        this.f28510f = interfaceC0298c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.d dVar) {
        this.f28511g = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.g gVar) {
        this.f28509e = gVar;
    }

    public void a() {
        this.f28505a = null;
        this.f28507c = null;
        this.f28506b = null;
        this.f28508d = null;
        this.f28509e = null;
        this.f28510f = null;
        this.f28511g = null;
    }

    public final void a(int i2) {
        try {
            if (this.f28507c != null) {
                this.f28507c.a(this, i2);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        try {
            if (this.f28509e != null) {
                this.f28509e.a(this, i2, i3, i4, i5);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    public final boolean a(int i2, int i3) {
        try {
            if (this.f28510f != null) {
                return this.f28510f.a(this, i2, i3);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }
}
