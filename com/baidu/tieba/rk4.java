package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class rk4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rk4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final qk4<String> a;
    public String b;

    @SuppressLint({"BDThrowableCheck"})
    public rk4(Context context) {
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
        qk4<String> qk4Var = new qk4<>();
        this.a = qk4Var;
        if (context == null) {
            return;
        }
        qk4Var.a(new uk4(context));
        this.a.a(new wk4(context));
        this.a.a(new vk4(context));
        this.a.a(new yk4(context));
        this.a.a(new sk4(context));
        this.a.a(new xk4(context));
    }

    public static rk4 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (c == null) {
                synchronized (rk4.class) {
                    if (c == null) {
                        c = new rk4(context);
                    }
                }
            }
            return c;
        }
        return (rk4) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.b)) {
                synchronized (this) {
                    if (TextUtils.isEmpty(this.b)) {
                        String b = this.a.b();
                        this.b = b;
                        this.a.d(b);
                    }
                }
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }
}
