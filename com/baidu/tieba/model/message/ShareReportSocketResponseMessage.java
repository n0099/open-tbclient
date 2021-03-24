package com.baidu.tieba.model.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Share.ShareResIdl;
/* loaded from: classes3.dex */
public class ShareReportSocketResponseMessage extends SocketResponsedMessage {
    public ShareResIdl idl;

    public ShareReportSocketResponseMessage() {
        super(309480);
    }

    public ShareResIdl getIdl() {
        return this.idl;
    }

    public void setIdl(ShareResIdl shareResIdl) {
        this.idl = shareResIdl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.idl = (ShareResIdl) new Wire(new Class[0]).parseFrom(bArr, ShareResIdl.class);
    }
}
