package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class qj1 implements fj1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public pj1 b;

    public qj1() {
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

    @Override // com.baidu.tieba.fj1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            pj1 pj1Var = this.b;
            return pj1Var.a(this.a, pj1Var.c);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fj1
    public void a(Context context, gj1 gj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, gj1Var) == null) {
            this.a = context;
            pj1 pj1Var = new pj1();
            this.b = pj1Var;
            pj1Var.c = null;
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                pj1Var.b = cls;
                pj1Var.a = cls.newInstance();
            } catch (Throwable unused) {
            }
            try {
                pj1Var.c = pj1Var.b.getMethod("getOAID", Context.class);
            } catch (Throwable unused2) {
            }
            try {
                pj1Var.b.getMethod("getVAID", Context.class);
            } catch (Throwable unused3) {
            }
            try {
                pj1Var.b.getMethod("getAAID", Context.class);
            } catch (Throwable unused4) {
            }
            if (gj1Var != null) {
                gj1Var.a();
            }
        }
    }
}
