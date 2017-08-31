package com.baidu.tieba.model.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Share.ShareResIdl;
/* loaded from: classes.dex */
public class ShareReportHttpResponseMessage extends TbHttpResponsedMessage {
    private ShareResIdl idl;

    public ShareReportHttpResponseMessage() {
        super(CmdConfigHttp.CMD_SHARE_REPORT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
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
