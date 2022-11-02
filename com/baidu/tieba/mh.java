package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class mh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(eh ehVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, ehVar) == null) && d() && ehVar != null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", ehVar.h());
                uBCManager.onEvent("3102", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(eh ehVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, ehVar) == null) && d() && ehVar != null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", ehVar.h());
                uBCManager.onEvent("3052", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void c(eh ehVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, ehVar) == null) && d() && ehVar != null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", ehVar.h());
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
            return gh.isOn();
        }
        return invokeV.booleanValue;
    }

    public static void e(nh nhVar, eh ehVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, nhVar, ehVar) == null) {
            if (nhVar instanceof ci) {
                c(ehVar);
            } else if (nhVar instanceof bi) {
                b(ehVar);
            } else if (nhVar instanceof ai) {
                a(ehVar);
            }
        }
    }
}
