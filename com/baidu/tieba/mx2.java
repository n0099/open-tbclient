package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Headers;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class mx2 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> d;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, Long> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947987970, "Lcom/baidu/tieba/mx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947987970, "Lcom/baidu/tieba/mx2;");
                return;
            }
        }
        d = Sets.newHashSet("REFERER", "USER-AGENT");
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return rp2.q().a().getCookie(".baidu.com");
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mx2(h73 h73Var, String str) {
        super(h73Var, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h73Var, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new ConcurrentHashMap<>();
    }

    public void j(@NonNull JSONObject jSONObject, String str) throws JSONException {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, jSONObject, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        String optString = jSONObject.optString("Cookie");
        if (TextUtils.isEmpty(optString)) {
            jSONObject.put("Cookie", str);
            return;
        }
        if (optString.endsWith(ParamableElem.DIVIDE_PARAM)) {
            str2 = optString + str;
        } else {
            str2 = optString + ParamableElem.DIVIDE_PARAM + str;
        }
        jSONObject.put("Cookie", str2);
    }

    public boolean k(k63 k63Var, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k63Var, unitedSchemeEntity)) == null) {
            if (k63Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            }
            JSONObject a = h83.a(unitedSchemeEntity, "params");
            if (a == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal params");
                return false;
            } else if (TextUtils.isEmpty(a.optString("cb"))) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal cb");
                return false;
            } else if (TextUtils.isEmpty(a.optString("url"))) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal url");
                return false;
            } else {
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public void r(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, jSONObject) == null) && !TextUtils.isEmpty(str) && jSONObject != null && jSONObject != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("header", jSONObject);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject2.toString());
                xr2.V().v(new lg2(str, hashMap));
            } catch (JSONException e) {
                if (h83.b) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static HashMap<String, String> l(@Nullable JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject != null && jSONObject.length() >= 1) {
                HashMap<String, String> hashMap = new HashMap<>();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next) && !d.contains(next.toUpperCase())) {
                        String optString = jSONObject.optString(next);
                        if (TextUtils.isEmpty(optString)) {
                            optString = "";
                        }
                        hashMap.put(next, optString);
                    }
                }
                return hashMap;
            }
            return null;
        }
        return (HashMap) invokeL.objValue;
    }

    public JSONObject t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    return UnitedSchemeUtility.wrapCallbackParams(202, "illegal request");
                                }
                                return UnitedSchemeUtility.wrapCallbackParams(202, "illegal upload file over size.");
                            }
                            return UnitedSchemeUtility.wrapCallbackParams(202, "HTTP method is invalid");
                        }
                        return UnitedSchemeUtility.wrapCallbackParams(202, "request:fail parameter error: arrayBuffer of data exceed size limit.");
                    }
                    return UnitedSchemeUtility.wrapCallbackParams(202, "request url header must be https or wss");
                }
                return UnitedSchemeUtility.wrapCallbackParams(202, "illegal request");
            }
            return UnitedSchemeUtility.wrapCallbackParams(0);
        }
        return (JSONObject) invokeI.objValue;
    }

    public static HashMap<String, String> m(@Nullable JSONObject jSONObject, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, jSONObject, z)) == null) {
            HashMap<String, String> l = l(jSONObject);
            if (z) {
                if (l == null) {
                    l = new HashMap<>();
                }
                l.put("Referer", aw1.d());
            }
            return l;
        }
        return (HashMap) invokeLZ.objValue;
    }

    public static JSONObject s(Headers headers) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, headers)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (headers == null) {
                return jSONObject;
            }
            for (String str : headers.names()) {
                if (!TextUtils.isEmpty(str)) {
                    List<String> values = headers.values(str);
                    StringBuilder sb = new StringBuilder();
                    int size = values.size();
                    for (int i = 0; i < size; i++) {
                        sb.append(values.get(i));
                        if (i == size - 1) {
                            break;
                        }
                        sb.append(",");
                    }
                    jSONObject.put(str, sb.toString());
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public JSONObject n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("cancelTag", str);
                }
            } catch (JSONException e) {
                if (h83.b) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final long p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            try {
                return this.c.get(str).longValue();
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public final void q(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && this.c != null && !TextUtils.isEmpty(str)) {
            this.c.remove(str);
        }
    }
}
