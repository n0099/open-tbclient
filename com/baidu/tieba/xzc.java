package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.McnAdInfo;
/* loaded from: classes9.dex */
public class xzc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull McnAdInfo mcnAdInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, mcnAdInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "ad_start_time", mcnAdInfo.ad_start_time);
            poc.a(jSONObject, "ad_end_time", mcnAdInfo.ad_end_time);
            poc.a(jSONObject, "pic_url", mcnAdInfo.pic_url);
            poc.a(jSONObject, BigdayActivityConfig.JUMP_URL, mcnAdInfo.jump_url);
            poc.a(jSONObject, "card_title", mcnAdInfo.card_title);
            poc.a(jSONObject, "button_title", mcnAdInfo.button_title);
            poc.a(jSONObject, "effect_time", mcnAdInfo.effect_time);
            poc.a(jSONObject, "expire_time", mcnAdInfo.expire_time);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
