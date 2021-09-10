package com.baidu.webkit.logsdk.upload;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.logsdk.d.c;
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f63900a;

    /* renamed from: b  reason: collision with root package name */
    public int f63901b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63902c;

    /* renamed from: d  reason: collision with root package name */
    public long f63903d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.webkit.logsdk.b.a f63904e;

    /* renamed from: f  reason: collision with root package name */
    public String f63905f;

    /* renamed from: g  reason: collision with root package name */
    public String f63906g;

    /* renamed from: h  reason: collision with root package name */
    public String f63907h;

    /* renamed from: i  reason: collision with root package name */
    public String f63908i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(com.baidu.webkit.logsdk.b.a aVar, String str) {
        this(aVar, str, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f63900a = str;
        this.f63901b = 0;
        this.f63902c = false;
        this.f63904e = aVar;
        int a2 = !TextUtils.isEmpty(str2) ? c.a(str2) : -1;
        if (a2 <= 1 && a2 >= 0) {
            this.f63905f = str2;
            return;
        }
        this.f63905f = aVar.f63871c;
        this.f63906g = aVar.f63872d;
    }
}
