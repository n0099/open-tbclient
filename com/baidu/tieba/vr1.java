package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vr1 implements wr1 {
    public static /* synthetic */ Interceptable $ic;
    public static vr1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public wr1 a;
    public boolean b;

    public vr1() {
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

    public static vr1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (vr1.class) {
                    if (c == null) {
                        c = new vr1();
                    }
                }
            }
            return c;
        }
        return (vr1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wr1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            wr1 wr1Var = this.a;
            if (wr1Var == null) {
                return null;
            }
            try {
                return wr1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wr1
    public void a(Context context, xr1 xr1Var) {
        wr1 zr1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, xr1Var) == null) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        zr1Var = new zr1();
                    } else if (ordinal == 2) {
                        zr1Var = new hs1();
                    } else if (ordinal == 3) {
                        zr1Var = new fs1();
                    } else if (ordinal == 4) {
                        zr1Var = new bs1();
                    }
                    this.a = zr1Var;
                } else {
                    this.a = null;
                }
                if (this.a != null) {
                    this.a.a(context, xr1Var);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
