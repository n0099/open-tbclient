package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.NetMessage;
import d.b.i0.z0.w;
import tbclient.CloseAd.CloseAdReqIdl;
import tbclient.CloseAd.DataReq;
/* loaded from: classes4.dex */
public class MemberCloseAdRequestMessage extends NetMessage {
    public int mVipClose;

    public MemberCloseAdRequestMessage(int i, int i2) {
        super(i, i2);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.vip_close = Integer.valueOf(this.mVipClose);
        if (z) {
            w.a(builder, true);
        }
        CloseAdReqIdl.Builder builder2 = new CloseAdReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setVipClose(int i) {
        this.mVipClose = i;
    }
}
