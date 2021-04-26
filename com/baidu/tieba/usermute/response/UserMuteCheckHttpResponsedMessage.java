package com.baidu.tieba.usermute.response;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.UserMuteCheck.DataRes;
import tbclient.UserMuteCheck.UserMuteCheckResIdl;
/* loaded from: classes5.dex */
public class UserMuteCheckHttpResponsedMessage extends HttpResponsedMessage {
    public DataRes mResult;

    public UserMuteCheckHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_USER_MUTE_CHECK);
    }

    public DataRes getResult() {
        return this.mResult;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
