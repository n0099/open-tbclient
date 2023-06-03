package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.impl.CronetLibraryLoader;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes7.dex */
public final class pla implements CronetLibraryLoader.b {
    public static /* synthetic */ Interceptable $ic;
    public static CronetLibraryLoader.b a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948067268, "Lcom/baidu/tieba/pla;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948067268, "Lcom/baidu/tieba/pla;");
        }
    }

    public pla() {
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

    @Override // com.baidu.turbonet.net.impl.CronetLibraryLoader.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetLibraryLoader_cronetInitOnInitThread();
        }
    }

    @Override // com.baidu.turbonet.net.impl.CronetLibraryLoader.b
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return GEN_JNI.com_baidu_turbonet_net_impl_CronetLibraryLoader_getTurboNetVersion();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.turbonet.net.impl.CronetLibraryLoader.b
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return GEN_JNI.com_baidu_turbonet_net_impl_CronetLibraryLoader_getTurboNetHandler();
        }
        return invokeV.longValue;
    }

    public static CronetLibraryLoader.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (GEN_JNI.TESTING_ENABLED) {
                CronetLibraryLoader.b bVar = a;
                if (bVar != null) {
                    return bVar;
                }
                if (GEN_JNI.REQUIRE_MOCK) {
                    throw new UnsupportedOperationException("No mock found for the native implementation for com.baidu.turbonet.net.impl.CronetLibraryLoader.Natives. The current configuration requires all native implementations to have a mock instance.");
                }
            }
            NativeLibraryLoadedStatus.checkLoaded(false);
            return new pla();
        }
        return (CronetLibraryLoader.b) invokeV.objValue;
    }
}
