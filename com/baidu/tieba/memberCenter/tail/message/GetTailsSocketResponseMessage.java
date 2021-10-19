package com.baidu.tieba.memberCenter.tail.message;

import c.a.r0.y1.h.a.d;
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
import tbclient.Error;
import tbclient.GetTails.GetTailsResIdl;
/* loaded from: classes7.dex */
public class GetTailsSocketResponseMessage extends SocketResponsedMessage implements IDataResponseMessage<d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d resultData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTailsSocketResponseMessage() {
        super(305001);
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

    public static d getResult(ResponsedMessage<?> responsedMessage, int i2, byte[] bArr) throws Exception {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, responsedMessage, i2, bArr)) == null) {
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
            d dVar = new d();
            dVar.c(getTailsResIdl.data);
            return dVar;
        }
        return (d) invokeLIL.objValue;
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
    public d getResultData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.resultData : (d) invokeV.objValue;
    }
}
