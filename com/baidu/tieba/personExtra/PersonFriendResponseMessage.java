package com.baidu.tieba.personExtra;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.d.l;
import d.a.p0.s.q.g1;
import d.a.p0.s.r.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PersonFriendResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CACHETIME = 604800000;
    public transient /* synthetic */ FieldHolder $fh;
    public g1 data;
    public int errCode;
    public String resultString;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonFriendResponseMessage(int i2) {
        super(i2);
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
        this.errCode = -1;
        this.data = new g1();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode != 200 || error < 0 || jSONObject == null) {
                return;
            }
            this.resultString = jSONObject.toString();
            this.errCode = jSONObject.optInt("error_code");
            this.data.g(jSONObject);
        }
    }

    public int getErrCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.errCode : invokeV.intValue;
    }

    public g1 getPersonFriendData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.data : (g1) invokeV.objValue;
    }

    public String getResultString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.resultString : (String) invokeV.objValue;
    }

    public void setErrCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.errCode = i2;
        }
    }

    public void setPersonFriendData(g1 g1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, g1Var) == null) {
            this.data = g1Var;
        }
    }

    public void setResultString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.resultString = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i2, byte[] bArr) {
        l<String> g2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) && isSuccess() && this.errCode == 0) {
            HttpMessage httpMessage = (HttpMessage) getOrginalMessage();
            String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
            if (httpMessage.getExtra() == null) {
                try {
                    String parseToString = parseToString(bArr);
                    if (parseToString == null || (g2 = a.f().g("tb.my_pages")) == null) {
                        return;
                    }
                    g2.e("personal_myfollow_" + id, parseToString, 604800000L);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
