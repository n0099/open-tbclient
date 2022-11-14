package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.CriusLoader;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class uj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> a;
    public Map<String, a> b;

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CriusData a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public uj0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static uj0 b(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            uj0 uj0Var = new uj0();
            uj0Var.i(jSONObject);
            return uj0Var;
        }
        return (uj0) invokeL.objValue;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            CriusLoader.init(context);
            CriusLoader.registerComponentFactory(new sj0());
            CriusLoader.registerNativeRenderFactory(new tj0());
        }
    }

    public CriusData e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            try {
                return new CriusData(aj0.b(), jSONObject, true, null);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (CriusData) invokeL.objValue;
    }

    public final void g(Set<String> set) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, set) != null) || set == null) {
            return;
        }
        for (String str : set) {
            qn0.a().d(str);
        }
    }

    public uj0 i(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jSONObject)) == null) {
            j(jSONObject, "cmd_map", Arrays.asList("crius", "crius_pop", "crius_content"));
            return this;
        }
        return (uj0) invokeL.objValue;
    }

    public final Map<String, String> c(@NonNull JSONObject jSONObject, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, str)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject != null) {
                HashMap hashMap = new HashMap();
                Iterator<String> keys = optJSONObject.keys();
                while (keys != null && keys.hasNext()) {
                    String next = keys.next();
                    String optString = optJSONObject.optString(next);
                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                        hashMap.put(next, optString);
                    }
                }
                return hashMap;
            }
            return null;
        }
        return (Map) invokeLL.objValue;
    }

    public a d(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull Map<String, String> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str, map)) == null) {
            a aVar = new a();
            String optString = jSONObject.optString(str);
            if (h()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue()) && optString != null) {
                        optString = optString.replaceAll(entry.getKey(), Uri.encode(entry.getValue()));
                    }
                }
            }
            if (CriusLoader.isCriusNone()) {
                a(aj0.b());
            }
            if (!CriusLoader.isCriusOk()) {
                return aVar;
            }
            try {
                aVar.a = e(new JSONObject(optString));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            CriusData criusData = aVar.a;
            if (criusData != null && criusData.getImageUrls() != null) {
                g(aVar.a.getImageUrls());
            }
            return aVar;
        }
        return (a) invokeLLL.objValue;
    }

    public final Map<String, a> f(@NonNull JSONObject jSONObject, @NonNull List<String> list, @NonNull Map<String, String> map) {
        InterceptResult invokeLLL;
        a d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, jSONObject, list, map)) == null) {
            HashMap hashMap = null;
            for (String str : list) {
                if (!TextUtils.isEmpty(str) && (d = d(jSONObject, str, map)) != null) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(str, d);
                }
            }
            return hashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    public uj0 j(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull List<String> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, str, list)) == null) {
            Map<String, String> c = c(jSONObject, str);
            this.a = c;
            if (c != null) {
                this.b = f(jSONObject, list, c);
            }
            return this;
        }
        return (uj0) invokeLLL.objValue;
    }
}
