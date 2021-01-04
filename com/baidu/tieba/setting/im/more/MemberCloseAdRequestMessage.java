package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.util.t;
import tbclient.CloseAd.CloseAdReqIdl;
import tbclient.CloseAd.DataReq;
/* loaded from: classes8.dex */
public class MemberCloseAdRequestMessage extends NetMessage {
    private int mVipClose;

    public MemberCloseAdRequestMessage(int i, int i2) {
        super(i, i2);
    }

    public void setVipClose(int i) {
        this.mVipClose = i;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.vip_close = Integer.valueOf(this.mVipClose);
        if (z) {
            t.b(builder, true);
        }
        CloseAdReqIdl.Builder builder2 = new CloseAdReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
