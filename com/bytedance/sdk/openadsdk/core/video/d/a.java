package com.bytedance.sdk.openadsdk.core.video.d;

import com.bytedance.sdk.openadsdk.core.video.d.c;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes5.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public c.e f28358a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f28359b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f28360c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f28361d;

    /* renamed from: e  reason: collision with root package name */
    public c.g f28362e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0315c f28363f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f28364g;

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.e eVar) {
        this.f28358a = eVar;
    }

    public final void b() {
        try {
            if (this.f28358a != null) {
                this.f28358a.b(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    public final void c() {
        try {
            if (this.f28359b != null) {
                this.f28359b.a(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    public final void d() {
        try {
            if (this.f28361d != null) {
                this.f28361d.c(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.b bVar) {
        this.f28359b = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.a aVar) {
        this.f28360c = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.f fVar) {
        this.f28361d = fVar;
    }

    public final boolean b(int i, int i2) {
        try {
            if (this.f28364g != null) {
                return this.f28364g.b(this, i, i2);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.InterfaceC0315c interfaceC0315c) {
        this.f28363f = interfaceC0315c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.d dVar) {
        this.f28364g = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.g gVar) {
        this.f28362e = gVar;
    }

    public void a() {
        this.f28358a = null;
        this.f28360c = null;
        this.f28359b = null;
        this.f28361d = null;
        this.f28362e = null;
        this.f28363f = null;
        this.f28364g = null;
    }

    public final void a(int i) {
        try {
            if (this.f28360c != null) {
                this.f28360c.a(this, i);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        try {
            if (this.f28362e != null) {
                this.f28362e.a(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    public final boolean a(int i, int i2) {
        try {
            if (this.f28363f != null) {
                return this.f28363f.a(this, i, i2);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }
}
