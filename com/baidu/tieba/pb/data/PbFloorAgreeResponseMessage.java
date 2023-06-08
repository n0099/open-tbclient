package com.baidu.tieba.pb.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.n29;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PbFloorAgreeResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isFirstAgree;
    public CustomDialogData mActDialogData;
    public ContriInfo mContriInfo;
    public int mScore;
    public AuthTokenData tokenData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFloorAgreeResponseMessage(int i) {
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
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode != 200 || error < 0 || jSONObject == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("agree");
            if (optJSONObject2 != null) {
                this.mScore = optJSONObject2.optInt("score");
                boolean z = true;
                if (optJSONObject2.optInt("is_first_agree") != 1) {
                    z = false;
                }
                this.isFirstAgree = z;
            }
            this.mActDialogData = n29.a(optJSONObject);
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("contri_info");
            ContriInfo contriInfo = new ContriInfo();
            this.mContriInfo = contriInfo;
            contriInfo.parseJson(optJSONObject3);
            this.tokenData = AuthTokenData.parse(jSONObject);
        }
    }

    public CustomDialogData getActivityDialogData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mActDialogData;
        }
        return (CustomDialogData) invokeV.objValue;
    }

    public ContriInfo getContriInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mContriInfo;
        }
        return (ContriInfo) invokeV.objValue;
    }

    public int getScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mScore;
        }
        return invokeV.intValue;
    }

    public AuthTokenData getTokenData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.tokenData;
        }
        return (AuthTokenData) invokeV.objValue;
    }

    public boolean isFirstAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.isFirstAgree;
        }
        return invokeV.booleanValue;
    }

    public void setContriInfo(ContriInfo contriInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, contriInfo) == null) {
            this.mContriInfo = contriInfo;
        }
    }
}
