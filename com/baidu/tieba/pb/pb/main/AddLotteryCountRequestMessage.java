package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.AddLotteryCount.AddLotteryCountReqIdl;
import tbclient.AddLotteryCount.DataReq;
/* loaded from: classes.dex */
public class AddLotteryCountRequestMessage extends NetMessage {
    private long mAwardActId;
    private int mFromType;
    private long mThreadId;
    private long mUserId;

    public void setAwardActId(long j) {
        this.mAwardActId = j;
    }

    public void setUserId(long j) {
        this.mUserId = j;
    }

    public void setFromType(int i) {
        this.mFromType = i;
    }

    public void setThreadId(long j) {
        this.mThreadId = j;
    }

    public AddLotteryCountRequestMessage() {
        super(CmdConfigHttp.PB_LOTTERY_ADD_COUNT, 309313);
        setNetType(NetMessage.NetType.HTTP);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.award_act_id = Long.valueOf(this.mAwardActId);
        builder.user_id = Long.valueOf(this.mUserId);
        builder.from_type = Integer.valueOf(this.mFromType);
        builder.thread_id = Long.valueOf(this.mThreadId);
        if (z) {
            com.baidu.tbadk.util.o.bindCommonParamsToProtobufData(builder, true);
        }
        AddLotteryCountReqIdl.Builder builder2 = new AddLotteryCountReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
