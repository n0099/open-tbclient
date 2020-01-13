package com.baidu.tieba.pbextra;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.PushThread.DataReq;
import tbclient.PushThread.PushThreadReqIdl;
/* loaded from: classes7.dex */
public class PbPushRequestMessage extends NetMessage {
    private long mForumId;
    private int mPushType;
    private long mThreadId;
    private long mUserId;

    public PbPushRequestMessage(long j, long j2, int i, long j3) {
        super(1001806, CmdConfigSocket.CMD_PUSH_THREAD);
        this.mForumId = j;
        this.mThreadId = j2;
        this.mPushType = i;
        this.mUserId = j3;
        setNetType(NetMessage.NetType.HTTP);
    }

    public long getForumId() {
        return this.mForumId;
    }

    public long getThreadId() {
        return this.mThreadId;
    }

    public int getPushType() {
        return this.mPushType;
    }

    public long getUserId() {
        return this.mUserId;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.mForumId);
        builder.thread_id = Long.valueOf(this.mThreadId);
        builder.push_type = Integer.valueOf(this.mPushType);
        builder.user_id = Long.valueOf(this.mUserId);
        if (z) {
            t.a(builder, true);
        }
        PushThreadReqIdl.Builder builder2 = new PushThreadReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
