package com.baidu.tieba.model.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.AddPollPost.AddPollPostResIdl;
/* loaded from: classes2.dex */
public class AddPollPostHttpResponseMessage extends TbHttpResponsedMessage {
    private AddPollPostResIdl idl;

    public AddPollPostHttpResponseMessage() {
        super(CmdConfigHttp.CMD_ADD_POLL_POST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.idl = (AddPollPostResIdl) new Wire(new Class[0]).parseFrom(bArr, AddPollPostResIdl.class);
    }

    public AddPollPostResIdl getIdl() {
        return this.idl;
    }

    public void setIdl(AddPollPostResIdl addPollPostResIdl) {
        this.idl = addPollPostResIdl;
    }
}
