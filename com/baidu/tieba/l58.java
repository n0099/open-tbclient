package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mvc.data.IResponseData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.frs.voiceroom.data.VoiceRoomWrapper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.VoiceRoom;
import tbclient.VoiceRoomListPage.VoiceRoomListPageResIdl;
/* loaded from: classes7.dex */
public class l58 implements IResponseData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public List<ThreadInfo> a;

    public l58() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
    }

    @NonNull
    public List<VoiceRoomWrapper> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : this.a) {
                VoiceRoom voiceRoom = threadInfo.voice_room;
                if (voiceRoom != null && b(voiceRoom)) {
                    String str = threadInfo.fname;
                    if (str == null) {
                        str = "";
                    }
                    arrayList.add(new VoiceRoomWrapper(voiceRoom, str));
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean b(@NonNull VoiceRoom voiceRoom) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceRoom)) == null) {
            Long l = voiceRoom.room_id;
            if (l != null && l.longValue() != 0 && !TextUtils.isEmpty(voiceRoom.room_name)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.data.IResponseData
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("voice_room_list");
                if (optJSONArray != null) {
                    this.a = DataExt.toEntityList(optJSONArray.toString(), ThreadInfo.class);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.data.IResponseData
    public void initByProtobuf(Message message) {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, message) == null) && (message instanceof VoiceRoomListPageResIdl) && (list = ((VoiceRoomListPageResIdl) message).data.voice_room_list) != null) {
            this.a = list;
        }
    }
}
