package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SetBackground.SetBackgroundResIdl;
/* loaded from: classes.dex */
public class BackgroundSetSocketResponseMessage extends SocketResponsedMessage {
    public BackgroundSetSocketResponseMessage() {
        super(309022);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        SetBackgroundResIdl setBackgroundResIdl = (SetBackgroundResIdl) new Wire(new Class[0]).parseFrom(bArr, SetBackgroundResIdl.class);
        if (setBackgroundResIdl != null && setBackgroundResIdl.error != null) {
            setError(setBackgroundResIdl.error.errorno.intValue());
            setErrorString(setBackgroundResIdl.error.usermsg);
        }
    }
}
