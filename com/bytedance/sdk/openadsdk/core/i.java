package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f30253a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.e.m f30254b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f30255c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.e f30256d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.d f30257e;

    /* renamed from: f  reason: collision with root package name */
    public View f30258f;

    /* renamed from: g  reason: collision with root package name */
    public String f30259g;

    public i(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, view, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30259g = "rewarded_video";
        this.f30254b = mVar;
        this.f30253a = context;
        this.f30258f = view;
        if (TextUtils.isEmpty(str)) {
            this.f30259g = com.bytedance.sdk.openadsdk.r.o.b(com.bytedance.sdk.openadsdk.r.o.c(mVar.ao()));
        } else {
            this.f30259g = str;
        }
        if (this.f30254b.X() == 4) {
            this.f30255c = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f30253a, this.f30254b, this.f30259g);
        }
        String str2 = this.f30259g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, mVar, str2, com.bytedance.sdk.openadsdk.r.o.a(str2));
        this.f30256d = eVar;
        eVar.a(this.f30258f);
        this.f30256d.a(this.f30255c);
        String str3 = this.f30259g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context, mVar, str3, com.bytedance.sdk.openadsdk.r.o.a(str3));
        this.f30257e = dVar;
        dVar.a(this.f30258f);
        this.f30257e.a(this.f30255c);
    }

    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) || i2 == -1 || kVar == null) {
            return;
        }
        int i3 = kVar.f30060a;
        int i4 = kVar.f30061b;
        int i5 = kVar.f30062c;
        int i6 = kVar.f30063d;
        if (i2 != 1) {
            if (i2 == 2 && (dVar = this.f30257e) != null) {
                dVar.a(kVar);
                this.f30257e.a(this.f30258f, i3, i4, i5, i6);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = this.f30256d;
        if (eVar != null) {
            eVar.a(kVar);
            this.f30256d.a(this.f30258f, i3, i4, i5, i6);
        }
    }
}
