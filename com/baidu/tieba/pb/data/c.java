package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String exT;
    private final LotteryUserChanceInfo exU;
    private final b exV;
    private int mStatus;

    private c(DataRes dataRes) {
        this.exU = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.exV = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.exT = dataRes.status_msg;
    }

    public b aMQ() {
        return this.exV;
    }

    public LotteryUserChanceInfo aMR() {
        return this.exU;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.exT;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
