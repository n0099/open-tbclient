package com.bytedance.sdk.openadsdk.core.video.d;

import com.bytedance.sdk.openadsdk.core.video.d.c;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes5.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public c.e f29228a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f29229b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f29230c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f29231d;

    /* renamed from: e  reason: collision with root package name */
    public c.g f29232e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0308c f29233f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f29234g;

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.e eVar) {
        this.f29228a = eVar;
    }

    public final void b() {
        try {
            if (this.f29228a != null) {
                this.f29228a.b(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    public final void c() {
        try {
            if (this.f29229b != null) {
                this.f29229b.a(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    public final void d() {
        try {
            if (this.f29231d != null) {
                this.f29231d.c(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.b bVar) {
        this.f29229b = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.a aVar) {
        this.f29230c = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.f fVar) {
        this.f29231d = fVar;
    }

    public final boolean b(int i2, int i3) {
        try {
            if (this.f29234g != null) {
                return this.f29234g.b(this, i2, i3);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.InterfaceC0308c interfaceC0308c) {
        this.f29233f = interfaceC0308c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.d dVar) {
        this.f29234g = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.g gVar) {
        this.f29232e = gVar;
    }

    public void a() {
        this.f29228a = null;
        this.f29230c = null;
        this.f29229b = null;
        this.f29231d = null;
        this.f29232e = null;
        this.f29233f = null;
        this.f29234g = null;
    }

    public final void a(int i2) {
        try {
            if (this.f29230c != null) {
                this.f29230c.a(this, i2);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        try {
            if (this.f29232e != null) {
                this.f29232e.a(this, i2, i3, i4, i5);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    public final boolean a(int i2, int i3) {
        try {
            if (this.f29233f != null) {
                return this.f29233f.a(this, i2, i3);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }
}
