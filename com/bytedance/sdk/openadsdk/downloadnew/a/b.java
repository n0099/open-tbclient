package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.e.k;
import com.bytedance.sdk.openadsdk.q.q;
/* loaded from: classes9.dex */
public class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, m mVar, String str) {
        super(context, mVar, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (m) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    try {
                        Intent b2 = q.b(context, str);
                        if (b2 == null) {
                            return false;
                        }
                        if (this.f67457h) {
                            com.bytedance.sdk.openadsdk.e.d.a(m(), this.f67452c, this.f67453d, "lp_open_dpl", str);
                        }
                        n();
                        b2.putExtra("START_ONLY_FOR_ANDROID", true);
                        context.startActivity(b2);
                        if (this.f67457h) {
                            com.bytedance.sdk.openadsdk.e.d.b(m(), this.f67452c, this.f67453d, "lp_openurl");
                        }
                        if (this.f67457h) {
                            k.a().a(this.f67452c, this.f67453d, true);
                        }
                        return true;
                    } catch (Exception unused) {
                        if (this.f67457h) {
                            com.bytedance.sdk.openadsdk.e.d.b(m(), this.f67452c, this.f67453d, "lp_openurl_failed");
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d, com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            com.bytedance.sdk.openadsdk.core.e.b bVar = this.f67451b;
            boolean z = false;
            if (bVar == null) {
                return false;
            }
            String d2 = bVar.d();
            if (!TextUtils.isEmpty(d2) && b(m(), d2)) {
                z = true;
                this.f67455f.set(true);
                if (!a(this.f67453d, "click_open", this.f67452c)) {
                    com.bytedance.sdk.openadsdk.e.d.i(m(), this.f67452c, this.f67453d, q.h(this.f67452c), null);
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f67452c.an() != null) {
                String a2 = this.f67452c.an().a();
                if (!TextUtils.isEmpty(a2)) {
                    Uri parse = Uri.parse(a2);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(parse);
                    if (this.f67457h) {
                        com.bytedance.sdk.openadsdk.e.d.a(m(), this.f67452c, this.f67453d, "lp_open_dpl", a(a2));
                    }
                    try {
                        Context m = m();
                        if (!(m instanceof Activity)) {
                            intent.addFlags(268435456);
                        }
                        if (!a(this.f67453d, "open_url_app", this.f67452c)) {
                            com.bytedance.sdk.openadsdk.e.d.h(m(), this.f67452c, this.f67453d, "open_url_app", null);
                        }
                        n();
                        m.startActivity(intent);
                        k.a().a(this.f67452c, this.f67453d, this.f67457h);
                        if (this.f67457h) {
                            com.bytedance.sdk.openadsdk.e.d.b(m(), this.f67452c, this.f67453d, "lp_openurl");
                            com.bytedance.sdk.openadsdk.e.d.b(o.a(), this.f67452c, this.f67453d, "lp_deeplink_success_realtime");
                        } else {
                            com.bytedance.sdk.openadsdk.e.d.b(o.a(), this.f67452c, this.f67453d, "deeplink_success_realtime");
                        }
                        return true;
                    } catch (Throwable unused) {
                        com.bytedance.sdk.openadsdk.e.d.b(m(), this.f67452c, this.f67453d, "open_fallback_download");
                        if (this.f67457h) {
                            com.bytedance.sdk.openadsdk.e.d.b(m(), this.f67452c, this.f67453d, "lp_openurl_failed");
                            com.bytedance.sdk.openadsdk.e.d.b(o.a(), this.f67452c, this.f67453d, "lp_deeplink_fail_realtime");
                        } else {
                            com.bytedance.sdk.openadsdk.e.d.b(o.a(), this.f67452c, this.f67453d, "deeplink_fail_realtime");
                        }
                    }
                }
                if (this.f67454e.get() == 4 || this.f67454e.get() == 3) {
                    return false;
                }
                if (!this.f67456g || this.f67455f.get()) {
                    this.f67456g = true;
                    if (a(this.f67453d, "open_fallback_url", this.f67452c)) {
                        return false;
                    }
                    com.bytedance.sdk.openadsdk.e.d.h(m(), this.f67452c, this.f67453d, "open_fallback_url", null);
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
