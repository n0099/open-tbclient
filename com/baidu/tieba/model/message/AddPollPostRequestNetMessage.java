package com.baidu.tieba.model.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.t;
import tbclient.AddPollPost.AddPollPostReqIdl;
import tbclient.AddPollPost.DataReq;
/* loaded from: classes.dex */
public class AddPollPostRequestNetMessage extends NetMessage {
    private long forumId;
    private String options;
    private long threadId;

    public AddPollPostRequestNetMessage() {
        super(CmdConfigHttp.CMD_ADD_POLL_POST, 309006);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.thread_id = Long.valueOf(this.threadId);
        builder.options = this.options;
        builder.forum_id = Long.valueOf(this.forumId);
        if (z) {
            t.b(builder, true);
        }
        AddPollPostReqIdl.Builder builder2 = new AddPollPostReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getThreadId() {
        return this.threadId;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public String getOptions() {
        return this.options;
    }

    public void setOptions(String str) {
        this.options = str;
    }

    public long getForumId() {
        return this.forumId;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }
}
