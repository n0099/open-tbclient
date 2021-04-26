package com.baidu.tieba.usermute.response;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.UserMuteCheck.DataRes;
import tbclient.UserMuteCheck.UserMuteCheckResIdl;
/* loaded from: classes5.dex */
public class UserMuteCheckSocketResponsedMessage extends SocketResponsedMessage {
    public DataRes mResult;

    public UserMuteCheckSocketResponsedMessage() {
        super(303040);
    }

    public DataRes getResult() {
        return this.mResult;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        UserMuteCheckResIdl userMuteCheckResIdl = (UserMuteCheckResIdl) new Wire(new Class[0]).parseFrom(bArr, UserMuteCheckResIdl.class);
        Error error = userMuteCheckResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(userMuteCheckResIdl.error.usermsg);
        }
        if (getError() == 0 && (dataRes = userMuteCheckResIdl.data) != null) {
            this.mResult = dataRes;
        }
    }
}
