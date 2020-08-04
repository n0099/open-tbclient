package com.baidu.turbonet.base.library_loader;

import android.os.Bundle;
import com.baidu.turbonet.base.library_loader.Linker;
import java.util.HashMap;
/* loaded from: classes19.dex */
class ModernLinker extends Linker {
    static final /* synthetic */ boolean $assertionsDisabled;
    private boolean mInitialized = false;
    private boolean mGI = false;
    private HashMap<String, Linker.LibInfo> mGW = null;
    private Bundle mGX = null;
    private boolean mGH = true;
    private long mGL = -1;
    private long mGM = -1;
    private boolean mGN = false;
    private HashMap<String, Linker.LibInfo> mGO = null;

    private static native boolean nativeCreateSharedRelro(String str, long j, String str2, Linker.LibInfo libInfo);

    private static native String nativeGetCpuAbi();

    private static native boolean nativeLoadLibrary(String str, long j, Linker.LibInfo libInfo);

    static {
        $assertionsDisabled = !ModernLinker.class.desiredAssertionStatus();
    }

    private ModernLinker() {
    }
}
