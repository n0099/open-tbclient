package com.bytedance.sdk.openadsdk.core.video.d;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
/* loaded from: classes5.dex */
public interface c {

    /* loaded from: classes5.dex */
    public interface a {
        void a(c cVar, int i);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(c cVar);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0315c {
        boolean a(c cVar, int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface d {
        boolean b(c cVar, int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void b(c cVar);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void c(c cVar);
    }

    /* loaded from: classes5.dex */
    public interface g {
        void a(c cVar, int i, int i2, int i3, int i4);
    }

    void a(float f2, float f3) throws Throwable;

    void a(long j) throws Throwable;

    @Deprecated
    void a(Context context, int i) throws Throwable;

    void a(Surface surface) throws Throwable;

    void a(SurfaceHolder surfaceHolder) throws Throwable;

    void a(a aVar);

    void a(b bVar);

    void a(InterfaceC0315c interfaceC0315c);

    void a(d dVar);

    void a(e eVar);

    void a(f fVar);

    void a(g gVar);

    void a(FileDescriptor fileDescriptor) throws Throwable;

    void a(String str) throws Throwable;

    void a(String str, String str2);

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
