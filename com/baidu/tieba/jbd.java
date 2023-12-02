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
/* loaded from: classes6.dex */
public class jbd extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VoiceRoom voiceRoom) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, voiceRoom)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "room_id", voiceRoom.room_id);
            User user = voiceRoom.author;
            if (user != null) {
                ktc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, pad.b(user));
            }
            if (voiceRoom.talker != null) {
                JSONArray jSONArray = new JSONArray();
                for (User user2 : voiceRoom.talker) {
                    jSONArray.put(pad.b(user2));
                }
                ktc.a(jSONObject, "talker", jSONArray);
            }
            ktc.a(jSONObject, "joined_num", voiceRoom.joined_num);
            ktc.a(jSONObject, "talker_num", voiceRoom.talker_num);
            ktc.a(jSONObject, "status", voiceRoom.status);
            ktc.a(jSONObject, DpStatConstants.KEY_ROOM_NAME, voiceRoom.room_name);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
