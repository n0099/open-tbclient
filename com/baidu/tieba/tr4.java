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
public class tr4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tr4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final sr4<String> a;
    public String b;

    @SuppressLint({"BDThrowableCheck"})
    public tr4(Context context) {
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
        sr4<String> sr4Var = new sr4<>();
        this.a = sr4Var;
        if (context == null) {
            return;
        }
        sr4Var.a(new wr4(context));
        this.a.a(new yr4(context));
        this.a.a(new xr4(context));
        this.a.a(new as4(context));
        this.a.a(new ur4(context));
        this.a.a(new zr4(context));
    }

    public static tr4 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (c == null) {
                synchronized (tr4.class) {
                    if (c == null) {
                        c = new tr4(context);
                    }
                }
            }
            return c;
        }
        return (tr4) invokeL.objValue;
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
