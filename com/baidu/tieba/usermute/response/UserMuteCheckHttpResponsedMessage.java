package com.baidu.tieba.usermute.response;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.UserMuteCheck.DataRes;
import tbclient.UserMuteCheck.UserMuteCheckResIdl;
/* loaded from: classes.dex */
public class UserMuteCheckHttpResponsedMessage extends HttpResponsedMessage {
    private DataRes mResult;

    public UserMuteCheckHttpResponsedMessage() {
        super(1003025);
    }

    public DataRes getResult() {
        return this.mResult;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        UserMuteCheckResIdl userMuteCheckResIdl = (UserMuteCheckResIdl) new Wire(new Class[0]).parseFrom(bArr, UserMuteCheckResIdl.class);
        if (userMuteCheckResIdl.error != null) {
            setError(userMuteCheckResIdl.error.errorno.intValue());
            setErrorString(userMuteCheckResIdl.error.usermsg);
        }
        if (getError() == 0 && userMuteCheckResIdl.data != null) {
            this.mResult = userMuteCheckResIdl.data;
        }
    }
}
