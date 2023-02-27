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
public class yp4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yp4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final xp4<String> a;
    public String b;

    @SuppressLint({"BDThrowableCheck"})
    public yp4(Context context) {
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
        xp4<String> xp4Var = new xp4<>();
        this.a = xp4Var;
        if (context == null) {
            return;
        }
        xp4Var.a(new bq4(context));
        this.a.a(new dq4(context));
        this.a.a(new cq4(context));
        this.a.a(new fq4(context));
        this.a.a(new zp4(context));
        this.a.a(new eq4(context));
    }

    public static yp4 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (c == null) {
                synchronized (yp4.class) {
                    if (c == null) {
                        c = new yp4(context);
                    }
                }
            }
            return c;
        }
        return (yp4) invokeL.objValue;
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
