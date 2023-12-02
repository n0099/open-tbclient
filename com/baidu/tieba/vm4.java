package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vm4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vm4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final um4<String> a;
    public String b;

    @SuppressLint({"BDThrowableCheck"})
    public vm4(Context context) {
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
        um4<String> um4Var = new um4<>();
        this.a = um4Var;
        if (context == null) {
            return;
        }
        um4Var.a(new ym4(context));
        this.a.a(new an4(context));
        this.a.a(new zm4(context));
        this.a.a(new cn4(context));
        this.a.a(new wm4(context));
        this.a.a(new bn4(context));
    }

    public static vm4 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (c == null) {
                synchronized (vm4.class) {
                    if (c == null) {
                        c = new vm4(context);
                    }
                }
            }
            return c;
        }
        return (vm4) invokeL.objValue;
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
