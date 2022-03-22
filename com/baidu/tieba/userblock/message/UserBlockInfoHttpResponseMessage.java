package com.baidu.tieba.userblock.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.GetUserBlackInfo.DataRes;
import tbclient.GetUserBlackInfo.GetUserBlackInfoResIdl;
/* loaded from: classes6.dex */
public class UserBlockInfoHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserBlockInfoHttpResponseMessage() {
        super(CmdConfigHttp.CMD_GET_USER_BLOCK_INFO);
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

    public DataRes getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mData : (DataRes) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            try {
                GetUserBlackInfoResIdl getUserBlackInfoResIdl = (GetUserBlackInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetUserBlackInfoResIdl.class);
                if (getUserBlackInfoResIdl != null && getUserBlackInfoResIdl.error != null) {
                    setError(getUserBlackInfoResIdl.error.errorno.intValue());
                    setErrorString(getUserBlackInfoResIdl.error.usermsg);
                }
                if (getUserBlackInfoResIdl != null) {
                    this.mData = getUserBlackInfoResIdl.data;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                setError(-2);
            }
        }
    }
}
