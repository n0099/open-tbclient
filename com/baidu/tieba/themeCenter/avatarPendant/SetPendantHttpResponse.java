package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SetPendant.SetPendantResIdl;
/* loaded from: classes9.dex */
public class SetPendantHttpResponse extends TbHttpResponsedMessage {
    private int freeUseLevel;
    private long pendantId;
    private int type;

    public SetPendantHttpResponse(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SetPendantResIdl setPendantResIdl = (SetPendantResIdl) new Wire(new Class[0]).parseFrom(bArr, SetPendantResIdl.class);
        if (setPendantResIdl != null) {
            if (setPendantResIdl.error != null) {
                setError(setPendantResIdl.error.errorno.intValue());
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

    public long getPendantId() {
        return this.pendantId;
    }

    public int getType() {
        return this.type;
    }

    public int getFreeUseLevel() {
        return this.freeUseLevel;
    }
}
