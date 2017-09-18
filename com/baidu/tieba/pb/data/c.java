package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String eEN;
    private final LotteryUserChanceInfo eEO;
    private final b eEP;
    private int mStatus;

    private c(DataRes dataRes) {
        this.eEO = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.eEP = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.eEN = dataRes.status_msg;
    }

    public b aPb() {
        return this.eEP;
    }

    public LotteryUserChanceInfo aPc() {
        return this.eEO;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.eEN;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
