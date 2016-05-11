package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Message;
import tbclient.Lottery.DataReq;
import tbclient.Lottery.LotteryReqIdl;
/* loaded from: classes.dex */
public class PbLotteryRequestMessage extends NetMessage {
    public static final int ATTENTION_LOTTERY_TYPE = 1;
    public static final int LOTTERY_TYPE = 0;
    private long mActivityId;
    private long mAwardActId;
    private long mComponentId;
    private String mForumId;
    private int mFromType;
    private boolean mIsSenior;
    private String mThreadId;
    private String mUserId;
    private String mUserName;

    public PbLotteryRequestMessage(String str, String str2, String str3, String str4, int i, long j, long j2, long j3, boolean z) {
        super(CmdConfigHttp.PB_LOTTERY_HTTP_CMD, 309297);
        this.mUserId = str;
        this.mUserName = str2;
        this.mForumId = str3;
        this.mThreadId = str4;
        this.mFromType = i;
        this.mActivityId = j;
        this.mAwardActId = j2;
        this.mComponentId = j3;
        this.mIsSenior = z;
        setNetType(NetMessage.NetType.HTTP);
    }

    public String getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public long getActivityId() {
        return this.mActivityId;
    }

    public long getAwardActId() {
        return this.mAwardActId;
    }

    public long getComponentId() {
        return this.mComponentId;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.framework.message.NetMessage
    public Message encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.user_name = this.mUserName;
        builder.user_id = Long.valueOf(com.baidu.adp.lib.h.b.c(this.mUserId, -1L));
        builder.forum_id = Long.valueOf(com.baidu.adp.lib.h.b.c(this.mForumId, -1L));
        builder.thread_id = Long.valueOf(com.baidu.adp.lib.h.b.c(this.mThreadId, -1L));
        builder.from_type = Integer.valueOf(this.mFromType);
        builder.activity_id = Long.valueOf(this.mActivityId);
        builder.award_act_id = Long.valueOf(this.mAwardActId);
        builder.component_id = Long.valueOf(this.mComponentId);
        if (z) {
            com.baidu.tbadk.util.o.a(builder, true);
        }
        LotteryReqIdl.Builder builder2 = new LotteryReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
