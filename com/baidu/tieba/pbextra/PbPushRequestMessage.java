package com.baidu.tieba.pbextra;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.j0.z0.w;
import tbclient.PushThread.DataReq;
import tbclient.PushThread.PushThreadReqIdl;
/* loaded from: classes5.dex */
public class PbPushRequestMessage extends NetMessage {
    public long mForumId;
    public int mPushType;
    public long mThreadId;
    public long mUserId;

    public PbPushRequestMessage(long j, long j2, int i2, long j3) {
        super(CmdConfigHttp.PB_PUSH_THREAD_HTTP_CMD, 309325);
        this.mForumId = j;
        this.mThreadId = j2;
        this.mPushType = i2;
        this.mUserId = j3;
        setNetType(NetMessage.NetType.HTTP);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.mForumId);
        builder.thread_id = Long.valueOf(this.mThreadId);
        builder.push_type = Integer.valueOf(this.mPushType);
        builder.user_id = Long.valueOf(this.mUserId);
        if (z) {
            w.a(builder, true);
        }
        PushThreadReqIdl.Builder builder2 = new PushThreadReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getForumId() {
        return this.mForumId;
    }

    public int getPushType() {
        return this.mPushType;
    }

    public long getThreadId() {
        return this.mThreadId;
    }

    public long getUserId() {
        return this.mUserId;
    }
}
