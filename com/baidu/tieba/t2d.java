package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.TopbarEntrance;
/* loaded from: classes8.dex */
public class t2d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TopbarEntrance topbarEntrance) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topbarEntrance)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "guide_tip_first_text", topbarEntrance.guide_tip_first_text);
            ltc.a(jSONObject, "guide_tip_text", topbarEntrance.guide_tip_text);
            ltc.a(jSONObject, BigdayActivityConfig.JUMP_URL, topbarEntrance.jump_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
