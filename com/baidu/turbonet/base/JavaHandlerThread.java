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
    public final HandlerThread f22643a;

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f22644e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f22645f;

        public a(long j, long j2) {
            this.f22644e = j;
            this.f22645f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JavaHandlerThread.this.nativeInitializeThread(this.f22644e, this.f22645f);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f22647e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f22648f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f22649g;

        public b(long j, long j2, boolean z) {
            this.f22647e = j;
            this.f22648f = j2;
            this.f22649g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            JavaHandlerThread.this.nativeStopThread(this.f22647e, this.f22648f);
            if (this.f22649g) {
                return;
            }
            JavaHandlerThread.this.f22643a.quit();
        }
    }

    public JavaHandlerThread(String str) {
        this.f22643a = new HandlerThread(str);
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
        this.f22643a.start();
        new Handler(this.f22643a.getLooper()).post(new a(j, j2));
    }

    @CalledByNative
    @TargetApi(18)
    private void stop(long j, long j2) {
        boolean z = Build.VERSION.SDK_INT >= 18;
        new Handler(this.f22643a.getLooper()).post(new b(j, j2, z));
        if (z) {
            this.f22643a.quitSafely();
        }
    }
}
