package com.baidu.tieba.pushdialog.data;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pushdialog.PushDialogStatic;
import tbclient.GetLockWindowTid.GetLockWindowTidResIdl;
/* loaded from: classes5.dex */
public class PullTidHttpRespMessage extends HttpResponsedMessage {
    public String tid;

    public PullTidHttpRespMessage(int i2) {
        super(i2);
    }

    public String getTid() {
        return this.tid;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        try {
            this.tid = Long.toString(((GetLockWindowTidResIdl) PushDialogStatic.f20145a.parseFrom(bArr, GetLockWindowTidResIdl.class)).data.tid.longValue());
        } catch (Throwable unused) {
        }
    }
}
