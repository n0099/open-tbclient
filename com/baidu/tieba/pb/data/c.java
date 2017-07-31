package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String eDD;
    private final LotteryUserChanceInfo eDE;
    private final b eDF;
    private int mStatus;

    private c(DataRes dataRes) {
        this.eDE = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.eDF = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.eDD = dataRes.status_msg;
    }

    public b aPc() {
        return this.eDF;
    }

    public LotteryUserChanceInfo aPd() {
        return this.eDE;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.eDD;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
