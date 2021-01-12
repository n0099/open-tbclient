package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.HotForum.DataReq;
import tbclient.HotForum.HotForumReqIdl;
/* loaded from: classes7.dex */
public class HotForumNetMessage extends NetMessage {
    private int lyo;

    public HotForumNetMessage() {
        super(1001534, CmdConfigSocket.CMD_GET_HOTFORUM);
        this.lyo = 0;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.lyo = Integer.valueOf(this.lyo);
        if (z) {
            t.b(builder, true);
        }
        HotForumReqIdl.Builder builder2 = new HotForumReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
