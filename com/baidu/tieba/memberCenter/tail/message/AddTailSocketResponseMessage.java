package com.baidu.tieba.memberCenter.tail.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.IDataResponseMessage;
import com.baidu.tieba.rn7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.AddTail.AddTailResIdl;
import tbclient.Error;
/* loaded from: classes5.dex */
public class AddTailSocketResponseMessage extends SocketResponsedMessage implements IDataResponseMessage<rn7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rn7 resultData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddTailSocketResponseMessage() {
        super(305101);
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

    public static rn7 getResult(ResponsedMessage<?> responsedMessage, int i, byte[] bArr) throws Exception {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, responsedMessage, i, bArr)) == null) {
            AddTailResIdl addTailResIdl = (AddTailResIdl) new Wire(new Class[0]).parseFrom(bArr, AddTailResIdl.class);
            if (addTailResIdl == null) {
                return null;
            }
            Error error = addTailResIdl.error;
            if (error != null) {
                responsedMessage.setError(error.errorno.intValue());
                responsedMessage.setErrorString(addTailResIdl.error.errmsg);
            }
            if (addTailResIdl.data == null) {
                return null;
            }
            rn7 rn7Var = new rn7();
            rn7Var.b(addTailResIdl.data);
            return rn7Var;
        }
        return (rn7) invokeLIL.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            rn7 result = getResult(this, i, bArr);
            this.resultData = result;
            return result;
        }
        return invokeIL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.IDataResponseMessage
    public rn7 getResultData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.resultData : (rn7) invokeV.objValue;
    }
}
