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
public class rr1 implements sr1 {
    public static /* synthetic */ Interceptable $ic;
    public static rr1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public sr1 a;
    public boolean b;

    public rr1() {
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

    public static rr1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (rr1.class) {
                    if (c == null) {
                        c = new rr1();
                    }
                }
            }
            return c;
        }
        return (rr1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sr1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            sr1 sr1Var = this.a;
            if (sr1Var == null) {
                return null;
            }
            try {
                return sr1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sr1
    public void a(Context context, tr1 tr1Var) {
        sr1 vr1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, tr1Var) == null) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        vr1Var = new vr1();
                    } else if (ordinal == 2) {
                        vr1Var = new ds1();
                    } else if (ordinal == 3) {
                        vr1Var = new bs1();
                    } else if (ordinal == 4) {
                        vr1Var = new xr1();
                    }
                    this.a = vr1Var;
                } else {
                    this.a = null;
                }
                if (this.a != null) {
                    this.a.a(context, tr1Var);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
