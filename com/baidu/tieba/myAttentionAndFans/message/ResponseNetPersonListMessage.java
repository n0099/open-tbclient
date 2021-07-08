package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.d.l;
import d.a.o0.r.q.h1;
import d.a.o0.r.r.a;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ResponseNetPersonListMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h1 data;
    public int mErrCode;
    public String mErrMsg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseNetPersonListMessage(int i2) {
        super(CmdConfigHttp.PIC_PERSONAL_LIST);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mErrCode = 0;
        this.mErrMsg = "";
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0) {
                this.mErrCode = jSONObject.optInt("error_code");
                this.mErrMsg = jSONObject.optString("error_msg");
                h1 h1Var = new h1();
                this.data = h1Var;
                h1Var.c(jSONObject);
            }
        }
    }

    public h1 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.data : (h1) invokeV.objValue;
    }

    public String getErrMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mErrMsg : (String) invokeV.objValue;
    }

    public int getErrNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mErrCode : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            super.afterDispatchInBackGround(i2, (int) bArr);
            if (getError() == 0 && (getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) getOrginalMessage();
                BdUniqueId tag = httpMessage.getTag();
                Map map = (Map) httpMessage.getExtra();
                if (map == null) {
                    return;
                }
                if ((map.get("page") == null || map.get("page").equals("0")) && map.get("id") != null) {
                    boolean z = tag != null && tag.equals(PersonListModel.FOLLOWME);
                    String str = new String(bArr);
                    l<String> g2 = a.f().g("tb.my_pages");
                    if (g2 != null) {
                        String str2 = z ? "personal_followme" : "personal_myfollow";
                        g2.e(str2 + "_" + map.get("id"), str, 604800000L);
                    }
                }
            }
        }
    }
}
