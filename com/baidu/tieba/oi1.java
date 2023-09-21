package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface oi1 {
    void a(a aVar);

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;
        public long c;
        public long d;
        public long e;
        public String f;
        public int g;
        public List<C0405a> h;

        /* renamed from: com.baidu.tieba.oi1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0405a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;
            public String b;

            public C0405a() {
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

            public static C0405a a(JSONObject jSONObject) {
                InterceptResult invokeL;
                String optString;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                    if (jSONObject == null) {
                        return null;
                    }
                    C0405a c0405a = new C0405a();
                    String str = "";
                    if (jSONObject.isNull("promotionInsId")) {
                        optString = "";
                    } else {
                        optString = jSONObject.optString("promotionInsId");
                    }
                    c0405a.a = optString;
                    if (!jSONObject.isNull("valid")) {
                        str = jSONObject.optString("valid");
                    }
                    c0405a.b = str;
                    return c0405a;
                }
                return (C0405a) invokeL.objValue;
            }

            public static JSONObject b(C0405a c0405a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c0405a)) == null) {
                    if (c0405a == null) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("promotionInsId", c0405a.a);
                        jSONObject.put("valid", c0405a.b);
                    } catch (JSONException e) {
                        fi1.d(e.getMessage());
                    }
                    return jSONObject;
                }
                return (JSONObject) invokeL.objValue;
            }

            public static List<C0405a> c(JSONArray jSONArray) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONArray)) == null) {
                    if (jSONArray == null) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    try {
                        jSONArray.get(0);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(a((JSONObject) jSONArray.opt(i)));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return arrayList;
                }
                return (List) invokeL.objValue;
            }
        }

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
                    return;
                }
            }
            this.a = 2;
        }

        public static JSONObject a(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
                if (aVar == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("statusCode", aVar.a);
                    jSONObject.put("msg", aVar.b);
                    jSONObject.put("totalAmount", aVar.c);
                    jSONObject.put("userPayAmount", aVar.d);
                    jSONObject.put("reduceAmount", aVar.e);
                    jSONObject.put("overdueStatus", aVar.g);
                    jSONObject.put("usedHostMarketingDetail", aVar.f);
                    if (aVar.h != null && !aVar.h.isEmpty()) {
                        JSONArray jSONArray = new JSONArray();
                        for (C0405a c0405a : aVar.h) {
                            jSONArray.put(C0405a.b(c0405a));
                        }
                        jSONObject.put("promotionStatus", jSONArray);
                    }
                } catch (JSONException e) {
                    fi1.d(e.getMessage());
                }
                return jSONObject;
            }
            return (JSONObject) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "Data{statusCode=" + this.a + ", message='" + this.b + "', totalAmount=" + this.c + ", userPayAmount=" + this.d + ", reduceAmount=" + this.e + ", usedHostMarketingDetail='" + this.f + "', overdueStatus='" + this.g + "'}";
            }
            return (String) invokeV.objValue;
        }
    }
}
