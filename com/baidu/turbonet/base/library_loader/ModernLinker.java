package com.baidu.turbonet.base.library_loader;

import android.os.Bundle;
import com.baidu.turbonet.base.library_loader.Linker;
import java.util.HashMap;
/* loaded from: classes4.dex */
class ModernLinker extends Linker {
    static final /* synthetic */ boolean $assertionsDisabled;
    private boolean mInitialized = false;
    private boolean oED = false;
    private HashMap<String, Linker.LibInfo> oER = null;
    private Bundle oES = null;
    private boolean oEC = true;
    private long oEG = -1;
    private long oEH = -1;
    private boolean oEI = false;
    private HashMap<String, Linker.LibInfo> oEJ = null;

    private static native boolean nativeCreateSharedRelro(String str, long j, String str2, Linker.LibInfo libInfo);

    private static native String nativeGetCpuAbi();

    private static native boolean nativeLoadLibrary(String str, long j, Linker.LibInfo libInfo);

    static {
        $assertionsDisabled = !ModernLinker.class.desiredAssertionStatus();
    }

    private ModernLinker() {
    }
}
