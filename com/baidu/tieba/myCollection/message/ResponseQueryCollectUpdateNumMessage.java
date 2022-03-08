package com.baidu.tieba.myCollection.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.QueryCollectUpdateNum.DataRes;
import tbclient.QueryCollectUpdateNum.QueryCollectUpdateNumResIdl;
/* loaded from: classes6.dex */
public class ResponseQueryCollectUpdateNumMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCollectUpdateNum;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseQueryCollectUpdateNumMessage() {
        super(303005);
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
        this.mCollectUpdateNum = 0;
    }

    public int getCollectUpdateNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCollectUpdateNum : invokeV.intValue;
    }

    public void setCollectUpdateNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.mCollectUpdateNum = i2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            QueryCollectUpdateNumResIdl queryCollectUpdateNumResIdl = (QueryCollectUpdateNumResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryCollectUpdateNumResIdl.class);
            setError(queryCollectUpdateNumResIdl.error.errorno.intValue());
            setErrorString(queryCollectUpdateNumResIdl.error.usermsg);
            if (getError() == 0 && (dataRes = queryCollectUpdateNumResIdl.data) != null) {
                setCollectUpdateNum(dataRes.collect_update_num.intValue());
            }
        }
    }
}
