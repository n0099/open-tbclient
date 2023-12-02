package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class pb4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JSONObject a;

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
            this.a = new JSONObject();
        }

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                return new a();
            }
            return (a) invokeV.objValue;
        }

        public JSONObject b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (JSONObject) invokeV.objValue;
        }

        public a c(String str, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        this.a.put(str, obj);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            return (a) invokeLL.objValue;
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
        a = vm1.a;
    }

    public static void a(ub4 ub4Var, et2 et2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ub4Var, et2Var) == null) {
            a a2 = a.a();
            a2.c("mapId", ub4Var.j);
            a2.c("markerId", et2Var.a);
            JSONObject b = a2.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "callouttap");
                jSONObject.put("data", b.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, ub4Var.i);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            rl3.d(ub4Var.i, ub4Var.j, "map", "callouttap", jSONObject);
        }
    }

    public static void b(View view2, ub4 ub4Var) {
        String str;
        ct2 ct2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, view2, ub4Var) == null) {
            sb4 I = ub4Var.I(view2);
            if (I != null && (ct2Var = I.a) != null) {
                str = ct2Var.a;
            } else {
                str = "";
            }
            a a2 = a.a();
            a2.c("mapId", ub4Var.j);
            a2.c("controlId", str);
            JSONObject b = a2.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "controltap");
                jSONObject.put("data", b.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, ub4Var.i);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            rl3.d(ub4Var.i, ub4Var.j, "map", "controltap", jSONObject);
        }
    }

    public static void e(Marker marker, ub4 ub4Var) {
        String str;
        et2 et2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, marker, ub4Var) == null) {
            tb4 J = ub4Var.J(marker);
            if (J != null && (et2Var = J.a) != null) {
                str = et2Var.a;
            } else {
                str = "";
            }
            a a2 = a.a();
            a2.c("mapId", ub4Var.j);
            a2.c("markerId", str);
            JSONObject b = a2.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "markertap");
                jSONObject.put("data", b.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, ub4Var.i);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            rl3.d(ub4Var.i, ub4Var.j, "map", "markertap", jSONObject);
        }
    }

    public static void c(ub4 ub4Var, LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ub4Var, latLng) == null) {
            a a2 = a.a();
            a2.c("latitude", Double.valueOf(latLng.latitude));
            a2.c("longitude", Double.valueOf(latLng.longitude));
            JSONObject b = a2.b();
            a a3 = a.a();
            a3.c("mapId", ub4Var.j);
            a3.c(CriusAttrConstants.POSITION, b);
            JSONObject b2 = a3.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "tap");
                jSONObject.put("data", b2.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, ub4Var.i);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            rl3.d(ub4Var.i, ub4Var.j, "map", "tap", jSONObject);
        }
    }

    public static void d(ub4 ub4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ub4Var) == null) {
            a a2 = a.a();
            a2.c("mapId", ub4Var.j);
            JSONObject b = a2.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "updated");
                jSONObject.put("data", b.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, ub4Var.i);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            rl3.d(ub4Var.i, ub4Var.j, "map", "updated", jSONObject);
        }
    }

    public static void f(ub4 ub4Var, MapStatus mapStatus, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65542, null, ub4Var, mapStatus, i) == null) {
            a a2 = a.a();
            a2.c("latitude", Double.valueOf(mapStatus.bound.northeast.latitude));
            a2.c("longitude", Double.valueOf(mapStatus.bound.northeast.longitude));
            JSONObject b = a2.b();
            a a3 = a.a();
            a3.c("latitude", Double.valueOf(mapStatus.bound.southwest.latitude));
            a3.c("longitude", Double.valueOf(mapStatus.bound.southwest.longitude));
            JSONObject b2 = a3.b();
            a a4 = a.a();
            a4.c("mapId", ub4Var.j);
            a4.c("northeast", b);
            a4.c("southwest", b2);
            a4.c("scale", Float.valueOf(mapStatus.zoom));
            a4.c("reason", Integer.valueOf(i));
            JSONObject b3 = a4.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "regionchange");
                jSONObject.put("data", b3.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, ub4Var.i);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            rl3.d(ub4Var.i, ub4Var.j, "map", "regionchange", jSONObject);
        }
    }
}
