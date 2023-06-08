package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nbb {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String b = "RootKeyUtil";
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947998107, "Lcom/baidu/tieba/nbb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947998107, "Lcom/baidu/tieba/nbb;");
        }
    }

    public nbb() {
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
    }

    public byte[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (byte[]) this.a.clone();
        }
        return (byte[]) invokeV.objValue;
    }

    public static nbb d(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, str, str2, str3, str4)) == null) {
            nbb nbbVar = new nbb();
            nbbVar.a(str, str2, str3, str4);
            return nbbVar;
        }
        return (nbb) invokeLLLL.objValue;
    }

    public final void a(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) {
            b(str, str2, str3, mbb.b(str4));
        }
    }

    @SuppressLint({"NewApi"})
    public final void b(String str, String str2, String str3, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, bArr) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                pbb.d(b, "initRootKey: sha1");
                this.a = kbb.h(str, str2, str3, bArr, false);
                return;
            }
            pbb.d(b, "initRootKey: sha256");
            this.a = kbb.h(str, str2, str3, bArr, true);
        }
    }
}
