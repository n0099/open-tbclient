package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pr4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pr4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final or4<String> a;
    public String b;

    @SuppressLint({"BDThrowableCheck"})
    public pr4(Context context) {
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
        or4<String> or4Var = new or4<>();
        this.a = or4Var;
        if (context == null) {
            return;
        }
        or4Var.a(new sr4(context));
        this.a.a(new ur4(context));
        this.a.a(new tr4(context));
        this.a.a(new wr4(context));
        this.a.a(new qr4(context));
        this.a.a(new vr4(context));
    }

    public static pr4 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (c == null) {
                synchronized (pr4.class) {
                    if (c == null) {
                        c = new pr4(context);
                    }
                }
            }
            return c;
        }
        return (pr4) invokeL.objValue;
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
