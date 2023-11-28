package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ActionControl;
import tbclient.AdCloseInfo;
/* loaded from: classes9.dex */
public class wtc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AdCloseInfo adCloseInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adCloseInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "support_close", adCloseInfo.support_close);
            ltc.a(jSONObject, "title", adCloseInfo.title);
            if (adCloseInfo.reasons != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : adCloseInfo.reasons) {
                    jSONArray.put(str);
                }
                ltc.a(jSONObject, "reasons", jSONArray);
            }
            ltc.a(jSONObject, "confirm_title", adCloseInfo.confirm_title);
            ActionControl actionControl = adCloseInfo.action_control;
            if (actionControl != null) {
                ltc.a(jSONObject, "action_control", ttc.b(actionControl));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
