package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class ap implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ao f23452a;

    public ap(ao aoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aoVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23452a = aoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        int i2;
        Handler handler2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.baidu.ufosdk.e.a.a(this.f23452a.f23451a.getApplicationContext());
            if (UfoSDK.clientid.length() != 0) {
                handler = this.f23452a.f23451a.v;
                i2 = 1;
            } else {
                handler = this.f23452a.f23451a.v;
                i2 = 4;
            }
            handler.obtainMessage(i2, null).sendToTarget();
            Context applicationContext = this.f23452a.f23451a.getApplicationContext();
            String str = UfoSDK.clientid;
            String c2 = com.baidu.ufosdk.e.a.c(applicationContext);
            if (c2 != null) {
                handler2 = this.f23452a.f23451a.v;
                handler2.obtainMessage(0, c2).sendToTarget();
            }
        }
    }
}
