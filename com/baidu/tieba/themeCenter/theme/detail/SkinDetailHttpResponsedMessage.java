package com.baidu.tieba.themeCenter.theme.detail;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetSkin.GetSkinResIdl;
/* loaded from: classes.dex */
public class SkinDetailHttpResponsedMessage extends TbHttpResponsedMessage {
    private com.baidu.tieba.themeCenter.b mSkinData;

    public SkinDetailHttpResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        GetSkinResIdl getSkinResIdl = (GetSkinResIdl) new Wire(new Class[0]).parseFrom(bArr, GetSkinResIdl.class);
        if (getSkinResIdl != null) {
            if (getSkinResIdl.error != null) {
                setError(getSkinResIdl.error.errorno.intValue());
                setErrorString(getSkinResIdl.error.usermsg);
            }
            if (getSkinResIdl.data != null) {
                SkinDetailReauestMessage skinDetailReauestMessage = null;
                if (getOrginalMessage() != null && getOrginalMessage().getExtra() != null) {
                    skinDetailReauestMessage = (SkinDetailReauestMessage) getOrginalMessage().getExtra();
                }
                this.mSkinData = new com.baidu.tieba.themeCenter.b();
                this.mSkinData.a(getSkinResIdl.data);
                this.mSkinData.setId(skinDetailReauestMessage.getThemeId());
            }
        }
    }

    public com.baidu.tieba.themeCenter.b getSkinData() {
        return this.mSkinData;
    }

    public void setmSkinData(com.baidu.tieba.themeCenter.b bVar) {
        this.mSkinData = bVar;
    }
}
