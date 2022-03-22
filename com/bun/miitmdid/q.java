package com.bun.miitmdid;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.flyme.openidsdk.OpenIdHelper;
/* loaded from: classes6.dex */
public class q extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context i;

    public q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = context;
    }

    @Override // com.bun.miitmdid.m
    public g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            g gVar = new g();
            this.i = a(this.i);
            gVar.e(new h(OpenIdHelper.class, null, "isSupported", null, null));
            gVar.d(null);
            gVar.b(new h(OpenIdHelper.class, null, "getOAID", new Class[]{Context.class}, new Object[]{this.i}));
            gVar.c(new h(OpenIdHelper.class, null, "getVAID", new Class[]{Context.class}, new Object[]{this.i}));
            gVar.a(new h(OpenIdHelper.class, null, "getAAID", new Class[]{Context.class}, new Object[]{this.i}));
            return gVar;
        }
        return (g) invokeV.objValue;
    }
}
