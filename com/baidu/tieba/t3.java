package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class t3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w3 a;
    public Context b;
    public int c;

    public t3(Context context) {
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
        this.a = new x3(context);
        this.c = c4.b().a();
    }

    public final boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            ArrayList<r3> l = s3.n(this.b).l();
            if (l != null) {
                for (r3 r3Var : l) {
                    if (r3Var.c() == i) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String d = yw.d();
            if (!TextUtils.isEmpty(d)) {
                try {
                    JsonReader jsonReader = new JsonReader(new StringReader(d));
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader.nextName().equals("version")) {
                            return jsonReader.nextString();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return this.a.b();
        }
        return (String) invokeV.objValue;
    }

    public synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                JSONObject jSONObject = new JSONObject();
                String b = this.a.b();
                String config = this.a.getConfig();
                if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(config)) {
                    try {
                        jSONObject.put("version", b);
                        jSONObject.put("data", new JSONObject(config));
                        yw.j(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public w3 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (w3) invokeV.objValue;
    }

    public HashMap<String, r3> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            HashMap<String, r3> hashMap = new HashMap<>();
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
                                    r3 r3Var = new r3(i2, i3, j);
                                    hashMap.put(i2 + "_" + i3, r3Var);
                                }
                            }
                        }
                    }
                } catch (JSONException e) {
                    u3.b("V1DataProcessor", "parse config JSONException!", e);
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public List<a4> e(int i) {
        InterceptResult invokeI;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ArrayList arrayList = new ArrayList();
            String config = this.a.getConfig();
            if (!TextUtils.isEmpty(config)) {
                try {
                    JSONArray jSONArray = new JSONObject(config).getJSONArray("exps");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            if (jSONObject2 != null && (jSONObject = jSONObject2.getJSONObject("components_values")) != null) {
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    if (ix.a(next, this.c) == i) {
                                        arrayList.add(new a4(next, jSONObject.get(next)));
                                    }
                                }
                            }
                        }
                    }
                } catch (JSONException e) {
                    u3.b("V1DataProcessor", "parse config JSONException!", e);
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) && jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    String valueOf = String.valueOf(jSONObject.getLong("version"));
                    String b = b();
                    if (!b.equals(valueOf)) {
                        this.a.c(jSONObject.toString());
                        this.a.a(valueOf);
                    }
                    f(jSONObject);
                    if (AppConfig.isDebug()) {
                        u3.a("V1DataProcessor", "parse config old version  = " + b + ", curr version = " + valueOf);
                    }
                }
            } catch (JSONException e) {
                u3.b("V1DataProcessor", "parse config JSONException!", e);
            } catch (Exception e2) {
                u3.b("V1DataProcessor", "parse config Exception!", e2);
            }
        }
    }

    public void f(JSONObject jSONObject) {
        JSONArray jSONArray;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            try {
                String valueOf = String.valueOf(jSONObject.getLong("version"));
                JSONArray jSONArray2 = jSONObject.getJSONArray("exps");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("version", valueOf);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    jSONObject2.put("exps", jSONArray2);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    JSONObject jSONObject3 = new JSONObject();
                    int length = jSONArray2.length();
                    boolean z = false;
                    int i2 = 0;
                    while (i2 < length) {
                        JSONObject jSONObject4 = jSONArray2.getJSONObject(i2);
                        if (jSONObject4 != null) {
                            int i3 = jSONObject4.getInt("exp_id");
                            long j = jSONObject4.getLong("expired_time");
                            boolean z2 = jSONObject4.getBoolean("is_upload");
                            boolean optBoolean = jSONObject4.optBoolean("is_immediate", z);
                            int i4 = jSONObject4.getInt("components_key");
                            r3 r3Var = new r3(i3, i4, j, z2);
                            jSONArray = jSONArray2;
                            r3 r3Var2 = new r3(i3, i4, j, z2);
                            JSONObject jSONObject5 = jSONObject4.getJSONObject("components_values");
                            Iterator<String> keys = jSONObject5.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                int i5 = length;
                                Object obj = jSONObject5.get(next);
                                jSONObject3.put(next, obj);
                                JSONObject jSONObject6 = jSONObject5;
                                a4 a4Var = new a4(next, obj);
                                if (optBoolean) {
                                    arrayList.add(a4Var);
                                }
                                length = i5;
                                jSONObject5 = jSONObject6;
                            }
                            i = length;
                            if (!optBoolean) {
                                try {
                                    if (!a(i3)) {
                                        r3Var.f(false);
                                    }
                                } catch (JSONException e) {
                                    e = e;
                                    u3.b("V1DataProcessor", "parse config JSONException!", e);
                                    return;
                                } catch (Exception e2) {
                                    e = e2;
                                    u3.b("V1DataProcessor", "parse config Exception!", e);
                                    return;
                                }
                            }
                            arrayList2.add(r3Var);
                            if (z2 && currentTimeMillis <= j) {
                                arrayList3.add(r3Var2);
                            }
                        } else {
                            jSONArray = jSONArray2;
                            i = length;
                        }
                        i2++;
                        length = i;
                        jSONArray2 = jSONArray;
                        z = false;
                    }
                    yw.i(jSONObject2, jSONObject3, arrayList3);
                    if (AppConfig.isDebug()) {
                        Log.d("V1DataProcessor", "v1DataProcessor saveExpInfoList >> " + arrayList3.size());
                        Log.d("V1DataProcessor", "v1DataProcessor updateAddSwitchInfoList >> " + arrayList.size());
                    }
                    cx.a().b(arrayList, false);
                }
            } catch (JSONException e3) {
                e = e3;
            } catch (Exception e4) {
                e = e4;
            }
        }
    }
}
