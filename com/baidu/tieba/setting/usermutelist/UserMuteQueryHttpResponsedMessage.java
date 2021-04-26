package com.baidu.tieba.setting.usermutelist;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.UserMuteQuery.DataRes;
import tbclient.UserMuteQuery.UserMuteQueryResIdl;
/* loaded from: classes5.dex */
public class UserMuteQueryHttpResponsedMessage extends HttpResponsedMessage {
    public DataRes mResult;

    public UserMuteQueryHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_USER_MUTE_QUERY);
    }

    public DataRes getResult() {
        return this.mResult;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
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
