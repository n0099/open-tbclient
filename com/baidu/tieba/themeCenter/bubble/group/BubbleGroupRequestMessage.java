package com.baidu.tieba.themeCenter.bubble.group;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.v;
import tbclient.GetBubbleByCategory.DataReq;
import tbclient.GetBubbleByCategory.GetBubbleByCategoryReqIdl;
/* loaded from: classes9.dex */
public class BubbleGroupRequestMessage extends NetMessage {
    public BubbleGroupRequestMessage() {
        super(1003039, CmdConfigSocket.CMD_BUBBLE_CATEGORY);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            v.b(builder, true);
        }
        GetBubbleByCategoryReqIdl.Builder builder2 = new GetBubbleByCategoryReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
