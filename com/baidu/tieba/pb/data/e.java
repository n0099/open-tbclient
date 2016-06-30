package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class e {
    private String dLI;
    private final LotteryUserChanceInfo dLJ;
    private final d dLK;
    private int mStatus;

    private e(DataRes dataRes) {
        this.dLJ = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.dLK = d.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.dLI = dataRes.status_msg;
    }

    public d aDI() {
        return this.dLK;
    }

    public LotteryUserChanceInfo aDJ() {
        return this.dLJ;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.dLI;
    }

    public static e a(DataRes dataRes) {
        return new e(dataRes);
    }
}
