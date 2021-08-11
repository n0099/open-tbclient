package com.baidu.ufosdk.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.f.c;
/* loaded from: classes8.dex */
public final class b extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f59162a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59163b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59164c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59165d;

    /* renamed from: e  reason: collision with root package name */
    public final long f59166e;

    /* renamed from: f  reason: collision with root package name */
    public String f59167f;

    public b(Context context) {
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
        this.f59163b = false;
        this.f59164c = false;
        this.f59165d = false;
        this.f59166e = 300L;
        this.f59167f = "";
        this.f59162a = context;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59163b = true;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f59163b = false;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String str = UfoSDK.clientid;
            this.f59167f = str;
            if (str.length() == 0) {
                return;
            }
            while (!this.f59163b) {
                c.b("@@@@@@@@@@@@@@@@@@@@@");
                try {
                    Thread.sleep(300L);
                } catch (InterruptedException e2) {
                    c.a("Interrupted!", e2);
                }
                if (!this.f59164c) {
                    com.baidu.ufosdk.e.a.c(this.f59162a);
                }
                try {
                    if (!this.f59165d) {
                        Thread.sleep(com.baidu.ufosdk.b.ai * 1000);
                    }
                } catch (InterruptedException unused) {
                    c.d("GetChatThread Interrupted! Maybe it's time to wakeup.");
                }
            }
        }
    }
}
