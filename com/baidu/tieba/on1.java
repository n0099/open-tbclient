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
public class on1 implements pn1 {
    public static /* synthetic */ Interceptable $ic;
    public static on1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public pn1 a;
    public boolean b;

    public on1() {
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

    public static on1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (on1.class) {
                    if (c == null) {
                        c = new on1();
                    }
                }
            }
            return c;
        }
        return (on1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pn1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            pn1 pn1Var = this.a;
            if (pn1Var == null) {
                return null;
            }
            try {
                return pn1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pn1
    public void a(Context context, qn1 qn1Var) {
        pn1 sn1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, qn1Var) == null) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        sn1Var = new sn1();
                    } else if (ordinal == 2) {
                        sn1Var = new ao1();
                    } else if (ordinal == 3) {
                        sn1Var = new yn1();
                    } else if (ordinal == 4) {
                        sn1Var = new un1();
                    }
                    this.a = sn1Var;
                } else {
                    this.a = null;
                }
                if (this.a != null) {
                    this.a.a(context, qn1Var);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
