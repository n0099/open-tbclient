package com.baidu.turbonet.base.library_loader;

import android.os.Bundle;
import com.baidu.turbonet.base.library_loader.Linker;
import java.util.HashMap;
/* loaded from: classes.dex */
class ModernLinker extends Linker {
    static final /* synthetic */ boolean $assertionsDisabled;
    private boolean mInitialized = false;
    private boolean mbz = false;
    private HashMap<String, Linker.LibInfo> mbN = null;
    private Bundle mbO = null;
    private boolean mby = true;
    private long mbC = -1;
    private long mbD = -1;
    private boolean mbE = false;
    private HashMap<String, Linker.LibInfo> mbF = null;

    private static native boolean nativeCreateSharedRelro(String str, long j, String str2, Linker.LibInfo libInfo);

    private static native String nativeGetCpuAbi();

    private static native boolean nativeLoadLibrary(String str, long j, Linker.LibInfo libInfo);

    static {
        $assertionsDisabled = !ModernLinker.class.desiredAssertionStatus();
    }

    private ModernLinker() {
    }
}
