package com.baidu.tieba.pushdialog.data;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.pushdialog.PushDialogStatic;
import tbclient.GetLockWindowTid.GetLockWindowTidResIdl;
/* loaded from: classes3.dex */
public class PullTidSocketResponseMessage extends SocketResponsedMessage {
    private String tid;

    public PullTidSocketResponseMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        try {
            this.tid = Long.toString(((GetLockWindowTidResIdl) PushDialogStatic.WIRE.parseFrom(bArr, GetLockWindowTidResIdl.class)).data.tid.longValue());
        } catch (Throwable th) {
        }
    }

    public String getTid() {
        return this.tid;
    }
}
