package com.baidu.tieba.usermute.response;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.UserMuteCheck.DataRes;
import tbclient.UserMuteCheck.UserMuteCheckResIdl;
/* loaded from: classes11.dex */
public class UserMuteCheckHttpResponsedMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes mResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserMuteCheckHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_USER_MUTE_CHECK);
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

    public DataRes getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mResult : (DataRes) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            UserMuteCheckResIdl userMuteCheckResIdl = (UserMuteCheckResIdl) new Wire(new Class[0]).parseFrom(bArr, UserMuteCheckResIdl.class);
            Error error = userMuteCheckResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(userMuteCheckResIdl.error.usermsg);
            }
            if (getError() == 0 && (dataRes = userMuteCheckResIdl.data) != null) {
                this.mResult = dataRes;
            }
        }
    }
}
