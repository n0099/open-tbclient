package com.baidu.tieba.memberCenter.tail.message;

import c.a.t0.g2.h.a.c;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.IDataResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.DeleteTail.DeleteTailResIdl;
import tbclient.Error;
/* loaded from: classes12.dex */
public class DeleteTailSocketResponseMessage extends SocketResponsedMessage implements IDataResponseMessage<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c resultData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteTailSocketResponseMessage() {
        super(305103);
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

    public static c getResult(ResponsedMessage<?> responsedMessage, int i2, byte[] bArr) throws Exception {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, responsedMessage, i2, bArr)) == null) {
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
            c cVar = new c();
            cVar.b(deleteTailResIdl.data);
            return cVar;
        }
        return (c) invokeLIL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            this.resultData = getResult(this, i2, bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.IDataResponseMessage
    public c getResultData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.resultData : (c) invokeV.objValue;
    }
}
