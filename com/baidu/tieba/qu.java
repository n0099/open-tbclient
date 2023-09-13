package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class qu implements ou {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final UBCManager a;
    public final ru b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448315401, "Lcom/baidu/tieba/qu;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448315401, "Lcom/baidu/tieba/qu;");
        }
    }

    public qu() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        this.b = (ru) ServiceManager.getService(ru.a.a());
    }

    @Override // com.baidu.tieba.ou
    public void a(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", str2);
            hashMap.put("page", str);
            if (jSONObject != null) {
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "it.toString()");
                hashMap.put("ext", jSONObject2);
            }
            UBCManager uBCManager = this.a;
            if (uBCManager != null) {
                uBCManager.onEvent("3676", hashMap);
            }
        }
    }

    @Override // com.baidu.tieba.ou
    public void b(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
            String extra = jSONObject.toString();
            HashMap hashMap = new HashMap();
            hashMap.put("value", str);
            hashMap.put("type", ApkCheckUBCManagerKt.TYPE_ABNORMAL);
            Intrinsics.checkExpressionValueIsNotNull(extra, "extra");
            hashMap.put("ext", extra);
            ru ruVar = this.b;
            if (ruVar != null) {
                ruVar.a("3677", str, extra);
            }
        }
    }
}
