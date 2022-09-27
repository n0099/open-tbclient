package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.VoiceRoom;
/* loaded from: classes6.dex */
public class tu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<pu6> a(List<VoiceRoom> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (VoiceRoom voiceRoom : list) {
                if (voiceRoom != null) {
                    ArrayList arrayList2 = new ArrayList();
                    pu6 pu6Var = new pu6();
                    pu6Var.a = voiceRoom.room_name;
                    pu6Var.c = String.valueOf(voiceRoom.talker_num);
                    pu6Var.d = String.valueOf(voiceRoom.joined_num);
                    pu6Var.e = voiceRoom.room_id.longValue();
                    for (User user : voiceRoom.talker) {
                        if (user != null) {
                            arrayList2.add(user.portrait);
                        }
                    }
                    pu6Var.b = arrayList2;
                    arrayList.add(pu6Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
