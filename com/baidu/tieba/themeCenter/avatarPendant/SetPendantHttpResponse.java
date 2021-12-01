package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.SetPendant.SetPendantResIdl;
/* loaded from: classes11.dex */
public class SetPendantHttpResponse extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int freeUseLevel;
    public long pendantId;
    public int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetPendantHttpResponse(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public int getFreeUseLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.freeUseLevel : invokeV.intValue;
    }

    public long getPendantId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.pendantId : invokeV.longValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.type : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        SetPendantResIdl setPendantResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (setPendantResIdl = (SetPendantResIdl) new Wire(new Class[0]).parseFrom(bArr, SetPendantResIdl.class)) == null) {
            return;
        }
        Error error = setPendantResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(setPendantResIdl.error.usermsg);
        }
        SetPendantRequest setPendantRequest = null;
        if (getOrginalMessage() != null && getOrginalMessage().getExtra() != null) {
            setPendantRequest = (SetPendantRequest) getOrginalMessage().getExtra();
        }
        if (setPendantRequest != null) {
            this.pendantId = setPendantRequest.getPendantId();
            this.type = setPendantRequest.getType();
            this.freeUseLevel = setPendantRequest.getFreeUseLevel();
            setPendantRequest.getFreeUseLevel();
        }
    }
}
