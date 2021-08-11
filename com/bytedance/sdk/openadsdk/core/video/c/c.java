package com.bytedance.sdk.openadsdk.core.video.c;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
/* loaded from: classes9.dex */
public interface c {

    /* loaded from: classes9.dex */
    public interface a {
        void a(c cVar, int i2);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(c cVar);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1905c {
        boolean a(c cVar, int i2, int i3);
    }

    /* loaded from: classes9.dex */
    public interface d {
        boolean b(c cVar, int i2, int i3);
    }

    /* loaded from: classes9.dex */
    public interface e {
        void b(c cVar);
    }

    /* loaded from: classes9.dex */
    public interface f {
        void c(c cVar);
    }

    /* loaded from: classes9.dex */
    public interface g {
        void a(c cVar, int i2, int i3, int i4, int i5);
    }

    void a(float f2, float f3) throws Throwable;

    void a(long j2) throws Throwable;

    @Deprecated
    void a(Context context, int i2) throws Throwable;

    void a(Surface surface) throws Throwable;

    void a(SurfaceHolder surfaceHolder) throws Throwable;

    void a(a aVar);

    void a(b bVar);

    void a(InterfaceC1905c interfaceC1905c);

    void a(d dVar);

    void a(e eVar);

    void a(f fVar);

    void a(g gVar);

    void a(com.bytedance.sdk.openadsdk.n.f.b bVar);

    void a(FileDescriptor fileDescriptor) throws Throwable;

    void a(String str) throws Throwable;

    void a(boolean z) throws Throwable;

    void b(boolean z) throws Throwable;

    void f() throws Throwable;

    void g() throws Throwable;

    void h() throws Throwable;

    long i() throws Throwable;

    long j() throws Throwable;

    void k() throws Throwable;

    void l() throws Throwable;
}
