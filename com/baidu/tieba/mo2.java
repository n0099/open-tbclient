package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class mo2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "guide_pull_toast" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rj3.a().putString("swan_guide_toast", this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947979321, "Lcom/baidu/tieba/mo2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947979321, "Lcom/baidu/tieba/mo2;");
                return;
            }
        }
        a = nr1.a;
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, jSONObject, jSONObject2) == null) && jSONObject != null && jSONObject2 != null) {
            try {
                if (!TextUtils.equals(jSONObject.optString("bbasp_guide_reset", "0"), jSONObject2.optString("bbasp_guide_reset", "-1"))) {
                    jSONObject.put("bbasp_guide_shown_count", "0");
                    jSONObject.put("bbasp_guide_last_time", "0");
                    jSONObject.put("bbasp_guide_image_index", "0");
                } else {
                    jSONObject.put("bbasp_guide_shown_count", jSONObject2.optString("bbasp_guide_shown_count", "0"));
                    jSONObject.put("bbasp_guide_last_time", jSONObject2.optString("bbasp_guide_last_time", "0"));
                }
                if (!TextUtils.equals(jSONObject.optString("bbaspg_guide_reset", "0"), jSONObject2.optString("bbaspg_guide_reset", "-1"))) {
                    jSONObject.put("bbaspg_guide_shown_count", "0");
                    jSONObject.put("bbaspg_guide_last_time", "0");
                    jSONObject.put("bbaspg_guide_image_index", "0");
                    return;
                }
                jSONObject.put("bbaspg_guide_shown_count", jSONObject2.optString("bbaspg_guide_shown_count", "0"));
                jSONObject.put("bbaspg_guide_last_time", jSONObject2.optString("bbaspg_guide_last_time", "0"));
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, jSONObject, jSONObject2) == null) && jSONObject != null && jSONObject2 != null && (optJSONArray = jSONObject2.optJSONArray("custom_guide_list")) != null && optJSONArray.length() > 0 && (optJSONArray2 = jSONObject.optJSONArray("custom_guide_list")) != null && optJSONArray2.length() > 0) {
            int length = optJSONArray2.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray2.optJSONObject(i);
                String optString = optJSONObject.optString("appid", "");
                String optString2 = optJSONObject.optString("reset", "0");
                int length2 = optJSONArray.length();
                int i2 = 0;
                while (true) {
                    if (i2 < length2) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        String optString3 = optJSONObject2.optString("appid", "-1");
                        String optString4 = optJSONObject2.optString("reset", "0");
                        if (TextUtils.equals(optString3, optString)) {
                            try {
                                if (!TextUtils.equals(optString4, optString2)) {
                                    optJSONObject.put("shown_count", "0");
                                    optJSONObject.put("last_time", "0");
                                    optJSONObject.put("image_index", "0");
                                } else {
                                    optJSONObject.put("shown_count", jSONObject2.optString("shown_count", "0"));
                                    optJSONObject.put("last_time", jSONObject2.optString("last_time", "0"));
                                    optJSONObject.put("image_index", jSONObject2.optString("image_index", "0"));
                                }
                            } catch (JSONException e) {
                                if (a) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            i2++;
                        }
                    }
                }
            }
        }
    }

    public static JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String string = rj3.a().getString("swan_guide_toast", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String string = rj3.a().getString("guide_toast_version", "0");
            if (a) {
                Log.d("SwanAppGuideToast", "version = " + string);
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public static void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, jSONObject) == null) {
            if (a) {
                Log.d("SwanAppGuideToast", "processGuide guideObject = " + jSONObject);
            }
            if (jSONObject == null) {
                return;
            }
            String optString = jSONObject.optString("version");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !TextUtils.equals(e(), optString)) {
                JSONObject d = d();
                if (d == null) {
                    g(optJSONObject.toString());
                    return;
                }
                a(optJSONObject, d);
                b(optJSONObject, d);
                g(optJSONObject.toString());
                rj3.a().putString("guide_toast_version", optString);
            }
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        xn3.k(new a(str), "swanGuideUpdateRunnable");
    }
}
