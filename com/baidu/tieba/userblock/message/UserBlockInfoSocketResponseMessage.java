package com.baidu.tieba.userblock.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetUserBlackInfo.DataRes;
import tbclient.GetUserBlackInfo.GetUserBlackInfoResIdl;
/* loaded from: classes5.dex */
public class UserBlockInfoSocketResponseMessage extends SocketResponsedMessage {
    public DataRes mData;

    public UserBlockInfoSocketResponseMessage() {
        super(309698);
    }

    public DataRes getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        try {
            GetUserBlackInfoResIdl getUserBlackInfoResIdl = (GetUserBlackInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetUserBlackInfoResIdl.class);
            if (getUserBlackInfoResIdl != null && getUserBlackInfoResIdl.error != null) {
                setError(getUserBlackInfoResIdl.error.errorno.intValue());
                setErrorString(getUserBlackInfoResIdl.error.usermsg);
            }
            if (getUserBlackInfoResIdl != null) {
                this.mData = getUserBlackInfoResIdl.data;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            setError(-2);
        }
    }
}
