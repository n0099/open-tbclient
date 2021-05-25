package com.baidu.tieba.themeCenter.bubble.list;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.m0.z0.w;
import tbclient.GetBubbleList.DataReq;
import tbclient.GetBubbleList.GetBubbleListReqIdl;
/* loaded from: classes5.dex */
public class BubbleListRequestMessage extends NetMessage {
    public int pn;
    public int rn;

    public BubbleListRequestMessage() {
        super(CmdConfigHttp.CMD_BUBBLE_LIST, 309031);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        if (z) {
            w.a(builder, true);
        }
        GetBubbleListReqIdl.Builder builder2 = new GetBubbleListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setPn(int i2) {
        this.pn = i2;
    }

    public void setRn(int i2) {
        this.rn = i2;
    }
}
