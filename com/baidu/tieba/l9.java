package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.ABTestConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public l9() {
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
        this.a = k9.b().a();
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            for (String str : k9.b().f()) {
                try {
                    String optString = new JSONObject(k9.b().e(str)).optString("sid");
                    String[] split = optString.split("_");
                    if (split.length == 2) {
                        hashMap.put(optString, new a9(q20.d(split[0]), q20.d(split[1])));
                    }
                } catch (JSONException unused) {
                    if (ABTestConfig.isDebug()) {
                        Log.d("V2DataProcessor", "ABTest switchInfo string parse json error");
                    }
                }
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public HashMap b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    JSONObject optJSONObject = jSONObject.optJSONObject(keys.next());
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("sid");
                        String[] split = optString.split("_");
                        if (split.length == 2) {
                            hashMap.put(optString, new a9(q20.d(split[0]), q20.d(split[1])));
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public HashMap d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONArray jSONArray = new JSONObject(str).getJSONArray("data");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            String string = jSONArray.getString(i);
                            String[] split = string.split("_");
                            if (split.length == 2) {
                                hashMap.put(string, new a9(q20.d(split[0]), q20.d(split[1])));
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public List e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ArrayList arrayList = new ArrayList();
            for (String str : k9.b().f()) {
                if (r20.a(str, this.a) == i) {
                    try {
                        arrayList.add(new i9(str, new JSONObject(k9.b().e(str)).opt("data")));
                    } catch (JSONException unused) {
                        if (ABTestConfig.isDebug()) {
                            Log.d("V2DataProcessor", "ABTest switchInfo string parse json error");
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public HashMap c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashMap hashMap = new HashMap();
            String c = k9.b().c();
            if (!TextUtils.isEmpty(c)) {
                try {
                    JSONArray jSONArray = new JSONArray(c);
                    if (jSONArray.length() > 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            String string = jSONArray.getString(i);
                            String[] split = string.split("_");
                            if (split.length == 2) {
                                hashMap.put(string, new a9(q20.d(split[0]), q20.d(split[1])));
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                String d = k9.b().d();
                String c = k9.b().c();
                if (!TextUtils.isEmpty(c)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        JSONArray jSONArray = new JSONArray(c);
                        jSONObject.put("version", d);
                        jSONObject.put("exps", jSONArray);
                        i20.h(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                Set<String> f = k9.b().f();
                JSONObject jSONObject = new JSONObject();
                for (String str : f) {
                    try {
                        jSONObject.put(str, new JSONObject(k9.b().e(str)));
                    } catch (JSONException unused) {
                        if (ABTestConfig.isDebug()) {
                            Log.d("V2DataProcessor", "ABTest switchInfo string parse json error");
                        }
                    }
                }
                i20.k(jSONObject);
            }
        }
    }
}
