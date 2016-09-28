package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class e {
    private String elT;
    private final LotteryUserChanceInfo elU;
    private final d elV;
    private int mStatus;

    private e(DataRes dataRes) {
        this.elU = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.elV = d.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.elT = dataRes.status_msg;
    }

    public d aMm() {
        return this.elV;
    }

    public LotteryUserChanceInfo aMn() {
        return this.elU;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.elT;
    }

    public static e a(DataRes dataRes) {
        return new e(dataRes);
    }
}
