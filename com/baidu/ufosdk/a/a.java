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
/* loaded from: classes4.dex */
public final class a extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f23427a;

    /* renamed from: b  reason: collision with root package name */
    public String f23428b;

    /* renamed from: c  reason: collision with root package name */
    public String f23429c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23430d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23431e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23432f;

    /* renamed from: g  reason: collision with root package name */
    public final long f23433g;

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
        this.f23428b = "";
        this.f23429c = "";
        this.f23430d = false;
        this.f23431e = false;
        this.f23432f = false;
        this.f23433g = 300L;
        this.f23427a = context;
        this.f23428b = str;
        this.f23429c = str2;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23430d = true;
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f23428b = str;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f23430d = false;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || UfoSDK.clientid.length() == 0) {
            return;
        }
        while (!this.f23430d) {
            c.b("###################");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e2) {
                c.a("Interrupted!", e2);
            }
            if (!this.f23431e && (str = this.f23428b) != null && !str.equals("newMessage")) {
                if (d.c(this.f23427a)) {
                    Context context = this.f23427a;
                    String str2 = UfoSDK.clientid;
                    com.baidu.ufosdk.e.a.a(context, this.f23428b, this.f23429c);
                } else {
                    this.f23427a.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                    this.f23427a.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
                }
            }
            try {
                if (!this.f23432f) {
                    Thread.sleep(com.baidu.ufosdk.b.ah * 1000);
                }
            } catch (InterruptedException unused) {
                c.d("GetChatThread Interrupted! Maybe it's time to wakeup.");
            }
        }
    }
}
