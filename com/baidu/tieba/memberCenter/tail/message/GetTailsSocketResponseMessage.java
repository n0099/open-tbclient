package com.baidu.tieba.memberCenter.tail.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.IDataResponseMessage;
import com.baidu.tieba.n79;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetTails.GetTailsResIdl;
/* loaded from: classes7.dex */
public class GetTailsSocketResponseMessage extends SocketResponsedMessage implements IDataResponseMessage<n79> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n79 resultData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTailsSocketResponseMessage() {
        super(305001);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public n79 getResultData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.resultData;
        }
        return (n79) invokeV.objValue;
    }

    public static n79 getResult(ResponsedMessage<?> responsedMessage, int i, byte[] bArr) throws Exception {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, responsedMessage, i, bArr)) == null) {
            GetTailsResIdl getTailsResIdl = (GetTailsResIdl) new Wire(new Class[0]).parseFrom(bArr, GetTailsResIdl.class);
            if (getTailsResIdl == null) {
                return null;
            }
            Error error = getTailsResIdl.error;
            if (error != null) {
                responsedMessage.setError(error.errorno.intValue());
                responsedMessage.setErrorString(getTailsResIdl.error.errmsg);
            }
            if (getTailsResIdl.data == null) {
                return null;
            }
            n79 n79Var = new n79();
            n79Var.d(getTailsResIdl.data);
            return n79Var;
        }
        return (n79) invokeLIL.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            n79 result = getResult(this, i, bArr);
            this.resultData = result;
            return result;
        }
        return invokeIL.objValue;
    }
}
