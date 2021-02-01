package com.baidu.tieba.themeCenter.card.setCard;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.SetCard.SetCardResIdl;
/* loaded from: classes9.dex */
public class SetPersonalCardSocketResponse extends SocketResponsedMessage {
    private long cardId;
    private int type;

    public SetPersonalCardSocketResponse() {
        super(CmdConfigSocket.CMD_SET_PERSONAL_CARD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
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
