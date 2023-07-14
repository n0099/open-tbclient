package com.baidu.tieba.personExtra;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.c45;
import com.baidu.tieba.o55;
import com.baidu.tieba.ye;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PersonFriendResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CACHETIME = 604800000;
    public transient /* synthetic */ FieldHolder $fh;
    public c45 data;
    public int errCode;
    public String resultString;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonFriendResponseMessage(int i) {
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
        this.errCode = -1;
        this.data = new c45();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) && isSuccess() && this.errCode == 0) {
            HttpMessage httpMessage = (HttpMessage) getOrginalMessage();
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = TbadkCoreApplication.getCurrentAccountObj().getID();
            } else {
                str = "";
            }
            if (httpMessage.getExtra() == null) {
                try {
                    String parseToString = parseToString(bArr);
                    if (parseToString != null) {
                        o55.e();
                        ye<String> f = o55.f("tb.my_pages");
                        if (f != null) {
                            f.e("personal_myfollow_" + str, parseToString, 604800000L);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
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
            if (statusCode == 200 && error >= 0 && jSONObject != null) {
                this.resultString = jSONObject.toString();
                this.errCode = jSONObject.optInt("error_code");
                this.data.b(jSONObject);
            }
        }
    }

    public int getErrCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.errCode;
        }
        return invokeV.intValue;
    }

    public c45 getPersonFriendData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.data;
        }
        return (c45) invokeV.objValue;
    }

    public String getResultString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.resultString;
        }
        return (String) invokeV.objValue;
    }

    public void setErrCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.errCode = i;
        }
    }

    public void setPersonFriendData(c45 c45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, c45Var) == null) {
            this.data = c45Var;
        }
    }

    public void setResultString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.resultString = str;
        }
    }
}
