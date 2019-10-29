package com.baidu.tieba.model.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.Share.ShareResIdl;
/* loaded from: classes.dex */
public class ShareReportSocketResponseMessage extends SocketResponsedMessage {
    private ShareResIdl idl;

    public ShareReportSocketResponseMessage() {
        super(CmdConfigSocket.CMD_SHARE_REPORT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.idl = (ShareResIdl) new Wire(new Class[0]).parseFrom(bArr, ShareResIdl.class);
    }

    public ShareResIdl getIdl() {
        return this.idl;
    }

    public void setIdl(ShareResIdl shareResIdl) {
        this.idl = shareResIdl;
    }
}
