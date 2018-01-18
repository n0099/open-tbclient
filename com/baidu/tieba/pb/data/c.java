package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes2.dex */
public class c {
    private String fDi;
    private final LotteryUserChanceInfo fDj;
    private final b fDk;
    private int mStatus;

    private c(DataRes dataRes) {
        this.fDj = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.fDk = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.fDi = dataRes.status_msg;
    }

    public b aYA() {
        return this.fDk;
    }

    public LotteryUserChanceInfo aYB() {
        return this.fDj;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.fDi;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
