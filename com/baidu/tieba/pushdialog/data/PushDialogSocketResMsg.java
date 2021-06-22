package com.baidu.tieba.pushdialog.data;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.pushdialog.PushDialogStatic;
import d.a.o0.p2.d.a;
import java.io.IOException;
import tbclient.GetLockWindowMsg.GetLockWindowMsgResIdl;
/* loaded from: classes5.dex */
public class PushDialogSocketResMsg extends SocketResponsedMessage {
    public a mData;

    public PushDialogSocketResMsg(int i2) {
        super(i2);
    }

    public a getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) {
        try {
            GetLockWindowMsgResIdl getLockWindowMsgResIdl = (GetLockWindowMsgResIdl) PushDialogStatic.f20226a.parseFrom(bArr, GetLockWindowMsgResIdl.class);
            setError(getLockWindowMsgResIdl.error.errorno.intValue());
            setErrorString(getLockWindowMsgResIdl.error.usermsg);
            if (getLockWindowMsgResIdl.data != null) {
                a aVar = new a();
                this.mData = aVar;
                aVar.e(getLockWindowMsgResIdl.data);
            }
        } catch (IOException unused) {
        }
    }
}
