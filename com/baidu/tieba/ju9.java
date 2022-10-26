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
/* loaded from: classes4.dex */
public final class ju9 {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference d;
    public transient /* synthetic */ FieldHolder $fh;
    public ku9 a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947895931, "Lcom/baidu/tieba/ju9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947895931, "Lcom/baidu/tieba/ju9;");
        }
    }

    public ju9(Context context, String str) {
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
        ou9.b();
        this.a = new ku9(context, str);
        this.b = str;
        this.c = context;
    }

    public static ju9 b(Context context, String str) {
        InterceptResult invokeLL;
        ju9 ju9Var;
        ju9 ju9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference softReference = d;
                if (softReference == null) {
                    ju9Var = null;
                } else {
                    ju9Var = (ju9) softReference.get();
                }
                if (ju9Var == null || !str.equals(ju9Var.b)) {
                    synchronized (ju9.class) {
                        ju9Var2 = new ju9(context, str);
                        d = new SoftReference(ju9Var2);
                    }
                    return ju9Var2;
                }
                return ju9Var;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (ju9) invokeLL.objValue;
    }

    public final void a(Activity activity, hu9 hu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, hu9Var) == null) {
            this.a.c(activity, TbEnum.SystemMessage.EVENT_ID_GROUP_ACTIVITYS_IN_CHAT, hu9Var);
        }
    }

    public final void c(int i, int i2, Intent intent, hu9 hu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, hu9Var}) == null) {
            this.a.d(i, i2, intent, hu9Var);
        }
    }
}
