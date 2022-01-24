package com.bun.miitmdid;

import android.app.KeyguardManager;
import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class t extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public Context f52977i;

    public t(Context context) {
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
        this.f52977i = context;
    }

    @Override // com.bun.miitmdid.m
    public g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            g gVar = new g();
            Context a = a(this.f52977i);
            this.f52977i = a;
            KeyguardManager keyguardManager = (KeyguardManager) a.getSystemService("keyguard");
            if (keyguardManager == null) {
                e0.b("PrizeProvider", "getIdManagerInfo: ClassNotFound: android.app.KeyguardManager");
                gVar.f();
                return gVar;
            }
            Class<?> cls = keyguardManager.getClass();
            gVar.e(new h(cls, keyguardManager, "isSupported", null, null));
            gVar.d(null);
            gVar.b(new h(cls, keyguardManager, "obtainOaid", null, null));
            gVar.c(new h(cls, keyguardManager, "obtainVaid", null, null));
            gVar.a(new h(cls, keyguardManager, "obtainAaid", null, null));
            return gVar;
        }
        return (g) invokeV.objValue;
    }
}
