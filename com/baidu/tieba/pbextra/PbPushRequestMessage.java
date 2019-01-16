package com.baidu.tieba.pbextra;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.q;
import tbclient.PushThread.DataReq;
import tbclient.PushThread.PushThreadReqIdl;
/* loaded from: classes3.dex */
public class PbPushRequestMessage extends NetMessage {
    private long mForumId;
    private int mPushType;
    private long mThreadId;
    private long mUserId;

    public PbPushRequestMessage(long j, long j2, int i, long j3) {
        super(CmdConfigHttp.PB_PUSH_THREAD_HTTP_CMD, 309325);
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
            q.bindCommonParamsToProtobufData(builder, true);
        }
        PushThreadReqIdl.Builder builder2 = new PushThreadReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
