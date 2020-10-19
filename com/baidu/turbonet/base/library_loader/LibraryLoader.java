package com.baidu.turbonet.base.library_loader;

import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
@JNINamespace
/* loaded from: classes17.dex */
public class LibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static volatile LibraryLoader nzD;
    private static final Object sLock;
    private final int nzE;

    private static native boolean nativeForkAndPrefetchNativeLibrary();

    private native String nativeGetVersionNumber();

    private native void nativeInitCommandLine(String[] strArr);

    private native boolean nativeLibraryLoaded();

    private static native int nativePercentageOfResidentNativeLibraryCode();

    private native void nativeRecordChromiumAndroidLinkerBrowserHistogram(boolean z, boolean z2, int i, long j);

    private native void nativeRecordLibraryPreloaderBrowserHistogram(int i);

    private native void nativeRegisterChromiumAndroidLinkerRendererHistogram(boolean z, boolean z2, long j);

    private native void nativeRegisterLibraryPreloaderRendererHistogram(int i);

    static {
        $assertionsDisabled = !LibraryLoader.class.desiredAssertionStatus();
        sLock = new Object();
    }

    @CalledByNative
    public static int getLibraryProcessType() {
        if (nzD == null) {
            return 0;
        }
        return nzD.nzE;
    }
}
