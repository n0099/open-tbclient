package com.baidu.tieba.memberCenter.tail.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.IDataResponseMessage;
import com.baidu.tieba.q99;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.DeleteTail.DeleteTailResIdl;
import tbclient.Error;
/* loaded from: classes7.dex */
public class DeleteTailSocketResponseMessage extends SocketResponsedMessage implements IDataResponseMessage<q99> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q99 resultData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteTailSocketResponseMessage() {
        super(305103);
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
    public q99 getResultData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.resultData;
        }
        return (q99) invokeV.objValue;
    }

    public static q99 getResult(ResponsedMessage<?> responsedMessage, int i, byte[] bArr) throws Exception {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, responsedMessage, i, bArr)) == null) {
            DeleteTailResIdl deleteTailResIdl = (DeleteTailResIdl) new Wire(new Class[0]).parseFrom(bArr, DeleteTailResIdl.class);
            if (deleteTailResIdl == null) {
                return null;
            }
            Error error = deleteTailResIdl.error;
            if (error != null) {
                responsedMessage.setError(error.errorno.intValue());
                responsedMessage.setErrorString(deleteTailResIdl.error.errmsg);
            }
            if (deleteTailResIdl.data == null) {
                return null;
            }
            q99 q99Var = new q99();
            q99Var.b(deleteTailResIdl.data);
            return q99Var;
        }
        return (q99) invokeLIL.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            q99 result = getResult(this, i, bArr);
            this.resultData = result;
            return result;
        }
        return invokeIL.objValue;
    }
}
