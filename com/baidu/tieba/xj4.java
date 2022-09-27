package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xj4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xj4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final wj4<String> a;
    public String b;

    @SuppressLint({"BDThrowableCheck"})
    public xj4(Context context) {
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
        wj4<String> wj4Var = new wj4<>();
        this.a = wj4Var;
        if (context == null) {
            return;
        }
        wj4Var.a(new ak4(context));
        this.a.a(new ck4(context));
        this.a.a(new bk4(context));
        this.a.a(new ek4(context));
        this.a.a(new yj4(context));
        this.a.a(new dk4(context));
    }

    public static xj4 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (c == null) {
                synchronized (xj4.class) {
                    if (c == null) {
                        c = new xj4(context);
                    }
                }
            }
            return c;
        }
        return (xj4) invokeL.objValue;
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
