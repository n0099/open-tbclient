package com.baidu.tieba.screenlocknotify.loadmore;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.rf8;
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
    public rf8 loadMoreData;

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
            if (dataRes != null && dataRes != null) {
                rf8 rf8Var = new rf8();
                this.loadMoreData = rf8Var;
                rf8Var.c(getMoreMsgResIdl.data);
            }
            return getMoreMsgResIdl;
        }
        return invokeIL.objValue;
    }

    public rf8 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.loadMoreData : (rf8) invokeV.objValue;
    }
}
