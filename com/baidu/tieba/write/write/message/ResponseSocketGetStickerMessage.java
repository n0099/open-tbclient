package com.baidu.tieba.write.write.message;

import GetSticker.DataRes;
import GetSticker.GetStickerResIdl;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
/* loaded from: classes5.dex */
public class ResponseSocketGetStickerMessage extends SocketResponsedMessage {
    public List<String> mUrlList;

    public ResponseSocketGetStickerMessage() {
        super(309475);
    }

    public List<String> getUrlList() {
        return this.mUrlList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        GetStickerResIdl getStickerResIdl = (GetStickerResIdl) new Wire(new Class[0]).parseFrom(bArr, GetStickerResIdl.class);
        if (getStickerResIdl == null) {
            return;
        }
        setError(getStickerResIdl.error.errorno.intValue());
        setErrorString(getStickerResIdl.error.usermsg);
        if (getError() != 0 || (dataRes = getStickerResIdl.data) == null) {
            return;
        }
        this.mUrlList = dataRes.pic_info;
    }
}
