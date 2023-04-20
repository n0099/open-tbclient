package com.baidu.tieba;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xj4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String c = "PageTipsManager";
    public static boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public Map<String, String> b;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948302279, "Lcom/baidu/tieba/xj4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948302279, "Lcom/baidu/tieba/xj4;");
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final xj4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-287269943, "Lcom/baidu/tieba/xj4$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-287269943, "Lcom/baidu/tieba/xj4$b;");
                    return;
                }
            }
            a = new xj4(null);
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends fo4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c() {
            super("updatecore_node_page_tips");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public xj4() {
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
        this.a = new c();
    }

    public static xj4 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return b.a;
        }
        return (xj4) invokeV.objValue;
    }

    public final void e() {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (map = this.b) == null) {
            return;
        }
        map.clear();
        this.b = null;
    }

    public Map<String, String> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Map<String, String> map = this.b;
            if (map == null || map.size() < 1) {
                p();
            }
            return this.b;
        }
        return (Map) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a.getString("version", "0");
        }
        return (String) invokeV.objValue;
    }

    public synchronized void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                JSONObject j = j(this.a.getString("page_error_tips", ""));
                e();
                i(j);
            }
        }
    }

    public /* synthetic */ xj4(a aVar) {
        this();
    }

    public static String a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return str + "_btn_cmd";
        }
        return (String) invokeL.objValue;
    }

    public static String b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return str + "_btn_text";
        }
        return (String) invokeL.objValue;
    }

    public static String c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return str + "_btn_cmd_btn_url";
        }
        return (String) invokeL.objValue;
    }

    public static String d(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            return str + "_tips";
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public static JSONObject j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (d) {
                    Log.w(c, "JSONObject parsed error!!", e);
                }
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public void k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        e();
        i(optJSONObject);
        q(optJSONObject.toString(), optString);
    }

    public static String l(@NonNull Map<String, String> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, map, str)) == null) {
            if (map == null) {
                return "";
            }
            return map.get(a(str));
        }
        return (String) invokeLL.objValue;
    }

    public static String m(@NonNull Map<String, String> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, map, str)) == null) {
            if (map == null) {
                return "";
            }
            return map.get(b(str));
        }
        return (String) invokeLL.objValue;
    }

    public static String n(@NonNull Map<String, String> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, map, str)) == null) {
            if (map == null) {
                return "";
            }
            return map.get(c(str));
        }
        return (String) invokeLL.objValue;
    }

    public static String o(@NonNull Map<String, String> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, map, str)) == null) {
            if (map == null) {
                return "";
            }
            return map.get(d(str));
        }
        return (String) invokeLL.objValue;
    }

    public final void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.b = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null) {
                this.b.put(d(next), optJSONObject.optString("tips"));
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(NativeConstants.ID_BUTTON);
                if (optJSONObject2 != null) {
                    String optString = optJSONObject2.optString("cmd");
                    if (!TextUtils.isEmpty(optString)) {
                        this.b.put(a(next), optString);
                    }
                    String optString2 = optJSONObject2.optString("text");
                    if (!TextUtils.isEmpty(optString2)) {
                        this.b.put(b(next), optString2);
                    }
                    String optString3 = optJSONObject2.optString("url");
                    if (!TextUtils.isEmpty(optString3)) {
                        this.b.put(c(next), optString3);
                    }
                }
            }
        }
    }

    public void q(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) && str != null && !str.isEmpty() && !TextUtils.isEmpty(str2)) {
            SharedPreferences.Editor edit = this.a.edit();
            edit.clear();
            edit.putString("version", str2);
            edit.putString("page_error_tips", str);
            edit.apply();
            if (d) {
                Log.d(c, "write success");
            }
        }
    }
}
