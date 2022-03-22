package com.baidu.tieba.screenlocknotify.loadmore;

import c.a.p0.n3.e.a;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetMoreMsg.DataRes;
import tbclient.GetMoreMsg.GetMoreMsgResIdl;
/* loaded from: classes5.dex */
public class ScreenLockLoadMoreSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a loadMoreData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenLockLoadMoreSocketResponseMessage() {
        super(309420);
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

    public a getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.loadMoreData : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetMoreMsgResIdl getMoreMsgResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (getMoreMsgResIdl = (GetMoreMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMoreMsgResIdl.class)) == null) {
            return;
        }
        Error error = getMoreMsgResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getMoreMsgResIdl.error.errmsg);
        }
        DataRes dataRes = getMoreMsgResIdl.data;
        if (dataRes == null || dataRes == null) {
            return;
        }
        a aVar = new a();
        this.loadMoreData = aVar;
        aVar.c(getMoreMsgResIdl.data);
    }
}
