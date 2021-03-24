package com.baidu.tieba.pushdialog.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.NetMessage;
import d.b.h0.z0.w;
import tbclient.GetLockWindowTid.DataReq;
import tbclient.GetLockWindowTid.GetLockWindowTidReqIdl;
/* loaded from: classes5.dex */
public class PullTidReqNetMessage extends NetMessage {
    public PullTidReqNetMessage(int i, int i2) {
        super(i, i2);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            w.c(builder, true, true, true);
            GetLockWindowTidReqIdl.Builder builder2 = new GetLockWindowTidReqIdl.Builder();
            builder2.data = builder.build(true);
            return builder2.build(true);
        } catch (Throwable unused) {
            return null;
        }
    }

    public PullTidReqNetMessage(int i, int i2, BdUniqueId bdUniqueId) {
        super(i, i2, bdUniqueId);
    }
}
