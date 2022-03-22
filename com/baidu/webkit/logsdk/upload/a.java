package com.baidu.webkit.logsdk.upload;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.logsdk.d.c;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f37927b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37928c;

    /* renamed from: d  reason: collision with root package name */
    public long f37929d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.webkit.logsdk.b.a f37930e;

    /* renamed from: f  reason: collision with root package name */
    public String f37931f;

    /* renamed from: g  reason: collision with root package name */
    public String f37932g;

    /* renamed from: h  reason: collision with root package name */
    public String f37933h;
    public String i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(com.baidu.webkit.logsdk.b.a aVar, String str) {
        this(aVar, str, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.baidu.webkit.logsdk.b.a) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public a(com.baidu.webkit.logsdk.b.a aVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f37927b = 0;
        this.f37928c = false;
        this.f37930e = aVar;
        int a = !TextUtils.isEmpty(str2) ? c.a(str2) : -1;
        if (a <= 1 && a >= 0) {
            this.f37931f = str2;
            return;
        }
        this.f37931f = aVar.f37907c;
        this.f37932g = aVar.f37908d;
    }
}
