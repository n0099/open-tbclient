package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes2.dex */
public class c {
    private String fBI;
    private final LotteryUserChanceInfo fBJ;
    private final b fBK;
    private int mStatus;

    private c(DataRes dataRes) {
        this.fBJ = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.fBK = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.fBI = dataRes.status_msg;
    }

    public b aYu() {
        return this.fBK;
    }

    public LotteryUserChanceInfo aYv() {
        return this.fBJ;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.fBI;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
