package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class vy2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final List<ty2> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948257050, "Lcom/baidu/tieba/vy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948257050, "Lcom/baidu/tieba/vy2;");
                return;
            }
        }
        a = u73.v;
        b = Arrays.asList(new ty2());
    }

    @NonNull
    public static JSONObject b() {
        JSONObject jSONObject;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                jSONObject = a();
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                    u42.k("SwanNaUseMapManager", ">>> NAUseMapException: " + e.getMessage());
                }
                jSONObject = null;
            }
            if (jSONObject == null) {
                return new JSONObject();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            JSONObject jSONObject = new JSONObject("{\"pages\":{},\"window\":{\"navigationBarBackgroundColor\":{},\"navigationBarTextStyle\":{},\"navigationBarTitleText\":{},\"navigationStyle\":{},\"backgroundColor\":{},\"backgroundTextStyle\":{},\"enablePullDownRefresh\":{},\"onReachBottomDistance\":{}},\"networkTimeout\":{\"request\":{},\"connectSocket\":{},\"uploadFile\":{},\"downloadFile\":{}},\"tabBar\":{\"color\":{},\"backgroundColor\":{},\"borderStyle\":{},\"list\":{},\"selectedColor\":{}},\"swanCookie\":{}}");
            if (a) {
                u42.i("SwanNaUseMapManager", ">>> before intercept: " + jSONObject);
            }
            c(jSONObject);
            if (a) {
                u42.i("SwanNaUseMapManager", ">>> after intercept: " + jSONObject);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, jSONObject) == null) && jSONObject != null && jSONObject.length() != 0) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                for (ty2 ty2Var : b) {
                    if (ty2Var.a(keys.next())) {
                        keys.remove();
                    }
                }
            }
        }
    }
}
