package com.baidu.tieba.pb.pb.main.relatelist;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.z0.w;
import tbclient.RelateRecThread.DataReq;
import tbclient.RelateRecThread.RelateRecThreadReqIdl;
/* loaded from: classes5.dex */
public class RelateRecThreadRequestMessage extends NetMessage {
    public long forumId;
    public int sourceFrom;
    public int sourceType;
    public long threadId;

    public RelateRecThreadRequestMessage() {
        super(CmdConfigHttp.CMD_RELATE_REC_THREAD, 309701);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.forumId);
        builder.thread_id = Long.valueOf(this.threadId);
        builder.source_type = Integer.valueOf(this.sourceType);
        builder.source_from = Integer.valueOf(this.sourceFrom);
        if (z) {
            w.a(builder, true);
        }
        RelateRecThreadReqIdl.Builder builder2 = new RelateRecThreadReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
