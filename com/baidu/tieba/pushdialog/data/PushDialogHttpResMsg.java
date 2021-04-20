package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.pushdialog.PushDialogStatic;
import d.b.i0.o2.d.a;
import java.io.IOException;
import tbclient.GetLockWindowMsg.GetLockWindowMsgResIdl;
/* loaded from: classes3.dex */
public class PushDialogHttpResMsg extends TbHttpResponsedMessage {
    public a mData;

    public PushDialogHttpResMsg(int i) {
        super(i);
    }

    public a getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        try {
            GetLockWindowMsgResIdl getLockWindowMsgResIdl = (GetLockWindowMsgResIdl) PushDialogStatic.f20313a.parseFrom(bArr, GetLockWindowMsgResIdl.class);
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
