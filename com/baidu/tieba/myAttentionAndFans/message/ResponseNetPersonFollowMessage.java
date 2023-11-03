package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ca;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.ly4;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.yz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ResponseNetPersonFollowMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ly4 data;
    public int mErrCode;
    public String mErrMsg;
    public PersonListModel mModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseNetPersonFollowMessage(int i) {
        super(CmdConfigHttp.PIC_PERSONAL_LIST);
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
        this.mErrCode = 0;
        this.mErrMsg = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        PersonListModel personListModel;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            super.afterDispatchInBackGround(i, (int) bArr);
            if (getError() != 0 || (personListModel = this.mModel) == null) {
                return;
            }
            boolean z = true;
            if (personListModel.W() == 1 && (getOrginalMessage() instanceof HttpMessage)) {
                BdUniqueId tag = ((HttpMessage) getOrginalMessage()).getTag();
                z = (tag == null || !tag.equals(PersonListModel.FOLLOWME)) ? false : false;
                String str2 = new String(bArr);
                yz4.l();
                ca<String> m = yz4.m("tb.my_pages");
                if (m != null) {
                    if (z) {
                        str = "personal_followme";
                    } else {
                        str = "personal_myfollow";
                    }
                    m.e(str + "_" + this.mModel.getId(), str2, 604800000L);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0) {
                this.mErrCode = jSONObject.optInt("error_code");
                this.mErrMsg = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                ly4 ly4Var = new ly4();
                this.data = ly4Var;
                ly4Var.c(jSONObject);
            }
        }
    }

    public ly4 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.data;
        }
        return (ly4) invokeV.objValue;
    }

    public String getErrMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mErrMsg;
        }
        return (String) invokeV.objValue;
    }

    public int getErrNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mErrCode;
        }
        return invokeV.intValue;
    }

    public void setModel(PersonListModel personListModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, personListModel) == null) {
            this.mModel = personListModel;
        }
    }
}
