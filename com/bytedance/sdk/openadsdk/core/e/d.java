package com.bytedance.sdk.openadsdk.core.e;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f30117a;

    /* renamed from: b  reason: collision with root package name */
    public String f30118b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f30119c;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f30117a = str;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f30118b = str;
        }
    }

    public void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
            this.f30119c = map;
        }
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.f30117a) && !TextUtils.isEmpty(this.f30118b)) {
                try {
                    jSONObject.put("url", this.f30117a);
                    jSONObject.put("html", this.f30118b);
                    JSONObject jSONObject2 = new JSONObject();
                    if (this.f30119c != null && this.f30119c.size() > 0) {
                        for (Map.Entry<String, String> entry : this.f30119c.entrySet()) {
                            jSONObject2.put(entry.getKey(), entry.getValue());
                        }
                    }
                    jSONObject.put("headers", jSONObject2);
                } catch (Exception unused) {
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
