package com.baidu.turbonet.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
@JNINamespace
/* loaded from: classes6.dex */
class JavaHandlerThread {
    final HandlerThread mThread;

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeInitializeThread(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeStopThread(long j, long j2);

    private JavaHandlerThread(String str) {
        this.mThread = new HandlerThread(str);
    }

    @CalledByNative
    private static JavaHandlerThread create(String str) {
        return new JavaHandlerThread(str);
    }

    @CalledByNative
    private void start(final long j, final long j2) {
        this.mThread.start();
        new Handler(this.mThread.getLooper()).post(new Runnable() { // from class: com.baidu.turbonet.base.JavaHandlerThread.1
            @Override // java.lang.Runnable
            public void run() {
                JavaHandlerThread.this.nativeInitializeThread(j, j2);
            }
        });
    }

    @CalledByNative
    @TargetApi(18)
    private void stop(final long j, final long j2) {
        final boolean z = Build.VERSION.SDK_INT >= 18;
        new Handler(this.mThread.getLooper()).post(new Runnable() { // from class: com.baidu.turbonet.base.JavaHandlerThread.2
            @Override // java.lang.Runnable
            public void run() {
                JavaHandlerThread.this.nativeStopThread(j, j2);
                if (!z) {
                    JavaHandlerThread.this.mThread.quit();
                }
            }
        });
        if (z) {
            this.mThread.quitSafely();
        }
    }
}
