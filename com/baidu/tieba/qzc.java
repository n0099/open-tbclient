package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.CarrierEnter;
/* loaded from: classes8.dex */
public class qzc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull CarrierEnter carrierEnter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, carrierEnter)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "title", carrierEnter.title);
            ltc.a(jSONObject, "text", carrierEnter.text);
            ltc.a(jSONObject, "headline_cover", carrierEnter.headline_cover);
            ltc.a(jSONObject, "url", carrierEnter.url);
            ltc.a(jSONObject, "obj_id", carrierEnter.obj_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
