package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.VoiceRoom;
/* loaded from: classes8.dex */
public class tk6 extends rk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String S0;
    public List<String> T0;
    public String U0;
    public String V0;
    public long W0;

    public tk6(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (threadData == null) {
            return;
        }
        this.a = threadData;
        String str = threadData.tid;
        threadData.getTitle();
        VoiceRoom voiceRoomData = threadData.getVoiceRoomData();
        if (voiceRoomData != null) {
            this.S0 = voiceRoomData.room_name;
            this.T0 = a0(voiceRoomData);
            this.U0 = String.valueOf(voiceRoomData.talker_num);
            this.V0 = String.valueOf(voiceRoomData.joined_num);
            this.W0 = voiceRoomData.room_id.longValue();
        }
    }

    public static boolean R(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, threadData)) == null) {
            if (threadData != null && threadData.getVoiceRoomData() != null && threadData.getVoiceRoomData().room_id.longValue() > 0 && !StringUtils.isNull(threadData.getVoiceRoomData().room_name)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final List<String> a0(VoiceRoom voiceRoom) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, voiceRoom)) == null) {
            ArrayList arrayList = new ArrayList();
            for (User user : voiceRoom.talker) {
                if (user != null) {
                    arrayList.add(user.portrait);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.V0;
        }
        return (String) invokeV.objValue;
    }

    public List<String> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.T0;
        }
        return (List) invokeV.objValue;
    }

    public long X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.W0;
        }
        return invokeV.longValue;
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.S0;
        }
        return (String) invokeV.objValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.U0;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rk6, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.yh
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.B) {
                return rk6.K0;
            }
            return ThreadData.TYPE_CONTENT_VOICE_ROOM;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
