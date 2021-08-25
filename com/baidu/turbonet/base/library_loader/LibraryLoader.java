package com.baidu.turbonet.base.library_loader;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
@JNINamespace
/* loaded from: classes8.dex */
public class LibraryLoader {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile LibraryLoader f59112b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f59113a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(468673833, "Lcom/baidu/turbonet/base/library_loader/LibraryLoader;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(468673833, "Lcom/baidu/turbonet/base/library_loader/LibraryLoader;");
        }
    }

    @CalledByNative
    public static int getLibraryProcessType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f59112b == null) {
                return 0;
            }
            return f59112b.f59113a;
        }
        return invokeV.intValue;
    }

    public static native boolean nativeForkAndPrefetchNativeLibrary();

    private native String nativeGetVersionNumber();

    private native void nativeInitCommandLine(String[] strArr);

    private native boolean nativeLibraryLoaded();

    public static native int nativePercentageOfResidentNativeLibraryCode();

    private native void nativeRecordChromiumAndroidLinkerBrowserHistogram(boolean z, boolean z2, int i2, long j2);

    private native void nativeRecordLibraryPreloaderBrowserHistogram(int i2);

    private native void nativeRegisterChromiumAndroidLinkerRendererHistogram(boolean z, boolean z2, long j2);

    private native void nativeRegisterLibraryPreloaderRendererHistogram(int i2);
}
