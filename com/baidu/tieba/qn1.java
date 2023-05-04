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
public class qn1 implements rn1 {
    public static /* synthetic */ Interceptable $ic;
    public static qn1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public rn1 a;
    public boolean b;

    public qn1() {
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

    public static qn1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (qn1.class) {
                    if (c == null) {
                        c = new qn1();
                    }
                }
            }
            return c;
        }
        return (qn1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rn1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            rn1 rn1Var = this.a;
            if (rn1Var == null) {
                return null;
            }
            try {
                return rn1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rn1
    public void a(Context context, sn1 sn1Var) {
        rn1 un1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sn1Var) == null) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        un1Var = new un1();
                    } else if (ordinal == 2) {
                        un1Var = new co1();
                    } else if (ordinal == 3) {
                        un1Var = new ao1();
                    } else if (ordinal == 4) {
                        un1Var = new wn1();
                    }
                    this.a = un1Var;
                } else {
                    this.a = null;
                }
                if (this.a != null) {
                    this.a.a(context, sn1Var);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
