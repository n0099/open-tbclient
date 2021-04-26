package com.baidu.tieba.model.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.AddPollPost.AddPollPostResIdl;
/* loaded from: classes3.dex */
public class AddPollPostSocketResponseMessage extends SocketResponsedMessage {
    public AddPollPostResIdl idl;

    public AddPollPostSocketResponseMessage() {
        super(309006);
    }

    public AddPollPostResIdl getIdl() {
        return this.idl;
    }

    public void setIdl(AddPollPostResIdl addPollPostResIdl) {
        this.idl = addPollPostResIdl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        this.idl = (AddPollPostResIdl) new Wire(new Class[0]).parseFrom(bArr, AddPollPostResIdl.class);
    }
}
