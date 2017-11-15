package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String eGv;
    private final LotteryUserChanceInfo eGw;
    private final b eGx;
    private int mStatus;

    private c(DataRes dataRes) {
        this.eGw = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.eGx = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.eGv = dataRes.status_msg;
    }

    public b aPQ() {
        return this.eGx;
    }

    public LotteryUserChanceInfo aPR() {
        return this.eGw;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.eGv;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
