package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class zk1 {
    public static /* synthetic */ Interceptable $ic;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    public zk1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bk1.a;
    }

    public static synchronized zk1 a(Context context) {
        InterceptResult invokeL;
        zk1 zk1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (zk1.class) {
                zk1Var = new zk1(context);
            }
            return zk1Var;
        }
        return (zk1) invokeL.objValue;
    }

    public String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            String str3 = zj1.b;
            String str4 = zj1.c;
            String str5 = "";
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                return "";
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            StringBuilder sb = new StringBuilder();
            try {
                str5 = c(str3, str4, currentTimeMillis);
            } catch (Throwable th) {
                ql1.d(th);
            }
            sb.append(e());
            sb.append(str);
            sb.append("/");
            sb.append(YYOption.UrlProtocol.USER);
            sb.append("/");
            sb.append(str3);
            sb.append("/");
            sb.append(currentTimeMillis);
            sb.append("/");
            sb.append(str5);
            sb.append("?skey=");
            sb.append(str2);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public String c(String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Long.valueOf(j)})) == null) {
            try {
                return vl1.b(str + j + str2);
            } catch (Throwable th) {
                ql1.d(th);
                return "";
            }
        }
        return (String) invokeCommon.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                b = new String(ol1.b(this.a));
            } catch (Throwable th) {
                ql1.d(th);
            }
        }
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(b)) {
                d();
            }
            return b;
        }
        return (String) invokeV.objValue;
    }
}
