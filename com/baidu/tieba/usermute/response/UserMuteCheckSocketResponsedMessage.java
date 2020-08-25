package com.baidu.tieba.usermute.response;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.UserMuteCheck.DataRes;
import tbclient.UserMuteCheck.UserMuteCheckResIdl;
/* loaded from: classes2.dex */
public class UserMuteCheckSocketResponsedMessage extends SocketResponsedMessage {
    private DataRes mResult;

    public UserMuteCheckSocketResponsedMessage() {
        super(CmdConfigSocket.CMD_USER_MUTE_CHECK);
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
