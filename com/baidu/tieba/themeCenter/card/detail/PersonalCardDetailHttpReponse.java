package com.baidu.tieba.themeCenter.card.detail;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetCard.GetCardResIdl;
/* loaded from: classes8.dex */
public class PersonalCardDetailHttpReponse extends TbHttpResponsedMessage {
    private com.baidu.tieba.themeCenter.a cardData;

    public PersonalCardDetailHttpReponse(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetCardResIdl getCardResIdl = (GetCardResIdl) new Wire(new Class[0]).parseFrom(bArr, GetCardResIdl.class);
        if (getCardResIdl != null) {
            if (getCardResIdl.error != null) {
                setError(getCardResIdl.error.errorno.intValue());
                setErrorString(getCardResIdl.error.usermsg);
            }
            if (getCardResIdl.data != null) {
                PersonalCardDetailRequest personalCardDetailRequest = null;
                if (getOrginalMessage() != null && getOrginalMessage().getExtra() != null) {
                    personalCardDetailRequest = (PersonalCardDetailRequest) getOrginalMessage().getExtra();
                }
                this.cardData = new com.baidu.tieba.themeCenter.a();
                if (personalCardDetailRequest != null) {
                    this.cardData.setCardId(personalCardDetailRequest.getCardId());
                }
                this.cardData.setTitle(getCardResIdl.data.title);
                this.cardData.setDescription(getCardResIdl.data.description);
                this.cardData.ST(getCardResIdl.data.pic_url);
                this.cardData.SU(getCardResIdl.data.permission);
                this.cardData.SV(getCardResIdl.data.props_state_img);
                this.cardData.JJ(getCardResIdl.data.in_use.intValue());
                this.cardData.setFreeUserLevel(getCardResIdl.data.free_user_level.intValue());
                this.cardData.setActivityUrl(getCardResIdl.data.activity_url);
                this.cardData.JK(getCardResIdl.data.is_finished.intValue());
                this.cardData.setDailyPrevilegeStatus(getCardResIdl.data.daily_previlege_status.intValue());
            }
        }
    }

    public com.baidu.tieba.themeCenter.a getCardData() {
        return this.cardData;
    }
}
