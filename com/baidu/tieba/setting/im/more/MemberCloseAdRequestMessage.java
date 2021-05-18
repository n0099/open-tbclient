package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.NetMessage;
import d.a.j0.z0.w;
import tbclient.CloseAd.CloseAdReqIdl;
import tbclient.CloseAd.DataReq;
/* loaded from: classes5.dex */
public class MemberCloseAdRequestMessage extends NetMessage {
    public int mVipClose;

    public MemberCloseAdRequestMessage(int i2, int i3) {
        super(i2, i3);
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

    public void setVipClose(int i2) {
        this.mVipClose = i2;
    }
}
