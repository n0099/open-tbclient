package com.baidu.tieba.setting.usermutelist;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.UserMuteQuery.DataRes;
import tbclient.UserMuteQuery.UserMuteQueryResIdl;
/* loaded from: classes3.dex */
public class UserMuteQuerySocketResponsedMessage extends SocketResponsedMessage {
    private DataRes mResult;

    public UserMuteQuerySocketResponsedMessage(int i) {
        super(303028);
    }

    public DataRes getResult() {
        return this.mResult;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        UserMuteQueryResIdl userMuteQueryResIdl = (UserMuteQueryResIdl) new Wire(new Class[0]).parseFrom(bArr, UserMuteQueryResIdl.class);
        if (userMuteQueryResIdl.error != null) {
            setError(userMuteQueryResIdl.error.errorno.intValue());
            setErrorString(userMuteQueryResIdl.error.usermsg);
        }
        if (getError() == 0 && userMuteQueryResIdl.data != null) {
            this.mResult = userMuteQueryResIdl.data;
        }
    }
}
