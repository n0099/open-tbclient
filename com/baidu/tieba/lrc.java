package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.DealMedia;
/* loaded from: classes7.dex */
public class lrc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DealMedia dealMedia) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dealMedia)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "type", dealMedia.type);
            qoc.a(jSONObject, "small_pic", dealMedia.small_pic);
            qoc.a(jSONObject, "big_pic", dealMedia.big_pic);
            qoc.a(jSONObject, "water_pic", dealMedia.water_pic);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
