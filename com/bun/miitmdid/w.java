package com.bun.miitmdid;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.identifier.IdentifierManager;
/* loaded from: classes2.dex */
public class w extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public String f55024i;

    /* renamed from: j  reason: collision with root package name */
    public Context f55025j;

    public w(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55025j = context;
        this.f55024i = str;
    }

    @Override // com.bun.miitmdid.m
    public g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            g gVar = new g();
            Context a = a(this.f55025j);
            this.f55025j = a;
            gVar.e(new h(IdentifierManager.class, null, "isSupported", new Class[]{Context.class}, new Object[]{a}));
            gVar.d(new h(IdentifierManager.class, (Object) null, "getOAIDStatus", new Class[]{Context.class}, new Object[]{this.f55025j}, String.class));
            gVar.b(new h(IdentifierManager.class, null, "getOAID", new Class[]{Context.class}, new Object[]{this.f55025j}));
            gVar.c(new h(IdentifierManager.class, null, "getVAID", new Class[]{Context.class, String.class}, new Object[]{this.f55025j, this.f55024i}));
            gVar.a(new h(IdentifierManager.class, null, "getAAID", new Class[]{Context.class}, new Object[]{this.f55025j}));
            return gVar;
        }
        return (g) invokeV.objValue;
    }
}
