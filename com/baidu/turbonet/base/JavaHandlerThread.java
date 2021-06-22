package com.baidu.turbonet.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
@JNINamespace
/* loaded from: classes5.dex */
public class JavaHandlerThread {

    /* renamed from: a  reason: collision with root package name */
    public final HandlerThread f22388a;

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f22389e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f22390f;

        public a(long j, long j2) {
            this.f22389e = j;
            this.f22390f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JavaHandlerThread.this.nativeInitializeThread(this.f22389e, this.f22390f);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f22392e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f22393f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f22394g;

        public b(long j, long j2, boolean z) {
            this.f22392e = j;
            this.f22393f = j2;
            this.f22394g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            JavaHandlerThread.this.nativeStopThread(this.f22392e, this.f22393f);
            if (this.f22394g) {
                return;
            }
            JavaHandlerThread.this.f22388a.quit();
        }
    }

    public JavaHandlerThread(String str) {
        this.f22388a = new HandlerThread(str);
    }

    @CalledByNative
    public static JavaHandlerThread create(String str) {
        return new JavaHandlerThread(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeInitializeThread(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeStopThread(long j, long j2);

    @CalledByNative
    private void start(long j, long j2) {
        this.f22388a.start();
        new Handler(this.f22388a.getLooper()).post(new a(j, j2));
    }

    @CalledByNative
    @TargetApi(18)
    private void stop(long j, long j2) {
        boolean z = Build.VERSION.SDK_INT >= 18;
        new Handler(this.f22388a.getLooper()).post(new b(j, j2, z));
        if (z) {
            this.f22388a.quitSafely();
        }
    }
}
