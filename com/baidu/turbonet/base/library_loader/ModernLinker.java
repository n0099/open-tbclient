package com.baidu.turbonet.base.library_loader;

import android.os.Bundle;
import com.baidu.turbonet.base.library_loader.Linker;
import java.util.HashMap;
/* loaded from: classes17.dex */
class ModernLinker extends Linker {
    static final /* synthetic */ boolean $assertionsDisabled;
    private boolean mInitialized = false;
    private boolean ola = false;
    private HashMap<String, Linker.LibInfo> olo = null;
    private Bundle olp = null;
    private boolean okZ = true;
    private long old = -1;
    private long ole = -1;
    private boolean olf = false;
    private HashMap<String, Linker.LibInfo> olg = null;

    private static native boolean nativeCreateSharedRelro(String str, long j, String str2, Linker.LibInfo libInfo);

    private static native String nativeGetCpuAbi();

    private static native boolean nativeLoadLibrary(String str, long j, Linker.LibInfo libInfo);

    static {
        $assertionsDisabled = !ModernLinker.class.desiredAssertionStatus();
    }

    private ModernLinker() {
    }
}
