package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String eDT;
    private final LotteryUserChanceInfo eDU;
    private final b eDV;
    private int mStatus;

    private c(DataRes dataRes) {
        this.eDU = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.eDV = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.eDT = dataRes.status_msg;
    }

    public b aOQ() {
        return this.eDV;
    }

    public LotteryUserChanceInfo aOR() {
        return this.eDU;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.eDT;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
