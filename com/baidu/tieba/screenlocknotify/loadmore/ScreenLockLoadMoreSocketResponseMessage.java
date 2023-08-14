package com.baidu.tieba.screenlocknotify.loadmore;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a2a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetMoreMsg.DataRes;
import tbclient.GetMoreMsg.GetMoreMsgResIdl;
/* loaded from: classes7.dex */
public class ScreenLockLoadMoreSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a2a loadMoreData;

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

    public a2a getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.loadMoreData;
        }
        return (a2a) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetMoreMsgResIdl getMoreMsgResIdl = (GetMoreMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMoreMsgResIdl.class);
            if (getMoreMsgResIdl == null) {
                return null;
            }
            Error error = getMoreMsgResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getMoreMsgResIdl.error.errmsg);
            }
            DataRes dataRes = getMoreMsgResIdl.data;
            if (dataRes == null) {
                return getMoreMsgResIdl;
            }
            if (dataRes != null) {
                a2a a2aVar = new a2a();
                this.loadMoreData = a2aVar;
                a2aVar.c(getMoreMsgResIdl.data);
            }
            return getMoreMsgResIdl;
        }
        return invokeIL.objValue;
    }
}
