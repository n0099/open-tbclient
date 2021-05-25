package com.baidu.turbonet.base.library_loader;

import com.baidu.turbonet.base.ThreadUtils;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.library_loader.Linker;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class LegacyLinker extends Linker {

    /* loaded from: classes5.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f22223e;

        public a(long j) {
            this.f22223e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            LegacyLinker.nativeRunCallbackOnUiThread(this.f22223e);
        }
    }

    public static native boolean nativeCreateSharedRelro(String str, long j, Linker.LibInfo libInfo);

    public static native boolean nativeLoadLibrary(String str, long j, Linker.LibInfo libInfo);

    public static native boolean nativeLoadLibraryInZipFile(@Nullable String str, String str2, long j, Linker.LibInfo libInfo);

    public static native void nativeRunCallbackOnUiThread(long j);

    public static native boolean nativeUseSharedRelro(String str, Linker.LibInfo libInfo);

    @CalledByNative
    public static void postCallbackOnMainThread(long j) {
        ThreadUtils.b(new a(j));
    }
}
