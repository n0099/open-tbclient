package com.baidu.tieba.themeCenter.card.setCard;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.SetCard.SetCardResIdl;
/* loaded from: classes5.dex */
public class SetPersonalCardHttpResponse extends TbHttpResponsedMessage {
    public long cardId;
    public int type;

    public SetPersonalCardHttpResponse(int i) {
        super(i);
    }

    public long getCardId() {
        return this.cardId;
    }

    public int getType() {
        return this.type;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SetCardResIdl setCardResIdl = (SetCardResIdl) new Wire(new Class[0]).parseFrom(bArr, SetCardResIdl.class);
        if (setCardResIdl == null) {
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
