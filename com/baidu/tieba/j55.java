package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "before_request");
                jSONObject.put("value", "1");
                uBCManager.onEvent("4509", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                jSONObject.put("value", "0");
                JSONObject jSONObject2 = new JSONObject();
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                jSONObject2.put("scheme", str);
                jSONObject.put("ext", jSONObject2);
                uBCManager.onEvent("4509", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                jSONObject.put("value", "1");
                JSONObject jSONObject2 = new JSONObject();
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                jSONObject2.put("scheme", str);
                jSONObject.put("ext", jSONObject2);
                uBCManager.onEvent("4509", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void d(boolean z, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65539, null, z, jSONObject) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("type", "request");
                jSONObject2.put("value", z ? "1" : "0");
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("slog", jSONObject != null ? jSONObject : "");
                jSONObject2.put("ext", jSONObject3);
                uBCManager.onEvent("4509", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
