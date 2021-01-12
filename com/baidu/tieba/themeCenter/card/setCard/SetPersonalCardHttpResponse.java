package com.baidu.tieba.themeCenter.card.setCard;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SetCard.SetCardResIdl;
/* loaded from: classes8.dex */
public class SetPersonalCardHttpResponse extends TbHttpResponsedMessage {
    private long cardId;
    private int type;

    public SetPersonalCardHttpResponse(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SetCardResIdl setCardResIdl = (SetCardResIdl) new Wire(new Class[0]).parseFrom(bArr, SetCardResIdl.class);
        if (setCardResIdl != null) {
            if (setCardResIdl.error != null) {
                setError(setCardResIdl.error.errorno.intValue());
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

    public long getCardId() {
        return this.cardId;
    }

    public int getType() {
        return this.type;
    }
}
