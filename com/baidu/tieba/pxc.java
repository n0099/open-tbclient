package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.TopbarEntrance;
/* loaded from: classes7.dex */
public class pxc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TopbarEntrance topbarEntrance) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topbarEntrance)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "guide_tip_first_text", topbarEntrance.guide_tip_first_text);
            poc.a(jSONObject, "guide_tip_text", topbarEntrance.guide_tip_text);
            poc.a(jSONObject, BigdayActivityConfig.JUMP_URL, topbarEntrance.jump_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
