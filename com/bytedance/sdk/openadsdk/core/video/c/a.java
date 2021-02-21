package com.bytedance.sdk.openadsdk.core.video.c;

import com.bytedance.sdk.openadsdk.core.video.c.c;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes6.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private c.e f6699a;

    /* renamed from: b  reason: collision with root package name */
    private c.b f6700b;
    private c.a c;
    private c.f d;
    private c.g e;
    private c.InterfaceC1011c f;
    private c.d g;

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.e eVar) {
        this.f6699a = eVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.b bVar) {
        this.f6700b = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.a aVar) {
        this.c = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.f fVar) {
        this.d = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.InterfaceC1011c interfaceC1011c) {
        this.f = interfaceC1011c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.d dVar) {
        this.g = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.g gVar) {
        this.e = gVar;
    }

    public void a() {
        this.f6699a = null;
        this.c = null;
        this.f6700b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        try {
            if (this.f6699a != null) {
                this.f6699a.b(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        try {
            if (this.f6700b != null) {
                this.f6700b.a(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i) {
        try {
            if (this.c != null) {
                this.c.a(this, i);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        try {
            if (this.d != null) {
                this.d.c(this);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i, int i2, int i3, int i4) {
        try {
            if (this.e != null) {
                this.e.a(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(int i, int i2) {
        try {
            if (this.f != null) {
                return this.f.a(this, i, i2);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b(int i, int i2) {
        try {
            if (this.g != null) {
                return this.g.b(this, i, i2);
            }
            return false;
        } catch (Throwable th) {
            u.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }
}
