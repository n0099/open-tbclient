package com.baidu.tieba.immessagecenter.chatgroup.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.d48;
import com.baidu.tieba.e48;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.gg;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatGroupInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ChatGroupListResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List mList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatGroupListResponseMessage() {
        super(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mList = new ArrayList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (jSONObject == null) {
                return;
            }
            int e = gg.e(jSONObject.optString("error_code"), -1);
            if (e == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(SpeedStatsUtils.UBC_VALUE_BANNER);
                    if (optJSONObject2 != null) {
                        e48 e48Var = new e48();
                        e48Var.f(optJSONObject2);
                        this.mList.add(e48Var);
                    }
                    JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject3 != null) {
                                ChatGroupInfo chatGroupInfo = new ChatGroupInfo();
                                chatGroupInfo.parse(optJSONObject3);
                                this.mList.add(chatGroupInfo);
                            }
                        }
                    }
                    JSONObject optJSONObject4 = optJSONObject.optJSONObject("footer");
                    if (optJSONObject4 != null) {
                        d48 d48Var = new d48();
                        d48Var.c(optJSONObject4);
                        this.mList.add(d48Var);
                        return;
                    }
                    return;
                }
                return;
            }
            setError(e);
            setErrorString(jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG));
        }
    }

    public List getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mList;
        }
        return (List) invokeV.objValue;
    }
}
