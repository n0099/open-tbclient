package com.baidu.tieba.themeCenter.bubble.list;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.v;
import tbclient.GetBubbleList.DataReq;
import tbclient.GetBubbleList.GetBubbleListReqIdl;
/* loaded from: classes9.dex */
public class BubbleListRequestMessage extends NetMessage {
    private int pn;
    private int rn;

    public BubbleListRequestMessage() {
        super(1003055, CmdConfigSocket.CMD_BUBBLE_LIST);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        if (z) {
            v.b(builder, true);
        }
        GetBubbleListReqIdl.Builder builder2 = new GetBubbleListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void setRn(int i) {
        this.rn = i;
    }
}
