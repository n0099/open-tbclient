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
    public final Context f66467a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.e.m f66468b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f66469c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.e f66470d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.d f66471e;

    /* renamed from: f  reason: collision with root package name */
    public View f66472f;

    /* renamed from: g  reason: collision with root package name */
    public String f66473g;

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
        this.f66473g = "rewarded_video";
        this.f66468b = mVar;
        this.f66467a = context;
        this.f66472f = view;
        if (TextUtils.isEmpty(str)) {
            this.f66473g = com.bytedance.sdk.openadsdk.q.q.b(com.bytedance.sdk.openadsdk.q.q.c(mVar.ao()));
        } else {
            this.f66473g = str;
        }
        if (this.f66468b.X() == 4) {
            this.f66469c = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f66467a, this.f66468b, this.f66473g);
        }
        String str2 = this.f66473g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, mVar, str2, com.bytedance.sdk.openadsdk.q.q.a(str2));
        this.f66470d = eVar;
        eVar.a(this.f66472f);
        this.f66470d.a(this.f66469c);
        String str3 = this.f66473g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context, mVar, str3, com.bytedance.sdk.openadsdk.q.q.a(str3));
        this.f66471e = dVar;
        dVar.a(this.f66472f);
        this.f66471e.a(this.f66469c);
    }

    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) || i2 == -1 || kVar == null) {
            return;
        }
        int i3 = kVar.f66266a;
        int i4 = kVar.f66267b;
        int i5 = kVar.f66268c;
        int i6 = kVar.f66269d;
        if (i2 != 1) {
            if (i2 == 2 && (dVar = this.f66471e) != null) {
                dVar.a(kVar);
                this.f66471e.a(this.f66472f, i3, i4, i5, i6);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = this.f66470d;
        if (eVar != null) {
            eVar.a(kVar);
            this.f66470d.a(this.f66472f, i3, i4, i5, i6);
        }
    }
}
