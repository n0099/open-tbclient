package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class zq1 implements ar1 {
    public static /* synthetic */ Interceptable $ic;
    public static zq1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ar1 a;
    public boolean b;

    public zq1() {
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

    public static zq1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (zq1.class) {
                    if (c == null) {
                        c = new zq1();
                    }
                }
            }
            return c;
        }
        return (zq1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ar1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ar1 ar1Var = this.a;
            if (ar1Var == null) {
                return null;
            }
            try {
                return ar1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ar1
    public void a(Context context, br1 br1Var) {
        ar1 dr1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, br1Var) == null) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        dr1Var = new dr1();
                    } else if (ordinal == 2) {
                        dr1Var = new lr1();
                    } else if (ordinal == 3) {
                        dr1Var = new jr1();
                    } else if (ordinal == 4) {
                        dr1Var = new fr1();
                    }
                    this.a = dr1Var;
                } else {
                    this.a = null;
                }
                if (this.a != null) {
                    this.a.a(context, br1Var);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
