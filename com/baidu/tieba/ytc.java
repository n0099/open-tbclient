package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AdMixFloor;
/* loaded from: classes9.dex */
public class ytc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AdMixFloor adMixFloor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adMixFloor)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, TiebaStatic.Params.AD_TYPE, adMixFloor.ad_type);
            ltc.a(jSONObject, "floor_num", adMixFloor.floor_num);
            ltc.a(jSONObject, LegoListActivityConfig.AD_ID, adMixFloor.ad_id);
            ltc.a(jSONObject, "advertise_id", adMixFloor.advertise_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
