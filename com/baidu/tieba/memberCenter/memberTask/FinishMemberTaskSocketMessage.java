package com.baidu.tieba.memberCenter.memberTask;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.FinishMemberTask.DataRes;
import tbclient.FinishMemberTask.FinishMemberTaskResIdl;
/* loaded from: classes3.dex */
public class FinishMemberTaskSocketMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int status;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FinishMemberTaskSocketMessage() {
        super(309429);
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
            FinishMemberTaskResIdl finishMemberTaskResIdl = (FinishMemberTaskResIdl) new Wire(new Class[0]).parseFrom(bArr, FinishMemberTaskResIdl.class);
            if (finishMemberTaskResIdl == null) {
                return null;
            }
            Error error = finishMemberTaskResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(finishMemberTaskResIdl.error.errmsg);
            }
            DataRes dataRes = finishMemberTaskResIdl.data;
            if (dataRes == null) {
                return finishMemberTaskResIdl;
            }
            this.status = dataRes.status.intValue();
            return finishMemberTaskResIdl;
        }
        return invokeIL.objValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.status : invokeV.intValue;
    }
}
