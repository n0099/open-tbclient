package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String dWs;
    private final LotteryUserChanceInfo dWt;
    private final b dWu;
    private int mStatus;

    private c(DataRes dataRes) {
        this.dWt = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.dWu = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.dWs = dataRes.status_msg;
    }

    public b aIf() {
        return this.dWu;
    }

    public LotteryUserChanceInfo aIg() {
        return this.dWt;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.dWs;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
