package com.baidu.turbonet.base.library_loader;

import com.baidu.turbonet.base.library_loader.Linker;
/* loaded from: classes5.dex */
public class ModernLinker extends Linker {
    public static native boolean nativeCreateSharedRelro(String str, long j, String str2, Linker.LibInfo libInfo);

    public static native String nativeGetCpuAbi();

    public static native boolean nativeLoadLibrary(String str, long j, Linker.LibInfo libInfo);
}
