package com.baidu.tieba.setting.usermutelist;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.UserMuteQuery.DataRes;
import tbclient.UserMuteQuery.UserMuteQueryResIdl;
/* loaded from: classes.dex */
public class UserMuteQueryHttpResponsedMessage extends HttpResponsedMessage {
    private DataRes mResult;

    public DataRes getResult() {
        return this.mResult;
    }

    public UserMuteQueryHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_USER_MUTE_QUERY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
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
