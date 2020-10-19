package com.baidu.tieba.pushdialog.data;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.pushdialog.PushDialogStatic;
import java.io.IOException;
import tbclient.GetLockWindowMsg.GetLockWindowMsgResIdl;
/* loaded from: classes21.dex */
public class PushDialogSocketResMsg extends SocketResponsedMessage {
    a mData;

    public PushDialogSocketResMsg(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        try {
            GetLockWindowMsgResIdl getLockWindowMsgResIdl = (GetLockWindowMsgResIdl) PushDialogStatic.WIRE.parseFrom(bArr, GetLockWindowMsgResIdl.class);
            setError(getLockWindowMsgResIdl.error.errorno.intValue());
            setErrorString(getLockWindowMsgResIdl.error.usermsg);
            if (getLockWindowMsgResIdl.data != null) {
                this.mData = new a();
                this.mData.a(getLockWindowMsgResIdl.data);
            }
        } catch (IOException e) {
        }
    }

    public a getData() {
        return this.mData;
    }
}
