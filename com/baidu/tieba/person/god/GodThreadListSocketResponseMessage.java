package com.baidu.tieba.person.god;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GodThreadList.DataRes;
import tbclient.GodThreadList.GodThreadListResIdl;
/* loaded from: classes.dex */
public class GodThreadListSocketResponseMessage extends SocketResponsedMessage {
    private DataRes mData;

    public DataRes getData() {
        return this.mData;
    }

    public GodThreadListSocketResponseMessage() {
        super(309291);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        GodThreadListResIdl godThreadListResIdl = (GodThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, GodThreadListResIdl.class);
        if (godThreadListResIdl != null) {
            setError(godThreadListResIdl.error.errorno.intValue());
            setErrorString(godThreadListResIdl.error.usermsg);
        }
        if (getError() == 0) {
            this.mData = godThreadListResIdl.data;
        }
    }
}
