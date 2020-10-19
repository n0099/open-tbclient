package com.baidu.tieba.setting.usermutelist;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.UserMuteQuery.DataRes;
import tbclient.UserMuteQuery.UserMuteQueryResIdl;
/* loaded from: classes26.dex */
public class UserMuteQueryHttpResponsedMessage extends HttpResponsedMessage {
    private DataRes mResult;

    public DataRes getResult() {
        return this.mResult;
    }

    public UserMuteQueryHttpResponsedMessage() {
        super(1003026);
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
