package com.baidu.tieba.write.share;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dw8;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CheckResponse extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dw8 mCheckResponseData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckResponse() {
        super(CmdConfigHttp.CMD_CHECK_SHARE_SDK);
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

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) && i == 1003417 && jSONObject != null) {
            setError(jSONObject.optInt("error_code"));
            setErrorString(jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG));
            if (getError() != 0) {
                return;
            }
            dw8 dw8Var = new dw8();
            this.mCheckResponseData = dw8Var;
            dw8Var.a = jSONObject.optString("tbopen_app_key");
            this.mCheckResponseData.c = jSONObject.optString("tbopen_app_name");
            this.mCheckResponseData.d = jSONObject.optString("tbopen_app_icon");
            JSONObject optJSONObject = jSONObject.optJSONObject(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
            if (optJSONObject != null) {
                this.mCheckResponseData.j = optJSONObject.optString("default_pic");
            }
        }
    }

    public dw8 getCheckResponseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCheckResponseData : (dw8) invokeV.objValue;
    }
}
