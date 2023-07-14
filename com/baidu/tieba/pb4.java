package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.dto.IsShowRealNameGuideDTO;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.tieba.gc3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.CfgFileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class pb4 extends ec3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public b c;
    public c d;
    public String e;
    public j84 f;
    public ia4 g;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;

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

        public static a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return new a();
            }
            return (a) invokeV.objValue;
        }

        public static a b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return c();
                }
                a aVar = new a();
                aVar.b = jSONObject.optString("root");
                aVar.a = jSONObject.optString("name");
                if (!TextUtils.isEmpty(aVar.b) && !TextUtils.isEmpty(aVar.a)) {
                    if (aVar.b.endsWith(".js")) {
                        String[] split = aVar.b.split(File.separator);
                        if (split.length < 1) {
                            return c();
                        }
                        aVar.d = split[split.length - 1];
                        aVar.c = "";
                        for (int i = 0; i < split.length - 1; i++) {
                            aVar.c += split[i] + File.separator;
                        }
                    } else {
                        String str = aVar.b;
                        aVar.c = str;
                        if (!str.endsWith(File.separator)) {
                            aVar.c += File.separator;
                        }
                        aVar.d = "index.js";
                    }
                    return aVar;
                }
                return c();
            }
            return (a) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<a> a;
        public HashMap<String, Boolean> b;

        public b() {
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

        public static b c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                b bVar = new b();
                bVar.a = new ArrayList();
                bVar.b = new HashMap<>();
                return bVar;
            }
            return (b) invokeV.objValue;
        }

        public static b b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return c();
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    b bVar = new b();
                    bVar.a = new ArrayList();
                    bVar.b = new HashMap<>();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            bVar.a.add(a.b(optJSONObject));
                        }
                    }
                    return bVar;
                }
                return c();
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap<String, String> a;

        public c() {
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

        public static c c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                c cVar = new c();
                cVar.a = new HashMap<>();
                return cVar;
            }
            return (c) invokeV.objValue;
        }

        public static c b(JSONObject jSONObject, b bVar) {
            InterceptResult invokeLL;
            List<a> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
                if (jSONObject != null && bVar != null && (list = bVar.a) != null && list.size() > 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                    if (optJSONObject == null) {
                        return c();
                    }
                    c cVar = new c();
                    cVar.a = new HashMap<>();
                    for (a aVar : bVar.a) {
                        if (aVar != null && !TextUtils.isEmpty(aVar.b)) {
                            HashMap<String, String> hashMap = cVar.a;
                            String str = aVar.b;
                            hashMap.put(str, optJSONObject.optString(str));
                        }
                    }
                    return cVar;
                }
                return c();
            }
            return (c) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948056263, "Lcom/baidu/tieba/pb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948056263, "Lcom/baidu/tieba/pb4;");
                return;
            }
        }
        h = fs1.a;
    }

    public pb4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static pb4 a(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            pb4 pb4Var = new pb4();
            try {
                JSONObject jSONObject = new JSONObject(str);
                pb4Var.a = gc3.a.a(jSONObject);
                String optString = jSONObject.optString("deviceOrientation", "portrait");
                boolean z = false;
                pb4Var.b = 0;
                if (TextUtils.equals(optString, "landscape")) {
                    pb4Var.b = 1;
                }
                jSONObject.optBoolean("showStatusBar", false);
                jSONObject.optString("workers");
                b b2 = b.b(jSONObject);
                pb4Var.c = b2;
                pb4Var.d = c.b(jSONObject, b2);
                pb4Var.e = jSONObject.optString("openDataContext");
                pb4Var.f = new j84(jSONObject);
                JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    z = true;
                }
                HybridUbcFlow p = a53.p("startup");
                if (z) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                p.D("preload_resources", str2);
                pb4Var.g = new ia4(optJSONArray);
                JSONObject optJSONObject = jSONObject.optJSONObject(IsShowRealNameGuideDTO.TYPE_SETTING);
                if (optJSONObject != null) {
                    optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
                }
                return pb4Var;
            } catch (JSONException e) {
                if (h) {
                    Log.e("SwanGameConfigData", "buildConfigData json error: " + Log.getStackTraceString(e));
                }
                return null;
            }
        }
        return (pb4) invokeL.objValue;
    }
}
