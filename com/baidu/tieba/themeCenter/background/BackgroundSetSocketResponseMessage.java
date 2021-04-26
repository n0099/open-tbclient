package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.SetBackground.SetBackgroundResIdl;
/* loaded from: classes5.dex */
public class BackgroundSetSocketResponseMessage extends SocketResponsedMessage {
    public BackgroundSetSocketResponseMessage() {
        super(309022);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Error error;
        SetBackgroundResIdl setBackgroundResIdl = (SetBackgroundResIdl) new Wire(new Class[0]).parseFrom(bArr, SetBackgroundResIdl.class);
        if (setBackgroundResIdl == null || (error = setBackgroundResIdl.error) == null) {
            return;
        }
        setError(error.errorno.intValue());
        setErrorString(setBackgroundResIdl.error.usermsg);
    }
}
