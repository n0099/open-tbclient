package com.bun.miitmdid;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.provider.nubia.NubiaIdentityImpl;
/* loaded from: classes2.dex */
public class r extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public Context f52929i;

    /* renamed from: j  reason: collision with root package name */
    public String f52930j;

    public r(Context context) {
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
        this.f52929i = context;
    }

    @Override // com.bun.miitmdid.m
    public g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            g gVar = new g();
            Context a = a(this.f52929i);
            this.f52929i = a;
            this.f52930j = a.getPackageName();
            gVar.e(new h(NubiaIdentityImpl.class, null, "isSupported", new Class[]{Context.class}, new Object[]{this.f52929i}));
            gVar.d(null);
            gVar.b(new h(NubiaIdentityImpl.class, null, "getOAID", new Class[]{Context.class}, new Object[]{this.f52929i}));
            gVar.c(new h(NubiaIdentityImpl.class, null, "getVAID", new Class[]{Context.class, String.class}, new Object[]{this.f52929i, this.f52930j}));
            gVar.a(new h(NubiaIdentityImpl.class, null, "getAAID", new Class[]{Context.class, String.class}, new Object[]{this.f52929i, this.f52930j}));
            return gVar;
        }
        return (g) invokeV.objValue;
    }
}
