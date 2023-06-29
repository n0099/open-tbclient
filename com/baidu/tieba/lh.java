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
public class lh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(dh dhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, dhVar) == null) && d() && dhVar != null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", dhVar.h());
                uBCManager.onEvent("3102", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(dh dhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, dhVar) == null) && d() && dhVar != null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", dhVar.h());
                uBCManager.onEvent("3052", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void c(dh dhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, dhVar) == null) && d() && dhVar != null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", dhVar.h());
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
            return fh.isOn();
        }
        return invokeV.booleanValue;
    }

    public static void e(mh mhVar, dh dhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mhVar, dhVar) == null) {
            if (mhVar instanceof bi) {
                c(dhVar);
            } else if (mhVar instanceof ai) {
                b(dhVar);
            } else if (mhVar instanceof zh) {
                a(dhVar);
            }
        }
    }
}
