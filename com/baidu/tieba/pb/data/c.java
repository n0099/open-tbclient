package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String ecN;
    private final LotteryUserChanceInfo ecO;
    private final b ecP;
    private int mStatus;

    private c(DataRes dataRes) {
        this.ecO = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.ecP = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.ecN = dataRes.status_msg;
    }

    public b aHz() {
        return this.ecP;
    }

    public LotteryUserChanceInfo aHA() {
        return this.ecO;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.ecN;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
