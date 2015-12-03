package com.baidu.tieba.themeCenter.bubble.group;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.i;
import tbclient.GetBubbleByCategory.DataReq;
import tbclient.GetBubbleByCategory.GetBubbleByCategoryReqIdl;
/* loaded from: classes.dex */
public class BubbleGroupRequestMessage extends NetMessage {
    public BubbleGroupRequestMessage() {
        super(CmdConfigHttp.CMD_BUBBLE_CATEGORY, 309030);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            i.a(builder, true);
        }
        GetBubbleByCategoryReqIdl.Builder builder2 = new GetBubbleByCategoryReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
