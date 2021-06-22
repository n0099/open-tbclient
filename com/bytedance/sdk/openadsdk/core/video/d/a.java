package com.bytedance.sdk.openadsdk.core.video.d;

import com.bytedance.sdk.openadsdk.core.video.d.c;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes6.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public c.e f28587a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f28588b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f28589c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f28590d;

    /* renamed from: e  reason: collision with root package name */
    public c.g f28591e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0301c f28592f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f28593g;

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.e eVar) {
        this.f28587a = eVar;
    }

    public final void b() {
        try {
            if (this.f28587a != null) {
                this.f28587a.b(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    public final void c() {
        try {
            if (this.f28588b != null) {
                this.f28588b.a(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    public final void d() {
        try {
            if (this.f28590d != null) {
                this.f28590d.c(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.b bVar) {
        this.f28588b = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.a aVar) {
        this.f28589c = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.f fVar) {
        this.f28590d = fVar;
    }

    public final boolean b(int i2, int i3) {
        try {
            if (this.f28593g != null) {
                return this.f28593g.b(this, i2, i3);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.InterfaceC0301c interfaceC0301c) {
        this.f28592f = interfaceC0301c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.d dVar) {
        this.f28593g = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c
    public final void a(c.g gVar) {
        this.f28591e = gVar;
    }

    public void a() {
        this.f28587a = null;
        this.f28589c = null;
        this.f28588b = null;
        this.f28590d = null;
        this.f28591e = null;
        this.f28592f = null;
        this.f28593g = null;
    }

    public final void a(int i2) {
        try {
            if (this.f28589c != null) {
                this.f28589c.a(this, i2);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        try {
            if (this.f28591e != null) {
                this.f28591e.a(this, i2, i3, i4, i5);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    public final boolean a(int i2, int i3) {
        try {
            if (this.f28592f != null) {
                return this.f28592f.a(this, i2, i3);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }
}
