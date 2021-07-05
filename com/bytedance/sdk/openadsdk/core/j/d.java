package com.bytedance.sdk.openadsdk.core.j;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.r.o;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends com.bytedance.sdk.component.e.g {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f30182a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d() {
        super("ProcessPushHelper");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private String b(e eVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, this, eVar, i2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wk_status", i2);
                jSONObject.put("app_id", com.bytedance.sdk.openadsdk.core.h.d().h());
                jSONObject.put("package_name", o.d());
                jSONObject.put("ad_sdk_version", "3.6.1.3");
                jSONObject.put(IAdRequestParam.OS, 1);
                jSONObject.put("os_api", Build.VERSION.SDK_INT);
                jSONObject.put(HttpConstants.OS_VERSION, Build.VERSION.RELEASE + "");
                jSONObject.put("ip", com.bytedance.sdk.openadsdk.core.k.c.a(true));
                jSONObject.put("ua", o.b());
                jSONObject.put("vendor", Build.MANUFACTURER);
                jSONObject.put("model", Build.MODEL);
                jSONObject.put("ad_package_name", eVar.f30185c);
                jSONObject.put("action", eVar.f30183a);
                jSONObject.put("service", eVar.f30184b);
                com.bytedance.sdk.openadsdk.n.a.a(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeLI.objValue;
    }

    public static d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f30182a == null) {
                synchronized (f.class) {
                    if (f30182a == null) {
                        f30182a = new d();
                    }
                }
            }
            return f30182a;
        }
        return (d) invokeV.objValue;
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.h.d().h()) : invokeV.booleanValue;
    }

    public void a(e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, eVar, i2) == null) {
            com.bytedance.sdk.openadsdk.k.a.c cVar = new com.bytedance.sdk.openadsdk.k.a.c();
            cVar.b(b(eVar, i2));
            cVar.a("wk_status");
            cVar.e("3.6.1.3");
            cVar.c(System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.k.a.a().m(cVar);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.bytedance.sdk.component.e.e.a(this, 1);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || e()) {
            return;
        }
        try {
            wait(1000L);
        } catch (Exception unused) {
        }
        List<e> K = com.bytedance.sdk.openadsdk.core.o.h().K();
        if (K != null) {
            for (int i2 = 0; i2 < K.size(); i2++) {
                e eVar = K.get(i2);
                if (eVar != null) {
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (eVar.f30184b != null && eVar.f30185c != null && currentTimeMillis - com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_push_time", eVar.f30185c, 0L) > eVar.f30186d * 1000) {
                            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_push_time", eVar.f30185c, Long.valueOf(currentTimeMillis));
                            Intent intent = new Intent();
                            intent.setAction(eVar.f30183a);
                            intent.setPackage(eVar.f30185c);
                            com.bytedance.sdk.openadsdk.core.o.a().startService(intent);
                            a(eVar, 1);
                        }
                    } catch (Throwable unused2) {
                        a(eVar, 0);
                    }
                }
            }
        }
    }
}
