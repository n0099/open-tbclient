package com.baidu.tieba.myCollection.message;

import androidx.annotation.Nullable;
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
/* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCollectUpdateNum = 0;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            QueryCollectUpdateNumResIdl queryCollectUpdateNumResIdl = (QueryCollectUpdateNumResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryCollectUpdateNumResIdl.class);
            setError(queryCollectUpdateNumResIdl.error.errorno.intValue());
            setErrorString(queryCollectUpdateNumResIdl.error.usermsg);
            if (getError() == 0 && (dataRes = queryCollectUpdateNumResIdl.data) != null) {
                setCollectUpdateNum(dataRes.collect_update_num.intValue());
            }
            return queryCollectUpdateNumResIdl;
        }
        return invokeIL.objValue;
    }

    public int getCollectUpdateNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCollectUpdateNum : invokeV.intValue;
    }

    public void setCollectUpdateNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.mCollectUpdateNum = i;
        }
    }
}
