package com.bun.miitmdid;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.flyme.openidsdk.OpenIdHelper;
/* loaded from: classes12.dex */
public class q extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public Context f54437i;

    public q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54437i = context;
    }

    @Override // com.bun.miitmdid.m
    public g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            g gVar = new g();
            this.f54437i = a(this.f54437i);
            gVar.e(new h(OpenIdHelper.class, null, "isSupported", null, null));
            gVar.d(null);
            gVar.b(new h(OpenIdHelper.class, null, "getOAID", new Class[]{Context.class}, new Object[]{this.f54437i}));
            gVar.c(new h(OpenIdHelper.class, null, "getVAID", new Class[]{Context.class}, new Object[]{this.f54437i}));
            gVar.a(new h(OpenIdHelper.class, null, "getAAID", new Class[]{Context.class}, new Object[]{this.f54437i}));
            return gVar;
        }
        return (g) invokeV.objValue;
    }
}
