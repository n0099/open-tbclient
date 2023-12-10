package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.User;
import tbclient.VoiceRoom;
/* loaded from: classes7.dex */
public class kbd extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VoiceRoom voiceRoom) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, voiceRoom)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "room_id", voiceRoom.room_id);
            User user = voiceRoom.author;
            if (user != null) {
                ltc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, qad.b(user));
            }
            if (voiceRoom.talker != null) {
                JSONArray jSONArray = new JSONArray();
                for (User user2 : voiceRoom.talker) {
                    jSONArray.put(qad.b(user2));
                }
                ltc.a(jSONObject, "talker", jSONArray);
            }
            ltc.a(jSONObject, "joined_num", voiceRoom.joined_num);
            ltc.a(jSONObject, "talker_num", voiceRoom.talker_num);
            ltc.a(jSONObject, "status", voiceRoom.status);
            ltc.a(jSONObject, DpStatConstants.KEY_ROOM_NAME, voiceRoom.room_name);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
