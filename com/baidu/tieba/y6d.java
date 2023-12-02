package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PsInfo;
/* loaded from: classes9.dex */
public class y6d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PsInfo psInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, psInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "game_id", psInfo.game_id);
            ktc.a(jSONObject, "score", psInfo.score);
            ktc.a(jSONObject, "game_type", psInfo.game_type);
            ktc.a(jSONObject, "game_pic_url", psInfo.game_pic_url);
            ktc.a(jSONObject, "game_intro", psInfo.game_intro);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
