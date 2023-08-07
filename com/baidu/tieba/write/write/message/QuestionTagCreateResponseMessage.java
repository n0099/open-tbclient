package com.baidu.tieba.write.write.message;

import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.write.data.CreateTagResponseData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class QuestionTagCreateResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_SPECIAL_CHAR = 230049;
    public transient /* synthetic */ FieldHolder $fh;
    public CreateTagResponseData data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuestionTagCreateResponseMessage() {
        super(CmdConfigHttp.CMD_QUESTION_THREAD_CREATE_TAG);
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
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (jSONObject == null) {
                return;
            }
            setError(JavaTypesHelper.toInt(jSONObject.optString("errno"), 0));
            if (getError() == 230049) {
                setErrorString(jSONObject.optString("errmsg"));
            } else if (getError() != 0) {
                setErrorString(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0512));
            }
            if (getError() != 0) {
                return;
            }
            this.data = (CreateTagResponseData) DataExt.toEntity(jSONObject.toString(), CreateTagResponseData.class);
        }
    }
}
