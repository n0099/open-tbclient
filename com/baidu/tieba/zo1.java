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
public class zo1 implements ap1 {
    public static /* synthetic */ Interceptable $ic;
    public static zo1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ap1 a;
    public boolean b;

    public zo1() {
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

    public static zo1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (zo1.class) {
                    if (c == null) {
                        c = new zo1();
                    }
                }
            }
            return c;
        }
        return (zo1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ap1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ap1 ap1Var = this.a;
            if (ap1Var == null) {
                return null;
            }
            try {
                return ap1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ap1
    public void a(Context context, bp1 bp1Var) {
        ap1 dp1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bp1Var) == null) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        dp1Var = new dp1();
                    } else if (ordinal == 2) {
                        dp1Var = new lp1();
                    } else if (ordinal == 3) {
                        dp1Var = new jp1();
                    } else if (ordinal == 4) {
                        dp1Var = new fp1();
                    }
                    this.a = dp1Var;
                } else {
                    this.a = null;
                }
                if (this.a != null) {
                    this.a.a(context, bp1Var);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
