package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mr1 implements br1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public lr1 b;

    public mr1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.br1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            lr1 lr1Var = this.b;
            return lr1Var.a(this.a, lr1Var.c);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.br1
    public void a(Context context, cr1 cr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cr1Var) == null) {
            this.a = context;
            lr1 lr1Var = new lr1();
            this.b = lr1Var;
            lr1Var.c = null;
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                lr1Var.b = cls;
                lr1Var.a = cls.newInstance();
            } catch (Throwable unused) {
            }
            try {
                lr1Var.c = lr1Var.b.getMethod("getOAID", Context.class);
            } catch (Throwable unused2) {
            }
            try {
                lr1Var.b.getMethod("getVAID", Context.class);
            } catch (Throwable unused3) {
            }
            try {
                lr1Var.b.getMethod("getAAID", Context.class);
            } catch (Throwable unused4) {
            }
            if (cr1Var != null) {
                cr1Var.a();
            }
        }
    }
}
