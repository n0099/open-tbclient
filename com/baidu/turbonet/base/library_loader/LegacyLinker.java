package com.baidu.turbonet.base.library_loader;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.base.ThreadUtils;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.library_loader.Linker;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class LegacyLinker extends Linker {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1061856369, "Lcom/baidu/turbonet/base/library_loader/LegacyLinker;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1061856369, "Lcom/baidu/turbonet/base/library_loader/LegacyLinker;");
        }
    }

    public static native boolean nativeCreateSharedRelro(String str, long j, Linker.LibInfo libInfo);

    public static native boolean nativeLoadLibrary(String str, long j, Linker.LibInfo libInfo);

    public static native boolean nativeLoadLibraryInZipFile(@Nullable String str, String str2, long j, Linker.LibInfo libInfo);

    public static native void nativeRunCallbackOnUiThread(long j);

    public static native boolean nativeUseSharedRelro(String str, Linker.LibInfo libInfo);

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LegacyLinker.nativeRunCallbackOnUiThread(this.a);
            }
        }
    }

    public LegacyLinker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @CalledByNative
    public static void postCallbackOnMainThread(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65544, null, j) == null) {
            ThreadUtils.b(new a(j));
        }
    }
}
