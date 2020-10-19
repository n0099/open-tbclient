package com.baidu.turbonet.base.library_loader;

import android.os.Bundle;
import com.baidu.turbonet.base.ThreadUtils;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.library_loader.Linker;
import java.util.HashMap;
import javax.annotation.Nullable;
/* loaded from: classes17.dex */
class LegacyLinker extends Linker {
    static final /* synthetic */ boolean $assertionsDisabled;
    private boolean mInitialized = false;
    private boolean nzu = true;
    private boolean nzv = false;
    private boolean nzw = false;
    private Bundle nzx = null;
    private long nzy = -1;
    private long nzz = -1;
    private boolean nzA = false;
    private HashMap<String, Linker.LibInfo> nzB = null;

    private static native boolean nativeCreateSharedRelro(String str, long j, Linker.LibInfo libInfo);

    private static native boolean nativeLoadLibrary(String str, long j, Linker.LibInfo libInfo);

    private static native boolean nativeLoadLibraryInZipFile(@Nullable String str, String str2, long j, Linker.LibInfo libInfo);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeRunCallbackOnUiThread(long j);

    private static native boolean nativeUseSharedRelro(String str, Linker.LibInfo libInfo);

    static {
        $assertionsDisabled = !LegacyLinker.class.desiredAssertionStatus();
    }

    private LegacyLinker() {
    }

    @CalledByNative
    public static void postCallbackOnMainThread(final long j) {
        ThreadUtils.x(new Runnable() { // from class: com.baidu.turbonet.base.library_loader.LegacyLinker.1
            @Override // java.lang.Runnable
            public void run() {
                LegacyLinker.nativeRunCallbackOnUiThread(j);
            }
        });
    }
}
