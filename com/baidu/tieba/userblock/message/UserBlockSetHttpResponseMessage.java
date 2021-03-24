package com.baidu.tieba.userblock.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SetUserBlack.SetUserBlackResIdl;
/* loaded from: classes5.dex */
public class UserBlockSetHttpResponseMessage extends TbHttpResponsedMessage {
    public UserBlockSetHttpResponseMessage() {
        super(CmdConfigHttp.CMD_USER_BLOCK_SET);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
