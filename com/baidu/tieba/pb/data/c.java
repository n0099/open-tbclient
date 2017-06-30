package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String erh;
    private final LotteryUserChanceInfo eri;
    private final b erj;
    private int mStatus;

    private c(DataRes dataRes) {
        this.eri = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.erj = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.erh = dataRes.status_msg;
    }

    public b aMo() {
        return this.erj;
    }

    public LotteryUserChanceInfo aMp() {
        return this.eri;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.erh;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
