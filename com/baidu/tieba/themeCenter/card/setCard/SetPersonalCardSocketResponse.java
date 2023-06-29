package com.baidu.tieba.themeCenter.card.setCard;

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
import tbclient.SetCard.SetCardResIdl;
/* loaded from: classes8.dex */
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

    public long getCardId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.cardId;
        }
        return invokeV.longValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            SetCardResIdl setCardResIdl = (SetCardResIdl) new Wire(new Class[0]).parseFrom(bArr, SetCardResIdl.class);
            SetPersonalCardRequest setPersonalCardRequest = null;
            if (setCardResIdl == null) {
                return null;
            }
            Error error = setCardResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(setCardResIdl.error.usermsg);
            }
            if (getOrginalMessage() != null && getOrginalMessage().getExtra() != null) {
                setPersonalCardRequest = (SetPersonalCardRequest) getOrginalMessage().getExtra();
            }
            if (setPersonalCardRequest != null) {
                this.cardId = setPersonalCardRequest.getCardId();
                this.type = setPersonalCardRequest.getType();
            }
            return setCardResIdl;
        }
        return invokeIL.objValue;
    }
}
