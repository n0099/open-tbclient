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
    public final HandlerThread f22329a;

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f22330e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f22331f;

        public a(long j, long j2) {
            this.f22330e = j;
            this.f22331f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JavaHandlerThread.this.nativeInitializeThread(this.f22330e, this.f22331f);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f22333e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f22334f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f22335g;

        public b(long j, long j2, boolean z) {
            this.f22333e = j;
            this.f22334f = j2;
            this.f22335g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            JavaHandlerThread.this.nativeStopThread(this.f22333e, this.f22334f);
            if (this.f22335g) {
                return;
            }
            JavaHandlerThread.this.f22329a.quit();
        }
    }

    public JavaHandlerThread(String str) {
        this.f22329a = new HandlerThread(str);
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
        this.f22329a.start();
        new Handler(this.f22329a.getLooper()).post(new a(j, j2));
    }

    @CalledByNative
    @TargetApi(18)
    private void stop(long j, long j2) {
        boolean z = Build.VERSION.SDK_INT >= 18;
        new Handler(this.f22329a.getLooper()).post(new b(j, j2, z));
        if (z) {
            this.f22329a.quitSafely();
        }
    }
}
