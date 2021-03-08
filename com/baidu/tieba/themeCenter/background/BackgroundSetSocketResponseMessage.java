package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.SetBackground.SetBackgroundResIdl;
/* loaded from: classes8.dex */
public class BackgroundSetSocketResponseMessage extends SocketResponsedMessage {
    public BackgroundSetSocketResponseMessage() {
        super(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SetBackgroundResIdl setBackgroundResIdl = (SetBackgroundResIdl) new Wire(new Class[0]).parseFrom(bArr, SetBackgroundResIdl.class);
        if (setBackgroundResIdl != null && setBackgroundResIdl.error != null) {
            setError(setBackgroundResIdl.error.errorno.intValue());
            setErrorString(setBackgroundResIdl.error.usermsg);
        }
    }
}
