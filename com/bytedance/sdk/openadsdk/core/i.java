package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f66267a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.e.m f66268b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f66269c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.e f66270d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.d f66271e;

    /* renamed from: f  reason: collision with root package name */
    public View f66272f;

    /* renamed from: g  reason: collision with root package name */
    public String f66273g;

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
        this.f66273g = "rewarded_video";
        this.f66268b = mVar;
        this.f66267a = context;
        this.f66272f = view;
        if (TextUtils.isEmpty(str)) {
            this.f66273g = com.bytedance.sdk.openadsdk.q.q.b(com.bytedance.sdk.openadsdk.q.q.c(mVar.ao()));
        } else {
            this.f66273g = str;
        }
        if (this.f66268b.X() == 4) {
            this.f66269c = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f66267a, this.f66268b, this.f66273g);
        }
        String str2 = this.f66273g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, mVar, str2, com.bytedance.sdk.openadsdk.q.q.a(str2));
        this.f66270d = eVar;
        eVar.a(this.f66272f);
        this.f66270d.a(this.f66269c);
        String str3 = this.f66273g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context, mVar, str3, com.bytedance.sdk.openadsdk.q.q.a(str3));
        this.f66271e = dVar;
        dVar.a(this.f66272f);
        this.f66271e.a(this.f66269c);
    }

    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) || i2 == -1 || kVar == null) {
            return;
        }
        int i3 = kVar.f66066a;
        int i4 = kVar.f66067b;
        int i5 = kVar.f66068c;
        int i6 = kVar.f66069d;
        if (i2 != 1) {
            if (i2 == 2 && (dVar = this.f66271e) != null) {
                dVar.a(kVar);
                this.f66271e.a(this.f66272f, i3, i4, i5, i6);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = this.f66270d;
        if (eVar != null) {
            eVar.a(kVar);
            this.f66270d.a(this.f66272f, i3, i4, i5, i6);
        }
    }
}
