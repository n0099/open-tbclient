package com.baidu.tieba.themeCenter.card.setCard;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.SetCard.SetCardResIdl;
/* loaded from: classes7.dex */
public class SetPersonalCardSocketResponse extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long cardId;
    public int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetPersonalCardSocketResponse() {
        super(309345);
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

    public long getCardId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.cardId : invokeV.longValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.type : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        SetCardResIdl setCardResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (setCardResIdl = (SetCardResIdl) new Wire(new Class[0]).parseFrom(bArr, SetCardResIdl.class)) == null) {
            return;
        }
        Error error = setCardResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(setCardResIdl.error.usermsg);
        }
        SetPersonalCardRequest setPersonalCardRequest = null;
        if (getOrginalMessage() != null && getOrginalMessage().getExtra() != null) {
            setPersonalCardRequest = (SetPersonalCardRequest) getOrginalMessage().getExtra();
        }
        if (setPersonalCardRequest != null) {
            this.cardId = setPersonalCardRequest.getCardId();
            this.type = setPersonalCardRequest.getType();
        }
    }
}
