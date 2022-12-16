package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
/* loaded from: classes5.dex */
public final class nz9 {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<nz9> d;
    public transient /* synthetic */ FieldHolder $fh;
    public oz9 a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948019900, "Lcom/baidu/tieba/nz9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948019900, "Lcom/baidu/tieba/nz9;");
        }
    }

    public nz9(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        sz9.b();
        this.a = new oz9(context, str);
        this.b = str;
        this.c = context;
    }

    public static nz9 b(Context context, String str) {
        InterceptResult invokeLL;
        nz9 nz9Var;
        nz9 nz9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<nz9> softReference = d;
                if (softReference == null) {
                    nz9Var = null;
                } else {
                    nz9Var = softReference.get();
                }
                if (nz9Var == null || !str.equals(nz9Var.b)) {
                    synchronized (nz9.class) {
                        nz9Var2 = new nz9(context, str);
                        d = new SoftReference<>(nz9Var2);
                    }
                    return nz9Var2;
                }
                return nz9Var;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (nz9) invokeLL.objValue;
    }

    public final void a(Activity activity, lz9 lz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, lz9Var) == null) {
            this.a.c(activity, TbEnum.SystemMessage.EVENT_ID_GROUP_ACTIVITYS_IN_CHAT, lz9Var);
        }
    }

    public final void c(int i, int i2, Intent intent, lz9 lz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, lz9Var}) == null) {
            this.a.d(i, i2, intent, lz9Var);
        }
    }
}
