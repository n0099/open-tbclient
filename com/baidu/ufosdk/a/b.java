package com.baidu.ufosdk.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.f.c;
/* loaded from: classes4.dex */
public final class b extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f23276a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23277b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23278c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23279d;

    /* renamed from: e  reason: collision with root package name */
    public final long f23280e;

    /* renamed from: f  reason: collision with root package name */
    public String f23281f;

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
        this.f23277b = false;
        this.f23278c = false;
        this.f23279d = false;
        this.f23280e = 300L;
        this.f23281f = "";
        this.f23276a = context;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23277b = true;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f23277b = false;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String str = UfoSDK.clientid;
            this.f23281f = str;
            if (str.length() == 0) {
                return;
            }
            while (!this.f23277b) {
                c.b("@@@@@@@@@@@@@@@@@@@@@");
                try {
                    Thread.sleep(300L);
                } catch (InterruptedException e2) {
                    c.a("Interrupted!", e2);
                }
                if (!this.f23278c) {
                    com.baidu.ufosdk.e.a.c(this.f23276a);
                }
                try {
                    if (!this.f23279d) {
                        Thread.sleep(com.baidu.ufosdk.b.ai * 1000);
                    }
                } catch (InterruptedException unused) {
                    c.d("GetChatThread Interrupted! Maybe it's time to wakeup.");
                }
            }
        }
    }
}
