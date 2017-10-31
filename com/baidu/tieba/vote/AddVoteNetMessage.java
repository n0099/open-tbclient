package com.baidu.tieba.vote;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.o;
import tbclient.AddPollPost.AddPollPostReqIdl;
import tbclient.AddPollPost.DataReq;
/* loaded from: classes.dex */
public class AddVoteNetMessage extends NetMessage {
    private String mOptions;
    private long mThreadId;
    private long mforumId;

    private AddVoteNetMessage() {
        super(CmdConfigHttp.CMD_ADD_VOTE, 309006);
    }

    public AddVoteNetMessage(long j, long j2, String str) {
        super(CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mforumId = j;
        this.mThreadId = j2;
        this.mOptions = str;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.mforumId);
        builder.thread_id = Long.valueOf(this.mThreadId);
        builder.options = this.mOptions;
        if (z) {
            o.bindCommonParamsToProtobufData(builder, true);
        }
        AddPollPostReqIdl.Builder builder2 = new AddPollPostReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
