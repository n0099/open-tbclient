package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.LiveRoomInfo;
/* loaded from: classes8.dex */
public class uzc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LiveRoomInfo liveRoomInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, liveRoomInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "btn_title", liveRoomInfo.btn_title);
            qoc.a(jSONObject, "own_room_count", liveRoomInfo.own_room_count);
            qoc.a(jSONObject, BigdayActivityConfig.JUMP_URL, liveRoomInfo.jump_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
