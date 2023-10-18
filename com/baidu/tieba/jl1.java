package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jl1 implements kl1 {
    public static /* synthetic */ Interceptable $ic;
    public static jl1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public kl1 a;
    public boolean b;

    public jl1() {
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

    public static jl1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (jl1.class) {
                    if (c == null) {
                        c = new jl1();
                    }
                }
            }
            return c;
        }
        return (jl1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kl1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            kl1 kl1Var = this.a;
            if (kl1Var == null) {
                return null;
            }
            try {
                return kl1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kl1
    public void a(Context context, ll1 ll1Var) {
        kl1 nl1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ll1Var) == null) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        nl1Var = new nl1();
                    } else if (ordinal == 2) {
                        nl1Var = new vl1();
                    } else if (ordinal == 3) {
                        nl1Var = new tl1();
                    } else if (ordinal == 4) {
                        nl1Var = new pl1();
                    }
                    this.a = nl1Var;
                } else {
                    this.a = null;
                }
                if (this.a != null) {
                    this.a.a(context, ll1Var);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
