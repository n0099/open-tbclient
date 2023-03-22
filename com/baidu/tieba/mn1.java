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
public class mn1 implements nn1 {
    public static /* synthetic */ Interceptable $ic;
    public static mn1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public nn1 a;
    public boolean b;

    public mn1() {
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

    public static mn1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (mn1.class) {
                    if (c == null) {
                        c = new mn1();
                    }
                }
            }
            return c;
        }
        return (mn1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nn1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            nn1 nn1Var = this.a;
            if (nn1Var == null) {
                return null;
            }
            try {
                return nn1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nn1
    public void a(Context context, on1 on1Var) {
        nn1 qn1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, on1Var) == null) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        qn1Var = new qn1();
                    } else if (ordinal == 2) {
                        qn1Var = new yn1();
                    } else if (ordinal == 3) {
                        qn1Var = new wn1();
                    } else if (ordinal == 4) {
                        qn1Var = new sn1();
                    }
                    this.a = qn1Var;
                } else {
                    this.a = null;
                }
                if (this.a != null) {
                    this.a.a(context, on1Var);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
