package com.baidu.tieba.person.god;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GodThreadList.DataRes;
import tbclient.GodThreadList.GodThreadListResIdl;
/* loaded from: classes.dex */
public class GodThreadListHttpResponseMessage extends TbHttpResponsedMessage {
    private DataRes mData;

    public DataRes getData() {
        return this.mData;
    }

    public GodThreadListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
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
