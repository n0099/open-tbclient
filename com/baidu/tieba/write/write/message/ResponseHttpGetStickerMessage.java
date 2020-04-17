package com.baidu.tieba.write.write.message;

import GetSticker.GetStickerResIdl;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
/* loaded from: classes2.dex */
public class ResponseHttpGetStickerMessage extends TbHttpResponsedMessage {
    private List<String> mUrlList;

    public ResponseHttpGetStickerMessage() {
        super(1003341);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetStickerResIdl getStickerResIdl = (GetStickerResIdl) new Wire(new Class[0]).parseFrom(bArr, GetStickerResIdl.class);
        if (getStickerResIdl != null) {
            setError(getStickerResIdl.error.errorno.intValue());
            setErrorString(getStickerResIdl.error.usermsg);
            if (getError() == 0 && getStickerResIdl.data != null) {
                this.mUrlList = getStickerResIdl.data.pic_info;
            }
        }
    }

    public List<String> getUrlList() {
        return this.mUrlList;
    }
}
