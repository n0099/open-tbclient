package com.baidu.tieba.themeCenter.card.detail;

import c.a.r0.d4.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetCard.GetCardResIdl;
/* loaded from: classes6.dex */
public class PersonalCardDetailHttpReponse extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a cardData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalCardDetailHttpReponse(int i2) {
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

    public a getCardData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.cardData : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetCardResIdl getCardResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (getCardResIdl = (GetCardResIdl) new Wire(new Class[0]).parseFrom(bArr, GetCardResIdl.class)) == null) {
            return;
        }
        Error error = getCardResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getCardResIdl.error.usermsg);
        }
        if (getCardResIdl.data == null) {
            return;
        }
        PersonalCardDetailRequest personalCardDetailRequest = null;
        if (getOrginalMessage() != null && getOrginalMessage().getExtra() != null) {
            personalCardDetailRequest = (PersonalCardDetailRequest) getOrginalMessage().getExtra();
        }
        a aVar = new a();
        this.cardData = aVar;
        if (personalCardDetailRequest != null) {
            aVar.m(personalCardDetailRequest.getCardId());
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
