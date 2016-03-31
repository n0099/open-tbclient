package com.baidu.tieba.pb.data;

import java.io.Serializable;
import tbclient.Lottery.ActRegular;
/* loaded from: classes.dex */
public class LotteryActRegularInfo implements Serializable {
    public static final int ACT_REGULAR_TYPE_LINK = 4;
    public static final int ACT_REGULAR_TYPE_REPLY = 3;
    public static final int ACT_REGULAR_TYPE_SHARE = 2;
    public static final int ACT_REGULAR_TYPE_SIGN = 1;
    private String mBtnName;
    private int mChance;
    private int mType;
    private String mUrl;

    private LotteryActRegularInfo(ActRegular actRegular) {
        if (actRegular != null) {
            this.mType = actRegular.type.intValue();
            this.mChance = actRegular.chance.intValue();
            this.mUrl = actRegular.url;
            this.mBtnName = actRegular.btn_name;
        }
    }

    public int getType() {
        return this.mType;
    }

    public int getChanceCount() {
        return this.mChance;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getBtnName() {
        return this.mBtnName;
    }

    public static LotteryActRegularInfo createFromProtobuf(ActRegular actRegular) {
        return new LotteryActRegularInfo(actRegular);
    }
}
