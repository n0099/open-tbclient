package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.open.SocialConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ServiceArea;
import tbclient.SmartApp;
/* loaded from: classes9.dex */
public class y2d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ServiceArea serviceArea) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, serviceArea)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "servicename", serviceArea.servicename);
            qoc.a(jSONObject, SocialConstants.PARAM_APP_ICON, serviceArea.picurl);
            qoc.a(jSONObject, "serviceurl", serviceArea.serviceurl);
            qoc.a(jSONObject, "version", serviceArea.version);
            qoc.a(jSONObject, TableDefine.MessageColumns.COLUME_SERVICE_TYPE, serviceArea.service_type);
            SmartApp smartApp = serviceArea.area_smart_app;
            if (smartApp != null) {
                qoc.a(jSONObject, "area_smart_app", k3d.b(smartApp));
            }
            qoc.a(jSONObject, "schema", serviceArea.schema);
            if (serviceArea.third_statistics_url != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : serviceArea.third_statistics_url) {
                    jSONArray.put(str);
                }
                qoc.a(jSONObject, "third_statistics_url", jSONArray);
            }
            qoc.a(jSONObject, "tag", serviceArea.tag);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
