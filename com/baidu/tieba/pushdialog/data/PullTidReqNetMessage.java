package com.baidu.tieba.pushdialog.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.util.r;
import tbclient.GetLockWindowTid.DataReq;
import tbclient.GetLockWindowTid.GetLockWindowTidReqIdl;
/* loaded from: classes3.dex */
public class PullTidReqNetMessage extends NetMessage {
    public PullTidReqNetMessage(int i, int i2) {
        super(i, i2);
    }

    public PullTidReqNetMessage(int i, int i2, BdUniqueId bdUniqueId) {
        super(i, i2, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            r.a(builder, true, true, true);
            GetLockWindowTidReqIdl.Builder builder2 = new GetLockWindowTidReqIdl.Builder();
            builder2.data = builder.build(true);
            return builder2.build(true);
        } catch (Throwable th) {
            return null;
        }
    }
}
