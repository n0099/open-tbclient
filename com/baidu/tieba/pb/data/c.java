package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes2.dex */
public class c {
    private String fDD;
    private final LotteryUserChanceInfo fDE;
    private final b fDF;
    private int mStatus;

    private c(DataRes dataRes) {
        this.fDE = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.fDF = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.fDD = dataRes.status_msg;
    }

    public b aYF() {
        return this.fDF;
    }

    public LotteryUserChanceInfo aYG() {
        return this.fDE;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.fDD;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
