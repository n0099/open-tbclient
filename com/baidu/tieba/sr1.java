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
public class sr1 implements tr1 {
    public static /* synthetic */ Interceptable $ic;
    public static sr1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public tr1 a;
    public boolean b;

    public sr1() {
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

    public static sr1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (sr1.class) {
                    if (c == null) {
                        c = new sr1();
                    }
                }
            }
            return c;
        }
        return (sr1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tr1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            tr1 tr1Var = this.a;
            if (tr1Var == null) {
                return null;
            }
            try {
                return tr1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tr1
    public void a(Context context, ur1 ur1Var) {
        tr1 wr1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ur1Var) == null) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        wr1Var = new wr1();
                    } else if (ordinal == 2) {
                        wr1Var = new es1();
                    } else if (ordinal == 3) {
                        wr1Var = new cs1();
                    } else if (ordinal == 4) {
                        wr1Var = new yr1();
                    }
                    this.a = wr1Var;
                } else {
                    this.a = null;
                }
                if (this.a != null) {
                    this.a.a(context, ur1Var);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
