package com.baidu.tieba;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class mn0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final n31 a;
    public final Map<String, String> b;
    @NonNull
    public final Map<String, Map<String, String>> c;
    public volatile boolean d;

    public mn0() {
        String[] a;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ConcurrentHashMap(128);
        this.c = new ConcurrentHashMap(8);
        this.a = q31.a().b("nad.cold.launch.config");
        for (String str : tn0.a().a()) {
            String string = this.a.getString(str, null);
            if (string != null) {
                f31.e(this.b, str, string);
            }
        }
    }

    @NonNull
    public Map<String, String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (Map) invokeV.objValue;
    }

    @NonNull
    public Map<String, Map<String, String>> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (Map) invokeV.objValue;
    }

    public final void c(@NonNull JSONObject jSONObject) {
        String[] a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            this.b.clear();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                f31.e(this.b, next, jSONObject.optString(next));
            }
            SharedPreferences.Editor edit = this.a.edit();
            edit.clear();
            for (String str : tn0.a().a()) {
                String str2 = (String) f31.b(this.b, str);
                if (str2 != null) {
                    edit.putString(str, str2);
                }
            }
            edit.apply();
            SharedPreferences.Editor edit2 = q31.a().b("nad.launch.config.global").edit();
            edit2.clear();
            for (String str3 : this.b.keySet()) {
                String str4 = (String) f31.b(this.b, str3);
                if (str4 != null) {
                    edit2.putString(str3, str4);
                }
            }
            edit2.apply();
        }
    }

    public final void d(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            this.c.clear();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                HashMap hashMap = null;
                if (!TextUtils.isEmpty(optString)) {
                    hashMap = new HashMap(8);
                    JSONObject c = e31.c(optString);
                    Iterator<String> keys2 = c.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        f31.e(hashMap, next2, c.optString(next2));
                    }
                }
                if (hashMap != null) {
                    f31.e(this.c, next, hashMap);
                    q31 a = q31.a();
                    SharedPreferences.Editor edit = a.b("nad.launch.config." + next).edit();
                    edit.clear();
                    for (String str : hashMap.keySet()) {
                        String str2 = (String) hashMap.get(str);
                        if (str2 != null) {
                            edit.putString(str, str2);
                        }
                    }
                    edit.apply();
                }
            }
        }
    }

    public void update(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            String optString = jSONObject.optString("global");
            if (!TextUtils.isEmpty(optString)) {
                c(e31.c(optString));
            }
            String optString2 = jSONObject.optString("place_conf");
            if (!TextUtils.isEmpty(optString2)) {
                d(e31.c(optString2));
            }
        }
    }
}
