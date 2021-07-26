package com.baidu.tieba.videoplay.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class JumpYYLiveHttpResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public YyExtData mYyExtData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JumpYYLiveHttpResponseMessage() {
        super(CmdConfigHttp.CMD_JUMP_YY_LIVE_IN_VIDEO_LIST);
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
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) || getError() != 0 || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("yy_ext")) == null) {
            return;
        }
        YyExtData yyExtData = new YyExtData();
        this.mYyExtData = yyExtData;
        yyExtData.parserJson(optJSONObject);
    }

    public YyExtData getYyExtData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (isLegalYYLiveData()) {
                return this.mYyExtData;
            }
            return null;
        }
        return (YyExtData) invokeV.objValue;
    }

    public boolean isLegalYYLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            YyExtData yyExtData = this.mYyExtData;
            return (yyExtData == null || k.isEmpty(yyExtData.mSid) || k.isEmpty(this.mYyExtData.mSsid)) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
