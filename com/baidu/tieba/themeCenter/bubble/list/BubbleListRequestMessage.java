package com.baidu.tieba.themeCenter.bubble.list;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.i;
import tbclient.GetBubbleList.DataReq;
import tbclient.GetBubbleList.GetBubbleListReqIdl;
/* loaded from: classes.dex */
public class BubbleListRequestMessage extends NetMessage {
    private int pn;
    private int rn;

    public BubbleListRequestMessage() {
        super(CmdConfigHttp.CMD_BUBBLE_LIST, 309031);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        if (z) {
            i.a(builder, true);
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
