package com.baidu.tieba.setting.usermutelist;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.UserMuteQuery.DataRes;
import tbclient.UserMuteQuery.UserMuteQueryResIdl;
/* loaded from: classes4.dex */
public class UserMuteQuerySocketResponsedMessage extends SocketResponsedMessage {
    public DataRes mResult;

    public UserMuteQuerySocketResponsedMessage(int i) {
        super(303028);
    }

    public DataRes getResult() {
        return this.mResult;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        UserMuteQueryResIdl userMuteQueryResIdl = (UserMuteQueryResIdl) new Wire(new Class[0]).parseFrom(bArr, UserMuteQueryResIdl.class);
        Error error = userMuteQueryResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(userMuteQueryResIdl.error.usermsg);
        }
        if (getError() == 0 && (dataRes = userMuteQueryResIdl.data) != null) {
            this.mResult = dataRes;
        }
    }
}
