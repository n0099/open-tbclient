package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.SetPendant.SetPendantResIdl;
/* loaded from: classes5.dex */
public class SetPendantSocketResponse extends SocketResponsedMessage {
    public int freeUseLevel;
    public long pendantId;
    public int type;

    public SetPendantSocketResponse() {
        super(309412);
    }

    public int getFreeUseLevel() {
        return this.freeUseLevel;
    }

    public long getPendantId() {
        return this.pendantId;
    }

    public int getType() {
        return this.type;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SetPendantResIdl setPendantResIdl = (SetPendantResIdl) new Wire(new Class[0]).parseFrom(bArr, SetPendantResIdl.class);
        if (setPendantResIdl == null) {
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
        }
    }
}
