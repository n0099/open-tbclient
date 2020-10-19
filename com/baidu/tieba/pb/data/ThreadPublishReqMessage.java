package com.baidu.tieba.pb.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.u;
import tbclient.ThreadPublish.DataReq;
import tbclient.ThreadPublish.ThreadPublishReqIdl;
/* loaded from: classes22.dex */
public class ThreadPublishReqMessage extends NetMessage {
    public long fid;
    public long tid;

    public ThreadPublishReqMessage() {
        super(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.fid);
        builder.thread_id = Long.valueOf(this.tid);
        if (z) {
            u.a(builder, true);
        }
        ThreadPublishReqIdl.Builder builder2 = new ThreadPublishReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
