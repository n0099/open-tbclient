package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c87;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MsgReminderHttpRespMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c87 msgData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgReminderHttpRespMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.msgData = null;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("message");
                if (jSONObject != null) {
                    c87 c87Var = new c87();
                    c87Var.f(optJSONObject);
                    this.msgData = c87Var;
                }
            }
        }
    }

    public c87 getMsgData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.msgData : (c87) invokeV.objValue;
    }
}
