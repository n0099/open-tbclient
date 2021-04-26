package com.baidu.tieba.model.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.AddPollPost.AddPollPostResIdl;
/* loaded from: classes3.dex */
public class AddPollPostHttpResponseMessage extends TbHttpResponsedMessage {
    public AddPollPostResIdl idl;

    public AddPollPostHttpResponseMessage() {
        super(CmdConfigHttp.CMD_ADD_POLL_POST);
    }

    public AddPollPostResIdl getIdl() {
        return this.idl;
    }

    public void setIdl(AddPollPostResIdl addPollPostResIdl) {
        this.idl = addPollPostResIdl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        this.idl = (AddPollPostResIdl) new Wire(new Class[0]).parseFrom(bArr, AddPollPostResIdl.class);
    }
}
