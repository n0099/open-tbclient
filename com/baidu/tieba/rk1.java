package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String b = b();
            if (TextUtils.isEmpty(b)) {
                return 0;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray(b);
                for (int i = 0; i < jSONArray2.length(); i++) {
                    long optLong = jSONArray2.optLong(i);
                    if (c61.d(optLong, currentTimeMillis)) {
                        jSONArray.put(optLong);
                    }
                }
                g(jSONArray.toString());
                return jSONArray.length();
            } catch (JSONException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
    }

    @NonNull
    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return l31.a().b("splash_sp_name").getString("today_cpc_show_list", "");
        }
        return (String) invokeV.objValue;
    }

    public static long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return l31.a().b("splash_sp_name").getLong(TableDefine.BusiAdvAdBtnShowColumns.COLUMN_LAST_SHOW_TIME, 0L);
        }
        return invokeV.longValue;
    }

    public static JSONArray d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String string = l31.a().b("splash_sp_name").getString("today_show_list", "");
            JSONArray jSONArray = new JSONArray();
            if (TextUtils.isEmpty(string)) {
                return jSONArray;
            }
            try {
                JSONArray jSONArray2 = new JSONArray(string);
                for (int i = 0; i < jSONArray2.length(); i++) {
                    JSONObject optJSONObject = jSONArray2.optJSONObject(i);
                    try {
                        if (c61.d(Long.valueOf(optJSONObject.optString("t").split("_")[0]).longValue() * 1000, System.currentTimeMillis())) {
                            jSONArray.put(optJSONObject);
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            l31.a().b("splash_sp_name").i("today_show_list", jSONArray.toString(), false);
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public static void e(pk1 pk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pk1Var) == null) {
            l31.a().b("splash_sp_name").g(TableDefine.BusiAdvAdBtnShowColumns.COLUMN_LAST_SHOW_TIME, System.currentTimeMillis() / 1000);
            h(pk1Var);
            mk1.m().g();
        }
    }

    public static void g(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            l31.a().b("splash_sp_name").i("today_cpc_show_list", str, false);
        }
    }

    public static void f() {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            String b = b();
            try {
                if (TextUtils.isEmpty(b)) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(b);
                }
                jSONArray.put(System.currentTimeMillis());
                g(jSONArray.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void h(pk1 pk1Var) {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, null, pk1Var) != null) || pk1Var == null) {
            return;
        }
        if (pk1Var.k()) {
            f();
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        String string = l31.a().b("splash_sp_name").getString("today_show_list", "");
        try {
            if (TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(string);
            }
            boolean z = true;
            if (jSONArray.length() > 0) {
                int i = 0;
                while (true) {
                    if (i >= jSONArray.length()) {
                        break;
                    }
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (TextUtils.equals(optJSONObject.optString("k"), pk1Var.c)) {
                        optJSONObject.put("t", TextUtils.concat(valueOf, "_", optJSONObject.optString("t")).toString());
                        jSONArray.put(i, optJSONObject);
                        z = false;
                        break;
                    }
                    i++;
                }
            }
            if (z) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("k", pk1Var.c);
                jSONObject.put("t", valueOf);
                jSONArray.put(jSONObject);
            }
            l31.a().b("splash_sp_name").i("today_show_list", jSONArray.toString(), false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
