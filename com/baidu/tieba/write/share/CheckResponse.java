package com.baidu.tieba.write.share;

import b.a.r0.e4.p.c;
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
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class CheckResponse extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c mCheckResponseData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckResponse() {
        super(CmdConfigHttp.CMD_CHECK_SHARE_SDK);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) && i2 == 1003417 && jSONObject != null) {
            setError(jSONObject.optInt("error_code"));
            setErrorString(jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG));
            if (getError() != 0) {
                return;
            }
            c cVar = new c();
            this.mCheckResponseData = cVar;
            cVar.f17590a = jSONObject.optString("tbopen_app_key");
            this.mCheckResponseData.f17592c = jSONObject.optString("tbopen_app_name");
            this.mCheckResponseData.f17593d = jSONObject.optString("tbopen_app_icon");
            JSONObject optJSONObject = jSONObject.optJSONObject(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
            if (optJSONObject != null) {
                this.mCheckResponseData.j = optJSONObject.optString("default_pic");
            }
        }
    }

    public c getCheckResponseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCheckResponseData : (c) invokeV.objValue;
    }
}
