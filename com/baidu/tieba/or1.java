package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class or1 implements pr1 {
    public static /* synthetic */ Interceptable $ic;
    public static or1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public pr1 a;
    public boolean b;

    public or1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = false;
    }

    public static or1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (or1.class) {
                    if (c == null) {
                        c = new or1();
                    }
                }
            }
            return c;
        }
        return (or1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            pr1 pr1Var = this.a;
            if (pr1Var == null) {
                return null;
            }
            try {
                return pr1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr1
    public void a(Context context, qr1 qr1Var) {
        pr1 sr1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, qr1Var) == null) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        sr1Var = new sr1();
                    } else if (ordinal == 2) {
                        sr1Var = new as1();
                    } else if (ordinal == 3) {
                        sr1Var = new yr1();
                    } else if (ordinal == 4) {
                        sr1Var = new ur1();
                    }
                    this.a = sr1Var;
                } else {
                    this.a = null;
                }
                if (this.a != null) {
                    this.a.a(context, qr1Var);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
