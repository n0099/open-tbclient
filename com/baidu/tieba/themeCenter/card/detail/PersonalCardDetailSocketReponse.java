package com.baidu.tieba.themeCenter.card.detail;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a4a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetCard.GetCardResIdl;
/* loaded from: classes7.dex */
public class PersonalCardDetailSocketReponse extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a4a cardData;

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

    public a4a getCardData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.cardData;
        }
        return (a4a) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetCardResIdl getCardResIdl = (GetCardResIdl) new Wire(new Class[0]).parseFrom(bArr, GetCardResIdl.class);
            PersonalCardDetailRequest personalCardDetailRequest = null;
            if (getCardResIdl == null) {
                return null;
            }
            Error error = getCardResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getCardResIdl.error.usermsg);
                if (getCardResIdl.error.errorno.intValue() != 0) {
                    return getCardResIdl;
                }
            }
            if (getCardResIdl.data == null) {
                return getCardResIdl;
            }
            if (getOrginalMessage() != null && getOrginalMessage().getExtra() != null) {
                personalCardDetailRequest = (PersonalCardDetailRequest) getOrginalMessage().getExtra();
            }
            a4a a4aVar = new a4a();
            this.cardData = a4aVar;
            if (personalCardDetailRequest != null) {
                a4aVar.m(personalCardDetailRequest.getCardId());
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
            return getCardResIdl;
        }
        return invokeIL.objValue;
    }
}
