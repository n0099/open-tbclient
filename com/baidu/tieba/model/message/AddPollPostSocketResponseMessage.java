package com.baidu.tieba.model.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.AddPollPost.AddPollPostResIdl;
/* loaded from: classes.dex */
public class AddPollPostSocketResponseMessage extends SocketResponsedMessage {
    private AddPollPostResIdl idl;

    public AddPollPostSocketResponseMessage() {
        super(309006);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
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
