package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.r;
import tbclient.HotForum.DataReq;
import tbclient.HotForum.HotForumReqIdl;
/* loaded from: classes6.dex */
public class HotForumNetMessage extends NetMessage {
    private int lyo;

    public HotForumNetMessage() {
        super(CmdConfigHttp.CMD_HTTP_GET_HOTFORUM, 303116);
        this.lyo = 0;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.lyo = Integer.valueOf(this.lyo);
        if (z) {
            r.bindCommonParamsToProtobufData(builder, true);
        }
        HotForumReqIdl.Builder builder2 = new HotForumReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
