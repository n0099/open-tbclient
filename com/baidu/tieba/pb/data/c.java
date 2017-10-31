package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String eGb;
    private final LotteryUserChanceInfo eGc;
    private final b eGd;
    private int mStatus;

    private c(DataRes dataRes) {
        this.eGc = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.eGd = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.eGb = dataRes.status_msg;
    }

    public b aPI() {
        return this.eGd;
    }

    public LotteryUserChanceInfo aPJ() {
        return this.eGc;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.eGb;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
