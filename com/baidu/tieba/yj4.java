package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class yj4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yj4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final xj4 a;
    public String b;

    public yj4(Context context) {
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
        xj4 xj4Var = new xj4();
        this.a = xj4Var;
        if (context == null) {
            return;
        }
        xj4Var.a(new bk4(context));
        this.a.a(new dk4(context));
        this.a.a(new ck4(context));
        this.a.a(new fk4(context));
        this.a.a(new zj4(context));
        this.a.a(new ek4(context));
    }

    public static yj4 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (c == null) {
                synchronized (yj4.class) {
                    if (c == null) {
                        c = new yj4(context);
                    }
                }
            }
            return c;
        }
        return (yj4) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.b)) {
                synchronized (this) {
                    if (TextUtils.isEmpty(this.b)) {
                        String str = (String) this.a.b();
                        this.b = str;
                        this.a.d(str);
                    }
                }
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }
}
