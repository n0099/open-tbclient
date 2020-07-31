package com.baidu.tieba.pushdialog.data;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pushdialog.PushDialogStatic;
import tbclient.GetLockWindowTid.GetLockWindowTidResIdl;
/* loaded from: classes15.dex */
public class PullTidHttpRespMessage extends HttpResponsedMessage {
    private String tid;

    public PullTidHttpRespMessage(int i) {
        super(i);
    }

    public String getTid() {
        return this.tid;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        try {
            this.tid = Long.toString(((GetLockWindowTidResIdl) PushDialogStatic.WIRE.parseFrom(bArr, GetLockWindowTidResIdl.class)).data.tid.longValue());
        } catch (Throwable th) {
        }
    }
}
