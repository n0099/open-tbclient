package com.baidu.tieba.themeCenter.card.detail;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.b.j0.j3.a;
import tbclient.Error;
import tbclient.GetCard.GetCardResIdl;
/* loaded from: classes5.dex */
public class PersonalCardDetailHttpReponse extends TbHttpResponsedMessage {
    public a cardData;

    public PersonalCardDetailHttpReponse(int i) {
        super(i);
    }

    public a getCardData() {
        return this.cardData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetCardResIdl getCardResIdl = (GetCardResIdl) new Wire(new Class[0]).parseFrom(bArr, GetCardResIdl.class);
        if (getCardResIdl == null) {
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
        this.cardData.o(getCardResIdl.data.daily_previlege_status.intValue());
    }
}
