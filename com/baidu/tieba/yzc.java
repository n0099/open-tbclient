package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.McnAdInfo;
/* loaded from: classes9.dex */
public class yzc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull McnAdInfo mcnAdInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, mcnAdInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "ad_start_time", mcnAdInfo.ad_start_time);
            qoc.a(jSONObject, "ad_end_time", mcnAdInfo.ad_end_time);
            qoc.a(jSONObject, "pic_url", mcnAdInfo.pic_url);
            qoc.a(jSONObject, BigdayActivityConfig.JUMP_URL, mcnAdInfo.jump_url);
            qoc.a(jSONObject, "card_title", mcnAdInfo.card_title);
            qoc.a(jSONObject, "button_title", mcnAdInfo.button_title);
            qoc.a(jSONObject, "effect_time", mcnAdInfo.effect_time);
            qoc.a(jSONObject, "expire_time", mcnAdInfo.expire_time);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
