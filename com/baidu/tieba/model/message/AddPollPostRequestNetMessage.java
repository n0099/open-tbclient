package com.baidu.tieba.model.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.m0.z0.w;
import tbclient.AddPollPost.AddPollPostReqIdl;
import tbclient.AddPollPost.DataReq;
/* loaded from: classes4.dex */
public class AddPollPostRequestNetMessage extends NetMessage {
    public long forumId;
    public String options;
    public long threadId;

    public AddPollPostRequestNetMessage() {
        super(CmdConfigHttp.CMD_ADD_POLL_POST, 309006);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.thread_id = Long.valueOf(this.threadId);
        builder.options = this.options;
        builder.forum_id = Long.valueOf(this.forumId);
        if (z) {
            w.a(builder, true);
        }
        AddPollPostReqIdl.Builder builder2 = new AddPollPostReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getForumId() {
        return this.forumId;
    }

    public String getOptions() {
        return this.options;
    }

    public long getThreadId() {
        return this.threadId;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void setOptions(String str) {
        this.options = str;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }
}
