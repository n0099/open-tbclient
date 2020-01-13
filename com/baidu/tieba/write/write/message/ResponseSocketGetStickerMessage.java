package com.baidu.tieba.write.write.message;

import GetSticker.GetStickerResIdl;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import java.util.List;
/* loaded from: classes11.dex */
public class ResponseSocketGetStickerMessage extends SocketResponsedMessage {
    private List<String> mUrlList;

    public ResponseSocketGetStickerMessage() {
        super(CmdConfigSocket.CMD_GET_STICKET_LIST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
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
