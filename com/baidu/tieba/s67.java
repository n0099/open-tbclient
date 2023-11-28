package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.f37;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class s67 implements z67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final Map<String, JSONObject> c;
    public final f37.h d;

    public s67(String spaceName, String uid) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {spaceName, uid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(spaceName, "spaceName");
        Intrinsics.checkNotNullParameter(uid, "uid");
        this.a = spaceName;
        this.b = uid;
        this.c = new LinkedHashMap();
        f37.h d = f37.a().d();
        this.d = d;
        Map<String, JSONObject> b = d.b(this.a, this.b);
        Intrinsics.checkNotNullExpressionValue(b, "cacheResolver.getCache(spaceName, uid)");
        this.c.putAll(b);
    }

    @Override // com.baidu.tieba.z67
    public void a(String key, Map<String, String> valueMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, key, valueMap) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(valueMap, "valueMap");
            if (this.c.get(key) == null) {
                this.c.put(key, new JSONObject());
            }
            try {
                for (String str : valueMap.keySet()) {
                    JSONObject jSONObject = this.c.get(key);
                    if (jSONObject != null) {
                        jSONObject.put(str, valueMap.get(str));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            JSONObject jSONObject2 = this.c.get(key);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            b(key, jSONObject2);
        }
    }

    public final void b(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
            this.d.a(this.a, this.b, str, jSONObject);
        }
    }

    @Override // com.baidu.tieba.z67
    public String getValue(String key, String subKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, key, subKey)) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(subKey, "subKey");
            JSONObject jSONObject = this.c.get(key);
            if (jSONObject != null) {
                return jSONObject.optString(subKey);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}
