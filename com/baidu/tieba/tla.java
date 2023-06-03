package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.RequestTimeInfo;
import com.baidu.turbonet.net.impl.CronetUrlRequest;
import java.nio.ByteBuffer;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes7.dex */
public final class tla implements CronetUrlRequest.i {
    public static /* synthetic */ Interceptable $ic;
    public static CronetUrlRequest.i a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948186432, "Lcom/baidu/tieba/tla;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948186432, "Lcom/baidu/tieba/tla;");
        }
    }

    public tla() {
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

    public static CronetUrlRequest.i v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (GEN_JNI.TESTING_ENABLED) {
                CronetUrlRequest.i iVar = a;
                if (iVar != null) {
                    return iVar;
                }
                if (GEN_JNI.REQUIRE_MOCK) {
                    throw new UnsupportedOperationException("No mock found for the native implementation for com.baidu.turbonet.net.impl.CronetUrlRequest.Natives. The current configuration requires all native implementations to have a mock instance.");
                }
            }
            NativeLibraryLoadedStatus.checkLoaded(false);
            return new tla();
        }
        return (CronetUrlRequest.i) invokeV.objValue;
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public void a(long j, CronetUrlRequest cronetUrlRequest, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), cronetUrlRequest, str}) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_setRequestTag(j, cronetUrlRequest, str);
        }
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public void b(long j, CronetUrlRequest cronetUrlRequest, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), cronetUrlRequest, Integer.valueOf(i)}) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_setTCPConnectTimeout(j, cronetUrlRequest, i);
        }
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public String e(long j, CronetUrlRequest cronetUrlRequest, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), cronetUrlRequest, Boolean.valueOf(z)})) == null) {
            return GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_getConnectionAttempts(j, cronetUrlRequest, z);
        }
        return (String) invokeCommon.objValue;
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public boolean f(long j, CronetUrlRequest cronetUrlRequest, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), cronetUrlRequest, str})) == null) {
            return GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_setHttpMethod(j, cronetUrlRequest, str);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public long g(long j, CronetUrlRequest cronetUrlRequest, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), cronetUrlRequest, Integer.valueOf(i)})) == null) {
            return GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_requestTimeGap(j, cronetUrlRequest, i);
        }
        return invokeCommon.longValue;
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public void h(long j, CronetUrlRequest cronetUrlRequest, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), cronetUrlRequest, Integer.valueOf(i)}) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_setResponseBodyReadTimeout(j, cronetUrlRequest, i);
        }
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public void m(long j, CronetUrlRequest cronetUrlRequest, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), cronetUrlRequest, Integer.valueOf(i)}) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_setTimeout(j, cronetUrlRequest, i);
        }
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public void n(long j, CronetUrlRequest cronetUrlRequest, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), cronetUrlRequest, Boolean.valueOf(z)}) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_destroy(j, cronetUrlRequest, z);
        }
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public void p(long j, CronetUrlRequest cronetUrlRequest, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), cronetUrlRequest, Integer.valueOf(i)}) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_setResponseHeaderRecvTimeout(j, cronetUrlRequest, i);
        }
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public void u(long j, CronetUrlRequest cronetUrlRequest, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j), cronetUrlRequest, str}) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_setDestinationAddress(j, cronetUrlRequest, str);
        }
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public void c(long j, CronetUrlRequest cronetUrlRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, cronetUrlRequest) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_disableResponseAutoUngzip(j, cronetUrlRequest);
        }
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public RequestTimeInfo i(long j, CronetUrlRequest cronetUrlRequest) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j, cronetUrlRequest)) == null) {
            return (RequestTimeInfo) GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_getRequestTimeInfo(j, cronetUrlRequest);
        }
        return (RequestTimeInfo) invokeJL.objValue;
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public String j(long j, CronetUrlRequest cronetUrlRequest) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j, cronetUrlRequest)) == null) {
            return GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_getDNSResults(j, cronetUrlRequest);
        }
        return (String) invokeJL.objValue;
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public void k(long j, CronetUrlRequest cronetUrlRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048586, this, j, cronetUrlRequest) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_followDeferredRedirect(j, cronetUrlRequest);
        }
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public void o(long j, CronetUrlRequest cronetUrlRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048590, this, j, cronetUrlRequest) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_start(j, cronetUrlRequest);
        }
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public String r(long j, CronetUrlRequest cronetUrlRequest) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048593, this, j, cronetUrlRequest)) == null) {
            return GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_getDNSErrorCode(j, cronetUrlRequest);
        }
        return (String) invokeJL.objValue;
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public String s(long j, CronetUrlRequest cronetUrlRequest) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048594, this, j, cronetUrlRequest)) == null) {
            return GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_getDNSNameServers(j, cronetUrlRequest);
        }
        return (String) invokeJL.objValue;
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public String t(long j, CronetUrlRequest cronetUrlRequest) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048595, this, j, cronetUrlRequest)) == null) {
            return GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_getRemoteEndpoint(j, cronetUrlRequest);
        }
        return (String) invokeJL.objValue;
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public boolean d(long j, CronetUrlRequest cronetUrlRequest, ByteBuffer byteBuffer, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), cronetUrlRequest, byteBuffer, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            return GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_readData(j, cronetUrlRequest, byteBuffer, i, i2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public boolean l(long j, CronetUrlRequest cronetUrlRequest, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), cronetUrlRequest, str, str2})) == null) {
            return GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_addRequestHeader(j, cronetUrlRequest, str, str2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequest.i
    public long q(CronetUrlRequest cronetUrlRequest, long j, String str, int i, boolean z, boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{cronetUrlRequest, Long.valueOf(j), str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i2), Boolean.valueOf(z5), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            return GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequest_createRequestAdapter(cronetUrlRequest, j, str, i, z, z2, z3, z4, i2, z5, i3, i4);
        }
        return invokeCommon.longValue;
    }
}
