package com.baidu.tieba.neighbors;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Person.DataRes;
import tbclient.Person.PersonResIdl;
/* loaded from: classes.dex */
public class ResponseGetNeighborsMessage extends SocketResponsedMessage {
    private DataRes mResource;

    public ResponseGetNeighborsMessage() {
        super(303004);
    }

    public DataRes getNeighborsData() {
        return this.mResource;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        PersonResIdl personResIdl = (PersonResIdl) new Wire(new Class[0]).parseFrom(bArr, PersonResIdl.class);
        if (personResIdl != null) {
            this.mResource = personResIdl.data;
        }
    }
}
