package com.baidu.tieba.personExtra;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.fv9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PersonBarResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fv9 data;
    public int errCode;
    public String resultString;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonBarResponseMessage(int i) {
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
        this.errCode = 0;
        this.data = new fv9();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error >= 0 && jSONObject != null) {
                this.resultString = jSONObject.toString();
                this.errCode = jSONObject.optInt("error_code");
                this.data.o(jSONObject);
            }
        }
    }

    public int getErrCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.errCode;
        }
        return invokeV.intValue;
    }

    public fv9 getPersonBarData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.data;
        }
        return (fv9) invokeV.objValue;
    }

    public String getResultString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.resultString;
        }
        return (String) invokeV.objValue;
    }

    public void setErrCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.errCode = i;
        }
    }

    public void setPersonBarData(fv9 fv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fv9Var) == null) {
            this.data = fv9Var;
        }
    }

    public void setResultString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.resultString = str;
        }
    }
}
