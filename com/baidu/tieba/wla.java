package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.impl.CronetUploadDataStream;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes8.dex */
public final class wla implements CronetUploadDataStream.d {
    public static /* synthetic */ Interceptable $ic;
    public static CronetUploadDataStream.d a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948275805, "Lcom/baidu/tieba/wla;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948275805, "Lcom/baidu/tieba/wla;");
        }
    }

    public wla() {
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

    public static CronetUploadDataStream.d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (GEN_JNI.TESTING_ENABLED) {
                CronetUploadDataStream.d dVar = a;
                if (dVar != null) {
                    return dVar;
                }
                if (GEN_JNI.REQUIRE_MOCK) {
                    throw new UnsupportedOperationException("No mock found for the native implementation for com.baidu.turbonet.net.impl.CronetUploadDataStream.Natives. The current configuration requires all native implementations to have a mock instance.");
                }
            }
            NativeLibraryLoadedStatus.checkLoaded(false);
            return new wla();
        }
        return (CronetUploadDataStream.d) invokeV.objValue;
    }

    @Override // com.baidu.turbonet.net.impl.CronetUploadDataStream.d
    public void a(long j, CronetUploadDataStream cronetUploadDataStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j, cronetUploadDataStream) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetUploadDataStream_onRewindSucceeded(j, cronetUploadDataStream);
        }
    }

    @Override // com.baidu.turbonet.net.impl.CronetUploadDataStream.d
    public void b(long j, CronetUploadDataStream cronetUploadDataStream, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), cronetUploadDataStream, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetUploadDataStream_onReadSucceeded(j, cronetUploadDataStream, i, z);
        }
    }

    @Override // com.baidu.turbonet.net.impl.CronetUploadDataStream.d
    public long c(CronetUploadDataStream cronetUploadDataStream, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{cronetUploadDataStream, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return GEN_JNI.com_baidu_turbonet_net_impl_CronetUploadDataStream_attachUploadDataToRequest(cronetUploadDataStream, j, j2);
        }
        return invokeCommon.longValue;
    }

    @Override // com.baidu.turbonet.net.impl.CronetUploadDataStream.d
    public void destroy(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetUploadDataStream_destroy(j);
        }
    }
}
