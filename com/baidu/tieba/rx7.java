package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.VoiceRoom;
/* loaded from: classes7.dex */
public class rx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<nx7> a(List<VoiceRoom> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (VoiceRoom voiceRoom : list) {
                if (voiceRoom != null) {
                    ArrayList arrayList2 = new ArrayList();
                    nx7 nx7Var = new nx7();
                    nx7Var.a = voiceRoom.room_name;
                    nx7Var.c = String.valueOf(voiceRoom.talker_num);
                    nx7Var.d = String.valueOf(voiceRoom.joined_num);
                    nx7Var.e = voiceRoom.room_id.longValue();
                    for (User user : voiceRoom.talker) {
                        if (user != null) {
                            arrayList2.add(user.portrait);
                        }
                    }
                    nx7Var.b = arrayList2;
                    arrayList.add(nx7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
