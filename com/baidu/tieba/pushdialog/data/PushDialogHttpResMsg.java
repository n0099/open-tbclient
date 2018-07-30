package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.pushdialog.PushDialogStatic;
import java.io.IOException;
import tbclient.GetLockWindowMsg.GetLockWindowMsgResIdl;
/* loaded from: classes3.dex */
public class PushDialogHttpResMsg extends TbHttpResponsedMessage {
    private a mData;

    public PushDialogHttpResMsg(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
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
