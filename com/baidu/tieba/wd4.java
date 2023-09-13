package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.videodownload.CyberVideoDownloader;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class wd4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static String i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, exc) == null) && wd4.a) {
                Log.e("SwanGameRevisitUtils", "请求配置信息失败，err = " + exc.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
                if (200 == i && !TextUtils.isEmpty(str)) {
                    try {
                        if (wd4.a) {
                            Log.d("SwanGameRevisitUtils", "回访引导配置信息 = " + str);
                        }
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.optInt("errno") == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.length() != 0) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray(wd4.i);
                            if (optJSONArray != null) {
                                vj3.a().putString(wd4.i, optJSONArray.toString());
                            }
                            String optString = optJSONObject.optString("version");
                            if (TextUtils.isEmpty(optString)) {
                                return;
                            }
                            JSONObject c = wd4.c();
                            if (c == null) {
                                wd4.r(optJSONObject);
                            } else if (TextUtils.equals(c.optString("version"), wd4.p(optString))) {
                                wd4.k(c);
                            } else {
                                wd4.i(optJSONObject, c);
                                wd4.j(optJSONObject, c);
                                wd4.r(optJSONObject);
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (wd4.a) {
                    Log.e("SwanGameRevisitUtils", "回访引导配置信息下发异常");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        public b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.put("version", wd4.p(this.a.optString("version")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                vj3.a().putString("swan_game_guide_toast", this.a.toString());
                wd4.k(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948266722, "Lcom/baidu/tieba/wd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948266722, "Lcom/baidu/tieba/wd4;");
                return;
            }
        }
        a = rr1.a;
        b = "bbaspg_guide_";
        c = "custom_guide_list";
        d = "appid";
        e = "shown_count";
        f = "image_index";
        g = "last_time";
        h = "reset";
        i = "duration_permission_list";
    }

    public static JSONObject n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            String string = vj3.a().getString("swan_game_guide_toast", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                return new JSONObject(string);
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public static /* synthetic */ JSONObject c() {
        return n();
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return x74.d() + File.separator + "guide_res";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String o(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            return l() + File.separator + str;
        }
        return (String) invokeL.objValue;
    }

    public static String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            return bp3.D() + "-" + str;
        }
        return (String) invokeL.objValue;
    }

    public static void i(JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65545, null, jSONObject, jSONObject2) == null) && jSONObject != null && jSONObject2 != null) {
            try {
                String optString = jSONObject.optString(b + h, "0");
                jSONObject2.optString(b + h, "-1");
                if (TextUtils.equals(optString, "1")) {
                    jSONObject.put(b + e, 0);
                    jSONObject.put(b + g, 0);
                    jSONObject.put(b + f, 0);
                } else {
                    jSONObject.put(b + e, jSONObject2.optInt(b + e, 0));
                    jSONObject.put(b + g, jSONObject2.optLong(b + g, 0L));
                }
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void j(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, null, jSONObject, jSONObject2) == null) && jSONObject != null && jSONObject2 != null && (optJSONArray = jSONObject2.optJSONArray(c)) != null && optJSONArray.length() > 0 && (optJSONArray2 = jSONObject.optJSONArray(c)) != null && optJSONArray2.length() > 0) {
            int length = optJSONArray2.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
                String optString = optJSONObject.optString(d, "");
                String optString2 = optJSONObject.optString(h, "0");
                int length2 = optJSONArray.length();
                int i3 = 0;
                while (true) {
                    if (i3 < length2) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                        String optString3 = optJSONObject2.optString(d, "-1");
                        String optString4 = optJSONObject2.optString(h, "0");
                        if (TextUtils.equals(optString3, optString)) {
                            try {
                                if (!TextUtils.equals(optString4, optString2)) {
                                    optJSONObject.put(e, "0");
                                    optJSONObject.put(g, "0");
                                    optJSONObject.put(f, "0");
                                } else {
                                    optJSONObject.put(e, jSONObject2.optString(e, "0"));
                                    optJSONObject.put(g, jSONObject2.optString(g, "0"));
                                    optJSONObject.put(f, jSONObject2.optString(f, "0"));
                                }
                            } catch (JSONException e2) {
                                if (a) {
                                    e2.printStackTrace();
                                }
                            }
                        } else {
                            i3++;
                        }
                    }
                }
            }
        }
    }

    public static void k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, jSONObject) == null) && jSONObject != null) {
            if (!TextUtils.isEmpty(jSONObject.optString(b + "zip"))) {
                String optString = jSONObject.optString(b + "zip");
                String m = m(optString);
                if (TextUtils.isEmpty(m)) {
                    return;
                }
                File file = new File(o(m));
                if (file.exists() && file.isDirectory() && file.length() > 0) {
                    if (a) {
                        Log.d("SwanGameRevisitUtils", optString + " 资源文件夹已存在");
                        return;
                    }
                    return;
                }
                lr4.L(file);
                y74.f().b(AppRuntime.getAppContext(), optString, m, l());
            }
        }
    }

    public static String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            if (TextUtils.isEmpty(lastPathSegment) || !lastPathSegment.contains(".zip")) {
                return null;
            }
            return lastPathSegment.replace(".zip", "");
        }
        return (String) invokeL.objValue;
    }

    public static void r(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65554, null, jSONObject) != null) || jSONObject == null) {
            return;
        }
        if (a) {
            Log.d("SwanGameRevisitUtils", "回访引导配置信息存入 = " + jSONObject);
        }
        bo3.k(new b(jSONObject), "swanGameGuideUpdateRunnable");
    }

    public static void q() {
        hb3 M;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65553, null) != null) || (M = hb3.M()) == null) {
            return;
        }
        M.i0().getRequest().url(y74.b().t()).cookieManager(ou2.q().a()).requestFrom(16).requestFrom(CyberVideoDownloader.DMDownloadError.Sys05).build().executeAsync(new a());
    }
}
