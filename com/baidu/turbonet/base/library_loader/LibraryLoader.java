package com.baidu.turbonet.base.library_loader;

import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
@JNINamespace
/* loaded from: classes5.dex */
public class LibraryLoader {

    /* renamed from: b  reason: collision with root package name */
    public static volatile LibraryLoader f22409b;

    /* renamed from: a  reason: collision with root package name */
    public final int f22410a;

    @CalledByNative
    public static int getLibraryProcessType() {
        if (f22409b == null) {
            return 0;
        }
        return f22409b.f22410a;
    }

    public static native boolean nativeForkAndPrefetchNativeLibrary();

    private native String nativeGetVersionNumber();

    private native void nativeInitCommandLine(String[] strArr);

    private native boolean nativeLibraryLoaded();

    public static native int nativePercentageOfResidentNativeLibraryCode();

    private native void nativeRecordChromiumAndroidLinkerBrowserHistogram(boolean z, boolean z2, int i2, long j);

    private native void nativeRecordLibraryPreloaderBrowserHistogram(int i2);

    private native void nativeRegisterChromiumAndroidLinkerRendererHistogram(boolean z, boolean z2, long j);

    private native void nativeRegisterLibraryPreloaderRendererHistogram(int i2);
}
