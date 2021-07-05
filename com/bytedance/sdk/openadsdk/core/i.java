package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f30143a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.e.m f30144b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f30145c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.e f30146d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.d f30147e;

    /* renamed from: f  reason: collision with root package name */
    public View f30148f;

    /* renamed from: g  reason: collision with root package name */
    public String f30149g;

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
        this.f30149g = "rewarded_video";
        this.f30144b = mVar;
        this.f30143a = context;
        this.f30148f = view;
        if (TextUtils.isEmpty(str)) {
            this.f30149g = com.bytedance.sdk.openadsdk.r.o.b(com.bytedance.sdk.openadsdk.r.o.c(mVar.ao()));
        } else {
            this.f30149g = str;
        }
        if (this.f30144b.X() == 4) {
            this.f30145c = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f30143a, this.f30144b, this.f30149g);
        }
        String str2 = this.f30149g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, mVar, str2, com.bytedance.sdk.openadsdk.r.o.a(str2));
        this.f30146d = eVar;
        eVar.a(this.f30148f);
        this.f30146d.a(this.f30145c);
        String str3 = this.f30149g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context, mVar, str3, com.bytedance.sdk.openadsdk.r.o.a(str3));
        this.f30147e = dVar;
        dVar.a(this.f30148f);
        this.f30147e.a(this.f30145c);
    }

    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) || i2 == -1 || kVar == null) {
            return;
        }
        int i3 = kVar.f29950a;
        int i4 = kVar.f29951b;
        int i5 = kVar.f29952c;
        int i6 = kVar.f29953d;
        if (i2 != 1) {
            if (i2 == 2 && (dVar = this.f30147e) != null) {
                dVar.a(kVar);
                this.f30147e.a(this.f30148f, i3, i4, i5, i6);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = this.f30146d;
        if (eVar != null) {
            eVar.a(kVar);
            this.f30146d.a(this.f30148f, i3, i4, i5, i6);
        }
    }
}
