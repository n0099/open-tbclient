package com.baidu.tieba.themeCenter.card.detail;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gm8;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetCard.GetCardResIdl;
/* loaded from: classes4.dex */
public class PersonalCardDetailSocketReponse extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gm8 cardData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalCardDetailSocketReponse() {
        super(309333);
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

    public gm8 getCardData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.cardData : (gm8) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetCardResIdl getCardResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (getCardResIdl = (GetCardResIdl) new Wire(new Class[0]).parseFrom(bArr, GetCardResIdl.class)) == null) {
            return;
        }
        Error error = getCardResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getCardResIdl.error.usermsg);
            if (getCardResIdl.error.errorno.intValue() != 0) {
                return;
            }
        }
        if (getCardResIdl.data == null) {
            return;
        }
        PersonalCardDetailRequest personalCardDetailRequest = null;
        if (getOrginalMessage() != null && getOrginalMessage().getExtra() != null) {
            personalCardDetailRequest = (PersonalCardDetailRequest) getOrginalMessage().getExtra();
        }
        gm8 gm8Var = new gm8();
        this.cardData = gm8Var;
        if (personalCardDetailRequest != null) {
            gm8Var.m(personalCardDetailRequest.getCardId());
        }
        this.cardData.v(getCardResIdl.data.title);
        this.cardData.p(getCardResIdl.data.description);
        this.cardData.q(getCardResIdl.data.pic_url);
        this.cardData.u(getCardResIdl.data.permission);
        this.cardData.n(getCardResIdl.data.props_state_img);
        this.cardData.s(getCardResIdl.data.in_use.intValue());
        this.cardData.r(getCardResIdl.data.free_user_level.intValue());
        this.cardData.l(getCardResIdl.data.activity_url);
        this.cardData.t(getCardResIdl.data.is_finished.intValue());
        this.cardData.o(getCardResIdl.data.daily_privilege_status.intValue());
    }
}
