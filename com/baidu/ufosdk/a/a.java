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
/* loaded from: classes10.dex */
public final class a extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f56627a;

    /* renamed from: b  reason: collision with root package name */
    public String f56628b;

    /* renamed from: c  reason: collision with root package name */
    public String f56629c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56630d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56631e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56632f;

    /* renamed from: g  reason: collision with root package name */
    public final long f56633g;

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
        this.f56628b = "";
        this.f56629c = "";
        this.f56630d = false;
        this.f56631e = false;
        this.f56632f = false;
        this.f56633g = 300L;
        this.f56627a = context;
        this.f56628b = str;
        this.f56629c = str2;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f56630d = true;
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f56628b = str;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f56630d = false;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || UfoSDK.clientid.length() == 0) {
            return;
        }
        while (!this.f56630d) {
            c.b("###################");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e2) {
                c.a("Interrupted!", e2);
            }
            if (!this.f56631e && (str = this.f56628b) != null && !str.equals("newMessage")) {
                if (d.c(this.f56627a)) {
                    Context context = this.f56627a;
                    String str2 = UfoSDK.clientid;
                    com.baidu.ufosdk.e.a.a(context, this.f56628b, this.f56629c);
                } else {
                    this.f56627a.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                    this.f56627a.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
                }
            }
            try {
                if (!this.f56632f) {
                    Thread.sleep(com.baidu.ufosdk.b.ah * 1000);
                }
            } catch (InterruptedException unused) {
                c.d("GetChatThread Interrupted! Maybe it's time to wakeup.");
            }
        }
    }
}
