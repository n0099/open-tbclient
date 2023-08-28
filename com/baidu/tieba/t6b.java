package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.impl.CronetBidirectionalStream;
import java.nio.ByteBuffer;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes8.dex */
public final class t6b implements CronetBidirectionalStream.f {
    public static /* synthetic */ Interceptable $ic;
    public static CronetBidirectionalStream.f a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948134569, "Lcom/baidu/tieba/t6b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948134569, "Lcom/baidu/tieba/t6b;");
        }
    }

    public t6b() {
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

    public static CronetBidirectionalStream.f c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (GEN_JNI.TESTING_ENABLED) {
                CronetBidirectionalStream.f fVar = a;
                if (fVar != null) {
                    return fVar;
                }
                if (GEN_JNI.REQUIRE_MOCK) {
                    throw new UnsupportedOperationException("No mock found for the native implementation for com.baidu.turbonet.net.impl.CronetBidirectionalStream.Natives. The current configuration requires all native implementations to have a mock instance.");
                }
            }
            NativeLibraryLoadedStatus.checkLoaded(false);
            return new t6b();
        }
        return (CronetBidirectionalStream.f) invokeV.objValue;
    }

    @Override // com.baidu.turbonet.net.impl.CronetBidirectionalStream.f
    public void a(long j, CronetBidirectionalStream cronetBidirectionalStream, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), cronetBidirectionalStream, Boolean.valueOf(z)}) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetBidirectionalStream_destroy(j, cronetBidirectionalStream, z);
        }
    }

    @Override // com.baidu.turbonet.net.impl.CronetBidirectionalStream.f
    public boolean b(long j, CronetBidirectionalStream cronetBidirectionalStream, ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), cronetBidirectionalStream, byteBufferArr, iArr, iArr2, Boolean.valueOf(z)})) == null) {
            return GEN_JNI.com_baidu_turbonet_net_impl_CronetBidirectionalStream_writevData(j, cronetBidirectionalStream, byteBufferArr, iArr, iArr2, z);
        }
        return invokeCommon.booleanValue;
    }
}
