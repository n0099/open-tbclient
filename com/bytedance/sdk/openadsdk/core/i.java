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
    public final Context f66993a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.e.m f66994b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f66995c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.e f66996d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.d f66997e;

    /* renamed from: f  reason: collision with root package name */
    public View f66998f;

    /* renamed from: g  reason: collision with root package name */
    public String f66999g;

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
        this.f66999g = "rewarded_video";
        this.f66994b = mVar;
        this.f66993a = context;
        this.f66998f = view;
        if (TextUtils.isEmpty(str)) {
            this.f66999g = com.bytedance.sdk.openadsdk.q.q.b(com.bytedance.sdk.openadsdk.q.q.c(mVar.ao()));
        } else {
            this.f66999g = str;
        }
        if (this.f66994b.X() == 4) {
            this.f66995c = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f66993a, this.f66994b, this.f66999g);
        }
        String str2 = this.f66999g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, mVar, str2, com.bytedance.sdk.openadsdk.q.q.a(str2));
        this.f66996d = eVar;
        eVar.a(this.f66998f);
        this.f66996d.a(this.f66995c);
        String str3 = this.f66999g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context, mVar, str3, com.bytedance.sdk.openadsdk.q.q.a(str3));
        this.f66997e = dVar;
        dVar.a(this.f66998f);
        this.f66997e.a(this.f66995c);
    }

    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) || i2 == -1 || kVar == null) {
            return;
        }
        int i3 = kVar.f66792a;
        int i4 = kVar.f66793b;
        int i5 = kVar.f66794c;
        int i6 = kVar.f66795d;
        if (i2 != 1) {
            if (i2 == 2 && (dVar = this.f66997e) != null) {
                dVar.a(kVar);
                this.f66997e.a(this.f66998f, i3, i4, i5, i6);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = this.f66996d;
        if (eVar != null) {
            eVar.a(kVar);
            this.f66996d.a(this.f66998f, i3, i4, i5, i6);
        }
    }
}
