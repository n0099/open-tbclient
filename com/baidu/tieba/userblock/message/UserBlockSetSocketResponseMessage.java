package com.baidu.tieba.userblock.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SetUserBlack.SetUserBlackResIdl;
/* loaded from: classes5.dex */
public class UserBlockSetSocketResponseMessage extends SocketResponsedMessage {
    public UserBlockSetSocketResponseMessage() {
        super(309697);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        try {
            SetUserBlackResIdl setUserBlackResIdl = (SetUserBlackResIdl) new Wire(new Class[0]).parseFrom(bArr, SetUserBlackResIdl.class);
            if (setUserBlackResIdl == null || setUserBlackResIdl.error == null) {
                return;
            }
            setError(setUserBlackResIdl.error.errorno.intValue());
            setErrorString(setUserBlackResIdl.error.usermsg);
        } catch (Exception e2) {
            e2.printStackTrace();
            setError(-2);
        }
    }
}
