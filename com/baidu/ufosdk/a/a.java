package com.baidu.ufosdk.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.b.d;
import com.baidu.ufosdk.f.c;
/* loaded from: classes8.dex */
public final class a extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f59701a;

    /* renamed from: b  reason: collision with root package name */
    public String f59702b;

    /* renamed from: c  reason: collision with root package name */
    public String f59703c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59704d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59705e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59706f;

    /* renamed from: g  reason: collision with root package name */
    public final long f59707g;

    public a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59702b = "";
        this.f59703c = "";
        this.f59704d = false;
        this.f59705e = false;
        this.f59706f = false;
        this.f59707g = 300L;
        this.f59701a = context;
        this.f59702b = str;
        this.f59703c = str2;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59704d = true;
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f59702b = str;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f59704d = false;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || UfoSDK.clientid.length() == 0) {
            return;
        }
        while (!this.f59704d) {
            c.b("###################");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e2) {
                c.a("Interrupted!", e2);
            }
            if (!this.f59705e && (str = this.f59702b) != null && !str.equals("newMessage")) {
                if (d.c(this.f59701a)) {
                    Context context = this.f59701a;
                    String str2 = UfoSDK.clientid;
                    com.baidu.ufosdk.e.a.a(context, this.f59702b, this.f59703c);
                } else {
                    this.f59701a.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                    this.f59701a.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
                }
            }
            try {
                if (!this.f59706f) {
                    Thread.sleep(com.baidu.ufosdk.b.ah * 1000);
                }
            } catch (InterruptedException unused) {
                c.d("GetChatThread Interrupted! Maybe it's time to wakeup.");
            }
        }
    }
}
