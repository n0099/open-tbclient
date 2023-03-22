package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class wg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(og ogVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, ogVar) == null) && d() && ogVar != null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", ogVar.h());
                uBCManager.onEvent("3102", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(og ogVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, ogVar) == null) && d() && ogVar != null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", ogVar.h());
                uBCManager.onEvent("3052", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void c(og ogVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, ogVar) == null) && d() && ogVar != null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", ogVar.h());
                uBCManager.onEvent("3103", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return qg.isOn();
        }
        return invokeV.booleanValue;
    }

    public static void e(xg xgVar, og ogVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, xgVar, ogVar) == null) {
            if (xgVar instanceof mh) {
                c(ogVar);
            } else if (xgVar instanceof lh) {
                b(ogVar);
            } else if (xgVar instanceof kh) {
                a(ogVar);
            }
        }
    }
}
