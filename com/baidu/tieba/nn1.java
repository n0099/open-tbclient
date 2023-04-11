package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class nn1 implements on1 {
    public static /* synthetic */ Interceptable $ic;
    public static nn1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public on1 a;
    public boolean b;

    public nn1() {
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

    public static nn1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (nn1.class) {
                    if (c == null) {
                        c = new nn1();
                    }
                }
            }
            return c;
        }
        return (nn1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.on1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            on1 on1Var = this.a;
            if (on1Var == null) {
                return null;
            }
            try {
                return on1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.on1
    public void a(Context context, pn1 pn1Var) {
        on1 rn1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, pn1Var) == null) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        rn1Var = new rn1();
                    } else if (ordinal == 2) {
                        rn1Var = new zn1();
                    } else if (ordinal == 3) {
                        rn1Var = new xn1();
                    } else if (ordinal == 4) {
                        rn1Var = new tn1();
                    }
                    this.a = rn1Var;
                } else {
                    this.a = null;
                }
                if (this.a != null) {
                    this.a.a(context, pn1Var);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
