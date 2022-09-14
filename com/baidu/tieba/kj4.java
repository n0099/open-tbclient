package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class kj4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kj4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final jj4<String> a;
    public String b;

    @SuppressLint({"BDThrowableCheck"})
    public kj4(Context context) {
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
        jj4<String> jj4Var = new jj4<>();
        this.a = jj4Var;
        if (context == null) {
            return;
        }
        jj4Var.a(new nj4(context));
        this.a.a(new pj4(context));
        this.a.a(new oj4(context));
        this.a.a(new rj4(context));
        this.a.a(new lj4(context));
        this.a.a(new qj4(context));
    }

    public static kj4 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (c == null) {
                synchronized (kj4.class) {
                    if (c == null) {
                        c = new kj4(context);
                    }
                }
            }
            return c;
        }
        return (kj4) invokeL.objValue;
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
