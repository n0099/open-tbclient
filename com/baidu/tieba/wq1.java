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
public class wq1 implements xq1 {
    public static /* synthetic */ Interceptable $ic;
    public static wq1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public xq1 a;
    public boolean b;

    public wq1() {
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

    public static wq1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (wq1.class) {
                    if (c == null) {
                        c = new wq1();
                    }
                }
            }
            return c;
        }
        return (wq1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xq1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            xq1 xq1Var = this.a;
            if (xq1Var == null) {
                return null;
            }
            try {
                return xq1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xq1
    public void a(Context context, yq1 yq1Var) {
        xq1 ar1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, yq1Var) == null) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        ar1Var = new ar1();
                    } else if (ordinal == 2) {
                        ar1Var = new ir1();
                    } else if (ordinal == 3) {
                        ar1Var = new gr1();
                    } else if (ordinal == 4) {
                        ar1Var = new cr1();
                    }
                    this.a = ar1Var;
                } else {
                    this.a = null;
                }
                if (this.a != null) {
                    this.a.a(context, yq1Var);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
