package com.baidu.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class Base64Encoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1561153805, "Lcom/baidu/util/Base64Encoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1561153805, "Lcom/baidu/util/Base64Encoder;");
                return;
            }
        }
        try {
            System.loadLibrary("base64encoder_v2_0");
        } catch (Error | Exception unused) {
        }
    }

    public Base64Encoder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static final byte[] B64Decode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            try {
                return nativeB64Decode(bArr, 0);
            } catch (Error | Exception unused) {
                return bArr;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static final byte[] B64Encode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            try {
                return nativeB64Encode(bArr, 0);
            } catch (Error | Exception unused) {
                return bArr;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static final int B64GetVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                return nativeB64GetVersion();
            } catch (Error | Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static final byte[] b64Decode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) {
            try {
                return nativeB64Decode(bArr, 0);
            } catch (Error | Exception unused) {
                return bArr;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static final byte[] b64Encode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
            try {
                return nativeB64Encode(bArr, 0);
            } catch (Error | Exception unused) {
                return bArr;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static final int b64GetVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                return nativeB64GetVersion();
            } catch (Error | Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static final native byte[] nativeB64Decode(byte[] bArr, int i2);

    public static final native byte[] nativeB64Encode(byte[] bArr, int i2);

    public static final native int nativeB64GetVersion();

    public static final byte[] b64Decode(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, bArr, i2)) == null) {
            try {
                return nativeB64Decode(bArr, i2);
            } catch (Error | Exception unused) {
                return bArr;
            }
        }
        return (byte[]) invokeLI.objValue;
    }

    public static final byte[] b64Encode(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, bArr, i2)) == null) {
            try {
                return nativeB64Encode(bArr, i2);
            } catch (Error | Exception unused) {
                return bArr;
            }
        }
        return (byte[]) invokeLI.objValue;
    }
}
