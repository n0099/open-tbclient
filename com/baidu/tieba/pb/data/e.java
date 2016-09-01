package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class e {
    private String ejV;
    private final LotteryUserChanceInfo ejW;
    private final d ejX;
    private int mStatus;

    private e(DataRes dataRes) {
        this.ejW = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.ejX = d.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.ejV = dataRes.status_msg;
    }

    public d aLK() {
        return this.ejX;
    }

    public LotteryUserChanceInfo aLL() {
        return this.ejW;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.ejV;
    }

    public static e a(DataRes dataRes) {
        return new e(dataRes);
    }
}
