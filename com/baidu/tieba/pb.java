package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class pb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void a(BdStatsItem bdStatsItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, bdStatsItem) == null) && d() && bdStatsItem != null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", bdStatsItem.toJSONObject());
                uBCManager.onEvent("3102", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(BdStatsItem bdStatsItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, bdStatsItem) == null) && d() && bdStatsItem != null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", bdStatsItem.toJSONObject());
                uBCManager.onEvent("3052", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void c(BdStatsItem bdStatsItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, bdStatsItem) == null) && d() && bdStatsItem != null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", bdStatsItem.toJSONObject());
                uBCManager.onEvent("3103", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void e(qb qbVar, BdStatsItem bdStatsItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, qbVar, bdStatsItem) == null) {
            if (qbVar instanceof fc) {
                c(bdStatsItem);
            } else if (qbVar instanceof ec) {
                b(bdStatsItem);
            } else if (qbVar instanceof cc) {
                a(bdStatsItem);
            }
        }
    }
}
