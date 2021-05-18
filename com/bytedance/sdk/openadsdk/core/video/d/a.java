package com.bytedance.sdk.openadsdk.core.video.d;

import com.bytedance.sdk.openadsdk.core.video.d.c;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes6.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public c.e f28473a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f28474b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f28475c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f28476d;

    /* renamed from: e  reason: collision with root package name */
    public c.g f28477e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0295c f28478f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f28479g;

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.e eVar) {
        this.f28473a = eVar;
    }

    public final void b() {
        try {
            if (this.f28473a != null) {
                this.f28473a.b(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    public final void c() {
        try {
            if (this.f28474b != null) {
                this.f28474b.a(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    public final void d() {
        try {
            if (this.f28476d != null) {
                this.f28476d.c(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.b bVar) {
        this.f28474b = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.a aVar) {
        this.f28475c = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.f fVar) {
        this.f28476d = fVar;
    }

    public final boolean b(int i2, int i3) {
        try {
            if (this.f28479g != null) {
                return this.f28479g.b(this, i2, i3);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.InterfaceC0295c interfaceC0295c) {
        this.f28478f = interfaceC0295c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.d dVar) {
        this.f28479g = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.g gVar) {
        this.f28477e = gVar;
    }

    public void a() {
        this.f28473a = null;
        this.f28475c = null;
        this.f28474b = null;
        this.f28476d = null;
        this.f28477e = null;
        this.f28478f = null;
        this.f28479g = null;
    }

    public final void a(int i2) {
        try {
            if (this.f28475c != null) {
                this.f28475c.a(this, i2);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        try {
            if (this.f28477e != null) {
                this.f28477e.a(this, i2, i3, i4, i5);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    public final boolean a(int i2, int i3) {
        try {
            if (this.f28478f != null) {
                return this.f28478f.a(this, i2, i3);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }
}
