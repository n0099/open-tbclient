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
    public final HandlerThread f23029a;

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f23030e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f23031f;

        public a(long j, long j2) {
            this.f23030e = j;
            this.f23031f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JavaHandlerThread.this.nativeInitializeThread(this.f23030e, this.f23031f);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f23033e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f23034f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f23035g;

        public b(long j, long j2, boolean z) {
            this.f23033e = j;
            this.f23034f = j2;
            this.f23035g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            JavaHandlerThread.this.nativeStopThread(this.f23033e, this.f23034f);
            if (this.f23035g) {
                return;
            }
            JavaHandlerThread.this.f23029a.quit();
        }
    }

    public JavaHandlerThread(String str) {
        this.f23029a = new HandlerThread(str);
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
        this.f23029a.start();
        new Handler(this.f23029a.getLooper()).post(new a(j, j2));
    }

    @CalledByNative
    @TargetApi(18)
    private void stop(long j, long j2) {
        boolean z = Build.VERSION.SDK_INT >= 18;
        new Handler(this.f23029a.getLooper()).post(new b(j, j2, z));
        if (z) {
            this.f23029a.quitSafely();
        }
    }
}
