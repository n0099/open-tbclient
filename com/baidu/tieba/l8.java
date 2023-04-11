package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class l8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n8 a;
    public Context b;
    public int c;

    public l8(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = context;
        this.a = new o8(context);
        this.c = t8.b().a();
    }

    public n8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (n8) invokeV.objValue;
    }

    public HashMap<String, j8> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            HashMap<String, j8> hashMap = new HashMap<>();
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONArray jSONArray = new JSONObject(str).getJSONArray("exps");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            if (jSONObject != null) {
                                int i2 = jSONObject.getInt("exp_id");
                                long j = jSONObject.getLong("expired_time");
                                int i3 = jSONObject.getInt("components_key");
                                if (System.currentTimeMillis() / 1000 <= j) {
                                    j8 j8Var = new j8(i2, i3, j);
                                    hashMap.put(i2 + "_" + i3, j8Var);
                                }
                            }
                        }
                    }
                } catch (JSONException e) {
                    m8.a("V1DataProcessor", "parse config JSONException!", e);
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public List<r8> c(int i) {
        InterceptResult invokeI;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            ArrayList arrayList = new ArrayList();
            String d = this.a.d();
            if (!TextUtils.isEmpty(d)) {
                try {
                    JSONArray jSONArray = new JSONObject(d).getJSONArray("exps");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            if (jSONObject2 != null && (jSONObject = jSONObject2.getJSONObject("components_values")) != null) {
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    if (t10.a(next, this.c) == i) {
                                        arrayList.add(new r8(next, jSONObject.get(next)));
                                    }
                                }
                            }
                        }
                    }
                } catch (JSONException e) {
                    m8.a("V1DataProcessor", "parse config JSONException!", e);
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                JSONObject jSONObject = new JSONObject();
                String e = this.a.e();
                String d = this.a.d();
                if (!TextUtils.isEmpty(e) && !TextUtils.isEmpty(d)) {
                    try {
                        jSONObject.put("version", e);
                        jSONObject.put("data", new JSONObject(d));
                        k10.i(jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
