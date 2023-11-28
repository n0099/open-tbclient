package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes7.dex */
public class mi5 extends ti5 {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadLocal<byte[]> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947973648, "Lcom/baidu/tieba/mi5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947973648, "Lcom/baidu/tieba/mi5;");
                return;
            }
        }
        b = new ThreadLocal<>();
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            byte[] bArr = b.get();
            if (bArr == null) {
                byte[] bArr2 = new byte[4];
                b.set(bArr2);
                return bArr2;
            }
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public short f() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            byte[] b2 = b();
            read(b2, 0, 2);
            return (short) (((b2[0] & 255) << 8) | (b2[1] & 255));
        }
        return invokeV.shortValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mi5(ui5 ui5Var) {
        super(ui5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ui5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ui5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public boolean c(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str) || str.length() != 4) {
                return false;
            }
            int d = d();
            for (int i = 0; i < 4; i++) {
                if (((d >> (i * 8)) & 255) != str.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int d() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            byte[] b2 = b();
            read(b2, 0, 4);
            return ((b2[3] & 255) << 24) | (b2[0] & 255) | ((b2[1] & 255) << 8) | ((b2[2] & 255) << 16);
        }
        return invokeV.intValue;
    }

    public int e() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            byte[] b2 = b();
            read(b2, 0, 4);
            return ((b2[0] & 255) << 24) | (b2[3] & 255) | ((b2[2] & 255) << 8) | ((b2[1] & 255) << 16);
        }
        return invokeV.intValue;
    }
}
