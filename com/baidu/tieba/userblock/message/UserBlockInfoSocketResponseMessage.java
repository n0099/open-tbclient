package com.baidu.tieba.userblock.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.GetUserBlackInfo.DataRes;
import tbclient.GetUserBlackInfo.GetUserBlackInfoResIdl;
/* loaded from: classes7.dex */
public class UserBlockInfoSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserBlockInfoSocketResponseMessage() {
        super(309698);
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

    public DataRes getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mData : (DataRes) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
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
