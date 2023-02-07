package com.baidu.tieba.immessagecenter.chatgroup.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.dh;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatGroupInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ResponseHttpSubscribeGroupChatListMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ChatGroupInfo chatGroupInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseHttpSubscribeGroupChatListMessage() {
        super(CmdConfigHttp.CMD_GET_SUBSCRIBE_GROUP_CHAT_LIST);
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
    }

    public ChatGroupInfo getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.chatGroupInfo;
        }
        return (ChatGroupInfo) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048576, this, i, jSONObject) != null) || jSONObject == null) {
            return;
        }
        int statusCode = getStatusCode();
        int e = dh.e(jSONObject.optString("error_code"), -1);
        String optString = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
        setError(e);
        setErrorString(optString);
        if (statusCode == 200 && e == 0 && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            ChatGroupInfo chatGroupInfo = new ChatGroupInfo();
            this.chatGroupInfo = chatGroupInfo;
            chatGroupInfo.parse(optJSONObject);
        }
    }
}
