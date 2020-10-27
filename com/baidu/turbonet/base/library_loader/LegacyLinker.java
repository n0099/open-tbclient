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
    private boolean obU = true;
    private boolean obV = false;
    private boolean obW = false;
    private Bundle obX = null;
    private long obY = -1;
    private long obZ = -1;
    private boolean oca = false;
    private HashMap<String, Linker.LibInfo> ocb = null;

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
        ThreadUtils.y(new Runnable() { // from class: com.baidu.turbonet.base.library_loader.LegacyLinker.1
            @Override // java.lang.Runnable
            public void run() {
                LegacyLinker.nativeRunCallbackOnUiThread(j);
            }
        });
    }
}
