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
public class rq1 implements sq1 {
    public static /* synthetic */ Interceptable $ic;
    public static rq1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public sq1 a;
    public boolean b;

    public rq1() {
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

    public static rq1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (rq1.class) {
                    if (c == null) {
                        c = new rq1();
                    }
                }
            }
            return c;
        }
        return (rq1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sq1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            sq1 sq1Var = this.a;
            if (sq1Var == null) {
                return null;
            }
            try {
                return sq1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sq1
    public void a(Context context, tq1 tq1Var) {
        sq1 vq1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, tq1Var) == null) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        vq1Var = new vq1();
                    } else if (ordinal == 2) {
                        vq1Var = new dr1();
                    } else if (ordinal == 3) {
                        vq1Var = new br1();
                    } else if (ordinal == 4) {
                        vq1Var = new xq1();
                    }
                    this.a = vq1Var;
                } else {
                    this.a = null;
                }
                if (this.a != null) {
                    this.a.a(context, tq1Var);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
