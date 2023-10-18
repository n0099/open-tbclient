package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes7.dex */
public class m5 {
    public static /* synthetic */ Interceptable $ic;
    public static m5 c;
    public transient /* synthetic */ FieldHolder $fh;
    public SecretKey a;
    public byte[] b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448309573, "Lcom/baidu/tieba/m5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448309573, "Lcom/baidu/tieba/m5;");
        }
    }

    public m5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
    }

    public static m5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (m5.class) {
                    if (c == null) {
                        c = new m5();
                    }
                }
            }
            return c;
        }
        return (m5) invokeV.objValue;
    }

    public SecretKey b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (SecretKey) invokeV.objValue;
    }

    public byte[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (byte[]) invokeV.objValue;
    }

    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr) == null) {
            try {
                PublicKey e = hd.e(bArr);
                String g = hd.g(32);
                byte[] bArr2 = new byte[g.length()];
                for (int i = 0; i < g.length(); i++) {
                    bArr2[i] = (byte) g.charAt(i);
                }
                this.a = hd.f(g);
                this.b = hd.d(e, bArr2);
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
                this.a = null;
                this.b = new byte[0];
            }
        }
    }
}
