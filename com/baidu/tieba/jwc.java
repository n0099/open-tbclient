package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.DealMedia;
/* loaded from: classes6.dex */
public class jwc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DealMedia dealMedia) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dealMedia)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "type", dealMedia.type);
            ltc.a(jSONObject, "small_pic", dealMedia.small_pic);
            ltc.a(jSONObject, "big_pic", dealMedia.big_pic);
            ltc.a(jSONObject, "water_pic", dealMedia.water_pic);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
