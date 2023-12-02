package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes8.dex */
public class ws2 extends b22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dt2 j;
    public double k;
    public List<et2> l;
    public List<gt2> m;
    public List<bt2> n;
    public List<ct2> o;
    public List<dt2> p;
    public List<ft2> q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public String y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ws2() {
        super("map", "mapId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = 16.0d;
        this.r = true;
        this.y = "";
    }

    @Override // com.baidu.tieba.b22, com.baidu.tieba.jw2
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            String str = "markers";
            if (jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                dt2 dt2Var = new dt2();
                this.j = dt2Var;
                dt2Var.a(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.k = jSONObject.optDouble("scale", 16.0d);
            }
            jSONObject.optString("subkey", "");
            jSONObject.optString("layerStyle", "");
            this.y = jSONObject.optString("cb");
            this.r = jSONObject.optBoolean("showLocation", true);
            this.s = jSONObject.optBoolean("enableZoom", true);
            this.t = jSONObject.optBoolean("enableScroll", true);
            this.u = jSONObject.optBoolean("enableRotate", false);
            this.v = jSONObject.optBoolean("showCompass", false);
            this.w = jSONObject.optBoolean("enableOverlooking", false);
            this.x = jSONObject.optBoolean("enable3D", false);
            try {
                if (!jSONObject.has("markers")) {
                    str = "covers";
                }
                this.l = h(jSONObject, str, et2.class);
                this.n = h(jSONObject, "circles", bt2.class);
                this.m = h(jSONObject, "polyline", gt2.class);
                this.o = h(jSONObject, "controls", ct2.class);
                this.p = h(jSONObject, "includePoints", dt2.class);
                this.q = h(jSONObject, "polygons", ft2.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final <T extends jw2> List<T> h(JSONObject jSONObject, String str, Class<T> cls) throws IllegalAccessException, InstantiationException, JSONException {
        InterceptResult invokeLLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, str, cls)) == null) {
            if (jSONObject.has(str)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(str);
                if (optJSONArray == null) {
                    length = 0;
                } else {
                    length = optJSONArray.length();
                }
                if (length > 0) {
                    ArrayList arrayList = new ArrayList(length);
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            T newInstance = cls.newInstance();
                            newInstance.a(optJSONObject);
                            if (newInstance.isValid()) {
                                arrayList.add(newInstance);
                            }
                        }
                    }
                    return arrayList;
                }
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
