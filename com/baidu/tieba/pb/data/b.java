package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class b {
    private String deW;
    private final LotteryUserChanceInfo deX;
    private final a deY;
    private int mStatus;

    private b(DataRes dataRes) {
        this.deX = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.deY = a.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.deW = dataRes.status_msg;
    }

    public a avy() {
        return this.deY;
    }

    public LotteryUserChanceInfo avz() {
        return this.deX;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.deW;
    }

    public static b a(DataRes dataRes) {
        return new b(dataRes);
    }
}
